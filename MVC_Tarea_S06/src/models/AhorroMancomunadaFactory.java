package models;

public class AhorroMancomunadaFactory implements CuentaFactory {
    
    @Override
    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = new CuentaAhorro(tipoCuenta, montoInicial);
        cuenta.setTasaInteres(3.0);
        cuenta.setCantidadTitulares(2);
        cuenta.setPagaMantenimiento(true);
        cuenta.setRetirosPermitidosATM(3);
        cuenta.setRequiereTutor(false);
        cuenta.setPlazoMeses(0);
        return cuenta;
    }
}
