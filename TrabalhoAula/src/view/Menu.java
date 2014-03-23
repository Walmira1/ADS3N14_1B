package view;

import static java.lang.System.out;

import java.util.Scanner;

public class Menu {
	public String seleciona() {
		out.println("Selecione opção ...\n" +  
		"1 - para novo contato \n" +
		"2 - para um contato especifico \n" +		
		"3 - Para listar todos os contatos \n" +
		"4 - Para Finalizar");
		out.println();
		String line = teclado.nextLine();
		return line;

	}

	public String DigitaNome() {
		out.println("Digite o nome da Pessoa ");
		out.println();
		String line = teclado.nextLine();
		return line;

	}
	public String DigitaTelefone() {
		out.println("Digite o telefone da Pessoa ");
		out.println();
		String line = teclado.nextLine();
		return line;

	}


	public static Scanner teclado = new Scanner(System.in);

}
