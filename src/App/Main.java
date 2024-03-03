package App;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

import Dominio.Fecha;
import Dominio.Exception.FechaAdelantadaException;
import Dominio.Exception.FechaFormatoErroneoException;
import Dominio.Exception.FechaNoValidaException;
import Dominio.MapeoMeses;
import Dominio.TiempoTranscurrido;

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

            Fecha fechaUsuario = Fecha.Crear(Byte.parseByte(fechaString.split("/")[0]),
                    Byte.parseByte(fechaString.split("/")[1]), Short.parseShort(fechaString.split("/")[2]));
            LocalDate fechaActual = LocalDate.now();

            logger.info("╔════════════════════════════════════════════╗");
            logger.info("║Fecha actual: " + fechaActual);
            logger.info("║Fecha ingresada: " + fechaUsuario.getDia() + "/" + fechaUsuario.getMes() + "/" + fechaUsuario.getAnio());
            MapeoMeses.imprimirFechaConNombreMes(fechaUsuario);
            logger.info("╚════════════════════════════════════════════╝");

            LocalDate fechaUsuarioLocalDate = LocalDate.of(fechaUsuario.getAnio(), fechaUsuario.getMes(),
                    fechaUsuario.getDia());

            TiempoTranscurrido.tiempoTranscurrido(fechaUsuarioLocalDate, fechaActual);
        } catch (FechaFormatoErroneoException | FechaAdelantadaException | FechaNoValidaException e) {
            logger.warning(e.getMessage());
        }
    }
}
