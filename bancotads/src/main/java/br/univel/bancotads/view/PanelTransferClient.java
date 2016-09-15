package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;

public class PanelTransferClient extends JPanel {
	private JTextField tf_ag;
	private JTextField tf_conta;
	private JTextField tf_titular;
	private JTextField tf_valor;

	/**
	 * Create the panel.
	 */
	public PanelTransferClient() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblContaDeDestinocrdito = new JLabel("Conta de destino/Crédito");
		lblContaDeDestinocrdito.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblContaDeDestinocrdito = new GridBagConstraints();
		gbc_lblContaDeDestinocrdito.gridwidth = 2;
		gbc_lblContaDeDestinocrdito.insets = new Insets(0, 0, 5, 5);
		gbc_lblContaDeDestinocrdito.gridx = 0;
		gbc_lblContaDeDestinocrdito.gridy = 0;
		add(lblContaDeDestinocrdito, gbc_lblContaDeDestinocrdito);
		
		JLabel lblAg = new JLabel("AG:");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 0;
		gbc_lblAg.gridy = 1;
		add(lblAg, gbc_lblAg);
		
		JLabel lblConta = new JLabel("Conta:");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConta.gridx = 1;
		gbc_lblConta.gridy = 1;
		add(lblConta, gbc_lblConta);
		
		tf_ag = new JTextField();
		GridBagConstraints gbc_tf_ag = new GridBagConstraints();
		gbc_tf_ag.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ag.gridx = 0;
		gbc_tf_ag.gridy = 2;
		add(tf_ag, gbc_tf_ag);
		tf_ag.setColumns(10);
		
		tf_conta = new JTextField();
		tf_conta.setText("");
		GridBagConstraints gbc_tf_conta = new GridBagConstraints();
		gbc_tf_conta.insets = new Insets(0, 0, 5, 5);
		gbc_tf_conta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_conta.gridx = 1;
		gbc_tf_conta.gridy = 2;
		add(tf_conta, gbc_tf_conta);
		tf_conta.setColumns(10);
		
		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 0;
		gbc_lblTipoConta.gridy = 3;
		add(lblTipoConta, gbc_lblTipoConta);
		
		JComboBox cb_tipoconta = new JComboBox();
		GridBagConstraints gbc_cb_tipoconta = new GridBagConstraints();
		gbc_cb_tipoconta.gridwidth = 2;
		gbc_cb_tipoconta.insets = new Insets(0, 0, 5, 5);
		gbc_cb_tipoconta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_tipoconta.gridx = 0;
		gbc_cb_tipoconta.gridy = 4;
		add(cb_tipoconta, gbc_cb_tipoconta);
		
		JLabel lblTitular = new JLabel("Titular");
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 0;
		gbc_lblTitular.gridy = 5;
		add(lblTitular, gbc_lblTitular);
		
		tf_titular = new JTextField();
		GridBagConstraints gbc_tf_titular = new GridBagConstraints();
		gbc_tf_titular.gridwidth = 2;
		gbc_tf_titular.insets = new Insets(0, 0, 5, 5);
		gbc_tf_titular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_titular.gridx = 0;
		gbc_tf_titular.gridy = 6;
		add(tf_titular, gbc_tf_titular);
		tf_titular.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 0;
		gbc_lblValor.gridy = 7;
		add(lblValor, gbc_lblValor);
		
		tf_valor = new JTextField();
		tf_valor.setText("");
		GridBagConstraints gbc_tf_valor = new GridBagConstraints();
		gbc_tf_valor.gridwidth = 2;
		gbc_tf_valor.insets = new Insets(0, 0, 0, 5);
		gbc_tf_valor.fill = GridBagConstraints.BOTH;
		gbc_tf_valor.gridx = 0;
		gbc_tf_valor.gridy = 8;
		add(tf_valor, gbc_tf_valor);
		tf_valor.setColumns(10);
		
		JButton btn_confirme = new JButton("Confirme");
		GridBagConstraints gbc_btn_confirme = new GridBagConstraints();
		gbc_btn_confirme.ipady = 20;
		gbc_btn_confirme.gridx = 2;
		gbc_btn_confirme.gridy = 8;
		add(btn_confirme, gbc_btn_confirme);

	}
}
