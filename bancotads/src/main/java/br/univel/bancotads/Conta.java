package br.univel.bancotads;

import java.math.BigDecimal;
import java.sql.Date;

import br.univel.bancotads.enums.TipoConta;

public class Conta {

	private int id;
	private Agencia agencia = new Agencia();
	private String numeroConta;
	private Usuario usuario;
	private TipoConta tipoConta = TipoConta.CORRENTE;
	private BigDecimal saldo;
	private Date dataCriacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	public void clear(){
		id = 0;
		agencia = null;
		numeroConta = null;
		usuario = null;
		tipoConta = null;
		saldo = null;
		dataCriacao = null;
	}
}
