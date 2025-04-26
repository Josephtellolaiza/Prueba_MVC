package models;

public class CuentaAhorro {
    private String tipo;
    private double tasaInteres;
    private double monto;
    private boolean pagaMantenimiento;
    private int retirosPermitidosATM;
    private boolean requiereTutor; // solo para "Cuenta Menores"
    private int cantidadTitulares;
    private int plazoMeses;

    public CuentaAhorro(String tipo, double tasaInteres, double monto,
                        boolean pagaMantenimiento, int retirosPermitidosATM,
                        boolean requiereTutor, int cantidadTitulares, int plazoMeses) {
        this.tipo = tipo;
        this.tasaInteres = tasaInteres;
        this.monto = monto;
        this.pagaMantenimiento = pagaMantenimiento;
        this.retirosPermitidosATM = retirosPermitidosATM;
        this.requiereTutor = requiereTutor;
        this.cantidadTitulares = cantidadTitulares;
        this.plazoMeses = plazoMeses;
    }

    // Getters
    public String getTipo() { return tipo; }
    public double getTasaInteres() { return tasaInteres; }
    public double getMonto() { return monto; }

    public boolean isPagaMantenimiento() { return pagaMantenimiento; }

    public int getRetirosPermitidosATM() { return retirosPermitidosATM; }

    public boolean isRequiereTutor() { return requiereTutor; }
    
    public int getCantidadTitulares() { return cantidadTitulares; }
    public int getPlazoMeses() { return plazoMeses; }

    @Override
    public String toString() {
        return tipo + ";" + tasaInteres + ";" + monto + ";" + pagaMantenimiento + ";" +
                retirosPermitidosATM + ";" + requiereTutor + ";" + cantidadTitulares + ";" + plazoMeses;
    }
}
