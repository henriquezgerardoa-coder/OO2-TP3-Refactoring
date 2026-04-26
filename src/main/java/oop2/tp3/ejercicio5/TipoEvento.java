package oop2.tp3.ejercicio5;

import java.util.Objects;

public interface TipoEvento {
    float montoPara(int numeroEspectadores);

    default float creditosPara(int numeroEspectadores) {
        return Math.max(numeroEspectadores - 30, 0);
    }

    static TipoEvento desde(String tipo) {
        String tipoNormalizado = Objects.requireNonNull(tipo, "tipo no puede ser null").trim();
        return switch (tipoNormalizado) {
            case "Drama" -> new Drama();
            case "Comedia" -> new Comedia();
            default -> new Desconocido(tipoNormalizado);
        };
    }
}

final class Drama implements TipoEvento {
    @Override
    public float montoPara(int numeroEspectadores) {
        float monto = 40000;
        if (numeroEspectadores > 30) {
            monto += 1000 * (numeroEspectadores - 30);
        }
        return monto;
    }
}

final class Comedia implements TipoEvento {
    @Override
    public float montoPara(int numeroEspectadores) {
        float monto = 30000;
        if (numeroEspectadores > 20) {
            monto += 10000 + 500 * (numeroEspectadores - 20);
        }
        monto += 300 * numeroEspectadores;
        return monto;
    }

    @Override
    public float creditosPara(int numeroEspectadores) {
        return TipoEvento.super.creditosPara(numeroEspectadores) + (float) Math.floor(numeroEspectadores / 5.0);
    }
}

final class Desconocido implements TipoEvento {
    private final String tipo;

    Desconocido(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public float montoPara(int numeroEspectadores) {
        throw new RuntimeException("Tipo de evento no conocido: " + tipo);
    }
}

