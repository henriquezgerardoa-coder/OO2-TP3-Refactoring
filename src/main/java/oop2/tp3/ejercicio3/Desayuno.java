package oop2.tp3.ejercicio3;

class Desayuno extends Gasto {
    private static final int LIMITE_EXCESO = 1000;

    Desayuno(int monto) {
        super(monto);
    }

    @Override
    String nombre() {
        return "Desayuno";
    }

    @Override
    boolean esComida() {
        return true;
    }

    @Override
    String marcaExceso() {
        return monto() > LIMITE_EXCESO ? "X" : " ";
    }
}


