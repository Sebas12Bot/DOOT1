package Dominio.Exception;

public class FechaFormatoErroneoException extends RuntimeException{
    public FechaFormatoErroneoException(){
        super("*DETALLES: \nLa fecha introducida no cumple con el formato solicitado.");
    }
}
