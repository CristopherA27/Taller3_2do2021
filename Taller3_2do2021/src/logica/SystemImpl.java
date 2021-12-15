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
	public void ingresarAsociarDocumento(String codigoEntrega, String rutRemitente, String rutDestinatario, int peso,int grosor) {
		Entrega e = new Documento(codigoEntrega, rutRemitente, rutDestinatario, peso, grosor);
		lentregas.ingresar(e);
		String rutRe = e.getRutRemitente();
		String rutDe = e.getRutDestinatario();
		for(int j=0;j<lclientes.size();j++) {
			String rutpersona = lclientes.get(j).getRut();	
			if(rutpersona.equals(rutRe) || rutpersona.equals(rutDe)) {
				Cliente c =lclientes.get(j);
				c.getLentregas().ingresar(e);
			}
		}
	}
	@Override
	public void ingresarAsociarEncomienda(String codigoEntrega, String rutRemitente, String rutDestinatario,int peso, int largo, int ancho, int profundidad) {
		Entrega e = new Encomienda(codigoEntrega, rutRemitente, rutDestinatario, peso, largo, ancho, profundidad);
		lentregas.ingresar(e);
		String rutRe = e.getRutRemitente();
		String rutDe = e.getRutDestinatario();
		for(int j=0;j<lclientes.size();j++) {
			String rutpersona = lclientes.get(j).getRut();	
			if(rutpersona.equals(rutRe) || rutpersona.equals(rutDe)) {
				Cliente c =lclientes.get(j);
				c.getLentregas().ingresar(e);
			}
		}
		
	}
	@Override
	public void ingresarAsociarValija(String codigoEntrega, String rutRemitente, String rutDestinatario,String material, int peso) {
		Entrega e = new Valija(codigoEntrega, rutRemitente, rutDestinatario, material, peso);
		lentregas.ingresar(e);
		String rutRe = e.getRutRemitente();
		String rutDe = e.getRutDestinatario();
		for(int j=0;j<lclientes.size();j++) {
			String rutpersona = lclientes.get(j).getRut();	
			if(rutpersona.equals(rutRe) || rutpersona.equals(rutDe)) {
				Cliente c =lclientes.get(j);
				c.getLentregas().ingresar(e);
			}
		}
	}
	@Override
	public boolean verificarParametro(String tipo, int peso, String material, int grosor, int largo, int ancho,int profundidad) {
		switch (tipo) {
		case("D"): 
			if(peso <=1500 && grosor <=50) {
				return true;
			}
			break;
		case("E"):
			if(peso<50000 && largo<120 && ancho<80 && profundidad<80) {
				return true;
			}
			break;
		case("V"):
			
			break;
		default:
			throw new IllegalArgumentException("El tipo "+tipo+" no existe");
		}
		return false;
	}

	@Override
	public boolean verificarRut(String rut) {
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			if(c.getRut().equals(rut)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean verificarCiudad(String ciudadOrigen) {
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			if(c.getNombre().equals(ciudadOrigen)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
}
