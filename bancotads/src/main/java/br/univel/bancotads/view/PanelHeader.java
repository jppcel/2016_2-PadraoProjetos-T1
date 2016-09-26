package br.univel.bancotads.view;

import javax.swing.JPanel;

import br.univel.bancotads.enums.TipoConta;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Date;

public class PanelHeader extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3379998260219697988L;
	JLabel lb_BancoTads, lbl_data, lb_ag, lb_conta, lb_slogan, lb_saldo;

	/**
	 * Create the panel.
	 */
	public PanelHeader() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		final ImageIcon icone = new ImageIcon(getClass().getResource("../icons/iconeBanco.png"), "Banco TADS");
		JLabel lb_icone = new JLabel(icone);
		GridBagConstraints gbc_lb_icone = new GridBagConstraints();
		gbc_lb_icone.gridheight = 4;
		gbc_lb_icone.insets = new Insets(5, 10, 5, 5);
		gbc_lb_icone.gridx = 0;
		gbc_lb_icone.gridy = 0;
		add(lb_icone, gbc_lb_icone);
		
		lb_BancoTads = new JLabel("Banco TADS");
		lb_BancoTads.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lb_BancoTads = new GridBagConstraints();
		gbc_lb_BancoTads.gridheight = 3;
		gbc_lb_BancoTads.insets = new Insets(0, 0, 5, 5);
		gbc_lb_BancoTads.gridx = 1;
		gbc_lb_BancoTads.gridy = 0;
		add(lb_BancoTads, gbc_lb_BancoTads);
		
		
		lbl_data = new JLabel(new Date().toLocaleString());
		GridBagConstraints gbc_lbl_data = new GridBagConstraints();
		gbc_lbl_data.ipadx = 10;
		gbc_lbl_data.anchor = GridBagConstraints.EAST;
		gbc_lbl_data.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_data.gridx = 4;
		gbc_lbl_data.gridy = 0;
		add(lbl_data, gbc_lbl_data);
		
		lb_ag = new JLabel("AG: [AGENCIA]");
		GridBagConstraints gbc_lb_ag = new GridBagConstraints();
		gbc_lb_ag.ipadx = 10;
		gbc_lb_ag.insets = new Insets(0, 0, 5, 0);
		gbc_lb_ag.anchor = GridBagConstraints.EAST;
		gbc_lb_ag.gridx = 4;
		gbc_lb_ag.gridy = 1;
		add(lb_ag, gbc_lb_ag);
		
		lb_conta = new JLabel("[TIPOCONTA]: [CONTA]");
		GridBagConstraints gbc_lb_conta = new GridBagConstraints();
		gbc_lb_conta.ipadx = 10;
		gbc_lb_conta.insets = new Insets(0, 0, 5, 0);
		gbc_lb_conta.anchor = GridBagConstraints.EAST;
		gbc_lb_conta.gridx = 4;
		gbc_lb_conta.gridy = 2;
		add(lb_conta, gbc_lb_conta);
		
		lb_slogan = new JLabel("Aqui sua nota não é zero!");
		GridBagConstraints gbc_lb_slogan = new GridBagConstraints();
		gbc_lb_slogan.insets = new Insets(0, 0, 0, 5);
		gbc_lb_slogan.gridx = 1;
		gbc_lb_slogan.gridy = 3;
		add(lb_slogan, gbc_lb_slogan);
		
		lb_saldo = new JLabel("Saldo: R$ [SALDO]");
		GridBagConstraints gbc_lb_saldo = new GridBagConstraints();
		gbc_lb_saldo.ipadx = 10;
		gbc_lb_saldo.anchor = GridBagConstraints.EAST;
		gbc_lb_saldo.gridx = 4;
		gbc_lb_saldo.gridy = 3;
		add(lb_saldo, gbc_lb_saldo);

	}
	
	public void setAg(int ag){
		lb_ag.setText("AG: " +ag);
	}
	
	public void setConta(TipoConta tp, int conta){
		lb_conta.setText(tp.getNome()+": "+conta);
	}
	
	public void setSaldo(float saldo){
		lb_saldo.setText("Saldo: R$ "+saldo);
	}
	
	protected void setVisibleFields(boolean opcao){
		lb_ag.setVisible(opcao);
		lb_conta.setVisible(opcao);
		lb_saldo.setVisible(opcao);
		lbl_data.setVisible(opcao);
	}

}
