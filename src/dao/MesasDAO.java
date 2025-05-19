/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import Modelo.Mesas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ocasp
 */
public class MesasDAO {
    private Connection conexion;
    
    public  MesasDAO (Connection conexion){
        this.conexion = conexion;
    }
    // Crear
    public boolean registrarMesa(Mesas mesa) {
         String sql = "INSERT INTO mesas (numero, capacidad, ubicacion, estado) VALUES (?, ?, ?, ?)";

         try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
             stmt.setString(1, mesa.getNumero());
             stmt.setInt(2, mesa.getCapacidad());
             stmt.setString(3, mesa.getUbicacion());
             stmt.setString(4, mesa.getEstado());

             int filasAfectadas = stmt.executeUpdate();
             return filasAfectadas > 0;
         } catch (SQLException e) {
             System.err.println("Error al registrar mesa: " + e.getMessage());
             return false;
         }
     }
    
    // Leer 
    public List<Mesas> obtenerTodasLasMesas() {
        List<Mesas> lista = new ArrayList<>();
        String sql = "SELECT * FROM mesas";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mesas mesa = new Mesas(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    rs.getInt("capacidad"),
                    rs.getString("ubicacion"),
                    rs.getString("estado")
                );
                lista.add(mesa);
            }

        } catch (SQLException e) {
            System.err.println("Error al listar mesas: " + e.getMessage());
        }

        return lista;
    }

    //  Eliminar
    public boolean eliminarMesa(int id) {
        String sql = "DELETE FROM mesas WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar mesa: " + e.getMessage());
            return false;
        }
    }
    public int contarMesas() {
        String sql = "SELECT COUNT(*) FROM mesas";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getInt(1); // devuelve el conteo
            }

        } catch (SQLException e) {
            System.err.println("Error al contar mesas: " + e.getMessage());
        }

        return 0; // por defecto si falla
    }
    public List<Mesas> obtenerMesasDisponibles() {
        List<Mesas> disponibles = new ArrayList<>();
        String sql = "SELECT * FROM mesas WHERE estado = 'Disponible'";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Mesas mesa = new Mesas(
                    rs.getInt("id"),
                    rs.getString("numero"),
                    rs.getInt("capacidad"),
                    rs.getString("ubicacion"),
                    rs.getString("estado")
                );
                disponibles.add(mesa);
            }

        } catch (SQLException e) {
            System.err.println("Error al obtener mesas disponibles: " + e.getMessage());
        }

        return disponibles;
    }

}
