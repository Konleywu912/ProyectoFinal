/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author leymanwu
 */
public class VentanaLogin extends JFrame {

    private JTextField campoUsuario;
    private JPasswordField campoContra;
    private GestionResiduos gestion;
    private int contador = 0;

    public VentanaLogin() {
        gestion = new GestionResiduos();

        setTitle("Registrar usuario");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        
        JLabel lblTitulo = new JLabel("Sistema de Gestion EcoFide");
        lblTitulo.setBounds(90, 5, 300, 25);
        add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario");
        lblUsuario.setBounds(45, 40, 80, 25);
        add(lblUsuario);

        campoUsuario = new JTextField();
        campoUsuario.setBounds(100, 40, 200, 25);
        add(campoUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(20, 80, 80, 25);
        add(lblContrasena);

        campoContra = new JPasswordField();
        campoContra.setBounds(100, 80, 200, 25);
        add(campoContra);

        JButton btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 125 , 100, 40);
        add(btnIngresar);

        btnIngresar.addActionListener(e -> {
            String usuario = campoUsuario.getText().trim();
            String contrasena = new String(campoContra.getPassword());

            if (usuario.equals("admin") && contrasena.equals("1234")) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                new VentanaEcoFide(gestion);
                this.dispose();
            } else {
                contador++;

                if (contador < 3) {
                    JOptionPane.showMessageDialog(null,
                            "Usuario o contraseña incorrecta. Intento " + contador + " de 3");
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario ha sido bloqueado");
                    System.exit(0);
                }
            }
        });

        setVisible(true);

    }

}
