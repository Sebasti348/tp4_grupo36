package ar.edu.unju.escmi.tp4.dominio;

import java.util.Date;

public  class ContratoCompraVenta extends Contrato{
	private Date fechaContrato; 	
	private double impuestos;
	private Terreno terreno;
	
	public double calcularMontoTotal() {
		return (terreno.getPrecioVenta() +  (terreno.getPrecioVenta()*impuestos)/100 );
	}
	


	public ContratoCompraVenta(Date fechaContrato, double impuestos, Cliente cliente, Inmobiliaria inmobiliaria,
			Terreno terreno) {
		super(cliente, inmobiliaria, fechaContrato);
		this.fechaContrato = fechaContrato;
		this.impuestos = impuestos;
		this.terreno = terreno;
	}


	public Date getFechaContrato() {
		return fechaContrato;
	}


	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}


	public double getImpuestos() {
		return impuestos;
	}


	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}

	public Terreno getTerreno() {
		return terreno;
	}



	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}





	
	
}
