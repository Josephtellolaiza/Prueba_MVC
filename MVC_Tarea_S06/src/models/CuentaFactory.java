package models;


public interface CuentaFactory {

    CuentaAhorro crearCuenta(String tipo, double monto);
}
