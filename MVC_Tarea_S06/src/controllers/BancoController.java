package controllers;

import core.Controller;
import core.View;
import models.CuentaAhorro;
import models.CuentaFactory;
import models.DefaultCuentaFactory;
import views.BancoGUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BancoController extends Controller {
    private CuentaFactory cuentaFactory;
    private View bancoView;

    public BancoController(CuentaFactory cuentaFactory) {
        this.cuentaFactory = cuentaFactory;
    }

    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = cuentaFactory.crearCuenta(tipoCuenta, montoInicial);
        guardarCuentaEnArchivo(cuenta);
        return cuenta;
    }

    private void guardarCuentaEnArchivo(CuentaAhorro cuenta) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("cuentas.txt", true))) {
            writer.write(
                cuenta.getTipo() + "," +
                cuenta.getMonto() + "," +
                cuenta.getTasaInteres() + "," +
                cuenta.getCantidadTitulares() + "," +
                (cuenta.isPagaMantenimiento() ? "Sí" : "No") + "," +
                cuenta.getRetirosPermitidosATM() + "," +
                (cuenta.isRequiereTutor() ? "Sí" : "No") + "," +
                cuenta.getPlazoMeses()
            );
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al guardar la cuenta: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        bancoView = new BancoGUI(this);
        Controller.addView("BancoGUI", bancoView);
        Controller.loadView("BancoGUI");

        mainFrame.setTitle("Sistema Bancario");
        mainFrame.setSize(500, 400);
        mainFrame.setLocationRelativeTo(null); // Centrar ventana
        mainFrame.setVisible(true);
    }
}
