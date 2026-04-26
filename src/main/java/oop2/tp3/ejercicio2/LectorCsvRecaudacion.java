package oop2.tp3.ejercicio2;
import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class LectorCsvRecaudacion {
    private final String dataPath;

    LectorCsvRecaudacion(String dataPath) {
        this.dataPath = dataPath;
    }
    List<String[]> leer() throws IOException {
        List<String[]> filas = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(dataPath))) {
            String[] row;
            while ((row = reader.readNext()) != null) {
                filas.add(row);
            }
        }
        if (!filas.isEmpty()) {
            filas.remove(0);
        }
        return filas;
    }
}

