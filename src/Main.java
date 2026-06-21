import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Banco banco = new Banco((byte) 2);

        Administrador administrador = new Administrador(
                "Ivannia Quesada Bogantes",
                "1-1111-1111",
                "ivannia@banco.com",
                "Admin123*"
        );

        Cliente cliente1 = new Cliente(
                "Amanda Álvarez Quesada",
                "2-2222-2222",
                "Femenino",
                "amanda@gmail.com",
                "Ingeniera",
                "Alajuela",
                "Cliente123*",
                (byte) 1,
                (byte) 1,
                (byte) 1
        );


        CuentaAhorro cuentaAhorro = new CuentaAhorro(
                "AH-001",
                500,
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2030, 1, 1),
                2.5
        );

        CuentaDebito cuentaDebito = new CuentaDebito(
                "DB-001",
                300,
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2030, 1, 1),
                1.5
        );

        CuentaCredito cuentaCredito = new CuentaCredito(
                "CR-001",
                LocalDate.of(2026, 1, 1),
                LocalDate.of(2030, 1, 1),
                3.0,
                1000,
                "Cashback"
        );

        banco.registrarAdministrador(administrador);
        banco.registrarCliente(cliente1);

        cliente1.agregarCuentaAhorro(cuentaAhorro);
        cliente1.agregarCuentaDebito(cuentaDebito);
        cliente1.agregarCuentaCredito(cuentaCredito);

        cuentaAhorro.depositar(100);
        cuentaAhorro.pagar(50);
        cuentaAhorro.generarIntereses();

        cuentaDebito.depositar(200);
        cuentaDebito.pagar(100);
        cuentaDebito.generarIntereses();

        cuentaCredito.pagar(250);
        cuentaCredito.abonar(100);
        cuentaCredito.generarIntereses();

        banco.imprimirClientes();
        banco.imprimirCuentasRegistradas();

        System.out.println(administrador);
        System.out.println(cliente1);
        System.out.println(cuentaAhorro);
        System.out.println(cuentaDebito);
        System.out.println(cuentaCredito);
        System.out.println(banco);
    }
}
