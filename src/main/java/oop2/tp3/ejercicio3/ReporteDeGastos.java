package oop2.tp3.ejercicio3;

import java.time.LocalDate;
import java.util.List;

public class ReporteDeGastos {
    private final LocalDate fecha;
    private final CalculadorDeGastos calculador;
    private final FormateadorReporteDeGastos formateador;

    public ReporteDeGastos() {
        this(LocalDate.now());
    }

    public ReporteDeGastos(LocalDate fecha) {
        this(fecha, new CalculadorDeGastos(), new FormateadorReporteDeGastos());
    }

    ReporteDeGastos(LocalDate fecha, CalculadorDeGastos calculador, FormateadorReporteDeGastos formateador) {
        this.fecha = fecha;
        this.calculador = calculador;
        this.formateador = formateador;
    }

    public String imprimir(List<Gasto> gastos) {
        ResumenDeGastos resumen = calculador.calcular(gastos);
        return formateador.formatear(fecha, resumen);
    }
}