package vista;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {

    public PanelInicio(String nombreUsuario) {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7"));

        // ---------------- BIENVENIDA ----------------
        JLabel lblBienvenida = new JLabel("¡Bienvenido, " + nombreUsuario + "!", SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblBienvenida.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        add(lblBienvenida, BorderLayout.NORTH);

        // ---------------- CENTRO: INFO CARDS ----------------
        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(2, 1, 10, 20));
        panelCentro.setBackground(getBackground());
        panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        // Tarjeta 1 - Próximo turno
        JPanel cardTurno = crearTarjeta("Próximo turno", "Lunes 13, 10:30 AM");
        // Tarjeta 2 - Turnos pendientes y estado de perfil
        JPanel cardEstado = crearTarjeta(" Turnos pendientes: 3", "Perfil: Completo ✅");

        panelCentro.add(cardTurno);
        panelCentro.add(cardEstado);
        add(panelCentro, BorderLayout.CENTER);

        // ---------------- BOTONES DE ACCESO RÁPIDO ----------------
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 15, 0));
        panelBotones.setBackground(getBackground());
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 50, 30, 50));

        JButton btnReservar = crearBotonAccion("📅", "Reservar turno");
        JButton btnHistorial = crearBotonAccion("🕘", "Ver historial");
        btnHistorial.setBackground(Color.decode("#FCFC62"));
        JButton btnPerfil = crearBotonAccion("👤", "Actualizar perfil");

        panelBotones.add(btnReservar);
        panelBotones.add(btnHistorial);
        panelBotones.add(btnPerfil);

        add(panelBotones, BorderLayout.SOUTH);
    }

    private JPanel crearTarjeta(String titulo, String dato) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel lblDato = new JLabel(dato, SwingConstants.RIGHT);
        lblDato.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        panel.add(lblTitulo, BorderLayout.WEST);
        panel.add(lblDato, BorderLayout.EAST);
        return panel;
    }

    private JButton crearBotonAccion(String icono, String texto) {
        JButton btn = new JButton(icono + "  " + texto);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        btn.setBackground(Color.WHITE);
        btn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        return btn;
    }
}
