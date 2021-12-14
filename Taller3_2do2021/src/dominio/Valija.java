package dominio;

public class Valija extends Entrega{
	
	private String rutRemitente;
	private String rutDestinatario;
	private String material;
	private int peso;
	
	public Valija(String codigoEntrega, String rutRemitente, String rutDestinatario, String material, int peso) {
		super(codigoEntrega);
		this.rutRemitente = rutRemitente;
		this.rutDestinatario = rutDestinatario;
		this.material = material;
		this.peso = peso;
	}
	public String getRutRemitente() {
		return rutRemitente;
	}
	public void setRutRemitente(String rutRemitente) {
		this.rutRemitente = rutRemitente;
	}
	public String getRutDestinatario() {
		return rutDestinatario;
	}
	public void setRutDestinatario(String rutDestinatario) {
		this.rutDestinatario = rutDestinatario;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
}
