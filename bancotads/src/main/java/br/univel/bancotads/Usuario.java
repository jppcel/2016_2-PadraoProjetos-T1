package br.univel.bancotads;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.bancotads.enums.TipoUsuario;

public class Usuario {
	private int idUsuario;
	private Pessoa pessoa;
	private String username;
	private String password;
	private String passwordOperacoes;
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
		if(!username.isEmpty()){
			if(tu.getId() == 1){
				MessageDigest m;
				StringBuilder sb = new StringBuilder();
				sb.append(username).append(password);
				try {
					m = MessageDigest.getInstance("SHA-1");
					m.reset();
				    m.update(sb.toString().getBytes("UTF-8"));
				    this.password = new BigInteger(1,m.digest()).toString(16);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else if(tu.getId() == 2){
				MessageDigest m;
				try {
					m = MessageDigest.getInstance("MD5");
					m.reset();
				    m.update(password.getBytes("UTF-8"),0,password.length());
					this.password = new BigInteger(1,m.digest()).toString(16);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else{
				throw new RuntimeException("O Tipo de Usuário deve ser setado.");
			}
		}else{
			throw new RuntimeException("O usuário precisa não pode ser nulo!");
		}
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
	public String getPasswordOperacoes() {
		return passwordOperacoes;
	}
	public void setPasswordOperacoes(String passwordOperacoes) {
		this.passwordOperacoes = passwordOperacoes;
	}
	
	public boolean checkSenha(String senha){
		if(password.equals(senha)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean checkSenhaOperacoes(String senha){
		if(passwordOperacoes.equals(senha)){
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
