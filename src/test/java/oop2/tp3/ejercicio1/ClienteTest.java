package oop2.tp3.ejercicio1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ClienteTest {
    @Test
    void calculaResumenSinAlquileres() {
        Cliente cliente = new Cliente("Javier");
        ResultadoDeCliente resultado = cliente.calcularResumen();
        assertEquals(0.0, resultado.total(), 0.001);
        assertEquals(0, resultado.puntos());
    }
    @Test
    void calculaResumenTipadoParaDosLibrosRegulares() {
        Libro elTunel = new Libro("El Túnel", Categoria.REGULAR);
        Libro antesDelFin = new Libro("Antes del Fin", Categoria.REGULAR);
        CopiaLibro elTunelCopia = new CopiaLibro(elTunel);
        CopiaLibro antesDelFinCopia = new CopiaLibro(antesDelFin);
        Alquiler alquilerElTunel = new Alquiler(elTunelCopia, 5);
        Alquiler alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        Cliente cliente = new Cliente("Javier");
        cliente.alquilar(alquilerElTunel);
        cliente.alquilar(alquilerAntesDelFin);
        ResultadoDeCliente resultado = cliente.calcularResumen();
        assertEquals(10.0, resultado.total(), 0.001);
        assertEquals(2, resultado.puntos());
    }
    @Test
    void calculaResumenParaNuevoLanzamientoConBonus() {
        Libro dune2 = new Libro("Dune 2", Categoria.NUEVO_LANZAMIENTO);
        CopiaLibro copiaDune2 = new CopiaLibro(dune2);
        Alquiler alquiler = new Alquiler(copiaDune2, 3);
        Cliente cliente = new Cliente("Javier");
        cliente.alquilar(alquiler);
        ResultadoDeCliente resultado = cliente.calcularResumen();
        assertEquals(9.0, resultado.total(), 0.001);
        assertEquals(2, resultado.puntos());
    }
    @Test
    void calculaResumenParaInfantilSinExcedente() {
        Libro bambi = new Libro("Bambi", Categoria.INFANTIL);
        CopiaLibro copiaBambi = new CopiaLibro(bambi);
        Alquiler alquiler = new Alquiler(copiaBambi, 3);
        Cliente cliente = new Cliente("Javier");
        cliente.alquilar(alquiler);
        ResultadoDeCliente resultado = cliente.calcularResumen();
        assertEquals(1.5, resultado.total(), 0.001);
        assertEquals(1, resultado.puntos());
    }
    @Test
    void libroRegularCalculaMonto() {
        Libro regular = new Libro("Regular", Categoria.REGULAR);
        assertEquals(6.5, regular.montoPara(5), 0.001);
    }
    @Test
    void libroRegularCalculaMontoEnElLimite() {
        Libro regular = new Libro("Regular", Categoria.REGULAR);
        assertEquals(2.0, regular.montoPara(2), 0.001);
    }
    @Test
    void libroRegularCalculaMontoAlSuperarElLimite() {
        Libro regular = new Libro("Regular", Categoria.REGULAR);
        assertEquals(3.5, regular.montoPara(3), 0.001);
    }
    @Test
    void libroNuevoLanzamientoCalculaPuntosConBonus() {
        Libro estreno = new Libro("Estreno", Categoria.NUEVO_LANZAMIENTO);
        assertEquals(2, estreno.puntosPara(2));
    }
    @Test
    void libroNuevoLanzamientoCalculaPuntosSinBonus() {
        Libro estreno = new Libro("Estreno", Categoria.NUEVO_LANZAMIENTO);
        assertEquals(1, estreno.puntosPara(1));
    }
    @Test
    void libroInfantilCalculaMontoEnElLimite() {
        Libro infantil = new Libro("Infantil", Categoria.INFANTIL);
        assertEquals(1.5, infantil.montoPara(3), 0.001);
    }
    @Test
    void libroInfantilCalculaMontoAlSuperarElLimite() {
        Libro infantil = new Libro("Infantil", Categoria.INFANTIL);
        assertEquals(3.0, infantil.montoPara(4), 0.001);
    }
    @Test
    void clienteNoAceptaNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Cliente("   "));
    }
    @Test
    void libroNoAceptaNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> new Libro("   ", Categoria.REGULAR));
    }
    @Test
    void alquilerNoAceptaDiasNoPositivos() {
        Libro regular = new Libro("Regular", Categoria.REGULAR);
        CopiaLibro copia = new CopiaLibro(regular);
        assertThrows(IllegalArgumentException.class, () -> new Alquiler(copia, 0));
    }
    @Test
    void libroNoAceptaDiasNoPositivosParaMontoYPuntos() {
        Libro regular = new Libro("Regular", Categoria.REGULAR);
        assertThrows(IllegalArgumentException.class, () -> regular.montoPara(0));
        assertThrows(IllegalArgumentException.class, () -> regular.puntosPara(-1));
    }
}

