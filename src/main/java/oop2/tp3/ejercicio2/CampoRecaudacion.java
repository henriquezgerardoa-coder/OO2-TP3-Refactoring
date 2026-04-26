package oop2.tp3.ejercicio2;

enum CampoRecaudacion {
    PERMALINK("permalink", 0),
    COMPANY_NAME("company_name", 1),
    NUMBER_EMPLOYEES("number_employees", 2),
    CATEGORY("category", 3),
    CITY("city", 4),
    STATE("state", 5),
    FUNDED_DATE("funded_date", 6),
    RAISED_AMOUNT("raised_amount", 7),
    RAISED_CURRENCY("raised_currency", 8),
    ROUND("round", 9);

    private final String clave;
    private final int indice;

    CampoRecaudacion(String clave, int indice) {
        this.clave = clave;
        this.indice = indice;
    }
    String clave() {
        return clave;
    }
    int indice() {
        return indice;
    }
}

