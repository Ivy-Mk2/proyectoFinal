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


public class GestorMesas extends JPanel {
    public JTextField txtNombreMesa;
    public JTextField txtCapacidadMesa;
    public JButton btnRegistrarMesa;

    public GestorMesas() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Registrar Nueva Mesa");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridwidth = 1;

        JLabel lblNombre = new JLabel("Nombre:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblNombre, gbc);

        txtNombreMesa = new JTextField();
        gbc.gridx = 1;
        add(txtNombreMesa, gbc);

        JLabel lblCapacidad = new JLabel("Capacidad:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblCapacidad, gbc);

        txtCapacidadMesa = new JTextField();
        gbc.gridx = 1;
        add(txtCapacidadMesa, gbc);

        btnRegistrarMesa = new JButton("Registrar Mesa");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnRegistrarMesa, gbc);
    }
}
