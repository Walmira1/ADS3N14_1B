package appdados;

import java.io.IOException;

import Controller.PessoaController;
import Controller.CriarListadoArquivo;
import view.*;
import estruturas.Arquivo;
import estruturas.ListaEncadeada;

public class AgendaTelefonica {
	public static void main(String[] args) throws IOException {
		// * leitura do arquivo e inclusão na lista encadeada em ordem
		// alfabética
		CriarListadoArquivo lista = new CriarListadoArquivo();
		lista.criarContatoLista();
		// * a partir da opções do menu escreve no arquivo ou mostra os dados
		PessoaController controller = new PessoaController();
		view.Menu menu = new view.Menu();
		String option = "";
		option = menu.seleciona();
		do {
			try {
		
				String nome = "";

				switch (option.charAt(0)) {
				case '1':
					nome = menu.DigitaNome();
					String telefone = menu.DigitaTelefone();
					controller.criarContato(nome, telefone);
					controller.writecontact(new Arquivo());
					controller.exibirContato(new ExtendedView());
					controller.exibirContato(new CompactView());
					break;
				case '2':
					lista.criarListaOrdenada();
					lista.criarListaOrdenada();
			//		nome = menu.DigitaNome();
		//			lista.lerContatoLista();
			//		System.out.println("vou bucar nome na lista");
			//		String busca = nome.substring(0, 1);
			//		System.out.println("nome = " + busca);
			//		nome = listae.busca(busca);
					option = "4";
					break;
				case '3':
			    	lista.lerContatoLista();
			    	System.out.println();
			    	option  = "4";
			    	break;
			    case '4':
					System.out.println("Fim da Agenda");
					break;
				default:
					option = menu.seleciona();
					System.out.println("erro de opção");
					break;
				}// fim do switch
				
			} catch (Exception e) {
				option = menu.seleciona();
				System.out.println("opção invalida tente novamente");
			}	
				

		}while ((option.charAt(0)) != '4');
	
	} 
}
	