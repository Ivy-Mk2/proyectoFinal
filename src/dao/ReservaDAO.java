/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import modelo.Reservas;
    

/**
 *
 * @author ocasp
 */
public class ReservaDAO {
    
    private Connection conexion;
    
    public ReservaDAO(Connection conexion ) {
        this.conexion = conexion;
    }
    public boolean registrarReserva(Reservas reserva) {
        String sql = "INSERT INTO reservas (id_mesa, id_usuario, fecha, hora, ubicacion, estado, comentario) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
            java.util.Date fechaUtil = formatoFecha.parse(reserva.getFecha());
            java.sql.Date fechaSQL = new java.sql.Date(fechaUtil.getTime());

            // Parsear hora (String ➜ java.sql.Time)
            java.text.SimpleDateFormat formatoHora = new java.text.SimpleDateFormat("hh:mm a");
            java.util.Date horaUtil = formatoHora.parse(reserva.getHora());
            java.sql.Time horaSQL = new java.sql.Time(horaUtil.getTime());
        
            stmt.setInt(1, reserva.getIdMesa());
            stmt.setInt(2, reserva.getIdUsuario());
            stmt.setDate(3, fechaSQL);
            stmt.setTime(4, horaSQL);
            stmt.setString(5, reserva.getUbicacion());
            stmt.setString(6, reserva.getEstado());
            stmt.setString(7, reserva.getComentario());
            return stmt.executeUpdate() > 0;
        } catch (SQLException|java.text.ParseException e) {
            System.err.println("Error al registrar reserva: " + e.getMessage());
            return false;
        }
    }
    public List<Reservas> obtenerReservasPorUsuario(int idUsuario) {
    List<Reservas> lista = new ArrayList<>();
    String sql = "SELECT * FROM reservas WHERE id_usuario = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Reservas r = new Reservas(
                    rs.getInt("id"),
                    rs.getInt("id_mesa"),
                    rs.getInt("id_usuario"),
                    rs.getString("fecha"),
                    rs.getString("hora"),
                    rs.getString("ubicacion"),
                    rs.getString("estado"),
                    rs.getString("comentario")
                );
                lista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public boolean eliminarReserva(int idReserva) {
        String sql = "DELETE FROM reservas WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, idReserva);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar reserva: " + e.getMessage());
            return false;
        }
    }

    



}
