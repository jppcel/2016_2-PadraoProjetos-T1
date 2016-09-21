package br.univel.bancotads.enums;

public enum TipoConta {
	CORRENTE(1, "Conta Corrente"),
	POUPANCA(2, "Conta Poupança"),
	ELETRONICA(3, "Conta Eletrônica");
	
	int id;
	String nome;
	
	private TipoConta(int id, String nome){
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
