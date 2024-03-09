package app;

public class UtilTexto {
    private UtilTexto() {
    }

    public static String concatenar(String... cadenas) {
        StringBuilder resultado = new StringBuilder();
        for (String cadena : cadenas) {
            resultado.append(cadena);
        }
        return resultado.toString();
    }

}
