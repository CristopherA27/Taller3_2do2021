package dominio;

public class Documento extends Entrega{
	
	private String rutRemitente;
	private String rutDestinatario;
	private int peso;
	private int grosor;
	
	public Documento(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int grosor) {
		super(codigoEntrega);
		this.rutRemitente = rutRemitente;
		this.rutDestinatario = rutDestinatario;
		this.peso = peso;
		this.grosor = grosor;
		
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
