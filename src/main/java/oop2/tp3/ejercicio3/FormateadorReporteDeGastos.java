package oop2.tp3.ejercicio3;

import java.time.LocalDate;

class FormateadorReporteDeGastos {
    String formatear(LocalDate fecha, ResumenDeGastos resumen) {
        StringBuilder reporte = new StringBuilder();

        reporte.append("Expenses ").append(fecha).append("\n");
        for (LineaDeReporteDeGasto linea : resumen.lineas()) {
            reporte.append(linea.nombre()).append("\t")
                    .append(linea.monto()).append("\t")
                    .append(linea.marcaExceso()).append("\n");
        }
        reporte.append("Gastos de comida: ").append(resumen.gastosDeComida()).append("\n");
        reporte.append("Total de gastos: ").append(resumen.total());

        return reporte.toString();
    }
}

