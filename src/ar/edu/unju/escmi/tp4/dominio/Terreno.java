package ar.edu.unju.escmi.tp4.dominio;

public class Terreno extends Inmueble{

	private double latitud;
	private double longitud;
	private double superficie;
	private double precioVenta;
	
	public Terreno() {
		// TODO Auto-generated constructor stub
	}
	
    public Terreno(int codigo, boolean disponible, double latitud, double longitud, double superficie, double precioVenta) {
        super(codigo, disponible);
        this.latitud = latitud;
        this.longitud = longitud;
        this.superficie = superficie;
        this.precioVenta = precioVenta;
    }
	
	
	@Override
	public String toString() {
		return "[Terreno N°=" + codigo + " latitud=" + latitud + ", longitud=" + longitud + ", superficie=" + superficie
				+ ", precioVenta=" + precioVenta + "]";
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}



	
	
	
}
