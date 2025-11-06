package mvc.model.repository;

import mvc.model.entity.Empleado;
import mvc.excepciones.RepositoryException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * DAO:
 * Se encarga de definir y gestionar el modo en que los objetos pueden ser guardados y recuperados de forma permanente (persisten).
 * Sus métodos gestionan la conexión y ejecución de SQL para obtener objetos Empleado de la base de datos.
 * Para ello el patrón de diseño agrupa todas las operaciones en una única clase que las gestiona.
 * ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
 * */

public class EmpleadoRepository {

    private static final String SELECT_ALL = "SELECT * FROM empleado";
    private static final String SELECT_BY_ID = "SELECT * FROM nomina WHERE Dni = ?";
    private static final String SELECT_BY_ALL = "SELECT * FROM empleado WHERE Dni = ? OR nombre = ? OR Categoria = ? OR Sexo = ? OR Anyos = ?";

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

    public static List<Empleado> buscarEmpleadosParaModificar(String dni, String nombre, Integer categoria, Character sexo, Integer anyos) throws RepositoryException {
        try {
            Connection conn = DBUtils.getConnection();
            List<Empleado> empleados = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ALL);

            String dniParam = (dni != null && !dni.trim().isEmpty()) ? dni : "IMPOSSIBLE_DNI_MATCH";
            stmt.setString(1, dniParam);

            String nombreParam = (nombre != null && !nombre.trim().isEmpty()) ? nombre : "IMPOSSIBLE_NAME_MATCH";
            stmt.setString(2, nombreParam);

            Integer categoriaParam = (categoria != null && categoria > 0) ? categoria : -1;
            stmt.setInt(3, categoriaParam);

            String sexoParam = (sexo != null) ? String.valueOf(sexo) : "Z"; // Asumiendo que Sexo es M o F
            stmt.setString(4, sexoParam);

            Integer anyosParam = (anyos != null && anyos > 0) ? anyos : -1;
            stmt.setInt(5, anyosParam);

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
