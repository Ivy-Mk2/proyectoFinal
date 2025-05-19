package vista;

import javax.swing.*;
import java.awt.*;

public class PanelPerfil extends JPanel {

    public JButton btnCerrarSesion;

    public PanelPerfil() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7"));

        // ---------- TÍTULO ----------
        JLabel lblTitulo = new JLabel("¡Bienvenido, " + sesion.SesionUsuario.getUsuarioActual().getNombre() + "!", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 20, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ---------- DATOS DE PERFIL ----------
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setBackground(getBackground());
        panelInfo.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 50));

        panelInfo.add(crearDato("Correo", sesion.SesionUsuario.getUsuarioActual().getCorreo()));
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(crearDato("Contraseña", "********"));
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(crearDato("Nombre completo", sesion.SesionUsuario.getUsuarioActual().getNombre()));
        panelInfo.add(Box.createVerticalStrut(10));
        panelInfo.add(crearDato("Tipo de usuario", sesion.SesionUsuario.getUsuarioActual().getTipo()));

        add(panelInfo, BorderLayout.CENTER);

        // ---------- BOTÓN CERRAR SESIÓN ----------
        JPanel panelBoton = new JPanel();
        panelBoton.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        panelBoton.setBackground(getBackground());

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBackground(Color.WHITE);
        btnCerrarSesion.setPreferredSize(new Dimension(Integer.MAX_VALUE, 50));
        btnCerrarSesion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        panelBoton.setLayout(new BorderLayout());
        panelBoton.add(btnCerrarSesion, BorderLayout.CENTER);

        add(panelBoton, BorderLayout.SOUTH);
    }

    public JButton getbtCerrarSesion() {
        return btnCerrarSesion;
    }

    private JPanel crearDato(String titulo, String valor) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblValor.setHorizontalAlignment(SwingConstants.RIGHT);

        panel.add(lblTitulo, BorderLayout.WEST);
        panel.add(lblValor, BorderLayout.EAST);

        return panel;
    }
}
