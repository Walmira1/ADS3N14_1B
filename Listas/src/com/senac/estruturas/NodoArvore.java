package com.senac.estruturas;

public class NodoArvore {
	private String data;
	private NodoArvore esquerda; 
	private NodoArvore direita; 
	
	public NodoArvore(String newData){
		esquerda = null; 
	    direita = null; 
	    this.data = newData; 
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodoArvore getEsquerda() {
		return esquerda;
	}

	public void setEsquerda(NodoArvore esquerda) {
		this.esquerda = esquerda;
	}

	public NodoArvore getDireita() {
		return direita;
	}

	public void setDireita(NodoArvore direita) {
		this.direita = direita;
	}
	
	

	

}
