package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {
	
	public void leerCiudades(SystemI system) throws FileNotFoundException {
		Scanner s = new Scanner(new File("Ciudades.txt"));
		while(s.hasNextLine()) {
			String line = s.nextLine();
			String [] partes = line.split(",");
			String nombre = partes[0];
			system.ingresarCiudad(nombre);
		}
		s.close();
	}
	
	public void leerClientes(SystemI system)throws FileNotFoundException {
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
	
	public void leerEntregas(SystemI system)throws FileNotFoundException{
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
				int gromor = Integer.parseInt(partes[5]);
				system.ingresarAsociarDocumento(codigoEntrega, rutRemmitente, rutDestinatario, peso, gromor);
				break;
			case("V"):
				rutRemmitente = partes[2];
				rutDestinatario = partes[3];
				String material  = partes[4];
				peso = Integer.parseInt(partes[5]);
				break;
			case("E"):
				rutRemmitente = partes[2];
				rutDestinatario = partes[3];
				peso = Integer.parseInt(partes[4]);
			    int largo = Integer.parseInt(partes[5]);
			    int ancho = Integer.parseInt(partes[6]);
			    int profundidad = Integer.parseInt(partes[6]);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + tipo);
			}
		}
		s.close();
	}
	
	
	
	

	public static void main(String[] args) {
		SystemI system = new SystemImpl();

	}

}
