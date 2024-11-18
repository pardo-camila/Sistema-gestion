package transaccion;

public abstract class Transaccion {
    private String descripcion;
    private double monto;
    private int dia;
    private int mes;
    private int anio;


    public Transaccion(String descripcion, double monto, int dia, int mes, int anio) {
        this.descripcion = descripcion;
        this.monto = monto;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }


    public abstract void mostrarDetalles();


    public String getDescripcion() {
        return descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAnio() {
        return anio;
    }
}
