package mvc.model.repository;

import mvc.excepciones.RepositoryException;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class DBUtils {

//    private static final String CONN_URL = "jdbc:mysql://localhost:3306/empleadosnominas?useTimezone=true&serverTimezone=UTC";
//
//    private static Connection conn = null;
//
//    public static Connection getConnection() throws RepositoryException {
//        try {
//            if (conn == null) {
//                Class.forName("org.mysql.cj.jdbc.Driver");
//                conn = DriverManager.getConnection(CONN_URL);
    /// /             initialize();
//            }
//            return conn;
//        } catch (SQLException | ClassNotFoundException e) {
//            throw new RepositoryException(e.getMessage());
//        }
//    }
//
//    private DBUtils() {
//    }

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

//    private static boolean customerTableIsEmpty(Connection conn) throws SQLException {
//        Statement stm = conn.createStatement();
//        ResultSet rs = stm.executeQuery("SELECT COUNT(*) FROM CUSTOMERS");
//        if (rs != null && rs.next()) {
//            int count = rs.getInt(1);
//            return count == 0;
//        }
//        return true;
//    }
//
//    public static void closeConnection() throws RepositoryException {
//        try {
//            if (conn != null)
//                conn.close();
//        } catch (SQLException e) {
//            throw new RepositoryException(e.getMessage());
//        }
//    }
//
//    public static void close(Statement st) throws RepositoryException {
//        try {
//            if (st != null)
//                st.close();
//        } catch (SQLException e) {
//            throw new RepositoryException(e.getMessage());
//        }
//    }
//
//    public static void close(ResultSet rs) throws RepositoryException {
//        try {
//            if (rs != null)
//                rs.close();
//        } catch (SQLException e) {
//            throw new RepositoryException(e.getMessage());
//        }
//    }

//    private static final String URL = "jdbc:mysql://localhost:3306/empleadosnominas?useTimezone=true&serverTimezone=UTC";
//    private static final String USER = "root";
//    private static final String PASSWORD = "123456";
//
//    public static Connection getConnection() throws SQLException, RepositoryException {
//        Connection conn = null;
//        try {
//            conn = DriverManager.getConnection(URL, USER, PASSWORD);
//
//            if (conn != null) {
//                System.out.println("Conexion exitosa");
//            }
//            return conn;
//        } catch (SQLException e) {
//            throw new RepositoryException(e.getMessage());
//        } finally {
//            if (conn != null) {
//                try {
//                    conn.close();
//                    System.out.println("Conexión cerrada.");
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    private static BasicDataSource dataSource = null;

    private static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("123456");
            dataSource.setUrl("jdbc:mysql://localhost:3306/empleadosnominas?useTimezone=true&serverTimezone=UTC");
            dataSource.setInitialSize(20);
            dataSource.setMaxIdle(15);
            dataSource.setMaxTotal(20);
            dataSource.setMaxWaitMillis(5000);
        }
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }


}
