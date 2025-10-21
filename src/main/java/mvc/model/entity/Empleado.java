package mvc.model.entity;

import mvc.excepciones.DatosNoCorrectosExcepcion;

public class Empleado extends Persona {

    // ATRIBUTOS
    private int categoria;
    public int anyos;

    // CONSTRUCTORES
    public Empleado(char sexo, String dni, String nombre, int anyos, int categoria) {
        super(nombre, dni, sexo);

        this.anyos = anyos;
        if (this.anyos < 0) {
            throw new DatosNoCorrectosExcepcion("Datos no correctos");
        }

        this.categoria = categoria;
        if (this.categoria < 0 || this.categoria > 10) {
            throw new DatosNoCorrectosExcepcion("Datos no correctos");
        }
    }

    public Empleado(char sexo, String dni, String nombre) {
        super(nombre, dni, sexo);
        this.anyos = 0;
        this.categoria = 1;
    }

    // METODOS
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCategoria() {
        return categoria;
    }

    // IMPLEMENTO EL GETANYOS PARA LA FUNCION SUELDO DE EMPLEADOS
    public int getAnyos() {
        return anyos;
    }

    public void incrAnyo() {
        this.anyos++;
    }


    public String Imprime() {
        return "Empleado{" +
                "categoria=" + categoria +
                ", anyos=" + anyos +
                ", sexo=" + sexo +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
