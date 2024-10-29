package ar.edu.unju.escmi.tp4.dominio;

import java.util.Date;

public abstract class  Contrato {
	protected Cliente cliente;
	protected Inmobiliaria inmobiliaria;
	protected Date fechaContrato;
	

	public Contrato(Cliente cliente, Inmobiliaria inmobiliaria, Date fechaContrato) {
		super();
		this.cliente = cliente;
		this.inmobiliaria = inmobiliaria;
		this.fechaContrato = fechaContrato;
	}



	public abstract double calcularMontoTotal() ;

}
