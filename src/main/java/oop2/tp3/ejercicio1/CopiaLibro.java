package oop2.tp3.ejercicio1;

public record CopiaLibro(Libro libro) {
    public CopiaLibro {
        Validador.noNulo(libro, "El libro de la copia es obligatorio");
    }
}