import javax.swing.*;
import java.awt.*;

public class Interfaz {
    private final JFrame frame = new JFrame("RULETA — Casino Black Cat");

    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnSalir = new JButton("Salir");
    private final JLabel lblUsuario;


    private final JTextArea areaTexto = new JTextArea();


    public Interfaz(String usuario) {
        lblUsuario = new JLabel(usuario, SwingConstants.LEFT);
        frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panelLateral = new JPanel();
        panelLateral.setLayout(new GridLayout(4,1,5,5));
        panelLateral.add(btnInicio);
        panelLateral.add(btnJugar);
        panelLateral.add(btnHistorial);
        panelLateral.add(btnSalir);

        JLabel lblUsuario = new JLabel(usuario, SwingConstants.LEFT);

        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 13));
        areaTexto.setText("""
                Bienvenido al menú principal.
                A la izquierda tienes:
                • Jugar: abre la ventana de juego.
                • Historial: abre la ventana de historial.
                • Salir: cierra sesión y vuelve al login.
                """);

        JScrollPane scroll = new JScrollPane(areaTexto);

        frame.add(panelLateral, BorderLayout.WEST);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(lblUsuario, BorderLayout.SOUTH);

        btnInicio.addActionListener(e -> mostrarInicio());
        btnJugar.addActionListener(e -> mostrarJugar());
        btnHistorial.addActionListener(e -> mostrarHistorial());
        btnSalir.addActionListener(e -> salir());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void mostrarInicio() {
        areaTexto.setText("""
                Bienvenido al menú principal.
                A la izquierda tienes:
                • Jugar: abre la ventana de juego.
                • Historial: abre la ventana de historial.
                • Salir: cierra sesión y vuelve al login.
                """);
    }

    private void mostrarJugar() {
        new VentanaRuleta(lblUsuario.getText()).mostrarVentana();
    }

    private void mostrarHistorial() {
        new VentanaHistorial().mostrarVentana();
    }

    private void salir() {
        frame.dispose();
        new VentanaPrincipal().mostrarVentana();
    }
}
