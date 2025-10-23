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
}
