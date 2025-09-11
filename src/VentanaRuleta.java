import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class VentanaRuleta {
    private final JFrame frame = new JFrame("Casino Black Cat");
    private final JLabel lblResultado = new JLabel("Resultado: ");
    private final Random random = new Random();

    public VentanaRuleta(String nombreUsuario) {
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.setLocationRelativeTo(null);

        JLabel lblBienvenida = new JLabel("Bienvenido al Casino, " + nombreUsuario + "!");
        lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel panelCentro = new JPanel();
        panelCentro.setLayout(new GridLayout(2, 1, 5, 5));
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        lblResultado.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton btnGirarRuleta = new JButton("Girar Ruleta");
        panelCentro.add(btnGirarRuleta);
        panelCentro.add(lblResultado);

        frame.add(lblBienvenida, BorderLayout.NORTH);
        frame.add(panelCentro, BorderLayout.CENTER);

        btnGirarRuleta.addActionListener(e -> girarRuleta());
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }

    private void girarRuleta() {
        int numero = random.nextInt(37);
        String color;
        if (numero == 0) {
            color = "Verde";
        } else if ((numero % 2) == 0) {
            color = "Negro";
        } else {
            color = "Rojo";
        }

        lblResultado.setText("Resultado: " + numero + " (" + color + ")");
        JOptionPane.showMessageDialog(frame,
                "La ruleta cayó en: " + numero + " (" + color + ")",
                "Resultado Ruleta",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
