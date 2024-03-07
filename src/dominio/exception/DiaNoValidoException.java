package dominio.exception;

public class DiaNoValidoException extends RuntimeException{
    public DiaNoValidoException (){
        super("El dia no es valido");
    }
}
