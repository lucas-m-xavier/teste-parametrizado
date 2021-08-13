import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ufes.example.Fatorial;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TesteParametrizado {
    @Parameterized.Parameters(name = "{index}: fatorial({0}) = {1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0, 1}, {1, 1}, {2, 2}, {3, 6}, {4, 24}
        });
    }

    @Parameterized.Parameter(0)
    public int entrada;
    @Parameterized.Parameter(1)
    public int esperado;

    @Test
    public void CT002() {
        Assert.assertEquals(Fatorial.calcula(entrada), esperado);
    }
}
