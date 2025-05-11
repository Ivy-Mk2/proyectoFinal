package vista;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelTurno extends JPanel {

    private JPanel panelListaTurnos;
    private JComboBox<String> comboFiltro;

    public PanelTurno() {
        setLayout(new BorderLayout());
        setBackground(Color.decode("#F7F7F7"));

        // ----- TÍTULO -----
        JLabel lblTitulo = new JLabel("Mis turnos", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 26));
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(lblTitulo, BorderLayout.NORTH);

        // ----- FILTRO -----
        JPanel panelFiltro = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelFiltro.setBackground(getBackground());
        comboFiltro = new JComboBox<>(new String[]{"Todos", "Confirmados", "Cancelados", "Reagendados"});
        panelFiltro.add(comboFiltro);
        add(panelFiltro, BorderLayout.BEFORE_FIRST_LINE);

        // ----- LISTA DE TURNOS -----
        panelListaTurnos = new JPanel();
        panelListaTurnos.setLayout(new BoxLayout(panelListaTurnos, BoxLayout.Y_AXIS));
        panelListaTurnos.setBackground(getBackground());
        JScrollPane scroll = new JScrollPane(panelListaTurnos);
        scroll.setBorder(null);
        add(scroll, BorderLayout.CENTER);

        // Simulación de turnos (más adelante se conecta a BD)
        mostrarTurnosSimulados();
    }

    private void mostrarTurnosSimulados() {
        panelListaTurnos.removeAll();

        // Lista simulada
        ArrayList<TurnoUI> turnos = new ArrayList<>();
        turnos.add(new TurnoUI("Mesa 3", "Lunes 13", "10:30 AM", "Interior", "Confirmada"));
        turnos.add(new TurnoUI("Mesa 3", "Miércoles 15", "10:30 AM", "Interior", "Cancelada"));
        turnos.add(new TurnoUI("Mesa 3", "Viernes 17", "10:30 AM", "Terraza", "Reagendada"));

        for (TurnoUI turno : turnos) {
            panelListaTurnos.add(crearTarjetaTurno(turno));
            panelListaTurnos.add(Box.createVerticalStrut(10));
        }

        revalidate();
        repaint();
    }

    private JPanel crearTarjetaTurno(TurnoUI turno) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)
        ));

        // Datos básicos
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setBackground(Color.WHITE);
        JLabel lblMesa = new JLabel(turno.mesa);
        lblMesa.setFont(new Font("Segoe UI", Font.BOLD, 16));
        JLabel lblFecha = new JLabel(turno.fecha + "  •  " + turno.hora);
        JLabel lblUbicacion = new JLabel(turno.ubicacion);

        info.add(lblMesa);
        info.add(lblFecha);
        info.add(lblUbicacion);

        // Estado
        JLabel lblEstado = new JLabel(turno.estado);
        lblEstado.setOpaque(true);
        lblEstado.setForeground(Color.BLACK);
        lblEstado.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
        lblEstado.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        switch (turno.estado.toLowerCase()) {
            case "confirmada":
                lblEstado.setBackground(Color.decode("#C8FACC")); break;
            case "cancelada":
                lblEstado.setBackground(Color.decode("#F9C6C6")); break;
            case "reagendada":
                lblEstado.setBackground(Color.decode("#FCF3C2")); break;
            default:
                lblEstado.setBackground(Color.LIGHT_GRAY);
        }

        panel.add(info, BorderLayout.WEST);
        panel.add(lblEstado, BorderLayout.EAST);
        return panel;
    }

    // Clase interna solo para visualizar datos
    class TurnoUI {
        String mesa, fecha, hora, ubicacion, estado;
        public TurnoUI(String mesa, String fecha, String hora, String ubicacion, String estado) {
            this.mesa = mesa;
            this.fecha = fecha;
            this.hora = hora;
            this.ubicacion = ubicacion;
            this.estado = estado;
        }
    }
}
