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
			Cliente c =lclientes.get(j);
			String rutpersona = c.getRut();
			if(rutpersona.equals(rutRe) ) {
				c.getLenviados().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
						}
					}
				}
			}else if(rutpersona.equals(rutDe)) {
				c.getLrecibidos().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
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
			Cliente c =lclientes.get(j);
			String rutpersona = c.getRut();
			if(rutpersona.equals(rutRe) ) {
				c.getLenviados().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
						}
					}
				}
			}else if(rutpersona.equals(rutDe)) {
				c.getLrecibidos().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
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
			Cliente c =lclientes.get(j);
			String rutpersona = c.getRut();
			if(rutpersona.equals(rutRe) ) {
				c.getLenviados().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
						}
					}
				}
			}else if(rutpersona.equals(rutDe)) {
				c.getLrecibidos().ingresar(e);
				boolean existeciudad = verificarCiudad(c.getCiudadOrigen());
				if(existeciudad) {
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
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
			if(peso <2000) {
				return true;
			}
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
	
	public boolean verificarSaldo(String rut,int montopagar) {
		for(int i=0;i<lclientes.size();i++) {
			if(lclientes.get(i).getRut().equals(rut)) {
				Cliente c= lclientes.get(i);
				int saldo= c.getSaldo();
				if(saldo>montopagar) {
					c.setSaldo(saldo-montopagar);
					return true;
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	public void añadirSaldo(String rut,int dinero) {
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			if(c.getRut().equals(rut)) {
				c.setSaldo(c.getSaldo()+dinero);
				break;
			}
		}
	}
	
	public String obtenerEntregas(String rut) {
		String dato = "";
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			if(c.getRut().equals(rut)) {
				ListaDobleNexoCircular lenvios = c.getLenviados();
				ListaDobleNexoCircular lrecibe = c.getLrecibidos();
				dato+="Ha realizado "+lenvios.size()+"envios \n";
				for(int j=0;j<lenvios.size();i++) {
					Entrega e = lenvios.getElemento(i);
					if(e instanceof Documento) {
						Documento d = (Documento)e;
						dato+="\tDocumento: "+d.getCodigoEntrega()+","+d.getPeso()+","+d.getGrosor()+"\n";
					}else if(e instanceof Encomienda) {
						Encomienda en = (Encomienda)e;
						dato+="\tEncomienda: "+en.getCodigoEntrega()+","+en.getPeso()+","+en.getLargo()+","+en.getAncho()+","+en.getProfundidad()+"\n";
					}else if(e instanceof Valija) {
						Valija v = (Valija)e;
						dato+="\tValija: "+v.getCodigoEntrega()+","+v.getMaterial()+","+v.getPeso()+"\n";
					}
				}
				dato+="Ha recibido"+lrecibe.size()+"\n";
				for(int k=0;k<lrecibe.size();k++) {
					Entrega e = lenvios.getElemento(i);
					if(e instanceof Documento) {
						Documento d = (Documento)e;
						dato+="\tDocumento: "+d.getCodigoEntrega()+","+d.getPeso()+","+d.getGrosor()+"\n";
					}else if(e instanceof Encomienda) {
						Encomienda en = (Encomienda)e;
						dato+="\tEncomienda: "+en.getCodigoEntrega()+","+en.getPeso()+","+en.getLargo()+","+en.getAncho()+","+en.getProfundidad()+"\n";
					}else if(e instanceof Valija) {
						Valija v = (Valija)e;
						dato+="\tValija: "+v.getCodigoEntrega()+","+v.getMaterial()+","+v.getPeso()+"\n";
					}
				}
			}
		}
		return dato;
	}
	
	public String obtenerEntregasPorTipo() {
		String dato ="";
		for(int i=0;i<lentregas.size();i++) {
			Entrega e = lentregas.getElemento(i);
			if(e instanceof Documento) {
				Documento d = (Documento)e;
				dato+="\tDocumento: "+d.getCodigoEntrega()+","+d.getRutRemitente()+","+d.getRutDestinatario()+","+d.getPeso()+","+d.getGrosor()+"..Pagar: "+d.pagar()+"\n";
			}else if(e instanceof Encomienda) {
				Encomienda en = (Encomienda)e;
				dato+="\tEncomienda: "+en.getCodigoEntrega()+","+en.getRutRemitente()+","+en.getRutDestinatario()+","+en.getPeso()+","+en.getLargo()+","+en.getAncho()+","+en.getProfundidad()+"..Pagar: "+en.pagar()+"\n";
			}else if(e instanceof Valija) {
				Valija v = (Valija)e;
				dato+="\tValija: "+v.getCodigoEntrega()+","+v.getRutRemitente()+","+v.getRutDestinatario()+","+v.getMaterial()+","+v.getPeso()+"..Pagar: "+v.pagar()+"\n";
			}
			
		}
		return dato;
	}

	@Override
	public String obtenerEntregasPorLocalizacion() {
		String dato ="";
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			dato+="\t"+c.getNombre()+" realizo "+c.getCantEnvios()+" envios y recibio "+c.getCantRecibidos()+"\n";
		}
		return dato;
	}
	
	public String obtenerEntregasPorCliente() {
		String dato ="";
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			dato +="Cliente "+c.getNombre()+"....Entregas: "+"\n";
			ListaDobleNexoCircular le = c.getLenviados();
			for(int a=0;a<le.size();a++) {
				Entrega e = le.getElemento(i);
				if(e instanceof Documento) {
					Documento d = (Documento)e;
					dato+="\tDocumento: "+d.getCodigoEntrega()+","+d.getRutRemitente()+","+d.getRutDestinatario()+","+d.getPeso()+","+d.getGrosor()+"..Pagar: "+d.pagar()+"\n";
				}else if(e instanceof Encomienda) {
					Encomienda en = (Encomienda)e;
					dato+="\tEncomienda: "+en.getCodigoEntrega()+","+en.getRutRemitente()+","+en.getRutDestinatario()+","+en.getPeso()+","+en.getLargo()+","+en.getAncho()+","+en.getProfundidad()+"..Pagar: "+en.pagar()+"\n";
				}else if(e instanceof Valija) {
					Valija v = (Valija)e;
					dato+="\tValija: "+v.getCodigoEntrega()+","+v.getRutRemitente()+","+v.getRutDestinatario()+","+v.getMaterial()+","+v.getPeso()+"..Pagar: "+v.pagar()+"\n";
				}
			}
			
		}
		return dato;
	}
	
	
	
	
	
	
}
