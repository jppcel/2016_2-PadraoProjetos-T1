package br.univel.bancotads;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.univel.bancotads.dao.DaoUsuario;
import br.univel.bancotads.enums.TipoConta;
import br.univel.bancotads.view.DefaultView;
import br.univel.bancotads.view.PanelHeader;
import br.univel.bancotads.view.PanelHomeClient;

public class Login {
	private String login;
	private String senha;
	private Usuario u;
	
	private boolean operacaoOk = false;
	
	private final DefaultView dv;
	
	public Login(final DefaultView dv){
		this.dv = dv;
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
				sb.append(u.getUsername()).append(senha);
				try {
					m = MessageDigest.getInstance("SHA-1");
					m.reset();
				    m.update(sb.toString().getBytes("UTF-8"));
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
	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}
	
	public boolean hasLogin(){
		if(u.getIdUsuario() == 0){
			return false;
		}
		return true;
	}
	
	public boolean checkSenha(){
		Boolean cs = u.checkSenha(this.senha);
		if(!cs){
			login = null;
			senha = null;
			return false;
		}
		return true;
	}
	
	public void setInitialPanel(){
		final PanelHeader ph = dv.getPanelHeader();
		if(u.getTu().getId() == 1){
			Conta c = u.getConta();
			Agencia a = c.getAgencia();
			final PanelHomeClient pc = dv.getPanel_homeClient();
			ph.setAg(a.getNumeroAgencia());
			ph.setConta(c.getTipoConta(), c.getNumeroConta());
			ph.setSaldo(c.getSaldo());
			ph.setVisibleFields(true);
			dv.showPanel("homeClient");
			TipoConta tc = u.getConta().getTipoConta();
			switch(tc.getId()){
				case 1:
					int[] b1 = {1,2,3,4,5,6};
					pc.setButtons(b1);
					break;
				case 2:
					int[] b2 = {1,2,3,4,6};
					pc.setButtons(b2);
					break;
				case 3:
					int[] b3 = {2,4,5,6};
					pc.setButtons(b3);
			}
		}else{
			ph.setVisibleDate();
			dv.showPanel("homeBancario");
		}
	}
	
	public boolean checkSenhaOperacoes(String senha){
		if(u.getTu().getId() == 1){
			MessageDigest m;
			StringBuilder sb = new StringBuilder();
			sb.append(u.getUsername()).append(senha);
			try {
				m = MessageDigest.getInstance("SHA-1");
				m.reset();
			    m.update(sb.toString().getBytes("UTF-8"));
				senha = new BigInteger(1,m.digest()).toString(16);
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
				senha = new BigInteger(1,m.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else{
			throw new RuntimeException("O Tipo de Usuário deve ser setado.");
		}
		if(u.checkSenhaOperacoes(senha)){
			operacaoOk = true;
			return true;
		}else{
			operacaoOk = false;
		}
		return false;
	}
	
	public boolean senhaOperacoesConfirmada(){
		if(operacaoOk){
			operacaoOk = false;
			return true;
		}
		return false;
	}
	
	public void logout(){
		login = null;
		senha = null;
		u = null;
	}
	
}
