package br.univel.bancotads.enums;

public enum TipoConta {
	CORRENTE(1, "Conta Corrente", "CC"),
	POUPANCA(2, "Conta Poupança", "CP"),
	ELETRONICA(3, "Conta Eletrônica", "CE");
	
	private int id;
	private String nome;
	private String abb;
	
	private TipoConta(int id, String nome, String abb){
		this.id = id;
		this.nome = nome;
		this.abb = abb;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNome(){
		return this.nome;
	}
	
	public String getAbb(){
		return this.abb;
	}
}
