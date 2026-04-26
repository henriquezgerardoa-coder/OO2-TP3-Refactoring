package oop2.tp3.ejercicio5;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

final class CarteleraEventos {
    private final Map<String, Evento> eventosPorNombre;

    CarteleraEventos(List<Evento> eventos) {
        this.eventosPorNombre = eventos.stream()
                .collect(Collectors.toMap(Evento::nombreEvento, Function.identity(), (primero, segundo) -> primero));
    }

    ResultadoActuacion evaluar(Actuacion actuacion) {
        Evento evento = eventosPorNombre.get(actuacion.nombreEvento());
        if (evento == null) {
            throw new RuntimeException("Evento no encontrado");
        }
        return evento.evaluar(actuacion);
    }
}

