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
	/*
	public static boolean inicioSesion(SystemI system) {
		System.out.println("BIENVENIDO A STARKON");
		System.out.println();
		System.out.print("Ingrese su rut: ");
		String rut = leer.nextLine();
		if(rut.equalsIgnoreCase("Admin")) {
			System.out.print("Ingrese la contraseña: ");
			String contraseña = leer.nextLine();
			if(contraseña.equalsIgnoreCase("choripan123")) {
				menuAdmin(system);
				return true;
			}else {
				System.out.println("Contraseña incorrecta....");
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
					if(ingresado) {
						System.out.println("Region: "); String region = leer.nextLine();
						boolean ingresoRegion = system.asignarRegion(nombreCuenta, region);
						if(ingresoRegion) {
							System.out.println("Cuenta ingresada con exito");
						}else {
							System.out.println("No se pudo ingresar la cuenta");
						}
					}else {
						System.out.println("Error al ingresar la cuenta, No queda espacio suficiente");
		
					}
					return false;
				}else {
					System.out.println("Usted no ingreso la cuenta");
					return false;
				}	
			}
			
		}

	}*/
	

	public static void main(String[] args) throws FileNotFoundException {
		SystemI system = new SystemImpl();
		leerCiudades(system);
		leerClientes(system);
		leerEntregas(system);
		/*System.out.println("Ingrese el tipo de entrega: ");
		String resp = l.nextLine();
		if(resp.equals("D")) {
			int peso = l.nextInt();
			int grosor = l.nextInt();
			boolean serealizara = system.verificarParametro(resp, peso, null, grosor, 0, 0, 0);
			if(serealizara) {
				
			}
			
		}*/
		System.out.println(system.obtenerGananciasOficinas());
	}
	
	public static Scanner leer = new Scanner(System.in);

}
