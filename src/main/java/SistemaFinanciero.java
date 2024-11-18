import Clientes.Usuario;
import Gestion.GestionFinanzas;
import transaccion.Gasto;
import transaccion.Ingreso;
import java.util.Scanner;
import Clientes.GerenteDeAutenticacion;
import transaccion.Categoria;

public class SistemaFinanciero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestionFinanzas gestionFinanzas = new GestionFinanzas();
        GerenteDeAutenticacion authManager = new GerenteDeAutenticacion();

        int opcion;
        do {
            System.out.println("\n--- Sistema de Gestión Financiera Personal ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar sesión");
            System.out.println("3. Cerrar sesión");
            System.out.println("4. Ver perfil de usuario (Debe estar en sesión)");
            System.out.println("5. Registrar gasto (Debe estar en sesión)");
            System.out.println("6. Registrar ingreso (Debe estar en sesión)");
            System.out.println("7. Mostrar resumen financiero (Debe estar en sesión)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Registro de usuario
                    System.out.print("Ingrese nombre de usuario: ");
                    String nombreUsuario = scanner.nextLine();
                    System.out.print("Ingrese nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Ingrese fecha de nacimiento (dd/mm/yyyy): ");
                    String fechaNacimiento = scanner.nextLine();
                    System.out.print("Ingrese ingresos mensuales: ");
                    double ingresosMensuales = scanner.nextDouble();
                    System.out.print("Ingrese gastos fijos mensuales: ");
                    double gastosFijosMensuales = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Ingrese objetivos financieros: ");
                    String objetivosFinancieros = scanner.nextLine();
                    System.out.print("Ingrese información adicional: ");
                    String informacionAdicional = scanner.nextLine();

                    Usuario usuario = new Usuario(nombreUsuario, nombre, apellidos, fechaNacimiento, ingresosMensuales, gastosFijosMensuales, objetivosFinancieros, informacionAdicional);
                    authManager.registrarUsuario(usuario);
                    break;

                case 2:
                    // Iniciar sesión
                    System.out.print("Ingrese nombre de usuario para iniciar sesión: ");
                    String nombreUsuarioLogin = scanner.nextLine();
                    authManager.iniciarSesion(nombreUsuarioLogin);
                    break;

                case 3:
                    // Cerrar sesión
                    authManager.cerrarSesion();
                    break;

                case 4:
                    // Ver perfil de usuario
                    if (authManager.getUsuarioActivo() != null) {
                        System.out.println(authManager.getUsuarioActivo().obtenerResumenUsuario());
                    } else {
                        System.out.println("Debe estar logueado para ver el perfil.");
                    }
                    break;

                case 5:
                    // Registrar gasto
                    if (authManager.getUsuarioActivo() != null) {
                        System.out.print("Ingrese descripción del gasto: ");
                        String descripcionGasto = scanner.nextLine();
                        System.out.print("Ingrese monto del gasto: ");
                        double montoGasto = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese día del gasto (dd): ");
                        int diaGasto = scanner.nextInt();
                        System.out.print("Ingrese mes del gasto (mm): ");
                        int mesGasto = scanner.nextInt();
                        System.out.print("Ingrese año del gasto (yyyy): ");
                        int anioGasto = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        Categoria categoria = null;
                        boolean categoriaValida = false;
                        while (!categoriaValida) {
                            System.out.print("Seleccione categoría del gasto (Alimentos, Transporte, Entretenimiento, Otros): ");
                            String categoriaGasto = scanner.nextLine();
                            try {
                                categoria = Categoria.valueOf(categoriaGasto.toUpperCase());
                                categoriaValida = true;
                            } catch (IllegalArgumentException e) {
                                System.out.println("Categoría inválida. Por favor ingrese una categoría válida.");
                            }
                        }

                        Gasto gasto = new Gasto(descripcionGasto, montoGasto, diaGasto, mesGasto, anioGasto, categoria);
                        gestionFinanzas.agregarGasto(gasto);
                    } else {
                        System.out.println("Debe estar logueado para registrar un gasto.");
                    }
                    break;

                case 6:
                    // Registrar ingreso
                    if (authManager.getUsuarioActivo() != null) {
                        System.out.print("Ingrese descripción del ingreso: ");
                        String descripcionIngreso = scanner.nextLine();
                        System.out.print("Ingrese monto del ingreso: ");
                        double montoIngreso = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese día del ingreso (dd): ");
                        int diaIngreso = scanner.nextInt();
                        System.out.print("Ingrese mes del ingreso (mm): ");
                        int mesIngreso = scanner.nextInt();
                        System.out.print("Ingrese año del ingreso (yyyy): ");
                        int anioIngreso = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer
                        System.out.print("Ingrese fuente del ingreso: ");
                        String fuenteIngreso = scanner.nextLine();

                        Ingreso ingreso = new Ingreso(descripcionIngreso, montoIngreso, diaIngreso, mesIngreso, anioIngreso, fuenteIngreso);
                        gestionFinanzas.agregarIngreso(ingreso);
                    } else {
                        System.out.println("Debe estar logueado para registrar un ingreso.");
                    }
                    break;

                case 7:
                    // Mostrar resumen financiero
                    if (authManager.getUsuarioActivo() != null) {
                        gestionFinanzas.mostrarResumenFinanciero();
                    } else {
                        System.out.println("Debe estar logueado para ver el resumen financiero.");
                    }
                    break;
            }
        } while (opcion != 8);

        scanner.close();
    }
}
