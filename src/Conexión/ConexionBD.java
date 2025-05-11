package conexión;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/turnify_db";
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String USER = "root";       
    private static final String PASSWORD = "";       

    private static Connection conexion;
    public Statement st;
    public ResultSet rs;
    public PreparedStatement ps;

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName(DRIVER);
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println(" Conexión establecida a la base de datos.");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(" Error al conectar: " + e.getMessage());
            }
        }
        return conexion;
    }

    public static void cerrarConexion() {
        if (conexion != null) {
            try {
                conexion.close();
                System.out.println(" Conexión cerrada.");
            } catch (SQLException e) {
                System.err.println(" Error al cerrar conexión: " + e.getMessage());
            }
        }
    }
}
