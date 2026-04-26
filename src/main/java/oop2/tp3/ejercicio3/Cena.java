package oop2.tp3.ejercicio3;

class Cena extends Gasto {
    private static final int LIMITE_EXCESO = 5000;

    Cena(int monto) {
        super(monto);
    }

    @Override
    String nombre() {
        return "Cena";
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


