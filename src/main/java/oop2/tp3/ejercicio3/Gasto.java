package oop2.tp3.ejercicio3;

abstract class Gasto {
    private final int monto;

    Gasto(int monto) {
        this.monto = monto;
    }

    int monto() {
        return monto;
    }

    boolean esComida() {
        return false;
    }

    abstract String nombre();

    String marcaExceso() {
        return " ";
    }

    LineaDeReporteDeGasto lineaReporte() {
        return new LineaDeReporteDeGasto(nombre(), monto, marcaExceso());
    }
}

