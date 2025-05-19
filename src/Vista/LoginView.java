/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Controlador.ControlRegistro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import utils.Placeholder;

/**
 *
 * @author ocasp
 */
    public class LoginView extends JFrame {
    // Variables de los Componentes
    public JLabel lblRestaurar;
    public JTextField txtUsuario,txtNuevoUsuario,txtNuevoCorreo,txtResCorreo;
    public JPasswordField txtPassword,txtNuevoPassword,txtConfirmarPassword;
    public JButton btnLogin,btnRegistro,btnCrearCuenta,btnRecuperar;
    public JComboBox<String> comboTipo;
    
    
    private CardLayout cardLayout;
    private JPanel panelContenedor;

    public LoginView() {
        setTitle("Turnify");
        setSize(800, 475);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel Izquierdo (Imagen o color)
        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.decode("#FCFC62"));
        panelLogo.setPreferredSize(new Dimension(350, getHeight()));

        // Contenedor con CardLayout
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        panelContenedor.setBackground(Color.decode("#A3A3A3"));

        // ---------------- FORMULARIO LOGIN ----------------
        JPanel formLogin = new JPanel();
        formLogin.setBackground(Color.decode("#A3A3A3"));
        formLogin.setLayout(new BoxLayout(formLogin, BoxLayout.Y_AXIS));
        formLogin.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        

        JLabel lblTitulo = new JLabel("Turnify");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblTitulo.getPreferredSize().height));
        
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtUsuario = new JTextField();
        txtUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtUsuario, "Correo");
        txtUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        txtPassword = new JPasswordField();
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtPassword, "Contraseña");
        txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblRestaurar = new JLabel("Restaurar contraseña");
        lblRestaurar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblRestaurar.setForeground(Color.GRAY);
        lblRestaurar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel panelRestaurar = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelRestaurar.setBackground(Color.decode("#A3A3A3"));
        panelRestaurar.add(lblRestaurar);
        panelRestaurar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

        btnLogin = new JButton("Ingresar");
        btnLogin.setBackground(Color.decode("#424242"));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT); // <-- clave


        btnRegistro = new JButton("Registrarte");
        btnRegistro.setBackground(Color.decode("#FCFC62"));
        btnRegistro.setForeground(Color.decode("#424242"));
        btnRegistro.setFocusPainted(false);
        btnRegistro.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnRegistro.setAlignmentX(Component.CENTER_ALIGNMENT); // <-- clave
        
        // Agregar al formulario de login
        formLogin.add(lblTitulo);
        formLogin.add(Box.createVerticalStrut(20));
        formLogin.add(txtUsuario);
        formLogin.add(Box.createVerticalStrut(10));
        formLogin.add(txtPassword);
        formLogin.add(Box.createVerticalStrut(10));
        formLogin.add(panelRestaurar);
        formLogin.add(btnLogin);
        formLogin.add(Box.createVerticalStrut(10));
        formLogin.add(btnRegistro);

        // ---------------- FORMULARIO RESTAURAR ----------------
        JPanel formRestore = new JPanel();
        formRestore.setBackground(Color.decode("#A3A3A3"));
        formRestore.setLayout(new BoxLayout(formRestore, BoxLayout.Y_AXIS));
        formRestore.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel lblRestoreTitle = new JLabel("Restaurar contraseña");
        lblRestoreTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblRestoreTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtResCorreo = new JTextField();
        txtResCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtResCorreo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtResCorreo, "Correo electrónico");
        txtResCorreo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        btnRecuperar = new JButton("Aceptar");
        btnRecuperar.setBackground(Color.decode("#424242"));
        btnRecuperar.setForeground(Color.WHITE);
        btnRecuperar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnRecuperar.setFocusPainted(false);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(Color.decode("#FCFC62"));
        btnCancelar.setForeground(Color.decode("#424242"));
        btnCancelar.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnCancelar.setFocusPainted(false);

        formRestore.add(lblRestoreTitle);
        formRestore.add(Box.createVerticalStrut(20));
        formRestore.add(txtResCorreo);
        formRestore.add(Box.createVerticalStrut(20));
        formRestore.add(btnRecuperar);
        formRestore.add(Box.createVerticalStrut(10));
        formRestore.add(btnCancelar);
        
        // ---------------- FORMULARIO REGISTRO ----------------
        JPanel formRegister = new JPanel();
        formRegister.setBackground(Color.decode("#A3A3A3"));
        formRegister.setLayout(new BoxLayout(formRegister, BoxLayout.Y_AXIS));
        formRegister.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel lblRegisterTitle = new JLabel("Crear cuenta");
        lblRegisterTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
        lblRegisterTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblRegisterTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegisterTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblTitulo.getPreferredSize().height));

        txtNuevoUsuario = new JTextField();
        txtNuevoUsuario.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtNuevoUsuario.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtNuevoUsuario, "Nombre de usuario");
        txtNuevoUsuario.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        txtNuevoPassword = new JPasswordField();
        txtNuevoPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtNuevoPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtNuevoPassword, "Contraseña");
        txtNuevoPassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
         
        txtConfirmarPassword = new JPasswordField();
        txtConfirmarPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtConfirmarPassword.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtConfirmarPassword, "Confirma tu contraseña");
        txtConfirmarPassword.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
      
        txtNuevoCorreo =new JTextField();
        txtNuevoCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtNuevoCorreo.setFont(new Font("Segoe UI", Font.BOLD, 15));
        Placeholder.aplicar(txtNuevoCorreo, "Correo");
        txtNuevoCorreo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        comboTipo = new JComboBox<>(new String[] { "Admin", "Cliente"});
        comboTipo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        comboTipo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        comboTipo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        
        btnCrearCuenta = new JButton("Crear cuenta");
        btnCrearCuenta.setBackground(Color.decode("#424242"));
        btnCrearCuenta.setForeground(Color.WHITE);
        btnCrearCuenta.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnCrearCuenta.setFocusPainted(false);
        btnCrearCuenta.setAlignmentX(Component.CENTER_ALIGNMENT); // <-- clave


        JButton btnVolverLogin = new JButton("¿Ya tienes cuenta? Iniciar sesión");
        btnVolverLogin.setBackground(Color.decode("#FCFC62"));
        btnVolverLogin.setForeground(Color.decode("#424242"));
        btnVolverLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnVolverLogin.setAlignmentX(Component.CENTER_ALIGNMENT); // 
        btnVolverLogin.setFocusPainted(false);

        // Agregar al formulario
        formRegister.add(lblRegisterTitle);
        formRegister.add(Box.createVerticalStrut(20));
        formRegister.add(txtNuevoUsuario);
        formRegister.add(Box.createVerticalStrut(10));
        formRegister.add(txtNuevoPassword);
        formRegister.add(Box.createVerticalStrut(10));
        formRegister.add(txtConfirmarPassword);
        formRegister.add(Box.createVerticalStrut(10));
        formRegister.add(txtNuevoCorreo);
        formRegister.add(Box.createVerticalStrut(10));
        formRegister.add(comboTipo);
        formRegister.add(Box.createVerticalStrut(10));
        
        
        
        formRegister.add(btnCrearCuenta);
        formRegister.add(Box.createVerticalStrut(10));
        formRegister.add(btnVolverLogin);


        // Agregar ambos formularios al contenedor
        panelContenedor.add(formLogin, "login");
        panelContenedor.add(formRestore, "restore");
        panelContenedor.add(formRegister, "registro");

        // Mostrar por defecto el formulario de login
        cardLayout.show(panelContenedor, "login");

        // Agregar los dos paneles principales al JFrame
        add(panelContenedor, BorderLayout.CENTER);

        // ---------------- Eventos ----------------
        lblRestaurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cardLayout.show(panelContenedor, "restore");
            }
        });

        btnCancelar.addActionListener(e -> {
            cardLayout.show(panelContenedor, "login");
        });
        btnRegistro.addActionListener(e->{
            cardLayout.show(panelContenedor, "registro");
        });
        btnVolverLogin.addActionListener(e -> {
        cardLayout.show(panelContenedor, "login");
        });
    }

        public void mostrarLogin(){
            cardLayout.show(panelContenedor, "login");
        }

        
}

