package com.senac.estruturas;

import java.util.ArrayList;
import java.util.Comparator;

public class ArvoreBinaria implements Comparator<String> {
	private NodoArvore raiz;
	private int numComper = 0;
	ArrayList<String> pessoas = new ArrayList<String>();

	/**
	 * Cria uma arvore vazia -- nodo da raiz null.
	 */
	public ArvoreBinaria() {
		raiz = null;

	}

	/**
	 * Returns true if the given target is in the binary tree. Uses a recursive
	 * helper.
	 */
	public String lookup(String data) {
		numComper = 0;
		return (lookup(raiz, data));
	}

	/**
	 * Recursive lookup -- given a node, recur down searching for the given
	 * data.
	 */
	private String lookup(NodoArvore node, String data) {
		if (node == null) {

			return ("false");
		}
		numComper++;
		if (compare(data, node.getData().substring(0, data.length())) < 0) {
			System.out.println("dados esquerda = "
					+ node.getData().substring(0, data.length()) + " " + data);
			return (lookup(node.getEsquerda(), data));
		} else if (compare(data, node.getData().substring(0, data.length())) > 0) {
			System.out.println("dados direita = "
					+ node.getData().substring(0, data.length()) + " " + data);
			return (lookup(node.getDireita(), data));
		} else {
			System.out.println("dados  = " + node.getData());
			return (node.getData());
		}

	}

	public int getNumComper() {
		return numComper;
	}

	/**
	 * Inserts the given data into the binary tree. Uses a recursive helper
	 */
	public void insert(String data) {
		raiz = insert(raiz, data);
	}

	/**
	 * Recursive insert -- given a node pointer, recur down and insert the given
	 * data into the tree. Returns the new node pointer (the standard way to
	 * communicate a changed pointer back to the caller).
	 */
	public NodoArvore insert(NodoArvore node, String dados) {
		if (node == null) {
			node = new NodoArvore(dados);

		} else {
			if (compare(dados, node.getData()) <= 0) {

				node.setEsquerda(insert(node.getEsquerda(), dados));

			} else {

				node.setDireita(insert(node.getDireita(), dados));
			}
		}

		return (node); // in any case, return the new pointer to the caller
	}

	@Override
	public int compare(String dadosInsert, String dataFolha) {

		return dadosInsert.toLowerCase().compareTo(dataFolha.toLowerCase());
	}

	public void emOrdem() {
		emOrdem(raiz);
	}

	public void emOrdem(NodoArvore node) {
		if (node != null) {
			emOrdem(node.getEsquerda());
			System.out.println(node.getData() + " ");
			emOrdem(node.getDireita());
		}
	}

	public void emOrdemPreFixa() {
		emOrdemPreFixa(raiz);
	}

	/*
	 * Executa-se a ação a ser realizada Recursivamente percorre-se a subárvore
	 * esquerda Recursivamente percorre-se a subárvore direita
	 */

	public void emOrdemPreFixa(NodoArvore node) {
		if (node != null) {
			System.out.println(node.getData());
			emOrdemPreFixa(node.getEsquerda());
			emOrdemPreFixa(node.getDireita());
		}
	}

	public ArrayList<String> OrdemPreFixa() {
		OrdemPreFixa(raiz);

		return pessoas;
	}

	/*
	 * Executa-se a ação a ser realizada Recursivamente percorre-se a subárvore
	 * esquerda Recursivamente percorre-se a subárvore direita
	 */

	public void OrdemPreFixa(NodoArvore node) {
		if (node != null) {
			pessoas.add(node.getData());
			OrdemPreFixa(node.getEsquerda());
			OrdemPreFixa(node.getDireita());
		}

	}

	public void emOrdemPosFixa() {
		emOrdemPosFixa(raiz);
	}

	/*
	 * Recursivamente percorre-se a subárvore esquerda Recursivamente
	 * percorre-se a subárvore direita Executa-se a ação a ser realizada
	 */
	public void emOrdemPosFixa(NodoArvore node) {
		if (node != null) {
			emOrdemPosFixa(node.getEsquerda());
			emOrdemPosFixa(node.getDireita());
			System.out.println(node.getData());
		}
	}

	/**
	 * Remove from the tree..
	 * 
	 * @param dados
	 *            the item to remove.
	 * @throws ItemNotFoundException
	 *             if x is not found. remove a value from the tree, if it exists
	 * @param key
	 *            such that value.compareTo(key) == 0 for the node to remove
	 */
	public void remove(String dados) {
		raiz = remove(dados, raiz);
	}

	/*
	 * remove a value from the tree, if it exists
	 * 
	 * @param key such that value.compareTo(key) == 0 for the node to remove
	 * 
	 * @param node the root of the subtree from which to remove the value
	 * 
	 * @return the new tree with the value removed
	 */
	public NodoArvore remove(String value, NodoArvore node) {
		if (node == null) { // key not in tree
			System.out.println("contato = " + value + " nao encontrado");
		
		} else {
			if (compare(value, node.getData().substring(0, value.length())) == 0) { // remove
																					// this
																					// node
				System.out.println("contato = " + value + " removido");
				if (node.getEsquerda() == null) { // replace this node with
													// right
													// child
					return node.getDireita();
				} else if (node.getDireita() == null) { // replace with left
														// child
					return node.getEsquerda();
				} else {
					// replace the value in this node with the value in the
					// rightmost node of the left subtree
					node.setData(getRightmost(node.getEsquerda()));
					// now remove the rightmost node in the left subtree,
					// by calling "remove" recursively
					node.setEsquerda(remove(node.getData(), node.getEsquerda()));
					// return node; -- done below
				}
			} else { // remove from left or right subtree
				if (compare(value, node.getData().substring(0, value.length())) < 0) {
					// remove from left subtree
					node.setEsquerda(remove(value, node.getEsquerda()));
				} else { // remove from right subtree
					node.setDireita(remove(value, node.getDireita()));
				}
			}
		}
		return node;
	}

	public String getRightmost(NodoArvore node) {
		assert (node != null);
		NodoArvore right = node.getDireita();
		if (right == null) {
			return node.getData();
		} else {
			return getRightmost(right);
		}
	}

	public void consulta(NodoArvore raiz) {
		System.out.println(raiz.getData().substring(0,
				raiz.getData().indexOf('#')));
		raiz.getEsquerda();
		raiz.getDireita();

	}

}
