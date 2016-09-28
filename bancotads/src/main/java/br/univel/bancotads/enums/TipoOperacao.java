package br.univel.bancotads.enums;

public enum TipoOperacao {
	SAQUE(1, "Saque");
	
	int id;
	String nome;
	private TipoOperacao(int id, String nome){
		this.id = id;
		this.nome = nome;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
}
