package oop2.tp3.ejercicio1;

public record Alquiler(CopiaLibro copia, int diasAlquilados) {
    public Alquiler {
        Validador.noNulo(copia, "La copia del libro es obligatoria");
        Validador.enteroPositivo(diasAlquilados, "La cantidad de dias alquilados debe ser mayor a cero");
    }
    public double monto() {
        return copia.libro().montoPara(diasAlquilados);
    }
    public int puntosFrecuente() {
        return copia.libro().puntosPara(diasAlquilados);
    }
}
