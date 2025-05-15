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
    public boolean RegistroReserva(int idUsuario,int idMesa, String fecha, String hora,String estado, String ubicacion){
    String sql = "INSERT INTO reservas (id_usuario , id_mesa, fecha, hora, estado, ubicacion) VALUES (?, ?, ?, ?, ?,?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            stmt.setInt(2, idMesa);
            stmt.setString(3, fecha);
            stmt.setString(4, hora);
            stmt.setString(5, estado);
            stmt.setString(6, ubicacion);

            int filasInsertadas = stmt.executeUpdate();
            return filasInsertadas > 0;

        } catch (SQLException e) {
            System.err.println("❌ Error al insertar reserva: " + e.getMessage());
            return false;
        }
    }
}
