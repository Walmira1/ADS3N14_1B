package com.senac.apps.ListaTelefonica.controller;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.senac.apps.ListaTelefonica.model.Pessoa;
import com.senac.apps.ListaTelefonica.view.ConsoleView;
import com.senac.estruturas.ArvoreBinaria;


public class ListaController {

	private ArvoreBinaria contatos;

	ArrayList<String> pessoas = new ArrayList<String>();

	private ConsoleView view;

	public ListaController(ConsoleView view) {
		this.view = view;
		this.contatos = new ArvoreBinaria();

	}

	public void loadFile(String filename) {
		try {
			Scanner arq = new Scanner(new FileReader(filename));
			while (arq.hasNext()) {
				String name = arq.nextLine();
				String phone = arq.nextLine();
				Pessoa pessoa = new Pessoa(name);
				pessoa.setTelefone(phone);

				contatos.insert(name + "#" + phone);

			}
			arq.close();
		} catch (FileNotFoundException e) {
			view.logError(e.getMessage());
		}
	}

	public void insertContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(view.read("Nome"));
		contato.setTelefone(view.read("Telefone"));
		contatos.insert(contato.getNome() + "#" + contato.getTelefone());
		//pessoas.add(contato.getNome() + "#" + contato.getTelefone());

	}

	public void removeContato() {
		Pessoa contato = new Pessoa();
		contato.setNome(view.read("Nome"));
		contatos.remove(contato.getNome());

	}

	private String procuraContato(String chave) {
		return contatos.lookup(chave);
	}

	public void infixa() {
		
		contatos.emOrdem();
		
	}

	public void posfixa() {
		
		contatos.emOrdemPosFixa();
		
	}

	public void prefixa() {
		
		contatos.emOrdemPreFixa();
		
	}

	public void searchContato() {
		String chave = view.read("Inicio do Nome");
		String contato = procuraContato(chave);
		System.out.println("contato " + contato);
		if (contato != "false") {
			view.printContato(contato.substring(0, contato.indexOf('#')),
					contato.substring(contato.indexOf('#') + 1),contatos.getNumComper());
			
		} else
			System.out.println("Contato " + chave + " not found");
	}

	/*
	 * public void saveFile(String filename) { // TODO Auto-generated method
	 * stub contatos.saveFile();
	 * 
	 * }
	 */

	public void saveFile(String filename) {
		pessoas = contatos.OrdemPreFixa();
		FileWriter arq = null;
		try {
			arq = new FileWriter(filename, false);
					
			for (int i = 0; i < pessoas.size(); i++) {
				arq.append(pessoas.get(i).substring(0,
						pessoas.get(i).indexOf('#'))
						+ "\n");
				arq.append(pessoas.get(i).substring(
						pessoas.get(i).indexOf('#') + 1)
						+ "\n");
				
			}
		} catch (IOException e) {
			view.message(e.getMessage());
		} finally {
			if (arq != null)
				try {
					arq.close();
				} catch (IOException e) {
					view.message(e.getMessage());
				}
		}
	}

}
