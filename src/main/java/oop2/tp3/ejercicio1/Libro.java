package oop2.tp3.ejercicio1;

public class Libro {
    private final String nombre;
    private final Categoria categoria;

    public Libro(String nombre, Categoria categoria) {
        this.nombre = Validador.textoNoVacio(nombre, "El nombre del libro es obligatorio");
        this.categoria = Validador.noNulo(categoria, "La categoria del libro es obligatoria");
    }
    public String nombre() {
        return nombre;
    }
    public double montoPara(int diasAlquilados) {
        Validador.enteroPositivo(diasAlquilados, "La cantidad de dias alquilados debe ser mayor a cero");
        return categoria.montoPara(diasAlquilados);
    }
    public int puntosPara(int diasAlquilados) {
        Validador.enteroPositivo(diasAlquilados, "La cantidad de dias alquilados debe ser mayor a cero");
        return categoria.puntosPara(diasAlquilados);
    }
}