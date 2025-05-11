/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import Vista.LoginView;
import Controlador.ControlRegistro;
/**
 *
 * @author ocasp
 */
public class Launcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginView login = new LoginView();
        new ControlRegistro(login);
        login.setVisible(true);
        
        
    }
    
}
