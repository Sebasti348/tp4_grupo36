package ar.edu.unju.escmi.tp4.dominio;

public class Vivienda extends Inmueble {
	

	private String direccion;
	private int habitaciones;
	private double precioAlquiler;
	
	public Vivienda() {
		// TODO Auto-generated constructor stub
	}
	
	
    public Vivienda(int codigo, boolean disponible, String direccion, int habitaciones, double precioAlquiler) {
        super(codigo, disponible);
        this.direccion = direccion;
        this.habitaciones = habitaciones;
        this.precioAlquiler = precioAlquiler;
    }
	
	
	
	@Override
	public String toString() {
		return "Vivienda N°=" + codigo + " direccion=" + direccion + ", habitaciones=" + habitaciones + ", precioAlquiler="
				+ precioAlquiler;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getHabitaciones() {
		return habitaciones;
	}


	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}


	public double getPrecioAlquiler() {
		return precioAlquiler;
	}


	public void setPrecioAlquiler(double precioAlquiler) {
		this.precioAlquiler = precioAlquiler;
	}

	


	

}
