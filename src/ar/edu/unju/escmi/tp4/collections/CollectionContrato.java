package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVenta;

public class CollectionContrato {
	public static List<ContratoCompraVenta> terrenos = new ArrayList<>();
	public static List<ContratoAlquiler> alquiler = new ArrayList<>();
	public static void agregarContratoCompraVenta(ContratoCompraVenta contratoCompraVenta) {
        terrenos.add(contratoCompraVenta);
	}
	public static void agregarContratoAlquiler(ContratoAlquiler contratoAlquiler) {
        alquiler.add(contratoAlquiler);
    }
}
