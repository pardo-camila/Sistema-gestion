package transaccion;

public class Ingreso extends Transaccion {
    private String fuente;


    public Ingreso(String descripcion, double monto, int dia, int mes, int anio, String fuente) {
        super(descripcion, monto, dia, mes, anio);  // Llamada al constructor de la superclase
        this.fuente = fuente;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Ingreso: " + getDescripcion());
        System.out.println("Monto: " + getMonto());
        System.out.println("Fecha: " + getDia() + "/" + getMes() + "/" + getAnio());
        System.out.println("Fuente: " + fuente);
    }


    public String getFuente() {
        return fuente;
    }
}
