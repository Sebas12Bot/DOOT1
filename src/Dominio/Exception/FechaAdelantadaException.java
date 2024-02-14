package Dominio.Exception;

public class FechaAdelantadaException extends RuntimeException{
    public FechaAdelantadaException (){
        super("*DETALLES: \nLa fecha ingresada es una fecha del futuro, porfavor ingresar una fecha de un tiempo pasado.");
    }
}
