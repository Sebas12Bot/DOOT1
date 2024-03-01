package Dominio;

import java.time.LocalDate;

public class FechaPasada extends ManejoFecha {
    @Override
    public LocalDate splitDeFecha(String fechaStr) {
        return OrganizadorFechas.splitDeFecha(fechaStr);
    }
}
