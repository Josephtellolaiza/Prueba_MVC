package models;

public class DefaultCuentaFactory implements CuentaFactory{

    @Override
    public CuentaAhorro crearCuenta(String tipo, double monto) {
        
        switch (tipo) {
            case "Ahorro Sueldo":
                return new CuentaAhorro(tipo, 2.5, monto, false, 5, false, 1, 0);
            case "Ahorro Digital":
                return new CuentaAhorro(tipo, 3.0, monto, true, 3, false, 1, 0);
            case "Ahorro Mancomunada":
                return new CuentaAhorro(tipo, 4.0, monto, false, 5, false, 2, 0);
            case "Plazo Fijo":
                return new CuentaAhorro(tipo, 6.0, monto, false, 0, false, 1, 6);
            case "Cuenta para Menores":
                return new CuentaAhorro(tipo, 1.0, monto, false, 0, true, 1, 0);
            default:
                throw new IllegalArgumentException("Tipo de cuenta no reconocido");
        }
        
    }

    
}
