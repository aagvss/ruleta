import javax.swing.*;
import java.awt.*;

public class VentanaRegistro {
    private final JFrame frame = new JFrame("Registro - Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();

    public VentanaRegistro() {
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,2,10,10));
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(Color.CYAN);
        JLabel lblUsuario = new JLabel("Usuario:");
        frame.add(lblUsuario);
        frame.add(txtUsuario);
        JLabel lblClave = new JLabel("Clave:");
        frame.add(lblClave);
        frame.add(txtClave);
        JButton btnRegistrar = new JButton("Registrar");
        frame.add(btnRegistrar);
        JButton btnCancelar = new JButton("Cancelar");
        frame.add(btnCancelar);

        btnRegistrar.addActionListener(e -> registrarUsuario());
        btnCancelar.addActionListener(e -> {
            frame.dispose();
            new VentanaPrincipal().mostrarVentana();
        });
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void registrarUsuario() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();

        if (usuario.isEmpty() || clave.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Debe completar todos los campos",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        for (Usuario u : VentanaPrincipal.USUARIOS) {
            if (u.getusername().equals(usuario)) {
                JOptionPane.showMessageDialog(frame,
                        "El usuario ya existe",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        VentanaPrincipal.USUARIOS.add(new Usuario(usuario, clave));

        JOptionPane.showMessageDialog(frame,
                "Usuario registrado con éxito",
                "Registro",
                JOptionPane.INFORMATION_MESSAGE);

        frame.dispose();
        new VentanaPrincipal().mostrarVentana();
    }
}
