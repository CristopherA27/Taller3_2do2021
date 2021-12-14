package dominio;

public class Documento extends Entrega{

	private int peso;
	private int grosor;
	
	public Documento(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int grosor) {
		super(codigoEntrega,rutRemitente,rutDestinatario);
		this.peso = peso;
		this.grosor = grosor;
		
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getGrosor() {
		return grosor;
	}
	public void setGrosor(int grosor) {
		this.grosor = grosor;
	}	
			
}
