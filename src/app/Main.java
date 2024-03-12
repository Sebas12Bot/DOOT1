package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import dominio.Fecha;
import dominio.exception.FechaAdelantadaException;
import dominio.exception.FechaFormatoErroneoException;
import dominio.exception.FechaNoValidaException;
import dominio.MapeoMeses;
import dominio.TiempoTranscurrido;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            try {
                logger.info("╔════════════════════════════════════════════╗");
                logger.info("║    Bienvenido al calculador de fechas      ║");
                logger.info("║             (Fechas pasadas)               ║");
                logger.info("║    1. Calcular Fecha.                      ║");
                logger.info("║    2. Salir.                               ║");
                logger.info("╚════════════════════════════════════════════╝");
                logger.info("Digite una opcion: ");
                opc = scanner.nextInt();
                scanner.nextLine();

                switch (opc) {
                    case 1:
                        calcularFecha(scanner);
                        break;
                    case 2:
                        logger.info("Finalizado");
                        break;
                    default:
                        logger.info("Opcion invalida, digite nuevamente.");
                }
            } catch (InputMismatchException e) {
                logger.warning("Entrada no valida. Por favor, ingrese un numero.");
                scanner.nextLine();
                opc = 0;
            }
        } while (opc != 2);

        scanner.close();
    }

    private static void calcularFecha(Scanner scanner) {
        try {
            logger.info("Ingrese la fecha del pasado en formato (dia/mes/año): ");
            String fechaString = scanner.nextLine();

            String[] partesFecha = fechaString.split("/");
            if (partesFecha.length != 3) {
                throw new FechaFormatoErroneoException("Formato de fecha incorrecto.");
            }

            byte dia = Byte.parseByte(partesFecha[0]);
            byte mes = Byte.parseByte(partesFecha[1]);
            short anio = Short.parseShort(partesFecha[2]);

            Fecha fechaUsuario = Fecha.crear(dia, mes, anio);
            LocalDate fechaActual = LocalDate.now();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaActualFormateada = fechaActual.format(formatter);

            logger.info("╔════════════════════════════════════════════╗");
            if (logger.isLoggable(Level.INFO)) {
                logger.info("║Fecha actual:{} " + fechaActualFormateada);
                logger.info("║Fecha ingresada:{} " + fechaUsuario.getDia() + "/" + fechaUsuario.getMes() + "/" + fechaUsuario.getAnio());
            }
            MapeoMeses.imprimirFechaConNombreMes(fechaUsuario);
            logger.info("╚════════════════════════════════════════════╝");

            LocalDate fechaUsuarioLocalDate = LocalDate.of(fechaUsuario.getAnio(), fechaUsuario.getMes(),
                    fechaUsuario.getDia());

            TiempoTranscurrido.tiempoTranscurrido(fechaUsuarioLocalDate, fechaActual);
        } catch (FechaFormatoErroneoException | FechaAdelantadaException | FechaNoValidaException e) {
            logger.warning(e.getMessage());
        } catch (NumberFormatException e) {
            logger.warning("Formato de fecha incorrecto. Por favor, ingrese numeros validos.");
        }
    }
}