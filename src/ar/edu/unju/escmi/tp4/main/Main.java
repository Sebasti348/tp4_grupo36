package ar.edu.unju.escmi.tp4.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import ar.edu.unju.escmi.tp4.collections.CollectionCliente;
import ar.edu.unju.escmi.tp4.collections.CollectionContrato;
import ar.edu.unju.escmi.tp4.collections.CollectionInmueble;
import ar.edu.unju.escmi.tp4.dominio.Cliente;
import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVenta;
import ar.edu.unju.escmi.tp4.dominio.Inmobiliaria;
import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class Main {
    static double totalVentasTerrenos = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            // Menú de opciones
            System.out.println("---- Menú Principal ----");
            System.out.println("1 – Registrar terreno");
            System.out.println("2 – Registrar vivienda");
            System.out.println("3 - Registrar cliente");
            System.out.println("4 – Alquiler de vivienda");
            System.out.println("5 – Venta de terreno");
            System.out.println("6 – Consultar inmuebles (disponibles)");
            System.out.println("7 – Consultar viviendas alquiladas");
            System.out.println("8 – Consultar terrenos vendidos");
            System.out.println("9 – Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarTerreno(scanner);
                    break;
                case 2:
                    registrarVivienda(scanner);
                    break;
                case 3:
                    registrarCliente(scanner);
                    break;
                case 4:
                    alquilerVivienda(scanner);
                    break;
                case 5:
                    ventaTerreno(scanner);
                    break;
                case 6:
                    consultarInmuebles(scanner);
                    break;
                case 7:
                    consultarViviendasAlquiladas();
                    break;
                case 8:
                    consultarTerrenosVendidos();
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }

    // Métodos para manejar cada opción del menú

    public static void registrarTerreno(Scanner scanner) {
        System.out.print("Ingrese el código del terreno: ");
        int codigo = scanner.nextInt();
        System.out.print("Ingrese la latitud: ");
        double latitud = scanner.nextDouble();
        System.out.print("Ingrese la longitud: ");
        double longitud = scanner.nextDouble();
        System.out.print("Ingrese la superficie en m2: ");
        double superficie = scanner.nextDouble();
        System.out.print("Ingrese el precio de venta: ");
        double precioVenta = scanner.nextDouble();

        Terreno terreno = new Terreno(codigo, true, latitud, longitud, superficie, precioVenta);
        CollectionInmueble.agregarTerreno(terreno);
        System.out.println("Terreno registrado exitosamente.");
    }

    public static void registrarVivienda(Scanner scanner) {
        System.out.print("Ingrese el código de la vivienda: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();  // Consumir salto de línea
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el número de habitaciones: ");
        int habitaciones = scanner.nextInt();
        System.out.print("Ingrese el precio de alquiler: ");
        double precioAlquiler = scanner.nextDouble();

        Vivienda vivienda = new Vivienda(codigo, true, direccion, habitaciones, precioAlquiler);
        CollectionInmueble.agregarVivienda(vivienda);
        System.out.println("Vivienda registrada exitosamente.");
    }

    public static void registrarCliente(Scanner scanner) {
        scanner.nextLine();  // Consumir salto de línea
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el DNI: ");
        String dni = scanner.nextLine();
        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese el email: ");
        String email = scanner.nextLine();

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        CollectionCliente.agregarCliente(cliente);
        System.out.println("Cliente registrado exitosamente.");
    }

    public static void alquilerVivienda(Scanner scanner) {
    	scanner.nextLine(); 
    	boolean existe=false;
    	Cliente c1=null;
    	do {
            System.out.print("Ingrese el Dni de Cliente: ");
            String dni = scanner.nextLine();
            for (Cliente cliente : CollectionCliente.clientes) {
                if (dni.equals(cliente.getDni())) {
                	existe=true;
                	c1=cliente;
                	break;
                }
            }
            if(existe==true) {
            	 System.out.println("El Dni del Cliente es valido. ");
            }else {
            	System.out.println("El Dni del Cliente es invalido. ");
            }
        } while (existe!=true);
    	existe=false;
    	Vivienda v1 = null;
    	int codigo;
    	System.out.println("Viviendas disponibles:");
    	for (Vivienda vivienda : CollectionInmueble.viviendas) {
            if (vivienda.isDisponible()) {
            	System.out.println(vivienda.toString());
            }
        }
    	do {
	        System.out.print("Ingrese el codigo de la vivienda que quiera comprar: ");
	        codigo = scanner.nextInt();
	        for (Vivienda vivienda : CollectionInmueble.viviendas) {
	            if (vivienda.getCodigo() == codigo) {
	            	if(vivienda.isDisponible()==true) {
	            		existe=true;
		            	v1 = vivienda;
		            	break;	
	            	}
	            }
	        }
	        if(existe==false) {
	           	 System.out.println("El Vivienda no existe.");
	           }
    	} while (existe!=true);
    	Inmobiliaria inmobiliaria = new Inmobiliaria();
    	scanner.nextLine(); 
        System.out.print("Ingrese el nombre de la inmobiliaria: ");
        String nombre = scanner.nextLine();
        inmobiliaria.setNombre(nombre);

        System.out.print("Ingrese el teléfono de la inmobiliaria: ");
        String telefono = scanner.nextLine();
        inmobiliaria.setTelefono(telefono);

        System.out.print("Ingrese la dirección de la inmobiliaria: ");
        String direccion = scanner.nextLine();
        inmobiliaria.setDireccion(direccion);
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine(); 
        Date fechaContrato = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);  // Asegura que solo se acepten fechas válidas

        while (fechaContrato == null) {
            System.out.print("Ingrese la fecha del contrato (dd/MM/yyyy): ");
            String fechaContratoStr = scanner.nextLine();
            try {
                fechaContrato = formatoFecha.parse(fechaContratoStr);
                System.out.println("Fecha ingresada correctamente: " + formatoFecha.format(fechaContrato));
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, use el formato dd/MM/yyyy.");
            }
        }
        
        System.out.print("Ingrese la duración del contrato (meses): ");
        int duracion = scanner.nextInt();
        System.out.print("Ingrese los gastos de inmobiliaria: ");
        double gastosInmobiliaria = scanner.nextDouble();
        for (Vivienda vivienda : CollectionInmueble.viviendas) {
            if (vivienda.getCodigo() == codigo) {
            	vivienda.setDisponible(false);
            }
        }
        System.out.println(v1.toString());
		ContratoAlquiler contrato = new ContratoAlquiler(precio, fechaContrato, duracion, gastosInmobiliaria, inmobiliaria, c1, v1);
		CollectionContrato.agregarContratoAlquiler(contrato);
    }

    public static void ventaTerreno(Scanner scanner) {
    	scanner.nextLine(); 
    	boolean existe=false;
    	Cliente c1=null;
    	do {
            System.out.print("Ingrese el Dni de Cliente: ");
            String dni = scanner.nextLine();
            for (Cliente cliente : CollectionCliente.clientes) {
                if (dni.equals(cliente.getDni())) {
                	existe=true;
                	c1=cliente;
                	break;
                }
            }
            if(existe==true) {
            	 System.out.println("El Dni del Cliente es valido. ");
            }else {
            	System.out.println("El Dni del Cliente es invalido. ");
            }
        } while (existe!=true);
    	existe=false;
    	Terreno t1 = null;
    	int codigo;
    	System.out.println("Terrenos en venta: ");
        for (Terreno terreno : CollectionInmueble.terrenos) {
            if (terreno.isDisponible()) {
            	System.out.println(terreno.toString());
            }
        }
    	do {
	        System.out.print("Ingrese el codigo del terreno que quiera comprar: ");
	        codigo = scanner.nextInt();
	        for (Terreno terreno : CollectionInmueble.terrenos) {
	            if (terreno.getCodigo() == codigo) {
	            	if(terreno.isDisponible()==true) {
	            		existe=true;
		            	t1 = terreno;
		            	break;
	            	}
	            }
	        }
	        if(existe==false) {
           	 System.out.println("El Terreno no existe.");
           }
    	} while (existe!=true);
    	Inmobiliaria inmobiliaria = new Inmobiliaria();
    	scanner.nextLine(); 
        System.out.print("Ingrese el nombre de la inmobiliaria: ");
        String nombre = scanner.nextLine();
        inmobiliaria.setNombre(nombre);

        System.out.print("Ingrese el teléfono de la inmobiliaria: ");
        String telefono = scanner.nextLine();
        inmobiliaria.setTelefono(telefono);

        System.out.print("Ingrese la dirección de la inmobiliaria: ");
        String direccion = scanner.nextLine();
        inmobiliaria.setDireccion(direccion);
        
        Date fechaContrato = null;
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        formatoFecha.setLenient(false);  // Asegura que solo se acepten fechas válidas

        while (fechaContrato == null) {
            System.out.print("Ingrese la fecha del contrato (dd/MM/yyyy): ");
            String fechaContratoStr = scanner.nextLine();
            try {
                fechaContrato = formatoFecha.parse(fechaContratoStr);
                System.out.println("Fecha ingresada correctamente: " + formatoFecha.format(fechaContrato));
            } catch (ParseException e) {
                System.out.println("Formato de fecha incorrecto. Por favor, use el formato dd/MM/yyyy.");
            }
        }
        System.out.print("Ingrese el impuesto: ");
        double impuesto = scanner.nextDouble();
        for (Terreno terreno : CollectionInmueble.terrenos) {
            if (terreno.getCodigo() == codigo) {
            	terreno.setDisponible(false);
            }
        }
        ContratoCompraVenta contratoCompraVenta = new ContratoCompraVenta(fechaContrato, impuesto, c1, inmobiliaria, t1);
        CollectionContrato.agregarContratoCompraVenta(contratoCompraVenta);
    }

    public static void consultarInmuebles(Scanner scanner) {
    	 System.out.println("Seleccione el tipo de inmueble que desea ver:");
         System.out.println("1. Viviendas");
         System.out.println("2. Terrenos");
         int opcion = scanner.nextInt();
         
    
         if (opcion == 1) {
         	CollectionInmueble.mostrarViviendasDisponibles();
         } else if (opcion == 2) {
         	CollectionInmueble.mostrarTerrenosDisponibles();
         } else {
             System.out.println("Opción no válida");
             return;
         }
    	
    }

    public static void consultarViviendasAlquiladas() {
    	CollectionInmueble.mostrarViviendasAlquiladas();
    }

    public static void consultarTerrenosVendidos() {
    	CollectionInmueble.mostrarTerrenosVendidos();
    }
}
