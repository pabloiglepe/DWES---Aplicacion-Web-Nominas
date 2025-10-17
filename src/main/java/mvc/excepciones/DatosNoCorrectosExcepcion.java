package mvc.excepciones;

public class DatosNoCorrectosExcepcion extends RuntimeException{
    public DatosNoCorrectosExcepcion(String message) {
        super(message);
    }
}
