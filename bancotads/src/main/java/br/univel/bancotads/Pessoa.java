package br.univel.bancotads;

import java.util.Date;

import br.univel.bancotads.enums.EstadoCivil;
import br.univel.bancotads.enums.Genero;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private EstadoCivil estadoCivil;
	private Genero genero;
	// private String nacionalidade;
	//private String naturalidade;
	private Date dataNascimento;
	private String cpf; // Devido a diversos motivos, como por exemplo, números começados por 0 e etc.
	//private String email;
	//private String telefone;

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
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
}