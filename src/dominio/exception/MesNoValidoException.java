package dominio.exception;

public class MesNoValidoException extends RuntimeException{
    public MesNoValidoException (){
        super(" EL mes debe ser un numero entre 1 y 12 ");
    }
}
