package oop2.tp3.ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final List<Alquiler> alquileres = new ArrayList<>();
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = Validador.textoNoVacio(nombre, "El nombre del cliente es obligatorio");
    }
    public String nombre() {
        return nombre;
    }
    public ResultadoDeCliente calcularResumen() {
        double montoTotal = 0;
        int puntosTotales = 0;
        for (Alquiler alquiler : alquileres) {
            montoTotal += alquiler.monto();
            puntosTotales += alquiler.puntosFrecuente();
        }
        return new ResultadoDeCliente(montoTotal, puntosTotales);
    }
    public void alquilar(Alquiler alquiler) {
        alquileres.add(Validador.noNulo(alquiler, "El alquiler es obligatorio"));
    }
}