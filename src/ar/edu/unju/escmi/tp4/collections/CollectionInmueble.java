package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class CollectionInmueble {
	public static List<Vivienda> viviendas = new ArrayList<>();
	public static List<Terreno> terrenos = new ArrayList<>();

	public static void agregarVivienda(Vivienda vivienda) {
		viviendas.add(vivienda);
		System.out.println("Vivienda agregada correctamente.");
	}

	public static void agregarTerreno(Terreno terreno) {
		terrenos.add(terreno);
		System.out.println("Terreno agregado correctamente.");
	}

    public static void mostrarTerrenosDisponibles() {
        System.out.println("Terrenos disponibles para la venta:");
        for (Terreno terreno : terrenos) {
            if (terreno.isDisponible()) { 
                System.out.println(terreno.toString());  
            }
        }
    }

    public static void mostrarTerrenosVendidos() {
        double totalVentas = 0;
        System.out.println("Terrenos vendidos:");
        for (Terreno terreno : terrenos) {
            if (!terreno.isDisponible()) {  
                System.out.println(terreno.toString()); 
                totalVentas += terreno.getPrecioVenta(); 
            }
        }
        System.out.println("Monto total de todas las ventas: $" + totalVentas);
    }
    public static void mostrarViviendasDisponibles() {
		System.out.println("Viviendas disponibles para alquiler:");
		for (Vivienda vivienda : viviendas) {
			if (vivienda.isDisponible()) {
				System.out.println(vivienda.toString());
			}
		}
	}

	public static void mostrarViviendasAlquiladas() {
		System.out.println("Viviendas alquiladas:");
		for (Vivienda vivienda : viviendas) {
			if (!vivienda.isDisponible()) {
				System.out.println(vivienda.toString()); 
			}
		}
	}

}
