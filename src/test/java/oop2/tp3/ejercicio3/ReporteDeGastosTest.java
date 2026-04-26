package oop2.tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReporteDeGastosTest {
    private static final LocalDate FECHA_FIJA = LocalDate.of(2026, 4, 23);
    @Test
    public void imprimeReporteVacioConTotalesEnCero() {
        String salida = ejecutarReporte(List.of());
        String[] lineas = normalizarLineas(salida);
        assertEquals("Expenses " + FECHA_FIJA, lineas[0]);
        assertEquals("Gastos de comida: 0", lineas[1]);
        assertEquals("Total de gastos: 0", lineas[2]);
    }
    @Test
    public void imprimeDetalleYTotalesParaGastosMixtos() {
        Gasto desayuno = new Desayuno(1000);
        Gasto cena = new Cena(5001);
        Gasto alquilerAuto = new AlquilerAuto(3000);
        String salida = ejecutarReporte(List.of(desayuno, cena, alquilerAuto));
        String[] lineas = normalizarLineas(salida);
        assertEquals("Expenses " + FECHA_FIJA, lineas[0]);
        assertEquals("Desayuno\t1000\t ", lineas[1]);
        assertEquals("Cena\t5001\tX", lineas[2]);
        assertEquals("Alquiler de Autos\t3000\t ", lineas[3]);
        assertEquals("Gastos de comida: 6001", lineas[4]);
        assertEquals("Total de gastos: 9001", lineas[5]);
    }
    @Test
    public void marcaExcesoSoloCuandoSuperaUmbral() {
        Gasto desayunoUmbral = new Desayuno(1000);
        Gasto desayunoExceso = new Desayuno(1001);
        Gasto cenaUmbral = new Cena(5000);
        Gasto cenaExceso = new Cena(5001);
        String salida = ejecutarReporte(List.of(desayunoUmbral, desayunoExceso, cenaUmbral, cenaExceso));
        assertTrue(salida.contains("Desayuno\t1000\t "));
        assertTrue(salida.contains("Desayuno\t1001\tX"));
        assertTrue(salida.contains("Cena\t5000\t "));
        assertTrue(salida.contains("Cena\t5001\tX"));
    }
    private String ejecutarReporte(List<Gasto> gastos) {
        return new ReporteDeGastos(FECHA_FIJA).imprimir(gastos);
    }
    private String[] normalizarLineas(String salida) {
        return salida.replace("\r\n", "\n").trim().split("\n");
    }
}

