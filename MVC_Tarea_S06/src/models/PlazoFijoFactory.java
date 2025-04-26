package models;

public class PlazoFijoFactory implements CuentaFactory {
    @Override
    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = new CuentaAhorro(tipoCuenta, montoInicial);
        cuenta.setTasaInteres(4.0);
        cuenta.setCantidadTitulares(1);
        cuenta.setPagaMantenimiento(false);
        cuenta.setRetirosPermitidosATM(0); // No puede retirar hasta el vencimiento
        cuenta.setRequiereTutor(false);
        cuenta.setPlazoMeses(12); // Un año
        return cuenta;
    }
}
