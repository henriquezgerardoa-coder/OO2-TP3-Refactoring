package oop2.tp3.ejercicio1;

public enum Categoria {
    REGULAR {
        @Override
        public double montoPara(int diasAlquilados) {
            double monto = MONTO_BASE_REGULAR;
            if (diasAlquilados > DIAS_BASE_REGULAR) {
                monto += (diasAlquilados - DIAS_BASE_REGULAR) * MONTO_EXCEDENTE;
            }
            return monto;
        }
    },
    NUEVO_LANZAMIENTO {
        @Override
        public double montoPara(int diasAlquilados) {
            return diasAlquilados * MONTO_DIARIO_NUEVO_LANZAMIENTO;
        }
        @Override
        public int puntosPara(int diasAlquilados) {
            return diasAlquilados > 1 ? 2 : 1;
        }
    },
    INFANTIL {
        @Override
        public double montoPara(int diasAlquilados) {
            double monto = MONTO_BASE_INFANTIL;
            if (diasAlquilados > DIAS_BASE_INFANTIL) {
                monto += (diasAlquilados - DIAS_BASE_INFANTIL) * MONTO_EXCEDENTE;
            }
            return monto;
        }
    };
    private static final double MONTO_BASE_REGULAR = 2.0;
    private static final int DIAS_BASE_REGULAR = 2;
    private static final double MONTO_DIARIO_NUEVO_LANZAMIENTO = 3.0;
    private static final double MONTO_BASE_INFANTIL = 1.5;
    private static final int DIAS_BASE_INFANTIL = 3;
    private static final double MONTO_EXCEDENTE = 1.5;
    public abstract double montoPara(int diasAlquilados);
    public int puntosPara(int diasAlquilados) { return 1; }
}
