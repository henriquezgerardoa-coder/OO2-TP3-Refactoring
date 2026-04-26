package oop2.tp3.ejercicio6;

import java.util.Objects;

public class CalculadoraPedido {
    private static final PoliticaDescuento DESCUENTO_VIP =
            pedido -> pedido.totalConDescuentoPorcentajeSi(pedido::clienteVip, 0.15);
    private static final PoliticaDescuento DESCUENTO_PRIORITARIO =
            pedido -> pedido.totalConDescuentoPorcentajeSi(pedido::envioPrioritario, 0.05);

    public double calcularTotalConDescuentoVip(Pedido pedido) {
        return calcularTotal(pedido, DESCUENTO_VIP);
    }

    public double calcularTotalConDescuentoPrioritario(Pedido pedido) {
        return calcularTotal(pedido, DESCUENTO_PRIORITARIO);
    }

    public double calcularTotal(Pedido pedido, PoliticaDescuento politicaDescuento) {
        Objects.requireNonNull(pedido, "El pedido no puede ser null");
        Objects.requireNonNull(politicaDescuento, "La politica de descuento no puede ser null");
        return politicaDescuento.totalPara(pedido);
    }
}

