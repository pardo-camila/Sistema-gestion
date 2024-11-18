package transaccion;

public class Gasto extends Transaccion {
    private Categoria categoria;


    public Gasto(String descripcion, double monto, int dia, int mes, int anio, Categoria categoria) {
        super(descripcion, monto, dia, mes, anio);  // Llamada al constructor de la superclase
        this.categoria = categoria;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Gasto: " + getDescripcion());
        System.out.println("Monto: " + getMonto());
        System.out.println("Fecha: " + getDia() + "/" + getMes() + "/" + getAnio());
        System.out.println("Categoría: " + categoria);
    }


    public Categoria getCategoria() {
        return categoria;
    }
}
