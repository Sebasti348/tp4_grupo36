package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class CollectionInmueble {
	public static List<Vivienda> viviendas = new ArrayList<>();
	public static List<Terreno> terrenos = new ArrayList<>();
	
		static {
			viviendas.add(new Vivienda(101, true, "Calle del Sol 45", 2, 30000.0));
			viviendas.add(new Vivienda(102, false, "Avenida del Río 123", 3, 45000.0));
			viviendas.add(new Vivienda(103, true, "Calle Luna 78", 1, 25000.0));
			viviendas.add(new Vivienda(104, false, "Plaza Mayor 5", 4, 60000.0));
			viviendas.add(new Vivienda(105, true, "Calle de las Flores 9", 3, 42000.0));
			viviendas.add(new Vivienda(106, true, "Avenida de los Pinos 14", 2, 32000.0));
			viviendas.add(new Vivienda(107, false, "Callejón del Gato 23", 1, 27000.0));
			viviendas.add(new Vivienda(108, true, "Boulevard de los Andes 50", 3, 50000.0));
			viviendas.add(new Vivienda(109, true, "Avenida de la Paz 32", 4, 58000.0));
			viviendas.add(new Vivienda(110, false, "Calle del Mercado 8", 2, 35000.0));
			
			terrenos.add(new Terreno(201, true, -24.1833, -65.3000, 500.0, 100000.0));
			terrenos.add(new Terreno(202, false, -24.1944, -65.3025, 750.0, 150000.0));
			terrenos.add(new Terreno(203, true, -24.2000, -65.3100, 600.0, 120000.0));
			terrenos.add(new Terreno(204, false, -24.2100, -65.3200, 800.0, 160000.0));
			terrenos.add(new Terreno(205, true, -24.2200, -65.3300, 550.0, 110000.0));
			terrenos.add(new Terreno(206, true, -24.2300, -65.3400, 700.0, 140000.0));
			terrenos.add(new Terreno(207, false, -24.2400, -65.3500, 900.0, 180000.0));
			terrenos.add(new Terreno(208, true, -24.2500, -65.3600, 650.0, 130000.0));
			terrenos.add(new Terreno(209, true, -24.2600, -65.3700, 800.0, 160000.0));
			terrenos.add(new Terreno(210, false, -24.2700, -65.3800, 750.0, 150000.0));
		}
		

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
