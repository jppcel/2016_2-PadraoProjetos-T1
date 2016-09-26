package br.univel.bancotads;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.bancotads.dao.DaoUsuario;

public class Login {
	private int id;
	private String login;
	private String senha;
	private Usuario u;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
		DaoUsuario udao = new DaoUsuario();
		u = udao.search(login);
	}
	public void setSenha(String senha) {
		if(!login.isEmpty()){
			if(u.getTu().getId() == 1){
				MessageDigest m;
				StringBuilder sb = new StringBuilder();
				sb.append(senha).append(u.getUsername());
				try {
					m = MessageDigest.getInstance("SHA-1");
					m.reset();
				    m.update(senha.getBytes("UTF-8"));
					this.senha = new BigInteger(1,m.digest()).toString(16);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			}else if(u.getTu().getId() == 2){
				MessageDigest m;
				try {
					m = MessageDigest.getInstance("MD5");
					m.reset();
				    m.update(senha.getBytes("UTF-8"),0,senha.length());
					this.senha = new BigInteger(1,m.digest()).toString(16);
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
	
	public boolean checkSenha(){
		return u.checkSenha(this.senha);
	}
	
}
