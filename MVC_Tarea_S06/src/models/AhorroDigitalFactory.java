package models;

public class AhorroDigitalFactory implements CuentaFactory {
    @Override
    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = new CuentaAhorro(tipoCuenta, montoInicial);
        cuenta.setTasaInteres(2.5);
        cuenta.setCantidadTitulares(1);
        cuenta.setPagaMantenimiento(false);
        cuenta.setRetirosPermitidosATM(0); // Solo digital
        cuenta.setRequiereTutor(false);
        cuenta.setPlazoMeses(0);
        return cuenta;
    }
}
