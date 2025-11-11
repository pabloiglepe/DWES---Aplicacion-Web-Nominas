package mvc.model.service;

import mvc.excepciones.RepositoryException;
import mvc.model.entity.Empleado;
import mvc.model.repository.EmpleadoRepository;

import java.util.List;

/*
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * SERVICE LAYER:
 * Define un conjunto de servicios disponibles desde la capa de la aplicación y aisla la lógica del negocio.
 * Actúa como intermediario central entre el EmpleadoController y el EmpleadoRepository.
 *
 *
 * FACADE:
 * Proporciona una clase que simplifica el uso del subsistema por parte del cliente. Sirve como fachada para la clase EmpleadoRepository.
 * Simplifica el acceso a las operaciones del EmpleadoRepository.
 * Todos los métodos de EmpleadoService son métodos estáticos que delegan la llamada al metodo que se encuentra en EmpleadoRepository.
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * */


public class EmpleadoService {

    /**
     *
     * @return
     * @throws RepositoryException
     */
    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAll();
    }

    /**
     *
     * @param dni
     * @return
     * @throws RepositoryException
     */
    public static Double mostrarSalarioPorDni(String dni) throws RepositoryException {
        return EmpleadoRepository.mostrarSalarioPorDni(dni);
    }

    /**
     *
     * @param dni
     * @param nombre
     * @param categoria
     * @param sexo
     * @param anyos
     * @return
     * @throws RepositoryException
     */
    public static List<Empleado> buscarEmpleadosParaModificar(String dni, String nombre, Integer categoria, Character sexo, Integer anyos) throws RepositoryException {
        return EmpleadoRepository.buscarEmpleadosParaModificar(dni, nombre, categoria, sexo, anyos);
    }
}
