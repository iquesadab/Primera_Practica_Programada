import java.time.LocalDate;

public class CuentaAhorro {

    // Atributos
    private String numeroCuenta;
    private double saldo;
    private LocalDate fechaEmision;
    private LocalDate fechaVencimiento;
    private double porcentajeInteres;

    // Constructor

    public CuentaAhorro(String numeroCuenta, double saldo, LocalDate fechaEmision, LocalDate fechaVencimiento, double porcentajeInteres) {
        this.numeroCuenta = numeroCuenta;
        if (saldo >= 100) {
            this.saldo = saldo;
        } else {
            this.saldo = 100;
        }
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
        } else if (saldo - monto < 100) {
            System.out.println("No se puede realizar el pago. La cuenta de ahorro debe mantener mínimo $100.");
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

    public boolean equals(CuentaAhorro cuentaAhorro) {
        return numeroCuenta.equals(cuentaAhorro.getNumeroCuenta());
    }

    public String toString() {
        return "\n*** CUENTA DE AHORRO ***" +
                "\nNúmero de cuenta: " + numeroCuenta +
                "\nSaldo: $" + saldo +
                "\nFecha de emisión: " + fechaEmision +
                "\nFecha de vencimiento: " + fechaVencimiento +
                "\nPorcentaje de interés: " + porcentajeInteres + "%";
    }
}
