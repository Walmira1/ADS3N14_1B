package estruturas;

public class Nodo {
	private String dado;
	private Nodo head;
	private Nodo next;

	public Nodo(Nodo head,Nodo next,String i) {
		dado = i;
		this.next = next;
		this.head = head;
	}

	public void setData(String i) {
		dado = i;
		next = null;
	}

	public String getData() {
		return dado;
	}

	public void setNext(Nodo next) {
		this.next = next;
	}

	public Nodo getNext() {
		return next;
	}
	public void sethead(Nodo head) {
		this.head = head;
	}

	public Nodo gethead() {
		return head;
	}
}


