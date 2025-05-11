package Controlador;

import Vista.LoginView;
import Vista.MenuPrincipal;

import dao.UsuarioDAO;
import conexión.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlRegistro implements ActionListener {

    private LoginView vista;
    private UsuarioDAO usuarioDAO;

    public ControlRegistro(LoginView vista) {
        this.vista = vista;
        this.usuarioDAO = new UsuarioDAO(ConexionBD.getConexion());

        // Registrar los eventos
        vista.btnCrearCuenta.addActionListener(this);
        vista.btnLogin.addActionListener(this);
        vista.btnRecuperar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == vista.btnCrearCuenta) {
            registrarUsuario();
        }

        if (source == vista.btnLogin) {
            iniciarSesion();
        }
        if (source==vista.btnRecuperar){
            recuerarCuenta();
        }
    }

    private void registrarUsuario() {
        String nombre = vista.txtNuevoUsuario.getText();
        String correo = vista.txtNuevoCorreo.getText();
        String clave1 = new String(vista.txtNuevoPassword.getPassword());
        String clave2 = new String(vista.txtConfirmarPassword.getPassword());
        String tipo = vista.comboTipo.getSelectedItem().toString();

        if (nombre.isEmpty() || correo.isEmpty() || clave1.isEmpty() || clave2.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor completa todos los campos.");
            return;
        }

        if (!clave1.equals(clave2)) {
            JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden.");
            return;
        }

        boolean exito = usuarioDAO.registrarUsuario(nombre, correo, clave1, tipo);

        if (exito) {
            JOptionPane.showMessageDialog(vista, "Usuario registrado  correctamente.");
            vista.mostrarLogin(); // método personalizado para cambiar de formulario
        } else {
            JOptionPane.showMessageDialog(vista, "Error al registrar usuario.");
        }
    }

    private void iniciarSesion() {
        String correo = vista.txtUsuario.getText();
        String clave = new String(vista.txtPassword.getPassword());

        // validación real
        if (correo.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor completa todos los campos.");
            return;
        }

        boolean exito = usuarioDAO.validarLogin(correo, clave);

        if (exito) {
            JOptionPane.showMessageDialog(vista, "Usuario logeado correctamente.");
            abrirMenu();
        } else {
            JOptionPane.showMessageDialog(vista, "Error al logear usuario.");
        }
    }
    
    private void recuerarCuenta(){
        String correo = vista.txtResCorreo.getText();
        
        if (correo.isEmpty() ) {
            JOptionPane.showMessageDialog(vista, "Por favor completa todos los campos.");
            return;
        }
        boolean exito=usuarioDAO.recuperarCuenta(correo);
        
        if (exito) {
            JOptionPane.showMessageDialog(vista, "Se enviara un mensaje decuperacion a su correo en los proximos dias.");
        } else {
            JOptionPane.showMessageDialog(vista, "Error al encontrar email.");
        }
    }
    
    private void abrirMenu(){
        MenuPrincipal menu = new MenuPrincipal();
        new ControlMenu(menu);
        menu.setVisible(true);
        vista.dispose(); // Cierra el login
    };
    
}
