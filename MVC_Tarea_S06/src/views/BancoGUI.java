package views;

import controllers.BancoController;
import models.DefaultCuentaFactory;
import models.CuentaAhorro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BancoGUI extends JFrame {
    private JComboBox<String> tipoCuentaCombo;
    private JTextField montoField;
    private JTextArea detallesArea;
    private BancoController controller;

    public BancoGUI() {
        controller = new BancoController(new DefaultCuentaFactory());
        setTitle("Sistema Bancario");
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null); // CAMBIO aquí para usar posiciones absolutas

        make_labels();
        make_comboBox();
        make_buttons();
        make_textArea();
    }

    private void make_labels() {
        JLabel lbTipoCuenta = new JLabel("Tipo de Cuenta:");
        lbTipoCuenta.setFont(new Font("Arial", Font.BOLD, 16));
        lbTipoCuenta.setBounds(20, 20, 150, 30);
        add(lbTipoCuenta);

        JLabel lbMonto = new JLabel("Monto Inicial:");
        lbMonto.setFont(new Font("Arial", Font.BOLD, 16));
        lbMonto.setBounds(20, 60, 150, 30);
        add(lbMonto);

        montoField = new JTextField("100.00"); // USAMOS el atributo global
        montoField.setFont(new Font("Arial", Font.PLAIN, 16));
        montoField.setBounds(180, 60, 200, 30);
        add(montoField);
    }

    private void make_comboBox() {
        tipoCuentaCombo = new JComboBox<>(new String[]{
                "Ahorro Sueldo", "Ahorro Digital", "Ahorro Mancomunada", "Plazo Fijo", "Cuenta para Menores"
        });
        tipoCuentaCombo.setFont(new Font("Arial", Font.PLAIN, 16));
        tipoCuentaCombo.setBounds(180, 20, 200, 30);
        tipoCuentaCombo.setSelectedIndex(0);
        add(tipoCuentaCombo);
    }

    private void make_buttons() {
        JButton crearBtn = new JButton("Crear Cuenta");
        crearBtn.setFont(new Font("Arial", Font.BOLD, 16));
        crearBtn.setBounds(20, 100, 150, 30);
        crearBtn.addActionListener(new CrearCuentaListener());
        add(crearBtn);
    }

    private void make_textArea() {
        detallesArea = new JTextArea(); // USAMOS el atributo global
        detallesArea.setEditable(false);
        detallesArea.setFont(new Font("Arial", Font.PLAIN, 14));

        JScrollPane scrollPane = new JScrollPane(detallesArea);
        scrollPane.setBounds(20, 140, 400, 200);
        add(scrollPane);
    }

    private class CrearCuentaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tipo = (String) tipoCuentaCombo.getSelectedItem();
                double monto = Double.parseDouble(montoField.getText());

                CuentaAhorro cuenta = controller.crearCuenta(tipo, monto);
                mostrarDetalles(cuenta);
                JOptionPane.showMessageDialog(BancoGUI.this, "Cuenta creada exitosamente");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, "Monto inválido", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(BancoGUI.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void mostrarDetalles(CuentaAhorro cuenta) {
        StringBuilder detalles = new StringBuilder("=== Detalles de la Cuenta ===\n");
        detalles.append("Tipo: ").append(cuenta.getTipo()).append("\n");
        detalles.append("Tasa: ").append(cuenta.getTasaInteres()).append("%\n");
        detalles.append("Saldo: $").append(cuenta.getMonto()).append("\n");
        detalles.append("Cantidad de titulares: ").append(cuenta.getCantidadTitulares()).append("\n");
        detalles.append("Mantenimiento: ").append(cuenta.isPagaMantenimiento() ? "Sí" : "No").append("\n");
        detalles.append("Retiros ATM: ").append(cuenta.getRetirosPermitidosATM()).append("/mes\n");
        if (cuenta.isRequiereTutor()) {
            detalles.append("Requiere tutor: Sí\n");
        }
        if (cuenta.getPlazoMeses() > 0) {
            detalles.append("Plazo: ").append(cuenta.getPlazoMeses()).append(" meses\n");
        }
        detallesArea.setText(detalles.toString());
    }
}
