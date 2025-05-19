    package Vista;

import javax.swing.*;
import java.awt.*;
import vista.PanelInicio;
import vista.PanelPerfil;
import vista.PanelReservar;
import vista.PanelTurno;
import Vista.MenuLateralPersonalizado;
import Vista.PanelGestorMesas;
import Controlador.ControlMenu;
import Controlador.ControlMesas;
import Controlador.ControlReservas;
import conexión.ConexionBD;
import sesion.SesionUsuario;
import dao.ReservaDAO;

public class MenuPrincipal extends JFrame {
    CardLayout cardLayout;
    JPanel panelContenido;
    public PanelReservar panelReservar;
    public PanelInicio panelInicio;
    public PanelPerfil panelPerfil;
    public PanelGestorMesas gestorMesas;
    public MenuLateralPersonalizado menuLateral;
    public PanelTurno panelTurno;
    public ControlReservas controlReservas;

    public MenuPrincipal() {
        // Instanciar paneles
        panelReservar = new PanelReservar();
        panelTurno = new PanelTurno();
        panelPerfil = new PanelPerfil();
        panelInicio = new PanelInicio(SesionUsuario.getUsuarioActual().getNombre());
        gestorMesas = new PanelGestorMesas();
        menuLateral = new MenuLateralPersonalizado();

        // Instanciar controladores
        controlReservas = new ControlReservas(panelReservar,panelTurno);
        new ControlMesas(gestorMesas).actualizarTabla();
        

        // Configuración de la ventana
        setTitle("Panel principal - Turnify");
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel central con CardLayout
        cardLayout = new CardLayout();
        panelContenido = new JPanel(cardLayout);

        // Agregar vistas
        panelContenido.add(panelReservar, "reservar");
        panelContenido.add(panelTurno, "turnos");
        panelContenido.add(panelPerfil, "perfil");

        if (SesionUsuario.getUsuarioActual().getTipo().equalsIgnoreCase("Admin")) {
            panelContenido.add(gestorMesas, "mesas");
        }

        // Agregar paneles a la ventana
        add(menuLateral, BorderLayout.WEST);
        add(panelContenido, BorderLayout.CENTER);

        // Eventos de navegación
        menuLateral.btnReservar.addActionListener(e -> {
            controlReservas.recargarMesas(); // <-- esto llena el combo
            cardLayout.show(panelContenido, "reservar");
        });

        menuLateral.btnMisTurnos.addActionListener(e -> {
            controlReservas.mostrarReservasEnTabla(panelTurno.getTabla());
            cardLayout.show(panelContenido, "turnos");
        });

        menuLateral.btnPerfil.addActionListener(e -> {
            cardLayout.show(panelContenido, "perfil");
        });

        menuLateral.btnGestorMesas.addActionListener(e -> {
            cardLayout.show(panelContenido, "mesas");
        });
    }

    // Panel genérico
    private JPanel crearPanel(String texto) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        JLabel label = new JLabel(texto);
        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panel.add(label);
        return panel;
    }

    private JPanel ContenidoNodisponible(String texto) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        JLabel label = new JLabel("<html><div style='text-align: center;'>⚠️<br>" + texto + "</div></html>");
        label.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        label.setForeground(Color.DARK_GRAY);
        panel.add(label);
        return panel;
    }
}
