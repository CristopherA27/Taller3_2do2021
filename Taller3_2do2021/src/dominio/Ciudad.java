package dominio;

public class Ciudad {
	private String nombre;
	private int ganancias;
	private int cantEnvios;
	private int cantRecibidos;
	
	public Ciudad(String nombre) {
		this.nombre = nombre;
		ganancias = 0;
		cantEnvios = 0;
		cantRecibidos=0;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getGanancias() {
		return ganancias;
	}
	public void setGanancias(int ganancias) {
		this.ganancias = ganancias;
	}
	public int getCantEnvios() {
		return cantEnvios;
	}
	public void setCantEnvios(int cantEnvios) {
		this.cantEnvios = cantEnvios;
	}
	public int getCantRecibidos() {
		return cantRecibidos;
	}
	public void setCantRecibidos(int cantRecibidos) {
		this.cantRecibidos = cantRecibidos;
	}

}
