/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.LoginView;
import Vista.MenuPrincipal;
import dao.ReservaDAO;
import conexión.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sesion.SesionUsuario;

/**
 *
 * @author ocasp
 */
public class ControlMenu implements  ActionListener{
    
    private MenuPrincipal vista;
    private ReservaDAO reservaDAO;

    public ControlMenu(MenuPrincipal vista) {
        this.vista=vista;
        this.reservaDAO = new ReservaDAO(ConexionBD.getConexion());
        vista.panelReservar.btnReservar.addActionListener(this); 
        vista.panelPerfil.btnCerrarSesion.addActionListener(this);
        

    }
      @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
    if (source == vista.panelReservar.btnReservar) {
        registrarReserva();
    }else if(source == vista.panelPerfil.btnCerrarSesion){
        cerrarSesion(); 
        
    }
    }
    private void registrarReserva() {
        try {
            int idUsuario = SesionUsuario.getUsuarioActual().getId();
            int idMesa = Integer.parseInt(vista.panelReservar.comboMesas.getSelectedItem().toString());
            String fecha = vista.panelReservar.txtFecha.getText();
            String hora = vista.panelReservar.txtHora.getText();
            String estado = vista.panelReservar.comboEstado.getSelectedItem().toString();
            String ubicacion = vista.panelReservar.comboUbicacion.getSelectedItem().toString();

            boolean resultado = reservaDAO.RegistroReserva( idUsuario, idMesa,  fecha,  hora, estado,  ubicacion);

            if (resultado) {
                JOptionPane.showMessageDialog(vista, "✅ Reserva registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "❌ Error al registrar la reserva.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "⚠️ Por favor, selecciona una mesa válida.");
        }
    }
    private void cerrarSesion(){
   
            SesionUsuario.cerrarSesion(); // 1. Limpiar sesión
            // 2. Cerrar ventana actual
            vista.dispose();

            // 3. Volver al login
            LoginView login = new LoginView();
            new ControlRegistro(login);
            login.setVisible(true);

    }
}
