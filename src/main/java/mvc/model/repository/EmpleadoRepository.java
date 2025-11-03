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
    private static final String SELECT_BY_ID = "SELECT * FROM nomina WHERE Dni = ?";
//    private static final String SELECT_BY_ALL = "SELECT * " +
//            "WHERE (? IS NULL OR Dni = ?) " +
//            "AND (? IS NULL OR Nombre = ?) " +
//            "AND (? IS NULL OR Categoria = ?) ";

    private static final String SELECT_BY_ALL = "SELECT * FROM empleado " +
            "WHERE Dni = ? OR Nombre = ? OR Categoria = ?";

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


    public static Double mostrarSalarioPorDni(String dni) throws RepositoryException {
        try {
            Connection conn = DBUtils.getConnection();
            Double res = 0.0;

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);
            stmt.setString(1, dni);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                res = rs.getDouble("sueldo");
            }
            return res;

        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage());
        }
    }

    private static List<Empleado> buscarEmpleadosParaModificar(String dni, String nombre, Integer categoria) throws RepositoryException {
        try {
            Connection conn = DBUtils.getConnection();
            List<Empleado> empleados = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ALL);

            if (dni != null) {
                stmt.setString(1, dni);
            }

            if (nombre != null) {
                stmt.setString(2, nombre);
            }

            if (categoria != 0) {
                stmt.setInt(3, categoria);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String dniEmpleado = rs.getString("Dni");
                String nombreEmpleado = rs.getString("nombre");
                Character sexoEmpleado = rs.getString("Sexo").toCharArray()[0];
                Integer categoriaEmpleado = rs.getInt("Categoria");
                Integer anyosEmpleado = rs.getInt("Anyos");
                empleados.add(new Empleado(sexoEmpleado, dniEmpleado, nombreEmpleado, categoriaEmpleado, anyosEmpleado));
            }

            return empleados;

        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage());
        }
    }


}
