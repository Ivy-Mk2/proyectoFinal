    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;
import javax.swing.*;
import java.awt.*;
import sesion.SesionUsuario;

/**
 *
 * @author ocasp
 */
public class MenuLateralPersonalizado extends JPanel {
        public JButton btnReservar;
        public JButton btnMisTurnos;
        public JButton btnGestorMesas;
        public JButton btnPerfil;
    public MenuLateralPersonalizado() {
       
        JPanel menuLateral = new JPanel();
        menuLateral.setLayout(new BoxLayout(menuLateral, BoxLayout.Y_AXIS));
        menuLateral.setPreferredSize(new Dimension(200, getHeight()));
        menuLateral.setBackground(Color.decode("#EEEEEE"));
        
        btnReservar = new JButton("Reservar turno");
        btnMisTurnos = new JButton("Mis turnos");
        btnGestorMesas = new JButton("Gestor de mesas");
        btnPerfil = new JButton("Perfil de usuario");

        JButton[] botones;

        if (SesionUsuario.getUsuarioActual().getTipo().equalsIgnoreCase("Admin")) {
            botones = new JButton[] { btnReservar, btnMisTurnos, btnGestorMesas, btnPerfil };
        } else {
            botones = new JButton[] {  btnReservar, btnMisTurnos, btnPerfil };
        }
        for (JButton btn : botones) {
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
            btn.setFocusPainted(false);
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
            btn.setBackground(Color.decode("#FCFC62"));
            btn.setOpaque(true);
            btn.setForeground(Color.BLACK);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            menuLateral.add(btn);
        }
        this.setLayout(new BorderLayout());
        this.add(menuLateral,BorderLayout.CENTER);
    }
}
