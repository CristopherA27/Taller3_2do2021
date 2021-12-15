package logica;

public interface SystemI {
	
	public void ingresarCliente(String rut,String nombre,String apellido,int saldo,String ciudadOrigen);
	public void ingresarCiudad(String nombre);
	public void ingresarAsociarDocumento(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int grosor);
	public void ingresarAsociarEncomienda(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int largo,int ancho,int profundidad);
	public void ingresarAsociarValija(String codigoEntrega,String rutRemitente,String rutDestinatario,String material,int peso);
	

	

}
