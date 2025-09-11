import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal {
    public static final List<Usuario> USUARIOS = new ArrayList<>();

    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JTextField txtUsuario = new JTextField();
    private final JPasswordField txtClave = new JPasswordField();

    public VentanaPrincipal() {
        frame.setSize(350,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,2,10,10));
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

    void abrirRegistro() {
        frame.dispose();
        new VentanaRegistro().mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void login() {
        String usuario = txtUsuario.getText().trim();
        String clave = new String(txtClave.getPassword()).trim();
        String resultado = validarCredenciales(usuario,clave);

        if (!resultado.isEmpty()) {
            JOptionPane.showMessageDialog(frame,
                    "Bienvenido " + resultado + "!",
                    "Login exitoso",
                    JOptionPane.INFORMATION_MESSAGE);
            frame.dispose();
            new VentanaRuleta(resultado).mostrarVentana();
        } else {
            JOptionPane.showMessageDialog(frame,
                    "Usuario o clave incorrecto",
                    "Error de login",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private String validarCredenciales(String u, String p) {
        for (Usuario user : USUARIOS) {
            if (user.getusername().equals(u) && user.getClave().equals(p)){
                return user.getusername();
            }
        }
        return "";
    }
}
