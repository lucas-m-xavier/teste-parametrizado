import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

@RunWith(Parameterized.class)
public class TesteParametrizado {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                { "oio", true }, { "lucas", false }, { "ioioi", true }
        });
    }

    @Parameterized.Parameter(0)
    public String entrada;
    @Parameterized.Parameter(1)
    public boolean esperado;

    @Test
    public void CT001() {
        Assert.assertEquals(StringUtils.isPalindrome(entrada), esperado);
    }

    @ParameterizedTest
    @ValueSource(strings = { "level", "madam", "saippuakivikauppias" })
    void palindromeReadsSameBackward(String string) {
        Assert.assertTrue(StringUtils.isPalindrome(string));
    }

    @ParameterizedTest
    @ValueSource(ints = { 3, 6, 15})
    void divisibleByThree(int number) {
        Assert.assertEquals(0, number % 3);
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = { " " })
    void nullEmptyAndBlankStrings(String text) {
        Assert.assertTrue(text == null || text.trim().isEmpty());
    }

    @ParameterizedTest
    @MethodSource("numberToMonth")
    void monthNames(int month, String name) {
        Assert.assertEquals(name, DateUtils.getMonthName(month));
    }

    private static Stream<Arguments> numberToMonth() {
        return Stream.of(
                arguments(1, "January"),
                arguments(2, "February"),
                arguments(12, "December")
        );
    }
}
