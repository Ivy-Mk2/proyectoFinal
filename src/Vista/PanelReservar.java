/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

/**
 *
 * @author ocasp
 */

import javax.swing.*;   
import java.awt.*;

public class PanelReservar extends JPanel {

    public JComboBox<String> comboMesas;
    public JTextField txtFecha;
    public JTextField txtHora;
    public JComboBox<String> comboUbicacion,comboEstado;
    public JButton btnReservar;



    public PanelReservar() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7"));

        // ---------- Título ----------
        JLabel lblTitulo = new JLabel("Reservar turno", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ---------- Panel central con los campos ----------
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 1, 10, 10));
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));

        comboMesas = new JComboBox<>(new String[] { "1", "2", "3", "4", "5" });
        comboMesas.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        txtFecha = new JTextField();
        txtFecha.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtFecha.setToolTipText("dd/mm/aaaa");

        txtHora = new JTextField();
        txtHora.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtHora.setToolTipText("HH:MM AM/PM");

        comboUbicacion = new JComboBox<>(new String[] { "Interior", "Terraza" });
        comboUbicacion.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        comboEstado = new JComboBox<>(new String[] {"Confirmada", "Cancelada", "ReAgendada" });
        comboEstado.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        btnReservar = new JButton("Reservar");
        btnReservar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnReservar.setBackground(Color.decode("#FCFC62"));
        btnReservar.setFocusPainted(false);

        formPanel.add(estilizar("Mesas", comboMesas));
        formPanel.add(estilizar("Fecha", txtFecha));
        formPanel.add(estilizar("Hora", txtHora));
        formPanel.add(estilizar("Ubicación", comboUbicacion));
        formPanel.add("Estado",comboEstado);
        formPanel.add(btnReservar);

        add(formPanel, BorderLayout.CENTER);
    }
    
    public JButton getBtnReservar() {
        return btnReservar;
    }
    private JPanel estilizar(String etiqueta, JComponent campo) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel lbl = new JLabel(etiqueta);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 14));
        panel.setBackground(Color.WHITE);
        panel.add(lbl, BorderLayout.NORTH);
        panel.add(campo, BorderLayout.CENTER);
        return panel;
    }
}

