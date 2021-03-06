package logica;

public interface SystemI {
	
	public void ingresarCliente(String rut,String nombre,String apellido,int saldo,String ciudadOrigen);
	public void ingresarCiudad(String nombre);
	public void ingresarAsociarDocumento(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int grosor);
	public void ingresarAsociarEncomienda(String codigoEntrega,String rutRemitente,String rutDestinatario,int peso,int largo,int ancho,int profundidad);
	public void ingresarAsociarValija(String codigoEntrega,String rutRemitente,String rutDestinatario,String material,int peso);
	
	public boolean verificarParametro(String tipo,int peso,String material,int grosor,int largo,int ancho,int profundidad);
	public boolean verificarRut(String rut);
	
	public void realizarEntrega(String codigoEntreg,String tipo,String rutRemitente,String rutDestinatario,int peso, String material, int grosor, int largo, int ancho,int profundidad);
	
	public boolean verificarSaldo(String rut,int montopagar);
	
	public void recargarSaldo(String rut,int dinero);
	public String obtenerEntregas(String rut);
	
	public String obtenerEntregasPorTipo();
	
	public int obtenerPrecio(String tipo,int peso, String material, int grosor, int largo, int ancho,int profundidad);
	
	public String obtenerEntregasPorLocalizacion();
	
	public String obtenerEntregasPorCliente();
	public String obtenerGananciasOficinas();
	public String obtenerBalanceTotal();
	
	//Sobreescribir
	
	public String obtenerEntregas();
	public String obtenerClientes();
	
	
}
