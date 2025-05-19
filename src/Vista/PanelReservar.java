package vista;

import Modelo.MesaComboItem;
import javax.swing.*;
import java.awt.*;
import java.util.Date;
import javax.swing.border.TitledBorder;

public class PanelReservar extends JPanel {

    public JSpinner dateSpinner;
    public JSpinner timeSpinner;
    public JComboBox<String> comboUbicacion,comboEstado;
    public JComboBox<MesaComboItem> comboMesa;
    public JTextArea txtComentario;
    public JButton btnReservar;

    public PanelReservar() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7"));

        // ---------- TÍTULO ----------
        JLabel lblTitulo = new JLabel("Reservar turno", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ---------- FORMULARIO ----------
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(Color.WHITE);
        formPanel.setBorder(BorderFactory.createEmptyBorder(5, 40, 5, 40));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        // COMPONENTES
        comboMesa = new JComboBox<>();
        dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy"));
        timeSpinner = new JSpinner(new SpinnerDateModel(new Date(), null, null, java.util.Calendar.MINUTE));
        timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "hh:mm a"));
        comboUbicacion = new JComboBox<>(new String[]{"Interno", "Terraza"});

        comboEstado = new JComboBox<>(new String[]{"Asignada","Libre"});
        comboEstado.setEditable(false);
        txtComentario = new JTextArea(5, 20);
        txtComentario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtComentario.setLineWrap(true);
        txtComentario.setWrapStyleWord(true);
        JScrollPane comentarioScroll = new JScrollPane(txtComentario);
        comentarioScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        comentarioScroll.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        btnReservar = new JButton("Reservar");
        btnReservar.setBackground(Color.decode("#FCFC62"));
        btnReservar.setFocusPainted(false);

        // ---------- DISTRIBUCIÓN ----------

        // MESAS (fila completa)
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        formPanel.add(estilizar("Mesas", comboMesa), gbc);

        // FECHA
        gbc.gridy++; gbc.gridwidth = 1;
        formPanel.add(estilizar("Fecha", dateSpinner), gbc);

        // HORA
        gbc.gridx = 1;
        formPanel.add(estilizar("Hora", timeSpinner), gbc);

        // UBICACIÓN
        gbc.gridy++; gbc.gridx = 0;
        formPanel.add(estilizar("Ubicación", comboUbicacion), gbc);

        // ESTADO
        gbc.gridx = 1;
        formPanel.add(estilizar("Estado", comboEstado), gbc);

        // COMENTARIOS (fila completa, más alto)
        gbc.gridy++; gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.weighty = 2; // ocupa más espacio vertical
        gbc.fill = GridBagConstraints.BOTH;
        formPanel.add(estilizar("Comentarios", comentarioScroll), gbc);

        // BOTÓN (centrado)
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(btnReservar, gbc);

        add(formPanel, BorderLayout.CENTER);
    }

    private JPanel estilizar(String etiqueta, JComponent campo) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        campo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        campo.setPreferredSize(new Dimension(200, 30));
        campo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        TitledBorder borde = BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                etiqueta,
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Segoe UI", Font.BOLD, 13),
                Color.DARK_GRAY
        );
        panel.setBorder(borde);
        panel.add(campo, BorderLayout.CENTER);
        return panel;
    }
} 
