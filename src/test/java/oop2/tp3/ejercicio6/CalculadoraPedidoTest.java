package oop2.tp3.ejercicio6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraPedidoTest {

    private final CalculadoraPedido calculadora = new CalculadoraPedido();

    @Test
    public void aplicaDescuentoVipCuandoCorresponde() {
        Pedido pedido = new Pedido(10000, true, false);

        double total = calculadora.calcularTotalConDescuentoVip(pedido);

        assertEquals(8500, total, 0.001);
    }

    @Test
    public void noAplicaDescuentoVipCuandoNoCorresponde() {
        Pedido pedido = new Pedido(10000, false, false);

        double total = calculadora.calcularTotalConDescuentoVip(pedido);

        assertEquals(10000, total, 0.001);
    }

    @Test
    public void aplicaDescuentoPrioritarioCuandoCorresponde() {
        Pedido pedido = new Pedido(10000, false, true);

        double total = calculadora.calcularTotalConDescuentoPrioritario(pedido);

        assertEquals(9500, total, 0.001);
    }

    @Test
    public void permitePoliticaPersonalizadaConLambda() {
        Pedido pedido = new Pedido(10000, true, true);

        double total = calculadora.calcularTotal(pedido,
                p -> p.totalConDescuentoPorcentajeSi(() -> p.clienteVip() && p.envioPrioritario(), 0.20));

        assertEquals(8000, total, 0.001);
    }

    @Test
    public void lanzaErrorSiElPedidoEsNull() {
        assertThrows(NullPointerException.class,
                () -> calculadora.calcularTotalConDescuentoVip(null));
    }

    @Test
    public void lanzaErrorSiLaPoliticaEsNull() {
        Pedido pedido = new Pedido(10000, true, true);

        assertThrows(NullPointerException.class,
                () -> calculadora.calcularTotal(pedido, null));
    }

    @Test
    public void pedidoNoAceptaSubtotalNegativo() {
        assertThrows(IllegalArgumentException.class,
                () -> new Pedido(-1, true, true));
    }
}

