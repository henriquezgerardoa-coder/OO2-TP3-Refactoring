package oop2.tp3.ejercicio6;

public class MainCalculadoraPedido {
    public static void main(String[] args) {
        Pedido pedido = new Pedido(10000, true, true);
        CalculadoraPedido calculadora = new CalculadoraPedido();

        double totalVip = calculadora.calcularTotalConDescuentoVip(pedido);
        double totalPrioritario = calculadora.calcularTotal(pedido,
                p -> p.totalConDescuentoPorcentajeSi(p::envioPrioritario, 0.05));
        double totalCombo = calculadora.calcularTotal(pedido,
                p -> p.totalConDescuentoPorcentajeSi(() -> p.clienteVip() && p.envioPrioritario(), 0.20));

        System.out.println("Total con descuento VIP: " + totalVip);
        System.out.println("Total con descuento por envio prioritario: " + totalPrioritario);
        System.out.println("Total con descuento combo: " + totalCombo);
    }
}

