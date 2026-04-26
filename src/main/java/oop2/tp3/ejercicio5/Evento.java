package oop2.tp3.ejercicio5;

import java.util.Objects;

public record Evento(String nombreEvento, TipoEvento tipoEvento) {

	public Evento {
		Objects.requireNonNull(nombreEvento, "nombreEvento no puede ser null");
		Objects.requireNonNull(tipoEvento, "tipoEvento no puede ser null");
	}

	public Evento(String nombreEvento, String tipoEvento) {
		this(nombreEvento, TipoEvento.desde(tipoEvento));
	}

	public ResultadoActuacion evaluar(Actuacion actuacion) {
		int espectadores = actuacion.numberoEspectadores();
		float monto = tipoEvento.montoPara(espectadores);
		float creditos = tipoEvento.creditosPara(espectadores);
		return new ResultadoActuacion(actuacion.lineaCon(monto), creditos);
	}
}
