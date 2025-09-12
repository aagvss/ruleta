import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VentanaHistorial {
    private final JFrame frame = new JFrame("Historial de Apuestas");
    private final JTextArea areaHistorial = new JTextArea();

    public VentanaHistorial() {
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        areaHistorial.setEditable(false);
        areaHistorial.setFont(new Font("Arial", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(areaHistorial);

        JButton btnCerrar = new JButton("Cerrar");
        btnCerrar.addActionListener(e -> frame.dispose());

        frame.add(scroll, BorderLayout.CENTER);
        frame.add(btnCerrar, BorderLayout.SOUTH);

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        cargarHistorial();
    }

    private void cargarHistorial() {
        List<String> apuestas = Historial.getApuestas();
        if (apuestas.isEmpty()) {
            areaHistorial.setText("No hay apuestas registradas todavía.");
        } else {
            StringBuilder sb = new StringBuilder("Historial de apuestas:\n\n");
            for (String ap : apuestas) {
                sb.append("• ").append(ap).append("\n");
            }
            areaHistorial.setText(sb.toString());
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
