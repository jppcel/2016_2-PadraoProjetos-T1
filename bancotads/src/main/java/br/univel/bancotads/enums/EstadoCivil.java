package br.univel.bancotads.enums;

public enum EstadoCivil {
	CASADO(1,"Casado"),
	SOLTEIRO(2, "Solteiro"),
	VIUVO(3, "Viúvo"),
	SEPARADO(4, "Separado"),
	DIVORCIADO(5, "Divorciado");
	
	int id;
	String estadoCivil;
	
	private EstadoCivil(int id, String estadoCivil){
		this.id = id;
		this.estadoCivil = estadoCivil;
	}
	
	public String getEstadoCivil(){
		return this.estadoCivil;
	}
	
	public int getId(){
		return this.id;
	}
}
