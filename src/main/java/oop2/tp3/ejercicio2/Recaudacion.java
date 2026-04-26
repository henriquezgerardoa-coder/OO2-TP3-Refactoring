package oop2.tp3.ejercicio2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Recaudacion {
    private static final String DATA_PATH = "src/main/resources/data.csv";
    private static final List<Filtro> FILTROS;
    static {
        FILTROS = new ArrayList<>();
        FILTROS.add(new FiltroColumna(CampoRecaudacion.COMPANY_NAME));
        FILTROS.add(new FiltroColumna(CampoRecaudacion.CITY));
        FILTROS.add(new FiltroColumna(CampoRecaudacion.STATE));
        FILTROS.add(new FiltroColumna(CampoRecaudacion.ROUND));
    }
    private final List<String[]> csvData;
    public Recaudacion() throws IOException {
        this(new LectorCsvRecaudacion(DATA_PATH));
    }
    Recaudacion(LectorCsvRecaudacion lectorCsv) throws IOException {
        this.csvData = lectorCsv.leer();
    }
    public List<Map<String, String>> where(Map<String, String> options)
            throws IOException {
        List<String[]> filasFiltradas = new ArrayList<>(csvData);

        for (Filtro filtro : FILTROS) {
            filasFiltradas = filtro.aplicar(options, filasFiltradas);
        }
        return filasFiltradas.stream()
                .map(fila -> mapearFila(fila))
                .collect(Collectors.toList());
    }
    private static Map<String, String> mapearFila(String[] fila) {
        Map<String, String> mapped = new HashMap<>();
        for (CampoRecaudacion campo : CampoRecaudacion.values()) {
            mapped.put(campo.clave(), fila[campo.indice()]);
        }
        return mapped;
    }
}