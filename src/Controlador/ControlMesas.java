/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mesas;
import Vista.PanelGestorMesas;
import dao.MesasDAO;
import conexión.ConexionBD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.JButton;

/**
 *
 * @author ocasp
 */
public class ControlMesas implements ActionListener{
    private PanelGestorMesas gestorMesas;
    private MesasDAO mesasDAO;
  
    
    public ControlMesas (PanelGestorMesas gestorMesas){
        this.gestorMesas= gestorMesas;
        this.mesasDAO= new MesasDAO(ConexionBD.getConexion());
        gestorMesas.btnActualizarMesa.addActionListener(this);
        gestorMesas.btnEliminarMesa.addActionListener(this);
        gestorMesas.btnRegistrarMesa.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source == gestorMesas.btnRegistrarMesa){
            registrarMesa();
            actualizarTabla();
        }else if(source==gestorMesas.btnEliminarMesa){
            eliminarMesa();
            actualizarTabla();

        }else{
            actualizarTabla();
        }

    }
    public void registrarMesa(){
        String numero = gestorMesas.txtNumero.getText();
        int capacidad = Integer.parseInt(gestorMesas.txtCapacidad.getText());
        String ubicacion = gestorMesas.comboUbicacion.getSelectedItem().toString();
        String estado = gestorMesas.comboEstado.getSelectedItem().toString();
        
        if ( numero.isEmpty()||gestorMesas.txtCapacidad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(gestorMesas, "Por favor completa todos los campos.");
            return;
        }
        Mesas mesa = new Mesas(numero,capacidad,ubicacion,estado);
        
        boolean exito = mesasDAO.registrarMesa(mesa);
        if (exito) {
            JOptionPane.showMessageDialog(gestorMesas, "Mesa registrada correctamente.");
        } else {
            JOptionPane.showMessageDialog(gestorMesas, "Error al registrar nueva mesa.");
        }
        
    }
    public void actualizarTabla() {
        gestorMesas.modeloTabla.setRowCount(0); // Limpiar tabla

        for (Mesas mesa : mesasDAO.obtenerTodasLasMesas()) {
            Object[] fila = {
                mesa.getId(),
                mesa.getNumero(),
                mesa.getCapacidad(),
                mesa.getUbicacion(),
                mesa.getEstado()
            };
            gestorMesas.modeloTabla.addRow(fila);
        }
    }
    public void eliminarMesa() {
        int filaSeleccionada = gestorMesas.tablaMesas.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(gestorMesas, "Seleccione una mesa para eliminar.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(gestorMesas, "¿Estás seguro de eliminar esta mesa?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            int id = (int) gestorMesas.modeloTabla.getValueAt(filaSeleccionada, 0);
            if (mesasDAO.eliminarMesa(id)) {
                JOptionPane.showMessageDialog(gestorMesas, "Mesa eliminada correctamente.");
            } else {
                JOptionPane.showMessageDialog(gestorMesas, "Error al eliminar la mesa.");
            }
    }
}

    

    
}
