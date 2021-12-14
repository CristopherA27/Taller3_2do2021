package logica;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dominio.*;

public class SystemImpl implements SystemI{
	
	private List<Cliente> lclientes;
	private List<Ciudad> lciudades;
	private ListaDobleNexoCircular lentregas;
	
	public SystemImpl() {
		lclientes = new LinkedList<Cliente>();
		lciudades =	new ArrayList<Ciudad>();
		lentregas= new ListaDobleNexoCircular();
	}

	public void ingresarCliente(String rut, String nombre, String apellido, int saldo, String ciudadOrigen) {
		Cliente cliente = new Cliente(rut, nombre, apellido, saldo, ciudadOrigen);
		lclientes.add(cliente); 
	}

	@Override
	public void ingresarCiudad(String nombre) {
		Ciudad ciudad = new Ciudad(nombre);
		lciudades.add(ciudad);
	}

	@Override
	public void ingresarDocumento(String codigoEntrega, String rutRemitente, String rutDestinatario, int peso,int grosor) {
		Entrega e = new Documento(codigoEntrega, rutRemitente, rutDestinatario, peso, grosor);
		lentregas.ingresar(e);

	}

	@Override
	public void ingresarEncomienda(String codigoEntrega, String rutRemitente, String rutDestinatario,int peso, int largo, int ancho, int profundidad) {
		Entrega e = new Encomienda(codigoEntrega, rutRemitente, rutDestinatario, peso, largo, ancho, profundidad);
		lentregas.ingresar(e);
	}

	@Override
	public void ingresarValija(String codigoEntrega, String rutRemitente, String rutDestinatario,String material, int peso) {
		Entrega e = new Valija(codigoEntrega, rutRemitente, rutDestinatario, material, peso);
		lentregas.ingresar(e);
	}

	
	
}
