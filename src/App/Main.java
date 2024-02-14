package App;

import Dominio.ControlFechas;
import Dominio.Exception.FechaAdelantadaException;
import Dominio.Exception.FechaNoValidaException;
import Dominio.TiempoTranscurrido;
import Dominio.Exception.FechaFormatoErroneoException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            try {
                System.out.println("╔════════════════════════════════════════════╗");
                System.out.println("║    Bienvenido al calculador de fechas      ║");
                System.out.println("║             (Fechas pasadas)               ║");
                System.out.println("║    1. Calcular Fecha.                      ║");
                System.out.println("║    2. Salir.                               ║");
                System.out.println("╚════════════════════════════════════════════╝");
                System.out.println("Digite una opcion: ");
                opc = scanner.nextInt();
                scanner.nextLine();

                switch (opc) {
                    case 1:
                        try {
                            System.out.println("Ingrese la fecha del pasado en formato (dia/mes/año): ");
                            String fechaString = scanner.nextLine();

                            LocalDate fechaUsuario = ControlFechas.splitDeFecha(fechaString);
                            LocalDate fechaActual = LocalDate.now();

                            System.out.println("╔════════════════════════════════════════════╗");
                            System.out.println("║Fecha actual: " + fechaActual);
                            System.out.println("║Fecha ingresada: " + fechaUsuario);
                            System.out.println("╚════════════════════════════════════════════╝");

                            TiempoTranscurrido.tiempoTranscurrido(fechaUsuario, fechaActual);
                        } catch (FechaFormatoErroneoException e) {
                            System.out.println(e.getMessage());
                        } catch (FechaAdelantadaException e) {
                            System.out.println(e.getMessage());
                        } catch (FechaNoValidaException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        System.out.println("Finalizado");
                        break;
                    default:
                        System.out.println("Opcion invalida, digite nuevamente.");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                opc = 0;
            }
        } while (opc != 2);

        scanner.close();
    }
}
