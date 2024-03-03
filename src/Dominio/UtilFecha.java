package Dominio;

public class UtilFecha {
    private UtilFecha() {
        super();
    }

    public static boolean esAnioBisiesto(short anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    public static boolean esDiaValid(byte dia, byte mes, short anio) {
        byte[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (mes == 2 && esAnioBisiesto(anio)) ? dia > 29 : dia > diasPorMes[mes];
    }

    public static boolean esMesValid(byte mes) {
        return mes >= 1 && mes <= 12;
    }

    public static boolean esAniValid(short anio) {
        return anio < 0;
    }
}
