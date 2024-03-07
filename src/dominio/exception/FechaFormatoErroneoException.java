package dominio.exception;

public class FechaFormatoErroneoException extends RuntimeException{
    public FechaFormatoErroneoException(String mensaje){
        super("*DETALLES: \nLa fecha introducida no cumple con el formato solicitado.");
    }
}
