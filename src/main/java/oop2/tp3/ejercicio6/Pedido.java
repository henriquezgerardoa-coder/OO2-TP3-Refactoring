package oop2.tp3.ejercicio6;

import java.util.function.BooleanSupplier;

public class Pedido {

    private final double subtotal;
    private final boolean clienteVip;
    private final boolean envioPrioritario;

    public Pedido(double subtotal, boolean clienteVip, boolean envioPrioritario) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        this.subtotal = subtotal;
        this.clienteVip = clienteVip;
        this.envioPrioritario = envioPrioritario;
    }

    public double subtotal() {
        return this.subtotal;
    }

    public boolean clienteVip() {
        return this.clienteVip;
    }

    public boolean envioPrioritario() {
        return this.envioPrioritario;
    }

    public double totalConDescuentoPorcentajeSi(BooleanSupplier condicion, double porcentaje) {
        if (porcentaje < 0 || porcentaje > 1) {
            throw new IllegalArgumentException("El porcentaje debe estar entre 0 y 1");
        }

        double descuento = condicion.getAsBoolean() ? subtotal * porcentaje : 0;
        return subtotal - descuento;
    }
}

