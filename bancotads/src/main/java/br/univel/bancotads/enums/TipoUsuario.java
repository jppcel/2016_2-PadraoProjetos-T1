package br.univel.bancotads.enums;

public enum TipoUsuario {
	CLIENTE(1, "Cliente"),
	BANCARIO(2, "Bancário");
	
	private int id;
	private String nomeTipo;
	
	private TipoUsuario(int id, String nomeTipo){
		this.id = id;
		this.nomeTipo = nomeTipo;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getNomeTipo(){
		return this.nomeTipo;
	}
}
