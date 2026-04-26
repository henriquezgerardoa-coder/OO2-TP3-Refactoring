package oop2.tp3.ejercicio2;

import java.util.List;
import java.util.Map;

interface Filtro {
    List<String[]> aplicar(Map<String, String> opciones, List<String[]> filas);
}


