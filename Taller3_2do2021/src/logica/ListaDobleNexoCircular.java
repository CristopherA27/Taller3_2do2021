package logica;
import dominio.*;

public class ListaDobleNexoCircular {
	private NodoD first;
	private int size;

	public ListaDobleNexoCircular() {
		this.first = null;
		size =0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		if(first == null) {
			return true;
		}
		return false;
	}
	
	public void ingresar(Entrega entrega) {
		NodoD nodo = new NodoD(entrega);
		if(first == null) {
			nodo.setNext(nodo);
			nodo.setPrev(nodo);
			first = nodo;
		}else {
			nodo.setNext(first);
			nodo.setPrev(first.getPrev());
			first = nodo;
			first.getNext().setPrev(first);
			first.getPrev().setNext(nodo);
		}
		size++;
	}
	
	public Entrega buscar(String codigoEntrega ){
		NodoD current = first;
		do {
			if(current.getEntrega().getCodigoEntrega().equals(codigoEntrega)) {
				return current.getEntrega();
			}
			current = current.getNext();
		}while(current!=first);
		return null;
	}
	
	
	
	
	

}
