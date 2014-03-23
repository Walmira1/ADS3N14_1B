package Controller;

import java.io.IOException;

import Model.Pessoa;
import estruturas.ListaEncadeada;
import estruturas.Arquivo;
import estruturas.ListaOrdenada;
import estruturas.Nodo;

public class CriarListadoArquivo {
	private String line = "";
	estruturas.ListaEncadeada lista = new ListaEncadeada();

	public void criarContatoLista() throws IOException {

		estruturas.Arquivo arquivo = new Arquivo();
		
		arquivo.openfileread();
		String contato = "";
		while (line != null) {
			line = arquivo.readfile() ;
			contato = line + ";" + arquivo.readfile();
			
			if (line != null) {
				lista.append(contato);
			}
			
		}
		

	}

	public void lerContatoLista()  {

		lista.print();

	}
	public void criarListaOrdenada(){
		System.out.println(lista.lerLista());
	}

}
