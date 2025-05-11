/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Modelo.UsuariosBase;
/**
 *
 * @author ocasp
 */

public class Admin extends UsuariosBase {

    public Admin(int id,String nombre, String correo, String contrasena) {
        super( nombre, correo, contrasena);
    }

    @Override
    public String getTipo() {
        return "admin";
    }

}
