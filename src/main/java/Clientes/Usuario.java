package Clientes;

public class Usuario {
    private String nombreUsuario;
    private String nombre;
    private String apellidos;
    private String fechaNacimiento;
    private double ingresosMensuales;
    private double gastosFijosMensuales;
    private String objetivosFinancieros;
    private String informacionAdicional;

    // Constructor
    public Usuario(String nombreUsuario, String nombre, String apellidos, String fechaNacimiento,
                   double ingresosMensuales, double gastosFijosMensuales, String objetivosFinancieros, String informacionAdicional) {
        this.nombreUsuario = nombreUsuario;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ingresosMensuales = ingresosMensuales;
        this.gastosFijosMensuales = gastosFijosMensuales;
        this.objetivosFinancieros = objetivosFinancieros;
        this.informacionAdicional = informacionAdicional;
    }

    public String obtenerResumenUsuario() {
        return "Usuario: " + nombre + " " + apellidos + "\nObjetivos Financieros: " + objetivosFinancieros;
    }


    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
