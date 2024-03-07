package dominio.exception;

public class AnhioNoValidoException extends RuntimeException{
    public AnhioNoValidoException (){
        super(" EL año no es valido");
    }
}

