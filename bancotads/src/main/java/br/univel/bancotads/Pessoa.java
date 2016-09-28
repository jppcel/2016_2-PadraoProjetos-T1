package br.univel.bancotads;

import java.util.Date;

import br.univel.bancotads.enums.Genero;

public class Pessoa {
	private int id;
	private String nome = null;
	private Genero genero = null;
	private Date dataNascimento = null;
	private String cpf = null; 

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public void clear(){
		id = 0;
		nome = null;
		genero = null;
		dataNascimento = null;
		cpf = null; 
	}
}