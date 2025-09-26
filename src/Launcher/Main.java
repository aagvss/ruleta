package Launcher;

import Vista.*;
import controlador.SessionController;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SessionController session = new SessionController();
                new VentanaPrincipal(session).mostrarVentana();
            }
        });
    }
}
