package ar.edu.unju.escmi.tp4.collections;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.escmi.tp4.dominio.Cliente;

public class CollectionCliente {
	public static List<Cliente> clientes = new ArrayList<>();

	public static void agregarCliente(Cliente cliente) {
		clientes.add(cliente);
		System.out.println("Cliente agregado correctamente.");
	}

	public static void mostrarClientes() {
		System.out.println("Lista de clientes:");
		for (Cliente cliente : clientes) {
			cliente.getDni();
		}
	}

	public static Cliente buscarClientePorDni(String dni) {
		for (Cliente cliente : clientes) {
			if (cliente.getDni().equals(dni)) {
				return cliente;
			}
		}
		System.out.println("Cliente no encontrado.");
		return null;
	}
}
