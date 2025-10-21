package mvc.model.repository;

import mvc.model.entity.Empleado;
import mvc.excepciones.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoRepository {

    private static final String SELECT_ALL = "SELECT * FROM empleado";

    public static List<Empleado> findAll() throws RepositoryException {
        try {
            Connection conn = DBUtils.getConnection();
            List<Empleado> empleados = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String dni = rs.getString("Dni");
                String nombre = rs.getString("nombre");
                Character sexo = rs.getString("Sexo").toCharArray()[0];
                Integer categoria = rs.getInt("Categoria");
                Integer anyos = rs.getInt("Anyos");
                empleados.add(new Empleado(sexo, dni, nombre, categoria, anyos));
            }

            return empleados;
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage());
        }
    }
}
