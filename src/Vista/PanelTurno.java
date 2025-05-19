package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelTurno extends JPanel {

    public JTable tablaTurnos;
    public DefaultTableModel modeloTabla;
    public JButton btnEliminar;
    public JButton btnRefrescar;

    public PanelTurno() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7")); // Fondo claro

        // Título
        JLabel lblTitulo = new JLabel("Mis Turnos");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
        add(lblTitulo, BorderLayout.NORTH);

        // Columnas según formulario de reserva
        String[] columnas = { "ID","Mesa", "Fecha", "Hora", "Ubicación", "Estado", "Comentarios" };
        modeloTabla = new DefaultTableModel(columnas, 0); // Inicial sin filas

        // Tabla
        tablaTurnos = new JTable(modeloTabla);
        tablaTurnos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tablaTurnos.setRowHeight(30);
        tablaTurnos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));

        JScrollPane scrollTabla = new JScrollPane(tablaTurnos);
        scrollTabla.setBorder(BorderFactory.createEmptyBorder(10, 20, 20, 20));
        
        // ---------- PANEL DE BOTONES ----------
        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(getBackground());
        panelBotones.setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 10));

        // Botón eliminar
        btnEliminar = new JButton("Eliminar");
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBackground(Color.decode("#E57373")); // Rojo claro
        btnEliminar.setForeground(Color.WHITE);

        // Botón refrescar
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setFocusPainted(false);
        btnRefrescar.setBackground(Color.decode("#64B5F6")); // Azul claro
        btnRefrescar.setForeground(Color.WHITE);

        // Agregar botones al panel
        panelBotones.add(btnEliminar);
        panelBotones.add(btnRefrescar);

        // Agregar panel de botones al sur del panel principal
        add(panelBotones, BorderLayout.SOUTH);
        add(scrollTabla, BorderLayout.CENTER);
        }


    public JTable getTabla() {
        return tablaTurnos;
    }

}
