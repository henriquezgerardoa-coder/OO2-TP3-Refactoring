package oop2.tp3.ejercicio1;

import java.util.Objects;

final class Validador {
    private Validador() {
    }
    static <T> T noNulo(T valor, String mensaje) {
        return Objects.requireNonNull(valor, mensaje);
    }
    static String textoNoVacio(String valor, String mensaje) {
        String valorValidado = noNulo(valor, mensaje).trim();
        if (valorValidado.isEmpty()) {
            throw new IllegalArgumentException(mensaje);
        }
        return valorValidado;
    }
    static int enteroPositivo(int valor, String mensaje) {
        if (valor <= 0) {
            throw new IllegalArgumentException(mensaje);
        }
        return valor;
    }
}



