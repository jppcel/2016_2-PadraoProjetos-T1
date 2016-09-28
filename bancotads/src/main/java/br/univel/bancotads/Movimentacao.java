package br.univel.bancotads;

import java.math.BigDecimal;
import java.util.Date;

import javax.swing.JOptionPane;

import br.univel.bancotads.enums.TipoOperacao;
import br.univel.bancotads.view.DefaultView;
import br.univel.bancotads.view.PanelHeader;
import br.univel.bancotads.view.PanelSuccess;
import br.univel.bancotads.dao.DaoAgencia;
import br.univel.bancotads.dao.DaoConta;
import br.univel.bancotads.dao.DaoMovimentacao;

public class Movimentacao {
	final DefaultView dv;
	final PanelHeader panel_header;
	int id;
	private BigDecimal valor;
	private TipoOperacao to;
	private Date data;
	private Conta c;
	private Usuario u;
	private String motivoMovimentacao;	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoOperacao getTo() {
		return to;
	}

	public void setTo(TipoOperacao to) {
		this.to = to;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public String getMotivoMovimentacao() {
		return motivoMovimentacao;
	}

	public void setMotivoMovimentacao(String motivoMovimentacao) {
		this.motivoMovimentacao = motivoMovimentacao;
	}

	public Movimentacao(final DefaultView dv){
		this.dv = dv;
		this.panel_header = dv.getPanel_header();
	}
	
	public void executaMovimentacao(){
		if(to.getId() == 1){
			Login l = dv.getL();
			Usuario u = l.getU();
			Conta c = u.getConta();
			c.setSaldo(c.getSaldo().subtract(valor));
			
			DaoConta daoc = new DaoConta();
			daoc.updateSaldo(c.getSaldo(), c.getId());
			panel_header.setSaldo(c.getSaldo());
			
			Agencia a = c.getAgencia();
			a.setSaldo(a.getSaldo().subtract(valor));
			
			DaoAgencia daoa = new DaoAgencia();
			daoa.update(a.getSaldo(), a.getId());
			
			DaoMovimentacao daom = new DaoMovimentacao();
			
			daom.insert(this);
			
			final PanelSuccess ps = dv.getPanel_success();
			ps.setValor(valor);
			ps.setOperacao(to.getNome());
			
			dv.showPanel("success");
		}
	}
	
	public void efetuaSaque(){
		if(dv.getL().isOperacaoOk()){
			Usuario u = dv.getL().getU();
			Conta c = u.getConta();
			if(c.getSaldo().doubleValue() >= valor.doubleValue()){
				Agencia a = c.getAgencia();
				if(a.getSaldo().doubleValue() >= valor.doubleValue()){
					to = TipoOperacao.SAQUE;
					this.setC(c);
					this.u = u;
					this.data = new Date();
					executaMovimentacao();
				}else{
					JOptionPane.showConfirmDialog(dv, "Operação não efetuada! Devido a regras internas, não há possibilidade de efetuar saque desse valor neste momento.", "AVISO!", JOptionPane.WARNING_MESSAGE);
				}
			}else{
				JOptionPane.showConfirmDialog(dv, "Operação não efetuada! Não há saldo suficiente para saque.", "AVISO!", JOptionPane.WARNING_MESSAGE);
			}
		}else{
			JOptionPane.showConfirmDialog(dv, "Operação não efetuada.", "AVISO!", JOptionPane.WARNING_MESSAGE);
		}
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getC() {
		return c;
	}

	public void setC(Conta c) {
		this.c = c;
	}
}
