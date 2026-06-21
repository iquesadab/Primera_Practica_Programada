public class Banco {
    // Atributos
    private Administrador administrador;
    private Cliente[] clientes;

    // Constructor
    public Banco(byte cantidadClientes) {
        administrador = null;
        clientes = new Cliente[cantidadClientes];
    }

    // Getters
    public Administrador getAdministrador() {
        return administrador;
    }

    public Cliente[] getClientes() {
        return clientes;
    }

    // Métodos
    public void registrarAdministrador(Administrador administrador) {
        if (this.administrador == null) {
            this.administrador = administrador;
            System.out.println("Administrador registrado correctamente.");
        } else {
            System.out.println("Ya existe un administrador registrado.");
        }
    }

    public void registrarCliente(Cliente cliente) {
        if (administrador == null) {
            System.out.println("No se pueden registrar clientes sin un administrador.");
            return;
        }

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                System.out.println("Cliente registrado correctamente.");
                return;
            }
        }

        System.out.println("No se pueden registrar más clientes.");
    }

    public void imprimirClientes() {
        System.out.println("\n*** LISTA DE CLIENTES REGISTRADOS ***");

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                System.out.println(clientes[i]);
            }
        }
    }

    public void imprimirCuentasRegistradas() {
        System.out.println("\n*** CUENTAS REGISTRADAS ***");

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null) {
                clientes[i].imprimirReporteCuentas();
            }
        }
    }

    public boolean equals(Banco banco) {
        return administrador.equals(banco.getAdministrador());
    }

    public String toString() {
        return "\n*** DATOS DEL BANCO ***" +
                "\nAdministrador: " + administrador.getNombreCompleto() +
                "\nCantidad máxima de clientes: " + clientes.length;
    }
}
