package ar.edu.unju.escmi.tp4.dominio;

public abstract class Inmueble {
	protected int codigo;
	protected boolean disponible; 
	
	
	public Inmueble() {
		// TODO Auto-generated constructor stub
	}
	
	public Inmueble(int codigo, boolean disponible) {
		// TODO Auto-generated constructor stub
		this.codigo = codigo;
		this.disponible = disponible;
	}
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

}
