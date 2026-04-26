package oop2.tp3.ejercicio5;

import java.util.List;
import java.util.ArrayList;

public class Calculador {
    private final FormateadorReporte formateador = new FormateadorReporte();

    public String reporte(Factura factura, List<Evento> eventos) {
        CarteleraEventos cartelera = new CarteleraEventos(eventos);
        ResumenReporte resumen = new ResumenReporte();

        factura.actuaciones().stream()
                .map(cartelera::evaluar)
                .forEach(resumen::agregar);

        return formateador.formatear(factura.nombreCliente(), resumen.lineas(), resumen.totalAmount(), resumen.creditos());
    }

    private static class ResumenReporte {
        private float totalAmount;
        private float creditos;
        private final List<LineaReporte> lineas = new ArrayList<>();

        void agregar(ResultadoActuacion resultado) {
            totalAmount += resultado.monto();
            creditos += resultado.creditos();
            lineas.add(resultado.linea());
        }

        float totalAmount() {
            return totalAmount;
        }

        float creditos() {
            return creditos;
        }

        List<LineaReporte> lineas() {
            return lineas;
        }
    }
}
