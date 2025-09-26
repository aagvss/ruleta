package Vista;

import controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class Interfaz {
    private final SessionController session;
    private final JFrame frame = new JFrame("RULETA — Casino Black Cat");

    private final JButton btnInicio = new JButton("Inicio");
    private final JButton btnJugar = new JButton("Jugar");
    private final JButton btnHistorial = new JButton("Historial");
    private final JButton btnPerfil = new JButton("Perfil");
    private final JButton btnSalir = new JButton("Salir");

    private final JLabel lblUsuario;
    private final JTextArea areaTexto = new JTextArea();

    public Interfaz(SessionController session) {
        this.session = session;
        Usuario u = session.getUsuarioActual();

        lblUsuario = new JLabel("Usuario: " + u.getNombre(), SwingConstants.LEFT);

        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panelLateral = new JPanel(new GridLayout(5, 1, 5, 5));
        panelLateral.add(btnInicio);
        panelLateral.add(btnJugar);
        panelLateral.add(btnHistorial);
        panelLateral.add(btnPerfil);
        panelLateral.add(btnSalir);

        areaTexto.setEditable(false);
        areaTexto.setFont(new Font("Arial", Font.PLAIN, 13));
        areaTexto.setText("""
                Bienvenido al menú principal.
                A la izquierda tienes:
                • Jugar: abre la ventana de juego.
                • Historial: abre la ventana de historial.
                • Perfil: administra tu usuario.
                • Salir: cierra sesión y vuelve al login.
                """);

        JScrollPane scroll = new JScrollPane(areaTexto);

        frame.add(panelLateral, BorderLayout.WEST);
        frame.add(scroll, BorderLayout.CENTER);
        frame.add(lblUsuario, BorderLayout.SOUTH);

        btnInicio.addActionListener(e -> mostrarInicio());
        btnJugar.addActionListener(e -> mostrarJugar());
        btnHistorial.addActionListener(e -> mostrarHistorial());
        btnPerfil.addActionListener(e -> mostrarPerfil());
        btnSalir.addActionListener(e -> salir());
    }

    private void mostrarInicio() {
        areaTexto.setText("""
                Bienvenido al menú principal.
                A la izquierda tienes:
                • Jugar: abre la ventana de juego.
                • Historial: abre la ventana de historial.
                • Perfil: administra tu usuario.
                • Salir: cierra sesión y vuelve al login.
                """);
    }

    private void mostrarJugar() {
        new VentanaRuleta(session.getUsuarioActual()).mostrarVentana();
    }

    private void mostrarHistorial() {
        new VentanaHistorial().mostrarVentana();
    }

    private void mostrarPerfil() {
        new VentanaPerfil(session).mostrarVentana();
    }

    private void salir() {
        session.cerrarSesion();
        frame.dispose();
        new VentanaPrincipal(session).mostrarVentana();
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
