package Vista;

import controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal {
    private final SessionController session;
    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();

    public VentanaPrincipal(SessionController session) {
        this.session = session;

        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel lblUsuario = new JLabel("Usuario: ");
        frame.add(lblUsuario);
        frame.add(txtUsuario);

        JLabel lblClave = new JLabel("Clave: ");
        frame.add(lblClave);
        frame.add(txtClave);

        JButton btnIngresar = new JButton("Ingresar");
        frame.add(btnIngresar);

        JButton btnRegistro = new JButton("Registrarse");
        frame.add(btnRegistro);

        btnIngresar.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> abrirRegistro());
    }

    private void login() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();
        if (session.iniciarSesion(usuario, clave)) {
            Usuario u = session.getUsuarioActual();
            JOptionPane.showMessageDialog(frame, "Bienvenido " + u.getNombre() + "!");
            frame.dispose();
            new Interfaz(session).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame, "Usuario o Clave incorrecto!");
        }
    }

    public void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro(session).mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
