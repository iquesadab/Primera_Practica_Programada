import java.time.LocalDate;

public class CuentaDebito {

    // Atributos
    private String numeroCuenta;
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;

    // Constructor
    public CuentaDebito(String numeroCuenta, double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.porcentajeInteres = porcentajeInteres;
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

    // Métodos  
    public boolean verificarVigencia() {
        return !fechaVencimiento.isBefore(LocalDate.now());
    }

    public void depositar(double monto) {
        if (!verificarVigencia()) {
            System.out.println("No se puede realizar el depósito. La cuenta está vencida.");
        } else {
            saldo += monto;
        }
    }

    public void pagar(double monto) {

        if (!verificarVigencia()) {
            System.out.println("No se puede realizar el pago. La cuenta está vencida.");
        } else if (saldo - monto < 0) {
            System.out.println("No se puede realizar el pago. La cuenta de débito no puede quedar en negativo.");
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

    public boolean equals(CuentaDebito cuentaDebito) {
        return numeroCuenta.equals(cuentaDebito.getNumeroCuenta());
    }

    public String toString() {
        return "\n*** CUENTA DE DÉBITO ***" +
                "\nNúmero de cuenta: " + numeroCuenta +
                "\nSaldo: $" + saldo +
                "\nFecha de emisión: " + fechaEmision +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nPorcentaje de interés: " + porcentajeInteres + "%";
    }
}
