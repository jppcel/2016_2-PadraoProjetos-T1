package br.univel.bancotads.enums;

public enum Genero {
	MASCULINO(1,"Masculino"),
	FEMININO(2,"Feminino"),
	NAO_DEFINIDO(3,"Não Definido");
	
	int id;
	String genero;
	
	private Genero(int id, String genero){
		this.id = id;
		this.genero = genero;
	}
	
	public String getGenero(){
		return this.genero;
	}
	
	public int getId(){
		return this.id;
	}
}