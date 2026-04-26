package oop2.tp3.ejercicio3;

import java.util.List;

record LineaDeReporteDeGasto(String nombre, int monto, String marcaExceso) {
}

record ResumenDeGastos(List<LineaDeReporteDeGasto> lineas, int gastosDeComida, int total) {
    ResumenDeGastos {
        lineas = List.copyOf(lineas);
    }
}

