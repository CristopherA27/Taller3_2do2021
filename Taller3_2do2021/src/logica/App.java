package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class App {
	
	public static void leerCiudades(SystemI system) throws FileNotFoundException {
		Scanner s = new Scanner(new File("Ciudades.txt"));
		while(s.hasNextLine()) {
			String line = s.nextLine();
			String [] partes = line.split(",");
			String nombre = partes[0];
			system.ingresarCiudad(nombre);
		}
		s.close();
	}
	
	public static void leerClientes(SystemI system)throws FileNotFoundException {
		Scanner s = new Scanner(new File("Clientes.txt"));
		while(s.hasNextLine()) {
			String line = s.nextLine();
			String [] partes = line.split(",");
			String rut = partes[0];
			String nombre = partes[1];
			String apellido = partes[2];
			int saldo = Integer.parseInt(partes[3]);
			String ciudadOrigen = partes[4];
			system.ingresarCliente(rut, nombre, apellido, saldo, ciudadOrigen);
		}
		s.close();
	}
	
	public static void leerEntregas(SystemI system)throws FileNotFoundException{
		Scanner s = new Scanner(new File("Entregas.txt"));
		while(s.hasNextLine()) {
			String line = s.nextLine();
			String [] partes = line.split(",");
			String codigoEntrega = partes[0];
			String tipo = partes[1];
			switch (tipo) {
			case("D"): 
				String rutRemmitente = partes[2];
				String rutDestinatario = partes[3];
				int peso = Integer.parseInt(partes[4]);
				int grosor = Integer.parseInt(partes[5]);
				system.ingresarAsociarDocumento(codigoEntrega, rutRemmitente, rutDestinatario, peso, grosor);
				break;
			case("V"):
				rutRemmitente = partes[2];
				rutDestinatario = partes[3];
				String material  = partes[4];
				peso = Integer.parseInt(partes[5]);
				system.ingresarAsociarValija(codigoEntrega, rutRemmitente, rutDestinatario, material, peso);
				break;
			case("E"):
				rutRemmitente = partes[2];
				rutDestinatario = partes[3];
				peso = Integer.parseInt(partes[4]);
			    int largo = Integer.parseInt(partes[5]);
			    int ancho = Integer.parseInt(partes[6]);
			    int profundidad = Integer.parseInt(partes[7]);
			    system.ingresarAsociarEncomienda(codigoEntrega, rutRemmitente, rutDestinatario, peso, largo, ancho, profundidad);
				break;
			default:
				throw new IllegalArgumentException("No existe el tipo ingresado "+tipo);
			}
			//System.out.println(line);
		}
		s.close();
	}
	
	public static boolean inicioSesion(SystemI system) {
		System.out.println("BIENVENIDO A STARKON");
		System.out.println();
		System.out.print("Ingrese su rut: ");
		String rut = leer.nextLine();
		if(rut.equalsIgnoreCase("Admin")) {
			System.out.print("Ingrese la contrase�a: ");
			String contrase�a = leer.nextLine();
			if(contrase�a.equalsIgnoreCase("choripan123")) {
				menuAdmin(system);
				return true;
			}else {
				System.out.println("Contrase�a incorrecta....");
				return false;
			}
		}else {
			boolean existeLaCuenta = system.verificarRut(rut);
			if(existeLaCuenta) {
				menuUsuario(system, rut);
				return true;
			}else {
				System.out.print("Desea registrar un nuevo Cliente? (SI-NO)");
				String respuesta = leer.nextLine();
				while(!respuesta.equalsIgnoreCase("Si") && !respuesta.equalsIgnoreCase("No")) {
					System.out.println("Ingrese (SI) o (NO) por favor.....");
					System.out.print("Desea registrar un nuevo Cliente? (SI-NO)");
					respuesta = leer.nextLine();
				}
				if(respuesta.equalsIgnoreCase("Si")) {
					System.out.print("Rut: "); rut = leer.nextLine();
					System.out.print("Nombre: "); String nombre = leer.nextLine();
					System.out.print("Apellido: ");String apellido = leer.nextLine();
					System.out.print("Saldo: ");int saldo = leer.nextInt();
					leer.nextLine();
					System.out.print("Ciudad Origen: "); String origenCiudad = leer.nextLine();
					system.ingresarCliente(rut, nombre, apellido, saldo, origenCiudad);
					return true;
				}else {
					System.out.println("Usted no ingresara la cuenta");
					return false;
				}	
			}
			
		}

	}
	

	private static void menuAdmin(SystemI system) {
		// TODO Auto-generated method stub
		
	}

	private static void menuUsuario(SystemI system, String rut) {
		boolean cierre = true;
		System.out.println("Bienvenido Menu Usuario:");
		System.out.println();
		while(cierre) {
			System.out.println("Estas son las opciones: ");
			System.out.println("\tA)Realizar Entrega:");
			System.out.println("\tB)Recargar Saldo");
			System.out.println("\tC)Ver mis Entregas");
			System.out.println("\tD)Cerrar Sesion");
			System.out.print("Seleccione una opcion: ");
			String opcion = leer.nextLine();
			switch (opcion) {
			case("A"):
				System.out.println("Usted Realizara una entrega! ");
				System.out.print("�Que tipo de entrega desea realizar: ");
				String tipoEntrega = leer.nextLine();
				while(!tipoEntrega.equalsIgnoreCase("D") && !tipoEntrega.equalsIgnoreCase("E") && !tipoEntrega.equalsIgnoreCase("V") ) {
					System.out.println("Ingrese (D) , (E)  o  (V)por favor.....");
					System.out.print("�Que tipo de entrega desea realizar: ");
					tipoEntrega = leer.nextLine();
				}
				if(tipoEntrega.equalsIgnoreCase("D")) {
					System.out.print("Ingrese el peso del Documento: ");
					int peso = leer.nextInt();
					System.out.print("Ingrese el grosor del Documento: ");
					int grosor = leer.nextInt();
					boolean verificar = system.verificarParametro(tipoEntrega, peso, null, grosor, 0, 0, 0);
					leer.nextLine();
					if(verificar) {
						System.out.print("Ingrese su rut porfavor: ");
						String rutRe = leer.nextLine();
						System.out.print("Ingrese el rut del Destinatario: ");
						String rutDe = leer.nextLine();
						boolean verificarDes = system.verificarRut(rutDe);
						if(verificarDes) {
							int precio = system.obtenerPrecio(tipoEntrega, peso, null, grosor, 0, 0, 0);
							boolean saldopagar = system.verificarSaldo(rutRe, precio);
							if(saldopagar) {
								String codigo= generarCodigo();
								system.realizarEntrega(codigo, tipoEntrega, rutRe, rutDe, peso, null, grosor, 0, 0, 0);
								System.out.println("Entrega Realizada!");
								break;
							}
						}
						
					}
				}else if(tipoEntrega.equalsIgnoreCase("E")) {
					System.out.print("Ingrese el peso de la Encomienda: ");
					int peso = leer.nextInt();
					System.out.print("Ingrese el largo:");
					int largo = leer.nextInt();
					System.out.print("Ingrese el ancho:");
					int ancho = leer.nextInt();
					System.out.print("Ingrese la profundidad: ");
					int profundidad = leer.nextInt();
					boolean verificar = system.verificarParametro(tipoEntrega, peso, null, 0, largo, ancho, profundidad);
					leer.nextLine();
					if(verificar) {
						System.out.print("Ingrese su rut porfavor: ");
						String rutRe = leer.nextLine();
						System.out.print("Ingrese el rut del Destinatario: ");
						String rutDe = leer.nextLine();
						boolean verificarDes = system.verificarRut(rutDe);
						if(verificarDes) {
							int precio = system.obtenerPrecio(tipoEntrega, peso, null, 0, largo, ancho, profundidad);
							boolean saldopagar = system.verificarSaldo(rutRe, precio);
							if(saldopagar) {
								String codigo= generarCodigo();
								system.realizarEntrega(codigo, tipoEntrega, rutRe, rutDe, peso, null, 0, largo, ancho, profundidad);
								System.out.println("Entrega Realizada!");
								break;
							}
						}else {
							System.out.println("El rut del destinatario no existe...");
						}
					}
				}else if(tipoEntrega.equalsIgnoreCase("V")) {
					System.out.print("Ingrese el material de la valija");
					String material = leer.nextLine();
					while(!material.equalsIgnoreCase("Documento") && !material.equalsIgnoreCase("Encomienda") && !material.equalsIgnoreCase("Valija") ) {
						System.out.println("Ingrese (Documento) , (Encomienda)  o  (Valija) por favor.....");
						System.out.print("Ingrese el material de la valija");
						material = leer.nextLine();
					}
					System.out.print("Ingresa el peso de la Valija: ");
					int peso = leer.nextInt();
					boolean verificar = system.verificarParametro(tipoEntrega, peso, material, 0, 0, 0, 0);
					if(verificar) {
						System.out.print("Ingrese su rut porfavor: ");
						String rutRe = leer.nextLine();
						System.out.print("Ingrese el rut del Destinatario: ");
						String rutDe = leer.nextLine();
						boolean verificarDes = system.verificarRut(rutDe);
						if(verificarDes) {
							int precio = system.obtenerPrecio(tipoEntrega, peso, material, 0, 0, 0, 0);
							boolean saldopagar = system.verificarSaldo(rutRe, precio);
							if(saldopagar) {
								String codigo= generarCodigo();
								system.realizarEntrega(codigo, tipoEntrega, rutRe, rutDe, peso, material, 0, 0, 0, 0);
								System.out.println("Entrega Realizada!");
								break;
							}
						}
					}	
				}
				break;
			case("B"):
				System.out.println("A�ADIR SALDO");
				System.out.println();
				System.out.print("Ingrese el dinero que desea agregar a su saldo");
				int dinero = leer.nextInt();
				system.a�adirSaldo(rut, dinero);
				break;
			case("C"):
				System.out.println("OBTENIENDO ENTREGAS");
				System.out.println();
				System.out.println(system.obtenerEntregas(rut));
				break;
			case("D"):
				cierre = false;break;
			default:
				System.out.println("Elija A ,B o C porfavor ");break;
			}
			if(opcion.equalsIgnoreCase("D")) {
	    		break;
	    	}
		}
		System.out.println("\tSALIENDO DEL MENU USUARIO");
	}
	
	public static String generarCodigo() {
		String dato ="";
		int codigo =0;
		codigo = (int)(Math.random()*1000000+100000);
		dato+=codigo;
		return dato;
	}
	

	public static void main(String[] args) throws FileNotFoundException {
		SystemI system = new SystemImpl();
		leerCiudades(system);
		leerClientes(system);
		leerEntregas(system);
		String rut = "12345678";
		menuUsuario(system, rut);
		
		System.out.println();
		System.out.println(system.obtenerEntregasPorLocalizacion());
		System.out.println();
		System.out.println(system.obtenerGananciasOficinas());
		//System.out.println(generarCodigo());
	}
	
	public static Scanner leer = new Scanner(System.in);

}
