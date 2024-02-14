package Dominio;

import java.time.DateTimeException;
import java.time.LocalDate;

import Dominio.Exception.FechaAdelantadaException;
import Dominio.Exception.FechaFormatoErroneoException;
import Dominio.Exception.FechaNoValidaException;

public class ControlFechas {
    public static LocalDate splitDeFecha(String fechaStr) {
        try {
            String[] divisionFechas = fechaStr.split("/");
            if (divisionFechas.length != 3) {
                throw new FechaFormatoErroneoException();
            }
            int dia = Integer.parseInt(divisionFechas[0]);
            int mes = Integer.parseInt(divisionFechas[1]);
            int anhio = Integer.parseInt(divisionFechas[2]);

            if (!fechaEsValida(dia, mes, anhio)) {
                throw new FechaNoValidaException();
            }

            LocalDate fecha = LocalDate.of(anhio, mes, dia);
            if (fecha.isAfter(LocalDate.now())) {
                throw new FechaAdelantadaException();
            }

            return fecha;

        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            throw new FechaFormatoErroneoException();
        }
    }

    private static boolean fechaEsValida(int dia, int mes, int anhio) {
        try {
            LocalDate.of(anhio, mes, dia);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

}
