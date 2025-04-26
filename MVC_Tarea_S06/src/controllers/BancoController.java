package controllers;

import models.CuentaAhorro;
import models.CuentaFactory;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BancoController {


    private List<CuentaAhorro> cuentas;
    private CuentaFactory cuentaFactory;

    public BancoController(CuentaFactory cuentaFactory) {
        this.cuentas = new ArrayList<>();
        this.cuentaFactory = cuentaFactory;
    }

    

    public CuentaAhorro crearCuenta(String tipo, double monto) {
        CuentaAhorro cuenta = cuentaFactory.crearCuenta(tipo, monto);
        cuentas.add(cuenta);
        guardarCuentaArchivo(cuenta);
        return cuenta;
    }

    private void guardarCuentaArchivo(CuentaAhorro cuenta) {
        try (FileWriter writer = new FileWriter("cuentas.txt", true)) {
            writer.write(cuenta.toString() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}