package models;

public class AhorroSueldoFactory implements CuentaFactory {
    
    @Override
    public CuentaAhorro crearCuenta(String tipoCuenta, double montoInicial) {
        CuentaAhorro cuenta = new CuentaAhorro(tipoCuenta, montoInicial);
        cuenta.setTasaInteres(2.0);
        cuenta.setCantidadTitulares(1);
        cuenta.setPagaMantenimiento(false);
        cuenta.setRetirosPermitidosATM(5);
        cuenta.setRequiereTutor(false);
        cuenta.setPlazoMeses(0);
        return cuenta;
    }
}
