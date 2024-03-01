package Dominio;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MapeoMeses {
    private static final Map<Integer, String> meses = new HashMap<>();

    static {
        meses.put(1, "Enero");
        meses.put(2, "Febrero");
        meses.put(3, "Marzo");
        meses.put(4, "Abril");
        meses.put(5, "Mayo");
        meses.put(6, "Junio");
        meses.put(7, "Julio");
        meses.put(8, "Agosto");
        meses.put(9, "Septiembre");
        meses.put(10, "Octubre");
        meses.put(11, "Noviembre");
        meses.put(12, "Diciembre");
    }

    public static String obtenerNombreMes(int numeroMes) {
        return meses.getOrDefault(numeroMes, "Mes inválido");
    }

    public static void imprimirFechaConNombreMes(LocalDate fecha) {
        int mes = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();
        int anhio = fecha.getYear();

        String nombreMes = obtenerNombreMes(mes);

        System.out.println("Fecha: " + dia + " de " + nombreMes + " de " + anhio);
    }
}
