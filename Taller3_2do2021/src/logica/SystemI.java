package logica;

public interface SystemI {
	
	public void ingresarCliente(String rut,String nombre,String apellido,int saldo,String ciudadOrigen);
	public void ingresarCiudad(String nombre);
	public void ingresarDocumento(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int grosor);
	public void ingresarEncomienda(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int largo,int ancho,int profundidad);
	public void ingresarValija(String codigoEntrega,String rutRemitente,String rutDestinatario,String material,int peso);
	

	

}
