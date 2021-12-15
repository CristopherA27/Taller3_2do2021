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
	
	public int precioMaterial(String material) {
		switch(material) {
		case("Cuero"):
			return 200;
		case("Plastico"):
			return 150;
		case("Tela"):
			return 100;
		default:
			throw new IllegalArgumentException("El tipo de material ingresado no existe");
		}
	}
	@Override
	public  int pagar() {
		int preciomaterial = precioMaterial(material);
		int pesokg = peso/1000;
		int pagarTotal = preciomaterial*pesokg*150;
		return pagarTotal;
	}
	
}
