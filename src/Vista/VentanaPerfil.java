package Vista;

import controlador.SessionController;
import Modelo.Usuario;

import javax.swing.*;
import java.awt.*;

public class VentanaPerfil {
    private final SessionController session;
    private final JFrame frame = new JFrame("Perfil de Usuario");
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblSaldo = new JLabel();

    public VentanaPerfil(SessionController session) {
        this.session = session;
        Usuario u = session.getUsuarioActual();

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridLayout(4, 2, 10, 10));

        frame.add(new JLabel("Usuario:"));
        frame.add(new JLabel(u.getUsername()));

        frame.add(new JLabel("Nombre:"));
        txtNombre.setText(u.getNombre());
        frame.add(txtNombre);

        frame.add(new JLabel("Saldo actual:"));
        lblSaldo.setText("$" + u.getSaldo());
        frame.add(lblSaldo);

        JButton btnGuardar = new JButton("Guardar cambios");
        JButton btnRecargar = new JButton("Recargar saldo");

        frame.add(btnGuardar);
        frame.add(btnRecargar);

        btnGuardar.addActionListener(e -> actualizarNombre());
        btnRecargar.addActionListener(e -> recargarSaldo());

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void actualizarNombre() {
        try {
            session.getUsuarioActual().setNombre(txtNombre.getText().trim());
            JOptionPane.showMessageDialog(frame, "Nombre actualizado correctamente");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void recargarSaldo() {
        String montoStr = JOptionPane.showInputDialog(frame, "Ingrese monto a recargar:");
        try {
            int monto = Integer.parseInt(montoStr);
            session.getUsuarioActual().depositar(monto);
            lblSaldo.setText("$" + session.getUsuarioActual().getSaldo());
            JOptionPane.showMessageDialog(frame, "Saldo recargado con éxito");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Monto inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void mostrarVentana() {
        frame.setVisible(true);
    }
}
