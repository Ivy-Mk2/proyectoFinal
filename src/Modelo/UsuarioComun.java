/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import Modelo.UsuariosBase;


public class UsuarioComun extends UsuariosBase {

    public UsuarioComun(int id, String nombre, String correo, String contrasena) {
        super(nombre, correo, contrasena);
        setId(id);
    }

    @Override
    public String getTipo() {
        return "usuario";
    }
}

