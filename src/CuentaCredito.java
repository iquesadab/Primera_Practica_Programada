import java.time.LocalDate;

public class CuentaCredito {

    // Atributos
    private String numeroCuenta;
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;
    private double limiteCredito;
    private String tipo;

    // Constructor
    public CuentaCredito(String numeroCuenta, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres, double limiteCredito, String tipo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = 0;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
        this.limiteCredito = limiteCredito;
        this.tipo = tipo;
    }

    // Getters
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public double getPorcentajeInteres() {
        return porcentajeInteres;
    }

    public double getLimiteCredito() {
        return limiteCredito;
    }

    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public void setPorcentajeInteres(double porcentajeInteres) {
        this.porcentajeInteres = porcentajeInteres;
    }

    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito;    }

    public void setTipo(String tipo) { this.tipo = tipo; }

    // Métodos
    public boolean verificarVigencia() {
        return !fechaVencimiento.isBefore(LocalDate.now());
    }

    public void pagar(double monto) {
        if (!verificarVigencia()) {
            System.out.println("No se puede realizar el pago. La cuenta está vencida.");
        } else if (saldo + monto > limiteCredito) {
            System.out.println("No se puede realizar el pago. Supera el límite de crédito.");
        } else {
            saldo += monto;
        }
    }

    public void abonar(double monto) {
        if (!verificarVigencia()) {
            System.out.println("No se puede realizar el abono. La cuenta está vencida.");
        } else if (saldo - monto < 0) {
            saldo = 0;
        } else {
            saldo -= monto;
        }
    }

    public void generarIntereses() {
        if (!verificarVigencia()) {
            System.out.println("No se pueden generar intereses. La cuenta está vencida.");
        } else {
            saldo += saldo * (porcentajeInteres / 100);
        }
    }

    public boolean equals(CuentaCredito cuentaCredito) {
        return numeroCuenta.equals(cuentaCredito.getNumeroCuenta());
    }

    public String toString() {
        return "\n*** CUENTA DE CRÉDITO ***" +
                "\nNúmero de cuenta: " + numeroCuenta +
                "\nSaldo: $" + saldo +
                "\nFecha de emisión: " + fechaEmision +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nPorcentaje de interés: " + porcentajeInteres + "%" +
                "\nLímite de crédito: $" + limiteCredito +
                "\nTipo: " + tipo;
    }
}
