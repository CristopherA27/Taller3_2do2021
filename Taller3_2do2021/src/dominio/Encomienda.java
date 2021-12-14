package dominio;

public class Encomienda extends Entrega {

	private int peso;
	private int largo;
	private int ancho;
	private int profundidad;
	
	public Encomienda(String codigoEntrega, String rutRemitente,String rutDestinatario,int peso,int largo,int ancho,int profundidad) {
		super(codigoEntrega,rutRemitente,rutDestinatario);
		this.peso = peso;
		this.largo = largo;
		this.ancho = ancho;
		this.profundidad = profundidad;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getLargo() {
		return largo;
	}
	public void setLargo(int largo) {
		this.largo = largo;
	}
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getProfundidad() {
		return profundidad;
	}
	public void setProfundidad(int profundidad) {
		this.profundidad = profundidad;
	}

}
