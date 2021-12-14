package dominio;

public class Valija extends Entrega{
	private String material;
	private int peso;
	
	public Valija(String codigoEntrega, String rutRemitente, String rutDestinatario, String material, int peso) {
		super(codigoEntrega,rutRemitente,rutDestinatario);
		this.material = material;
		this.peso = peso;
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
