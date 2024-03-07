package dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class MapeoMeses {
    private static final Map<Integer, String> meses = new HashMap<>();
    private static final Logger logger = Logger.getLogger(MapeoMeses.class.getName());

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

    private MapeoMeses() {
    }

    public static String obtenerNombreMes(int numeroMes) {
        return meses.getOrDefault(numeroMes, "Mes invalido");
    }

    public static void imprimirFechaConNombreMes(Fecha fecha) {
        int mes = fecha.getMes();
        int dia = fecha.getDia();
        int anhio = fecha.getAnio();

        String nombreMes = obtenerNombreMes(mes);
        String mensaje = String.format("Fecha: %d de %s de %d", dia, nombreMes, anhio);
        logger.info(mensaje);
    }
}
