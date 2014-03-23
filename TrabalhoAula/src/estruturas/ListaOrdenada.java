package estruturas;

public class ListaOrdenada extends ListaEncadeada {
	private Nodo procuraNodo(String data) {
		Nodo nodo = head;
		Nodo anterior = null;
		while (nodo != null) {
			int cmp = nodo.getData().compareTo(data);
			if (cmp == 0)
				return nodo;
			if (cmp > 0)
				return anterior;
			anterior = nodo;
			nodo = nodo.getNext();
		}
		return nodo;
	}

	@Override
	public void insert(Nodo novo) {
		Nodo anterior = procuraNodo(novo.getData());
		if (anterior != null) {
			novo.setNext(anterior.getNext());
			anterior.setNext(novo);
//			if (anterior == tail)
//				tail = novo;
//		} else {
//			if (tail != null) {
//				tail.setNext(novo);
	//		} else {
	//			head = novo;
		//	}
//			tail = novo;
		}
	}

	@Override
	public void insert(Nodo novo, Nodo anterior) {
		insert(novo);
	}

	@Override
	public void append(String novo) {
	//	insert(novo);
	}

/*	public static void main(String[] args) {
		// criar lista
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();
		Nodo<Integer> novo = new Nodo<Integer>(1);
		lista.insert(novo);
		lista.insert(new Nodo<Integer>(2), novo);
		lista.append(new Nodo<Integer>(3));
		lista.insert(new Nodo<Integer>(4), novo);
		lista.print();
	}*/
}
