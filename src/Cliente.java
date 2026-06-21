public class Cliente {

    // Atributos
    private String nombreCompleto;
    private String cedula;
    private String sexo;
    private String correoElectronico;
    private String profesion;
    private String direccion;
    private String contrasenia;

    private CuentaAhorro[] cuentasAhorro;
    private CuentaDebito[] cuentasDebito;
    private CuentaCredito[] cuentasCredito;

    // Constructor
    public Cliente(String nombreCompleto, String cedula, String sexo, String correoElectronico, String profesion,
                   String direccion, String contrasenia, byte cantidadCuentasAhorro,
                   byte cantidadCuentasDebito, byte cantidadCuentasCredito) {
        this.nombreCompleto = nombreCompleto;
        this.cedula = cedula;
        this.sexo = sexo;
        this.correoElectronico = correoElectronico;
        this.profesion = profesion;
        this.direccion = direccion;
        this.contrasenia = contrasenia;
        cuentasAhorro = new CuentaAhorro[cantidadCuentasAhorro];
        cuentasDebito = new CuentaDebito[cantidadCuentasDebito];
        cuentasCredito = new CuentaCredito[cantidadCuentasCredito];
    }

    // Getters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getProfesion() {
        return profesion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public CuentaAhorro[] getCuentasAhorro() {
        return cuentasAhorro;
    }

    public CuentaDebito[] getCuentasDebito() {
        return cuentasDebito;
    }

    public CuentaCredito[] getCuentasCredito() {
        return cuentasCredito;
    }

    // Setters
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    // Métodos
    public void agregarCuentaAhorro(CuentaAhorro cuenta) {
        for (int i = 0; i < cuentasAhorro.length; i++) {
            if (cuentasAhorro[i] == null) {
                cuentasAhorro[i] = cuenta;
                return;
            }
        }
        System.out.println("No se pueden agregar más cuentas de ahorro.");
    }

    public void agregarCuentaDebito(CuentaDebito cuenta) {
        for (int i = 0; i < cuentasDebito.length; i++) {
            if (cuentasDebito[i] == null) {
                cuentasDebito[i] = cuenta;
                return;
            }
        }
        System.out.println("No se pueden agregar más cuentas de débito.");
    }

    public void agregarCuentaCredito(CuentaCredito cuenta) {
        for (int i = 0; i < cuentasCredito.length; i++) {
            if (cuentasCredito[i] == null) {
                cuentasCredito[i] = cuenta;
                return;
            }
        }
        System.out.println("No se pueden agregar más cuentas de crédito.");
    }

    public void imprimirReporteCuentas() {

        double saldoFinalConsolidado = 0;

        System.out.println("\nReporte de cuentas de: " + nombreCompleto);

        for (int i = 0; i < cuentasAhorro.length; i++) {
            if (cuentasAhorro[i] != null) {
                System.out.println("\nNúmero de cuenta: " + cuentasAhorro[i].getNumeroCuenta());

                System.out.println("Tipo de cuenta: Ahorro");

                System.out.println("Saldo disponible: $" + cuentasAhorro[i].getSaldo());

                saldoFinalConsolidado += cuentasAhorro[i].getSaldo();
            }
        }

        for (int i = 0; i < cuentasDebito.length; i++) {
            if (cuentasDebito[i] != null) {
                System.out.println("\nNúmero de cuenta: " + cuentasDebito[i].getNumeroCuenta());

                System.out.println("Tipo de cuenta: Débito");

                System.out.println("Saldo disponible: $" + cuentasDebito[i].getSaldo());

                saldoFinalConsolidado += cuentasDebito[i].getSaldo();
            }
        }

        for (int i = 0; i < cuentasCredito.length; i++) {
            if (cuentasCredito[i] != null) {
                System.out.println("\nNúmero de cuenta: " + cuentasCredito[i].getNumeroCuenta());

                System.out.println("Tipo de cuenta: Crédito");

                System.out.println("Saldo utilizado: $" + cuentasCredito[i].getSaldo());

                saldoFinalConsolidado -= cuentasCredito[i].getSaldo();
            }
        }
        System.out.println("\nSaldo final consolidado: $" + saldoFinalConsolidado);
    }

    public boolean equals(Cliente cliente) {
        return cedula.equals(cliente.getCedula());
    }

    public String toString() {
        return "\n*** DATOS DEL CLIENTE ***" +
                "\nNombre completo: " + nombreCompleto +
                "\nCédula: " + cedula +
                "\nSexo: " + sexo +
                "\nCorreo electrónico: " + correoElectronico +
                "\nProfesión: " + profesion +
                "\nDirección: " + direccion;
    }
}
