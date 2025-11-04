package mvc.model.service;

import mvc.excepciones.RepositoryException;
import mvc.model.entity.Empleado;
import mvc.model.repository.EmpleadoRepository;

import java.util.List;

public class EmpleadoService {

    public static List<Empleado> findAll() throws RepositoryException {
        return EmpleadoRepository.findAll();
    }

    public static Double mostrarSalarioPorDni(String dni) throws RepositoryException {
        return EmpleadoRepository.mostrarSalarioPorDni(dni);
    }

    public static List<Empleado> buscarEmpleadosParaModificar(String dni, String nombre, Integer categoria, Character sexo, Integer anyos) throws RepositoryException {
        return EmpleadoRepository.buscarEmpleadosParaModificar(dni, nombre, categoria, sexo, anyos);
    }
}
