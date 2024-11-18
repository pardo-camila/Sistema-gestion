package Gestion;

import transaccion.Gasto;
import transaccion.Ingreso;
import java.util.ArrayList;
import java.util.List;

public class GestionFinanzas {
    private List<Gasto> gastos;
    private List<Ingreso> ingresos;

    public GestionFinanzas() {
        this.gastos = new ArrayList<>();
        this.ingresos = new ArrayList<>();
    }

    public void agregarGasto(Gasto gasto) {
        gastos.add(gasto);
    }

    public void agregarIngreso(Ingreso ingreso) {
        ingresos.add(ingreso);
    }

    public void mostrarResumenFinanciero() {
        System.out.println("Resumen Financiero:");
        System.out.println("Ingresos:");
        for (Ingreso ingreso : ingresos) {
            ingreso.mostrarDetalles();
        }
        System.out.println("Gastos:");
        for (Gasto gasto : gastos) {
            gasto.mostrarDetalles();
        }
    }
}
