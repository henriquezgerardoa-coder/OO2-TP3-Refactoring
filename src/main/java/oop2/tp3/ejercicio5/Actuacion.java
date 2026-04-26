package oop2.tp3.ejercicio5;

public record Actuacion(String nombreEvento, int numberoEspectadores) {
	LineaReporte lineaCon(float monto) {
		return new LineaReporte(nombreEvento, monto, numberoEspectadores);
	}
}
