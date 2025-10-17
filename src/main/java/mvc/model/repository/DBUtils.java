package mvc.model.repository;

import mvc.excepciones.RepositoryException;

import java.sql.*;

public class DBUtils {

    private static final String CONN_URL = "jdbc:mysql://localhost:3306/empleadosnominas?useTimezone=true&serverTimezone=UTC";

    private static Connection conn = null;


    public static Connection getConnection() throws RepositoryException {
        try {
            if (conn == null) {
                Class.forName("org.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(CONN_URL);
//                initialize();
            }
            return conn;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    private DBUtils() {
    }

//    private static void initialize() throws RepositoryException {
//        try {
//            PreparedStatement stm = conn.prepareStatement(CREATE_CUSTOMERS);
//            stm.executeUpdate();
//
//            if (customerTableIsEmpty(conn)) {
//                stm = conn.prepareStatement(INSERT_CUSTOMERS);
//                stm.setString(1, "Pepe");
//                stm.setString(2, "Su casa");
//                stm.setString(3, "http://pepephone.es");
//                stm.setDouble(4, 2000);
//                stm.executeUpdate();
//
//                stm.setString(1, "Juan");
//                stm.setString(2, "John's house");
//                stm.setString(3, "http://johnnywalker.es");
//                stm.setDouble(4, 2000);
//                stm.executeUpdate();
//
//                stm.setString(1, "Mary");
//                stm.setString(2, "Mary's house");
//                stm.setString(3, "http://maryhadalamb.es");
//                stm.setDouble(4, 2000);
//                stm.executeUpdate();
//            }
//        } catch (SQLException e) {
//            throw new RepositoryException(e.getMessage());
//        }
//    }

    private static boolean customerTableIsEmpty(Connection conn) throws SQLException {
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM CUSTOMERS");
        if (rs != null && rs.next()) {
            int count = rs.getInt(1);
            return count == 0;
        }
        return true;
    }

    public static void closeConnection() throws RepositoryException {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static void close(Statement st) throws RepositoryException {
        try {
            if (st != null)
                st.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }

    public static void close(ResultSet rs) throws RepositoryException {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage());
        }
    }
}