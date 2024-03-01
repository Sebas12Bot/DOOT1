package Dominio;

import Dominio.Exception.FechaAdelantadaException;
import Dominio.Exception.FechaFormatoErroneoException;
import Dominio.Exception.FechaNoValidaException;

import java.time.DateTimeException;
import java.time.LocalDate;

public class OrganizadorFechas {
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
            if (mes < 1 || mes > 12) {
                return false;
            }
            if (dia < 1 || dia > 31) {
                return false;
            }
            if (mes == 2) {
                if (dia > 29) {
                    return false;
                }
                if (dia == 29 && !esAnhioBisiesto(anhio)) {
                    return false;
                }
            }
            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                return false;
            }
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    private static boolean esAnhioBisiesto(int anhio) {
        return (anhio % 4 == 0 && anhio % 100 != 0) || (anhio % 400 == 0);
    }
}
