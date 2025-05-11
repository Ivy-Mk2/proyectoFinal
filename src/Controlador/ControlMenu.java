/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.MenuPrincipal;
import dao.ReservaDAO;
import conexión.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    }
      @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
    if (source == vista.panelReservar.btnReservar) {
    registrarReserva();
    }
    }
    private void registrarReserva() {
        try {
            int idMesa = Integer.parseInt(vista.panelReservar.comboMesas.getSelectedItem().toString());
            String fecha = vista.panelReservar.txtFecha.getText();
            String hora = vista.panelReservar.txtHora.getText();
            String ubicacion = vista.panelReservar.comboUbicacion.getSelectedItem().toString();

            boolean resultado = reservaDAO.RegistroReserva(idMesa, fecha, hora, ubicacion);

            if (resultado) {
                JOptionPane.showMessageDialog(vista, "✅ Reserva registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "❌ Error al registrar la reserva.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "⚠️ Por favor, selecciona una mesa válida.");
        }
    }
    
}
