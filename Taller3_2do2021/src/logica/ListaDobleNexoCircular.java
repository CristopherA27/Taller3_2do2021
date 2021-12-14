package logica;
import dominio.*;

public class ListaDobleNexoCircular {
	private NodoD first;
	private int size;

	public ListaDobleNexoCircular(NodoD first) {
		this.first = null;
		size =0;
	}
	
	public int size() {
		return size;
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
	
	public void buscar(Entrega entrega){
		NodoD current = first;
		do {
			
		}while(current!=first);
	}
	
	
	

}
