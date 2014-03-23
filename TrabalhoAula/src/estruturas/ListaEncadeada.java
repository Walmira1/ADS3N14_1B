package estruturas;

import static java.lang.System.out;

public class ListaEncadeada {
	protected Nodo head;
	protected Nodo next;

	public ListaEncadeada() {
		head = null;
		next = null;
	}

	public void insert(Nodo novo) {
		novo.setNext(head);
		head = novo;
		if (next == null)
			next = novo;
	}

	public void insert(Nodo novo, Nodo anterior) {
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		if (anterior == next)
			next = novo;
	}

	public void append(String novo) {
		Nodo caixa = new Nodo(head, null, novo);
		if (next != null)
			next.setNext(caixa);
		else
			head = caixa;
		next = caixa;
	}

	public void print() {
	  	 Nodo elem = head;
		
		while(elem != null){
			out.println(elem.getData());
		 String [] t = elem.getData().split(";");
		 System.out.println("nome = " + t[1] );
		 System.out.println("telefone = " + t[2] );
			elem = elem.getNext();
		} 
	}
	public String lerLista() {
		Nodo elem = head;
		String contato = " ";
		if (head == null){
			elem = elem.gethead();
		}
		contato = elem.getData();
		elem = elem.getNext();
		return contato; 
								
	}

	public String busca(String busca) {
		
			Nodo elem = head;
		//	Nodo elem = null;
			String dado = null;
			
			dado = elem.getData();
			elem = elem.getNext();
			System.out.println(dado.startsWith(busca)+ "dado = " + dado);
			System.out.println();
			do {
				dado = elem.getData();
				System.out.println("elem.getNext() " + elem.getNext());
				elem = elem.getNext();
			} while (elem != null && (dado.startsWith(busca)!= true));
			if (dado.startsWith(busca)){
				System.out.println(" encontrou = "+ dado + " " + busca);
				return dado;
			}
			return null;
	}

		
}
