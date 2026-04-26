package oop2.tp3.ejercicio5;

import java.util.List;

class FormateadorReporte {
    String formatear(String nombreCliente, List<LineaReporte> lineas, float total, float creditos) {
        StringBuilder resultado = new StringBuilder("Facturación para " + nombreCliente + System.lineSeparator());

        for (LineaReporte linea : lineas) {
            resultado.append(linea.nombreEvento())
                    .append(": ")
                    .append(linea.monto())
                    .append(". Asientos: ")
                    .append(linea.asientos())
                    .append(System.lineSeparator());
        }

        resultado.append("Monto ganado: ")
                .append(total)
                .append(System.lineSeparator());
        resultado.append("Créditos ganados: ")
                .append(creditos)
                .append(System.lineSeparator());

        return resultado.toString();
    }
}

