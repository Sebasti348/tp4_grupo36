package ar.edu.unju.escmi.tp4.dominio;

import java.util.Date;

public class ContratoAlquiler extends Contrato {
	private double precio;
	private int duracion;
	private double gastosInmobiliaria;
	private Vivienda vivienda;
	
	public double calcularMontoTotal() {
		return (precio + gastosInmobiliaria);
	}
	
	public ContratoAlquiler(double precio, Date fechaContrato, int duracion, double gastosInmobiliaria,
			Inmobiliaria inmobiliaria, Cliente cliente, Vivienda vivienda) {
		super(cliente, inmobiliaria, fechaContrato);
		this.precio = precio;
		this.duracion = duracion;
		this.gastosInmobiliaria = gastosInmobiliaria;
		this.vivienda = vivienda;
	}
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getGastosInmobiliaria() {
		return gastosInmobiliaria;
	}

	public void setGastosInmobiliaria(double gastosInmobiliaria) {
		this.gastosInmobiliaria = gastosInmobiliaria;
	}
	
	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
	}


	
	
}
