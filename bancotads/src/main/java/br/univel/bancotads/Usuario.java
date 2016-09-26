package br.univel.bancotads;

import br.univel.bancotads.enums.TipoUsuario;

public class Usuario {
	private int idUsuario;
	private Pessoa pessoa;
	private String username;
	private String password;
	private TipoUsuario tu;
	private Conta conta;
	private Boolean ativo;
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPassword(String password, boolean t){
		
	}
	public TipoUsuario getTu() {
		return tu;
	}
	public void setTu(TipoUsuario tu) {
		this.tu = tu;
	}
	public Conta getConta() {
		return conta;
	}
	public void setConta(Conta conta) {
		this.conta = conta;
	}
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
	
	public boolean checkSenha(String senha){
		if(password.equals(senha)){
			return true;
		}else{
			return false;
		}
	}
	
	public void clear(){
		idUsuario = 0;
		pessoa = null;
		username = null;
		password = null;
		tu = null;
		conta = null;
		ativo = null;
	}
}
