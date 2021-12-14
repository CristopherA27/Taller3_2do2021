package dominio;

public class NodoD {
	private Entrega entrega;
	private NodoD next;
	private NodoD prev;
	
	public NodoD(Entrega entrega) {
		this.entrega = entrega;
		next=null;
		prev=null;
	}

	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}

	public NodoD getNext() {
		return next;
	}
	public void setNext(NodoD next) {
		this.next = next;
	}
	public NodoD getPrev() {
		return prev;
	}
	public void setPrev(NodoD prev) {
		this.prev = prev;
	}
}

