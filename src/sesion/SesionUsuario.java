/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sesion;

/**
 *
 * @author ocasp
 */
import Modelo.UsuariosBase;

public class SesionUsuario {
    private static UsuariosBase usuarioActual;

    // Guardar el usuario que ha iniciado sesión
    public static void iniciarSesion(UsuariosBase usuario) {
        usuarioActual = usuario;
    }

    // Obtener los datos del usuario actual
    public static UsuariosBase getUsuarioActual() {
        return usuarioActual;
    }

    // Saber si hay una sesión activa
    public static boolean haySesionActiva() {
        return usuarioActual != null;
    }

    // Cerrar la sesión
    public static void cerrarSesion() {
        usuarioActual = null;
    }
}