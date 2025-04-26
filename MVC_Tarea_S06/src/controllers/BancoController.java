package controllers;

import core.Controller;
import core.View;
import models.*;
import views.BancoGUI;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BancoController extends Controller {
    private View bancoView;

    public BancoController() {
        // Ahora no necesitamos una fábrica general
    }

    private CuentaFactory getFactory(String tipoCuenta) {
        switch (tipoCuenta) {
            case "Ahorro Sueldo":
                return new AhorroSueldoFactory();
            case "Ahorro Digital":
                return new AhorroDigitalFactory();
            case "Ahorro Mancomunada":
                return new AhorroMancomunadaFactory();
            case "Plazo Fijo":
                return new PlazoFijoFactory();
            case "Cuenta para Menores":
                return new CuentaMenoresFactory();
            default:
                throw new IllegalArgumentException("Tipo de cuenta desconocido: " + tipoCuenta);
        }
    }

    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaFactory factory = getFactory(tipoCuenta);
        CuentaAhorro cuenta = factory.crearCuenta(tipoCuenta, montoInicial);
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
