package Dominio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class TiempoTranscurrido {
    public static void tiempoTranscurrido(LocalDate fechaUsuario, LocalDate fechaActual) {
        long diasTranscurridos = ChronoUnit.DAYS.between(fechaUsuario, fechaActual);
        long horasTranscurridas = ChronoUnit.HOURS.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());
        long minutosTranscurridos = ChronoUnit.MINUTES.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());
        long segundosTranscurridos = ChronoUnit.SECONDS.between(fechaUsuario.atStartOfDay(), fechaActual.atStartOfDay());

        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║Tiempo transcurrido de la fecha actual ☺☻:");
        System.out.println("║" + diasTranscurridos + " dias,");
        System.out.println("║" + horasTranscurridas + " horas,");
        System.out.println("║" + minutosTranscurridos + " minutos,");
        System.out.println("║" + segundosTranscurridos + " segundos.");
        System.out.println("╚════════════════════════════════════════════╝");
    }
}
