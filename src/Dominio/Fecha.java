package Dominio;

public class Fecha {
    private Byte dia;
    private Byte mes;
    private Short anio;

    private Fecha(Byte dia, Byte mes, Short anio) {
        setAnio(anio);
        setMes(mes);
        setDia(dia);
    }

    public static Fecha Crear(Byte dia, Byte mes, Short anio) {
        return new Fecha(dia, mes, anio);
    }

    public Byte getDia() {
        return dia;
    }

    public void setDia(Byte dia) {
        if(UtilFecha.esDiaValid(dia, mes, anio)){
            throw  new RuntimeException("El dia no es valido"+dia+" Mes:"+mes);
        }
        this.dia = dia;
    }

    public Byte getMes() {
        return mes;
    }

    public void setMes(Byte mes) {
        if(!UtilFecha.esMesValid(mes)){
            throw  new RuntimeException(" lL mes debe ser entre 1 y 12 ");
        }
        this.mes = mes;
    }

    public Short getAnio() {
        return anio;
    }

    public void setAnio(Short anio) {
        if(UtilFecha.esAniValid(anio)){
            throw  new RuntimeException("El año no es valido");
        }
        this.anio = anio;
    }
}
