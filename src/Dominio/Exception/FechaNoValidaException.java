package Dominio.Exception;

public class FechaNoValidaException extends RuntimeException {
    public FechaNoValidaException(){
        super("*DETALLES: \nLa fecha introducida no es valida para el proceso.");
    }
}
