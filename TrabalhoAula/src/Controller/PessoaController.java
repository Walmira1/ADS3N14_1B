package Controller;

import java.io.IOException;

import Model.Pessoa;
import estruturas.Arquivo;
import view.ContatoView;

public class PessoaController {
	private Pessoa contato;

	public void criarContato(String nome, String telefone) throws IOException {
		contato = new Pessoa();
		contato.setNome(nome);
		contato.setTelefone(telefone);
	}

	public void writecontact(Arquivo estrutura) throws IOException {

		estrutura.writefile(contato.getNome(), contato.getTelefone());
	}

	public void exibirContato(ContatoView view) {
		view.printContato(contato.getNome(), contato.getTelefone());

	}
}
