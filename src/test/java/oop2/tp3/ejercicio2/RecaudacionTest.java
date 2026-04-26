package oop2.tp3.ejercicio2;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecaudacionTest {
    @Test
    public void testWhereGivenCompany() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        assertEquals(7, recaudacion.where(options).size());
    }
    @Test
    public void testWhereGivenCity() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("city", "Tempe");
        assertEquals(3, recaudacion.where(options).size());
    }
    @Test
    public void testWhereGivenState() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("state", "CA");
        assertEquals(873, recaudacion.where(options).size());
    }
    @Test
    public void testWhereGivenRound() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        assertEquals(582, recaudacion.where(options).size());
    }
    @Test
    public void testMultipleOptions() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        options.put("company_name", "Facebook");
        assertEquals(1, recaudacion.where(options).size());
    }
    @Test
    public void testWhereNotExists() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "NotFacebook");
        assertEquals(0, recaudacion.where(options).size());
    }
    @Test
    public void testWhereCorrectKeys() throws IOException {
        Recaudacion recaudacion = new Recaudacion();
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        Map<String, String> row = recaudacion.where(options).get(0);
        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get("round"));
    }
}