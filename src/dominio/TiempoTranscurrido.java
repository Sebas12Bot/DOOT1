package dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.logging.Logger;

public class TiempoTranscurrido {
    private static final Logger logger = Logger.getLogger(TiempoTranscurrido.class.getName());

    private TiempoTranscurrido() {
    }

    public static void tiempoTranscurrido(LocalDate fechaUsuario, LocalDate fechaActual) {
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaUsuario, fechaActual);
        long horasTranscurridas = ChronoUnit.HOURS.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());
        long minutosTranscurridos = ChronoUnit.MINUTES.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());
        long segundosTranscurridos = ChronoUnit.SECONDS.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());

        String mensaje = String.format("Tiempo transcurrido de la fecha actual ☺☻:%n%d dias,%n%d horas,%n%d minutos,%n%d segundos.", diasTranscurridos, horasTranscurridas, minutosTranscurridos, segundosTranscurridos);

        logger.info(mensaje);
    }
}

