package oop2.tp3.ejercicio2;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FiltroColumna implements Filtro {
    private final String clave;
    private final int indiceColumna;

    FiltroColumna(CampoRecaudacion campo) {
        this.clave = campo.clave();
        this.indiceColumna = campo.indice();
    }
    @Override
    public List<String[]> aplicar(Map<String, String> opciones, List<String[]> filas) {
        if (!opciones.containsKey(clave)) {
            return filas;
        }
        String esperado = opciones.get(clave);
        return filas.stream()
                .filter(fila -> fila[indiceColumna].equals(esperado))
                .collect(Collectors.toList());
    }
}


