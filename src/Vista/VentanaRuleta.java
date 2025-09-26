package Vista;

import controlador.RuletaController;
import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JTextField txtNumero = new JTextField();
    private final JTextField txtMonto = new JTextField();
    private final JLabel lblResultado = new JLabel("Resultado:");

    private final Usuario usuario;
    private final RuletaController controller = new RuletaController();

    public VentanaRuleta(Usuario usuario) {
        this.usuario = usuario;
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JPanel panelApuesta = new JPanel(new GridLayout(2, 2, 5, 5));
        panelApuesta.add(new JLabel("Número (0 - 36):"));
        panelApuesta.add(txtNumero);
        panelApuesta.add(new JLabel("Monto:"));
        panelApuesta.add(txtMonto);

        JButton btnJugar = new JButton("Jugar");
        btnJugar.addActionListener(this::jugar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(e -> frame.dispose());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnJugar);
        panelBotones.add(btnSalir);

        lblResultado.setFont(new Font("Arial", Font.BOLD, 20));

        frame.add(panelApuesta, BorderLayout.NORTH);
        frame.add(lblResultado, BorderLayout.CENTER);
        frame.add(panelBotones, BorderLayout.SOUTH);
    }

    private void jugar(ActionEvent e) {
        try {
            int numero = Integer.parseInt(txtNumero.getText().trim());
            int monto = Integer.parseInt(txtMonto.getText().trim());

            Resultado r = controller.jugar(usuario, numero, monto);

            lblResultado.setText("Resultado: " + r.getNumeroGanador());
            JOptionPane.showMessageDialog(frame, r.getMensaje());
            Historial.agregar(r.getMensaje());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Debes ingresar un número y un monto válido.");
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
