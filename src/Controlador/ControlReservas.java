    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Mesas;
import Vista.LoginView;
import Vista.MenuPrincipal;
import conexión.ConexionBD;
import dao.ReservaDAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.Reservas;
import sesion.SesionUsuario;
import vista.PanelReservar;
import dao.MesasDAO;
import Modelo.MesaComboItem;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.PanelTurno;

/**
 *
 * @author ocasp
 */
public class ControlReservas implements ActionListener{
    private PanelReservar vista;
    private PanelTurno panelTurno;
    private ReservaDAO reservaDAO;
    private MesasDAO mesasDAO;


    
    public ControlReservas( PanelReservar vista,PanelTurno panelTurno){
        this.vista=vista;
        this.panelTurno = panelTurno;

        this.reservaDAO = new ReservaDAO(ConexionBD.getConexion());
        this.mesasDAO=new MesasDAO(ConexionBD.getConexion());
        
        vista.btnReservar.addActionListener(this); 
        panelTurno.btnEliminar.addActionListener(this);
        panelTurno.btnRefrescar.addActionListener(this);

        cargarMesasDisponibles();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();

    if (source == vista.btnReservar) {
        registrarReserva();
    } else if (source == panelTurno.btnEliminar) {
        eliminarReservaSeleccionada();
    } else if (source == panelTurno.btnRefrescar) {
        mostrarReservasEnTabla(panelTurno.getTabla());
}

    }
    private void registrarReserva() {
        
        try {
            
            int idUsuario = SesionUsuario.getUsuarioActual().getId();
            MesaComboItem item = (MesaComboItem) vista.comboMesa.getSelectedItem();
            int idMesa = item.getId();           
            Date fechaSpinnerValue = (Date) vista.dateSpinner.getValue();
            Date horaSpinnerValue = (Date) vista.timeSpinner.getValue();
            
            //  Formatear a texto 
            String fechaString = new SimpleDateFormat("dd/MM/yyyy").format(fechaSpinnerValue);
            String horaString = new SimpleDateFormat("hh:mm a").format(horaSpinnerValue);
            
            String ubicacion = vista.comboUbicacion.getSelectedItem().toString();
            String estado = vista.comboEstado.getSelectedItem().toString();
            String comentario = vista.txtComentario.getText();
            
            

            Reservas reserva = new Reservas(idUsuario,idMesa, fechaString, horaString, ubicacion, estado, comentario);
            boolean resultado = reservaDAO.registrarReserva(reserva);

            if (resultado) {
                JOptionPane.showMessageDialog(vista, "✅ Reserva registrada correctamente.");
            } else {
                JOptionPane.showMessageDialog(vista, "❌ Error al registrar la reserva.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "⚠️ Error al procesar la reserva: " + ex.getMessage());
        }
    }
    private void cargarMesasDisponibles() {
        List<Mesas> mesas = mesasDAO.obtenerMesasDisponibles(); // crea este método en tu MesasDAO
        vista.comboMesa.removeAllItems();

        for (Mesas mesa : mesas) {
            String label = "Mesa " + mesa.getNumero() + " (" + mesa.getCapacidad() + " personas)";
            vista.comboMesa.addItem(new MesaComboItem(mesa.getId(), label));
        }
    }
    public void recargarMesas(){
        cargarMesasDisponibles();
    }
    public void mostrarReservasEnTabla(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Limpiar la tabla

    int idUsuario = SesionUsuario.getUsuarioActual().getId();
    List<Reservas> lista = reservaDAO.obtenerReservasPorUsuario(idUsuario);

    for (Reservas r : lista) {
        Object[] fila = {
            r.getId(),r.getIdMesa(), r.getFecha(), r.getHora(),
            r.getUbicacion(), r.getEstado(  ), r.getComentario()
        };
        modelo.addRow(fila);
    }
}
    private void eliminarReservaSeleccionada() {
        JTable tabla = panelTurno.getTabla();
        int fila = tabla.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(panelTurno, "Debes seleccionar una reserva.");
            return;
        }

        int idReserva = (int) tabla.getValueAt(fila, 0); // Asumiendo que la columna 0 es el ID
        int confirmacion = JOptionPane.showConfirmDialog(panelTurno, "¿Eliminar esta reserva?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean eliminado = reservaDAO.eliminarReserva(idReserva);
            if (eliminado) {
                JOptionPane.showMessageDialog(panelTurno, "✅ Reserva eliminada.");
                mostrarReservasEnTabla(tabla);
            } else {
                JOptionPane.showMessageDialog(panelTurno, "❌ Error al eliminar reserva.");
            }
        }
}

    
    
}
