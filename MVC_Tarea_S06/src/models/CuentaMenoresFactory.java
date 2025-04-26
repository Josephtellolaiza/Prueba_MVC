package models;

public class CuentaMenoresFactory implements CuentaFactory {
    
    @Override
    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = new CuentaAhorro(tipoCuenta, montoInicial);
        cuenta.setTasaInteres(1.5);
        cuenta.setCantidadTitulares(1);
        cuenta.setPagaMantenimiento(false);
        cuenta.setRetirosPermitidosATM(2);
        cuenta.setRequiereTutor(true);
        cuenta.setPlazoMeses(0);
        return cuenta;
    }
}
