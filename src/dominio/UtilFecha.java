package dominio;

public class UtilFecha {
    private UtilFecha() {
        super();
    }

    public static boolean esanhioBisiesto(short anhio) {
        return (anhio % 4 == 0 && anhio % 100 != 0) || (anhio % 400 == 0);
    }

    public static boolean esDiaValid(byte dia, byte mes, short anhio) {
        byte[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (mes == 2 && esanhioBisiesto(anhio)) ? dia > 29 : dia > diasPorMes[mes];
    }

    public static boolean esMesValid(byte mes) {
        return mes >= 1 && mes <= 12;
    }

    public static boolean esAniValid(short anhio) {
        return anhio < 0;
    }
}
