package dominio;

public abstract class Entrega {
	
	private String codigoEntrega;
	private String rutRemitente;
	private String rutDestinatario;
	public Entrega(String codigoEntrega,String rutRemitente,String rutDestinatario) {
		this.codigoEntrega = codigoEntrega;
		this.rutRemitente = rutRemitente;
		this.rutDestinatario = rutDestinatario;
	}
	public String getCodigoEntrega() {
		return codigoEntrega;
	}
	public void setCodigoEntrega(String codigoEntrega) {
		this.codigoEntrega = codigoEntrega;
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
	
	public abstract int pagar();
	

}
