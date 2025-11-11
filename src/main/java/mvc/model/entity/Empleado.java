package mvc.model.entity;

import mvc.excepciones.DatosNoCorrectosExcepcion;

public class Empleado extends Persona {


    private int categoria;
    public int anyos;

    /**
     *
     * @param sexo
     * @param dni
     * @param nombre
     * @param anyos
     * @param categoria
     */
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

    /**
     *
     * @param sexo
     * @param dni
     * @param nombre
     */
    public Empleado(char sexo, String dni, String nombre) {
        super(nombre, dni, sexo);
        this.anyos = 0;
        this.categoria = 1;
    }


    /**
     *
     * @param categoria
     */
    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }


    public void incrAnyo() {
        this.anyos++;
    }


    /**
     *
     * @return
     */
    public String getDni() {return dni;}

    public int getCategoria() {
        return categoria;
    }

    public int getAnyos() {
        return anyos;
    }

    public String getNombre() {return nombre;}

    public char getSexo() {return sexo;}


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
