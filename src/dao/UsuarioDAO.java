package dao;

import Modelo.Admin;
import Modelo.UsuariosBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.UsuarioComun;

public class UsuarioDAO {

    private Connection conexion;

    public UsuarioDAO(Connection conexion) {
        this.conexion = conexion;
    }

    // Registro de usuario
    public boolean registrarUsuario(String nombre, String correo, String contrasena, String tipo) {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasena, tipo) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, nombre);
            stmt.setString(2, correo);
            stmt.setString(3, contrasena); // En el futuro: encriptar
            stmt.setString(4, tipo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("❌ Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    // Validación de inicio de sesión
     
    public boolean validarLogin(String correo, String contrasena) {
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND contrasena = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 

        } catch (SQLException e) {
            System.out.println("❌ Error al validar login: " + e.getMessage());
            return false;
        }
    }

    
    //Recuperacion de cuenta
    
    public boolean recuperarCuenta(String correo){
        String sql = "SELECT * FROM usuarios WHERE correo = ?";
        
        try(PreparedStatement stmt = conexion.prepareStatement(sql)){
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e){
            System.out.println("Error al encontrar correo:" + e.getMessage());
            return false;
        }
    }
    
    //Almcaenamientos de usario
    
    public UsuariosBase obtenerUsuarioPorCorreo(String correo) {
        UsuariosBase usuario = null;
        String sql = "SELECT * FROM usuarios WHERE correo = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, correo);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            String correoBD = rs.getString("correo");
            String contrasena = rs.getString("contrasena");
            String tipo = rs.getString("tipo");

            if (tipo.equalsIgnoreCase("admin")) {
                usuario = new Admin(id,nombre, correoBD, contrasena);
            } else {
                usuario = new UsuarioComun(id,nombre, correoBD, contrasena);
            }

            usuario.setId(id);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
