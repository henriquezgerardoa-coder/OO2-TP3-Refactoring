package oop2.tp3.ejercicio3;

import java.util.List;

class CalculadorDeGastos {
    ResumenDeGastos calcular(List<Gasto> gastos) {
        List<LineaDeReporteDeGasto> lineas = gastos.stream()
                .map(Gasto::lineaReporte)
                .toList();

        int gastosDeComida = gastos.stream()
                .filter(Gasto::esComida)
                .mapToInt(Gasto::monto)
                .sum();

        int total = gastos.stream()
                .mapToInt(Gasto::monto)
                .sum();

        return new ResumenDeGastos(lineas, gastosDeComida, total);
    }
}

