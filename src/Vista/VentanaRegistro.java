package Vista;

import controlador.SessionController;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final SessionController session;
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();
    private final JTextField txtNombre = new JTextField();

    public VentanaRegistro(SessionController session) {
        this.session = session;

        frame.setSize(350, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        frame.add(new JLabel("Usuario:"));
        frame.add(txtUsuario);

        frame.add(new JLabel("Clave:"));
        frame.add(txtClave);

        frame.add(new JLabel("Nombre:"));
        frame.add(txtNombre);

        JButton btnRegistrar = new JButton("Registrar");
        frame.add(btnRegistrar);

        JButton btnCancelar = new JButton("Cancelar");
        frame.add(btnCancelar);

        btnRegistrar.addActionListener(e -> registrarUsuario());
        btnCancelar.addActionListener(e -> {
            frame.dispose();
            new VentanaPrincipal(session).mostrarVentana();
        });
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();
        String nombre = txtNombre.getText().trim();
        try {
            session.registrarUsuario(usuario, clave, nombre);
            JOptionPane.showMessageDialog(frame,
                    "Usuario registrado con éxito",
                    "Registro",
                    JOptionPane.INFORMATION_MESSAGE);

            frame.dispose();
            new VentanaPrincipal(session).mostrarVentana();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
