package dominio;

import dominio.exception.AnhioNoValidoException;
import dominio.exception.DiaNoValidoException;
import dominio.exception.MesNoValidoException;

public class Fecha {
    private Byte dia;
    private Byte mes;
    private Short anio;

    private Fecha(Byte dia, Byte mes, Short anio) {
        setAnhio(anio);
        setMes(mes);
        setDia(dia);
    }

    public static Fecha crear(Byte dia, Byte mes, Short anio) {
        return new Fecha(dia, mes, anio);
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        if(UtilFecha.esDiaValid(dia, mes, anio)){
            throw  new DiaNoValidoException();
        }
        this.dia = dia;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        if(!UtilFecha.esMesValid(mes)){
            throw  new MesNoValidoException();
        }
        this.mes = mes;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnhio(Short anio) {
        if(UtilFecha.esAniValid(anio)){
            throw  new AnhioNoValidoException();
        }
        this.anio = anio;
    }

}
