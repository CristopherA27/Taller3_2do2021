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
	
	/**
	 * The client is entered into the general list of clients.
	 * @param rut 	
	 * @param nombre
	 * @param apellido
	 * @param saldo
	 * @param ciudadOrigen
	 */
	
	public void ingresarCliente(String rut, String nombre, String apellido, int saldo, String ciudadOrigen) {
		Cliente cliente = new Cliente(rut, nombre, apellido, saldo, ciudadOrigen);
		lclientes.add(cliente); 
	}
	
	/**
	 * The city is entered into the general list of cities
	 * @param nombre
	 */
	
	@Override
	public void ingresarCiudad(String nombre) {
		Ciudad ciudad = new Ciudad(nombre);
		lciudades.add(ciudad);
	}

	/**
	 * The document entered is associated with the 2 corresponding clients and the document is entered into the general list of deliveries.
	 * @param codigoEntrega
	 * @param rutRemitente
	 * @param rutDestinatario
	 * @param peso
	 * @param grosor
	 */
	
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
							ciu.setGanancias(ciu.getGanancias()+e.pagar());
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
	
	/**
	 * The order entered is associated with the 2 corresponding clients and the order is entered into the general list of deliveries
	 * @param codigoEntrega
	 * @param rutRemitente
	 * @param rutDestinatario
	 * @param peso
	 * @param largo
	 * @param ancho
	 * @param profundidad
	 */
	
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
							ciu.setGanancias(ciu.getGanancias()+e.pagar());
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
	
	/**
	 * The bag entered is associated with the 2 corresponding customers and the bag is entered into the general list of deliveries.
	 * @param codigoEntrega
	 * @param rutRemitente
	 * @param rutDestinatario
	 * @param material
	 * @param peso
	 */
	
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
							ciu.setGanancias(ciu.getGanancias()+e.pagar());
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
	
	/**
	 * The types of parameters of the entered delivery were verified.
	 * @param tipo
	 * @param peso
	 * @param material
	 * @param grosor
	 * @param largo
	 * @param ancho
	 * @param profundidad
	 * @return boolean
	 */
	
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
	
	/**
	 * Check if the rut exists in the general customer list
	 * @param rut
	 * @return boolean
	 */
	
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
	
	/**
	 * It is checked if the city exists in the general city list
	 * @param ciudadOrigen
	 * @return boolean
	 */
	
	public boolean verificarCiudad(String ciudadOrigen) {
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			if(c.getNombre().equals(ciudadOrigen)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 	It is verified if the client with the entered routine has enough balance to carry out the operation, if so, it will be discounted.
	 * @param montopagar
	 * @return boolean
	 */
	
	public boolean verificarSaldo(String rut,int montopagar) {
		for(int i=0;i<lclientes.size();i++) {
			if(lclientes.get(i).getRut().equals(rut)) {
				Cliente c= lclientes.get(i);
				int saldo= c.getSaldo();
				if(saldo>montopagar) {
					c.setSaldo(saldo-montopagar);
					for(int j=0;j<lciudades.size();j++) {
						if(lciudades.get(i).getNombre().equals(c.getCiudadOrigen())) {
							lciudades.get(i).setGanancias(lciudades.get(i).getGanancias()+montopagar);
							return true;
						}
					}
				}else {
					return false;
				}
			}
		}
		return false;
	}
	
	/**
	 * The price of the delivery is obtained.
	 * @param tipo
	 * @param peso
	 * @param material
	 * @param grosor
	 * @param largo
	 * @param ancho
	 * @param profundidad
	 * @return precio
	 */
	
	public int obtenerPrecio(String tipo,int peso, String material, int grosor, int largo, int ancho,int profundidad) {
		switch (tipo) {
		case("D"):
			Entrega e = new Documento(null, null, null, peso, grosor);
			int precio = e.pagar();
			return precio;
		case("E"):
			Entrega en = new Encomienda(null, null, null, peso, largo, ancho, profundidad);
			precio = en.pagar();
			return precio;
		case("V"):
			Entrega v = new Valija(null, null, null, material, peso);
			precio = v.pagar();
			return precio;
		default:
			break;
		}
		return 0;
	}
	
	/**
	 * It is verified if the entered ruts exist and if so, a delivery is created.
	 * @param codigoEntrega
	 * @param tipo
	 * @param rutRemitente
	 * @param rutDestinatario
	 * @param peso
	 * @param material
	 * @param grosor
	 * @param largo
	 * @param ancho
	 * @param profundidad
	 */
	
	public void realizarEntrega(String codigoEntrega,String tipo,String rutRemitente,String rutDestinatario,int peso, String material, int grosor, int largo, int ancho,int profundidad) {
		switch (tipo) {
		case("D"):
			Entrega e = new Documento(codigoEntrega, rutRemitente, rutDestinatario, peso, grosor);
			for(int i=0;i<lclientes.size();i++) {
				Cliente c = lclientes.get(i);
				if(c.getRut().equalsIgnoreCase(rutRemitente)) {
					c.getLenviados().ingresar(e);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
							ciu.setGanancias(ciu.getGanancias()+e.pagar());
						}
					}
				}else if(c.getRut().equalsIgnoreCase(rutDestinatario)) {
					c.getLrecibidos().ingresar(e);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
			}
			lentregas.ingresar(e);
			break;
		case("E"):
			Entrega en = new Encomienda(codigoEntrega,rutRemitente, rutDestinatario, peso, largo, ancho, profundidad);
			for(int i=0;i<lclientes.size();i++) {
				Cliente c = lclientes.get(i);
				if(c.getRut().equalsIgnoreCase(rutRemitente)) {
					c.getLenviados().ingresar(en);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
							ciu.setGanancias(ciu.getGanancias()+en.pagar());
						}
					}
				}else if(c.getRut().equalsIgnoreCase(rutDestinatario)) {
					c.getLrecibidos().ingresar(en);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
			}
			lentregas.ingresar(en);
			break;
		case("V"):
			Entrega v = new Valija(codigoEntrega, rutRemitente, rutDestinatario, material, peso);
			for(int i=0;i<lclientes.size();i++) {
				Cliente c = lclientes.get(i);
				if(c.getRut().equalsIgnoreCase(rutRemitente)) {
					c.getLenviados().ingresar(v);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantEnvios(ciu.getCantEnvios()+1);
							ciu.setGanancias(ciu.getGanancias()+v.pagar());
						}
					}
				}else if(c.getRut().equalsIgnoreCase(rutDestinatario)) {
					c.getLrecibidos().ingresar(v);
					for(int a=0;a<lciudades.size();a++) {
						Ciudad ciu = lciudades.get(a);
						if(ciu.getNombre().equals(c.getCiudadOrigen())) {
							ciu.setCantRecibidos(ciu.getCantRecibidos()+1);
						}
					}
				}
			}
			lentregas.ingresar(v);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Money is recharged to the balance of the entered rut.
	 * @param rut
	 * @param dinero
	 */
	
	public void recargarSaldo(String rut,int dinero) {
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			if(c.getRut().equals(rut)) {
				c.setSaldo(c.getSaldo()+dinero);
				break;
			}
		}
	}
	
	/**
	 * The data of the deliveries that the client received and sent are obtained.
	 * @param rut
	 * @return dato
	 */
	
	public String obtenerEntregas(String rut) {
		String dato = "";
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			if(c.getRut().equals(rut)) {
				ListaDobleNexoCircular lenvios = c.getLenviados();
				ListaDobleNexoCircular lrecibe = c.getLrecibidos();
				dato+="Ha realizado "+lenvios.size()+" envio(s) \n";
				for(int j=0;j<lenvios.size();j++) {
					Entrega e = lenvios.getElemento(j);
					if(e instanceof Documento) {
						Documento d = (Documento)e;
						dato+="\tDocumento: Codigo:"+d.getCodigoEntrega()+",Peso:"+d.getPeso()+",Grosor:"+d.getGrosor()+"\n";
					}else if(e instanceof Encomienda) {
						Encomienda en = (Encomienda)e;
						dato+="\tEncomienda: Codigo:"+en.getCodigoEntrega()+",Peso:"+en.getPeso()+",Largo:"+en.getLargo()+",Ancho:"+en.getAncho()+",Profundidad:"+en.getProfundidad()+"\n";
					}else if(e instanceof Valija) {
						Valija v = (Valija)e;
						dato+="\tValija: Codigo:"+v.getCodigoEntrega()+",Material:"+v.getMaterial()+",Peso:"+v.getPeso()+"\n";
					}
				}
				dato+="Ha recibido "+lrecibe.size()+"\n";
				for(int k=0;k<lrecibe.size();k++) {
					Entrega e = lrecibe.getElemento(k);
					if(e instanceof Documento) {
						Documento d = (Documento)e;
						dato+="\tDocumento: Codigo:"+d.getCodigoEntrega()+",Peso:"+d.getPeso()+",Grosor:"+d.getGrosor()+"\n";
					}else if(e instanceof Encomienda) {
						Encomienda en = (Encomienda)e;
						dato+="\tEncomienda: Codigo:"+en.getCodigoEntrega()+",Peso:"+en.getPeso()+",Largo:"+en.getLargo()+",Ancho:"+en.getAncho()+",Profundidad:"+en.getProfundidad()+"\n";
					}else if(e instanceof Valija) {
						Valija v = (Valija)e;
						dato+="\tValija: Codigo:"+v.getCodigoEntrega()+",Material:"+v.getMaterial()+",Peso:"+v.getPeso()+"\n";
					}
				}
			}
		}
		return dato;
	}
	
	/**
	 * You get the total deliveries according to their type.
	 * @return dato
	 */
	
	public String obtenerEntregasPorTipo() {
		String dato ="";
		for(int i=0;i<lentregas.size();i++) {
			Entrega e = lentregas.getElemento(i);
			if(e instanceof Documento) {
				Documento d = (Documento)e;
				dato+="\tDocumento: Codigo:"+d.getCodigoEntrega()+",RutRemitente:"+d.getRutRemitente()+",RutDestinatario"+d.getRutDestinatario()+",Peso:"+d.getPeso()+",Grosor:"+d.getGrosor()+"		Pagar: "+d.pagar()+"clp\n";
			}else if(e instanceof Encomienda) {
				Encomienda en = (Encomienda)e;
				dato+="\tEncomienda: Codigo:"+en.getCodigoEntrega()+",RutRemitente:"+en.getRutRemitente()+",RutDestinatario"+en.getRutDestinatario()+",Peso:"+en.getPeso()+",Largo:"+en.getLargo()+",Ancho:"+en.getAncho()+",Profundidad:"+en.getProfundidad()+"		Pagar: "+en.pagar()+"clp\n";
			}else if(e instanceof Valija) {
				Valija v = (Valija)e;
				dato+="\tValija:  Codigo:"+v.getCodigoEntrega()+",RutRemitente:"+v.getRutRemitente()+",RutDestinatario"+v.getRutDestinatario()+",Material:"+v.getMaterial()+",Peso:"+v.getPeso()+"		Pagar: "+v.pagar()+"clp\n";
			}
			
		}
		return dato;
	}

	/**
	 *You get the number of received and sent by city. 
	 *@return dato
	 */
	
	public String obtenerEntregasPorLocalizacion() {
		String dato ="";
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			dato+="\t"+c.getNombre()+" realizo "+c.getCantEnvios()+" envios y recibio "+c.getCantRecibidos()+"\n";
		}
		return dato;
	}
	
	/**
	 * You get the deliveries made by customer.
	 * @return dato
	 */
	
	public String obtenerEntregasPorCliente() {
		String dato ="";
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			dato +="Cliente "+c.getNombre()+"....Entregas: "+"\n";
			ListaDobleNexoCircular le = c.getLenviados();
			for(int a=0;a<le.size();a++) {
				Entrega e = le.getElemento(a);
				if(e instanceof Documento) {
					Documento d = (Documento)e;
					dato+="\tDocumento: Codigo:"+d.getCodigoEntrega()+",RutRemitente:"+d.getRutRemitente()+",RutDestinatario"+d.getRutDestinatario()+",Peso:"+d.getPeso()+",Grosor:"+d.getGrosor()+"\n";
				}else if(e instanceof Encomienda) {
					Encomienda en = (Encomienda)e;
					dato+="\tEncomienda: Codigo:"+en.getCodigoEntrega()+",RutRemitente:"+en.getRutRemitente()+",RutDestinatario"+en.getRutDestinatario()+",Peso:"+en.getPeso()+",Largo:"+en.getLargo()+",Ancho:"+en.getAncho()+",Profundidad:"+en.getProfundidad()+"\n";
				}else if(e instanceof Valija) {
					Valija v = (Valija)e;
					dato+="\tValija:  Codigo:"+v.getCodigoEntrega()+",RutRemitente:"+v.getRutRemitente()+",RutDestinatario"+v.getRutDestinatario()+",Material:"+v.getMaterial()+",Peso:"+v.getPeso()+"\n";
				}
			}
		}
		return dato;
	}
	
	/**
	 * The profit is obtained from each office.
	 * @return dato
	 */
	
	public String obtenerGananciasOficinas(){
		String dato = "";
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			dato+="La ciuadd "+c.getNombre()+" recaudo "+c.getGanancias()+"\n";
		}
		return dato;
	}
	
	/**
	 * The sum of the balances of each office is obtained.
	 * return dato
	 */
	
	public String obtenerBalanceTotal() {
		int sumador = 0;
		String dato = "";
		for(int i=0;i<lciudades.size();i++) {
			Ciudad c = lciudades.get(i);
			sumador+=c.getGanancias();
		}
		dato+="\tEl balance total de todas las oficinas fue "+sumador;
		return dato;
	}
	
	/**
	 * You get all the deliveries of the system.
	 * return rocklee
	 */
	
	public String obtenerEntregas() {
		String rocklee= "";
		for(int i=0;i<lentregas.size();i++) {
			Entrega e = lentregas.getElemento(i);
			if(e instanceof Documento) {
				Documento d = (Documento)e;
				rocklee+=d.getCodigoEntrega()+",D,"+d.getRutRemitente()+","+d.getRutDestinatario()+","+d.getPeso()+","+d.getGrosor()+"\n";
			}else if(e instanceof Encomienda) {
				Encomienda en = (Encomienda)e;
				rocklee+=en.getCodigoEntrega()+",E,"+en.getRutRemitente()+","+en.getRutDestinatario()+","+en.getPeso()+","+en.getLargo()+","+en.getAncho()+","+en.getProfundidad()+"\n";
			}else if(e instanceof Valija) {
				Valija v = (Valija)e;
				rocklee+=v.getCodigoEntrega()+",V,"+v.getRutRemitente()+","+v.getRutDestinatario()+","+v.getMaterial()+","+v.getPeso()+"\n";
			}
		}
		return rocklee;
	}
	
	/**
	 * All clients of the system are obtained.
	 * return covid
	 */
	
	public String obtenerClientes() {
		String covid ="";
		for(int i=0;i<lclientes.size();i++) {
			Cliente c = lclientes.get(i);
			covid+=c.getRut()+","+c.getNombre()+","+c.getApellido()+","+c.getSaldo()+","+c.getCiudadOrigen()+"\n";
		}
		return covid;
	}
	
	
	
	
	
	
	
	
	
}
