package ufes.example;

public class Fatorial {

    public static int calcula(int valor) {
        if (valor < 2) return 1;
        return valor * calcula(valor -1 );
    }

}
