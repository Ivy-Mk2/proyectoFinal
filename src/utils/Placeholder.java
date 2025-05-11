/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author ocasp
 */
public class Placeholder {
    //----------------JTextField------------------
    public static void aplicar(JTextField campo, String texto) {
        campo.setText(texto);
        campo.setForeground(Color.GRAY);


        campo.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (campo.getText().equals(texto)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (campo.getText().isEmpty()) {
                    campo.setText(texto);
                    campo.setForeground(Color.GRAY);
                }
            }
        });
    }
    //----------------JPassword------------------
    public static void aplicar(JPasswordField campo, String texto) {
        campo.setText(texto);
        campo.setEchoChar((char) 0); // Mostrar texto visible
        campo.setForeground(Color.GRAY);

        campo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(campo.getPassword()).equals(texto)) {
                    campo.setText("");
                    campo.setForeground(Color.BLACK);
                    campo.setEchoChar('*'); // Cambia a modo contraseña
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(campo.getPassword()).isEmpty()) {
                    campo.setForeground(Color.GRAY);
                    campo.setText(texto);
                    campo.setEchoChar((char) 0);
                }
            }
        });
    }
    
}
