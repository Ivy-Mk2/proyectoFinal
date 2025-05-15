/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;

import vista.PanelInicio;
import vista.PanelPerfil;
import vista.PanelReservar;
import vista.PanelTurno;
import Vista.GestorMesas;

import Controlador.ControlMenu;
import conexión.ConexionBD;

import sesion.SesionUsuario;


/**
 *
 * @author ocasp
 */

public class MenuPrincipal extends JFrame {
    CardLayout cardLayout;
    JPanel panelContenido;
    public PanelReservar panelReservar;
    public PanelInicio panelInicio;
    public PanelPerfil panelPerfil;
    public GestorMesas gestorMesas;
            

    public MenuPrincipal() {
        panelReservar = new PanelReservar();
        panelInicio = new PanelInicio(SesionUsuario.getUsuarioActual().getNombre());
        panelPerfil = new PanelPerfil();
        gestorMesas = new GestorMesas();
        
        
        setTitle("Panel principal - Turnify");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Menú lateral
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        menuLateral.setPreferredSize(new Dimension(200, getHeight()));
        menuLateral.setBackground(Color.decode("#EEEEEE"));

        JButton btnInicio = new JButton("Inicio");
        JButton btnReservar = new JButton("Reservar turno");
        JButton btnMisTurnos = new JButton("Mis turnos");
        JButton btnGestorMesas = new JButton("Gestor de mesas");
        JButton btnPerfil = new JButton("Perfil de usuario");
        JButton btnSoporte = new JButton("Soporte");

        JButton[] botones;

        if (SesionUsuario.getUsuarioActual().getTipo().equalsIgnoreCase("Admin")) {
            botones = new JButton[] { btnInicio, btnReservar, btnMisTurnos, btnGestorMesas, btnPerfil, btnSoporte };
        } else {
            botones = new JButton[] { btnInicio, btnReservar, btnMisTurnos, btnPerfil, btnSoporte };
        }
        for (JButton btn : botones) {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
            btn.setFocusPainted(false);
            menuLateral.add(Box.createVerticalStrut(10));
            menuLateral.add(btn);
        }

        // Panel de contenido central con CardLayout
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);
        
        // Vistas segun seleccion 
        panelContenido.add( panelInicio, "inicio");//Mensaje de bienvenida segun ususario
        panelContenido.add (panelReservar,"reservar");
        panelContenido.add(new PanelTurno(),"turnos");
        panelContenido.add(panelPerfil,"perfil");
        if(SesionUsuario.getUsuarioActual().getTipo().equalsIgnoreCase("Admin")){
        panelContenido.add(gestorMesas,"mesas");
            
        }
        panelContenido.add(crearPanel("Soporte"), "soporte");

        // Añadir al frame
        add(menuLateral, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);

        // Eventos de navegación
        btnInicio.addActionListener(e -> cardLayout.show(panelContenido, "inicio"));
        btnReservar.addActionListener(e -> cardLayout.show(panelContenido, "reservar"));
        btnMisTurnos.addActionListener(e -> cardLayout.show(panelContenido, "turnos"));
        btnPerfil.addActionListener(e -> cardLayout.show(panelContenido, "perfil"));
        btnGestorMesas.addActionListener(e -> cardLayout.show(panelContenido, "mesas"));
        btnSoporte.addActionListener(e -> cardLayout.show(panelContenido, "soporte"));
    }

    // Panel genérico de contenido
    private JPanel crearPanel(String texto) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panel.add(label);
        return panel;
    }

    
}