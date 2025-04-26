package models;

public class CuentaAhorro {
    private String tipo;
    private double monto;
    private double tasaInteres;
    private int cantidadTitulares;
    private boolean pagaMantenimiento;
    private int retirosPermitidosATM;
    private boolean requiereTutor;
    private int plazoMeses;

    // Constructor
    public CuentaAhorro(String tipo, double monto) {
        this.tipo = tipo;
        this.monto = monto;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public int getCantidadTitulares() {
        return cantidadTitulares;
    }

    public boolean isPagaMantenimiento() {
        return pagaMantenimiento;
    }

    public int getRetirosPermitidosATM() {
        return retirosPermitidosATM;
    }

    public boolean isRequiereTutor() {
        return requiereTutor;
    }

    public int getPlazoMeses() {
        return plazoMeses;
    }

    // Setters
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

    public void setCantidadTitulares(int cantidadTitulares) {
        this.cantidadTitulares = cantidadTitulares;
    }

    public void setPagaMantenimiento(boolean pagaMantenimiento) {
        this.pagaMantenimiento = pagaMantenimiento;
    }

    public void setRetirosPermitidosATM(int retirosPermitidosATM) {
        this.retirosPermitidosATM = retirosPermitidosATM;
    }

    public void setRequiereTutor(boolean requiereTutor) {
        this.requiereTutor = requiereTutor;
    }

    public void setPlazoMeses(int plazoMeses) {
        this.plazoMeses = plazoMeses;
    }
}
