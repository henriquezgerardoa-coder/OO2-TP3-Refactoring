package oop2.tp3.ejercicio3;

class AlquilerAuto extends Gasto {
    AlquilerAuto(int monto) {
        super(monto);
    }

    @Override
    String nombre() {
        return "Alquiler de Autos";
    }
}


