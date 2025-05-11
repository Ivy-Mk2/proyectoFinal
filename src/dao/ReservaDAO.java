/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;
    

/**
 *
 * @author ocasp
 */
public class ReservaDAO {
    
    private Connection conexion;
    
    public ReservaDAO(Connection conexion ) {
        this.conexion = conexion;
    }
    public boolean RegistroReserva(int idMesa, String fecha, String hora, String ubicacion){
  String sql = "INSERT INTO reservas (id_mesa, fecha, hora, ubicacion) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idMesa);
            stmt.setString(2, fecha);
            stmt.setString(3, hora);
            stmt.setString(4, ubicacion);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }
}
