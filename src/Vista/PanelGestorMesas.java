/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;


/**
 *
 * @author ocasp
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PanelGestorMesas extends JPanel {

    public JTextField txtNumero;
    public JTextField txtCapacidad;
    public JComboBox<String> comboEstado,comboUbicacion;
    public JButton btnRegistrarMesa;
    public JButton btnActualizarMesa;
    public JButton btnEliminarMesa;
    public JTable tablaMesas;
    public DefaultTableModel modeloTabla;

    public PanelGestorMesas() {
        setLayout(new BorderLayout(10, 10));

        // Formulario
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createTitledBorder("Datos de la mesa"));

        txtNumero = new JTextField();
        txtCapacidad = new JTextField();
        comboUbicacion = new JComboBox<>(new String[]{"Interno", "Terraza"});
        comboEstado = new JComboBox<>(new String[]{"Disponible", "Ocupada", "Reservada"});

        formPanel.add(new JLabel("Número de Mesa:"));
        formPanel.add(txtNumero);
        formPanel.add(new JLabel("Capacidad:"));
        formPanel.add(txtCapacidad);
        formPanel.add(new JLabel("Ubicación:"));
        formPanel.add(comboUbicacion);
        formPanel.add(new JLabel("Estado:"));
        formPanel.add(comboEstado);

        // Botones
        JPanel botonesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        btnRegistrarMesa = new JButton("Registrar Mesa");
        btnActualizarMesa = new JButton("Actualizar Mesa");
        btnEliminarMesa = new JButton("Eliminar Mesa");
        botonesPanel.add(btnRegistrarMesa);
        botonesPanel.add(btnActualizarMesa);
        botonesPanel.add(btnEliminarMesa);

        // Tabla
        String[] columnas = {"ID", "Número", "Capacidad", "Ubicación", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaMesas = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaMesas);
        scrollTabla.setBorder(BorderFactory.createTitledBorder("Lista de Mesas"));

        // Agregar al panel principal
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(botonesPanel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);
        add(scrollTabla, BorderLayout.CENTER);
    }
}
