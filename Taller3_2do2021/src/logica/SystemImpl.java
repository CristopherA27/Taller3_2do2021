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
	public boolean ingresarAsociarDocumento(String codigoEntrega, String rutRemitente, String rutDestinatario, int peso,
			int grosor) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarAsociarEncomienda(String codigoEntrega, String rutRemitente, String rutDestinatario,
			int peso, int largo, int ancho, int profundidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ingresarAsociarValija(String codigoEntrega, String rutRemitente, String rutDestinatario,
			String material, int peso) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
