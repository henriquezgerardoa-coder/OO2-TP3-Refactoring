package oop2.tp3.ejercicio5;

record ResultadoActuacion(LineaReporte linea, float creditos) {
    float monto() {
        return linea.monto();
    }
}

