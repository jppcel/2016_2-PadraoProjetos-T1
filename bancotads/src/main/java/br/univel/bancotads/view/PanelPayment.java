package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;

public class PanelPayment extends JPanel {
	private JTextField tf_valor;
	private JTextField tf_barras;

	/**
	 * Create the panel.
	 */
	public PanelPayment(final DefaultView df) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCdigoDeBarras = new JLabel("Código de Barras");
		GridBagConstraints gbc_lblCdigoDeBarras = new GridBagConstraints();
		gbc_lblCdigoDeBarras.anchor = GridBagConstraints.WEST;
		gbc_lblCdigoDeBarras.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigoDeBarras.gridx = 0;
		gbc_lblCdigoDeBarras.gridy = 0;
		add(lblCdigoDeBarras, gbc_lblCdigoDeBarras);
		
		tf_barras = new JTextField();
		GridBagConstraints gbc_tf_barras = new GridBagConstraints();
		gbc_tf_barras.insets = new Insets(0, 0, 5, 5);
		gbc_tf_barras.fill = GridBagConstraints.BOTH;
		gbc_tf_barras.gridx = 0;
		gbc_tf_barras.gridy = 1;
		add(tf_barras, gbc_tf_barras);
		tf_barras.setColumns(10);
		
		JLabel lblValorASer = new JLabel("Valor a ser pago");
		GridBagConstraints gbc_lblValorASer = new GridBagConstraints();
		gbc_lblValorASer.anchor = GridBagConstraints.WEST;
		gbc_lblValorASer.insets = new Insets(0, 0, 5, 5);
		gbc_lblValorASer.gridx = 0;
		gbc_lblValorASer.gridy = 2;
		add(lblValorASer, gbc_lblValorASer);
		
		tf_valor = new JTextField();
		GridBagConstraints gbc_tf_valor = new GridBagConstraints();
		gbc_tf_valor.fill = GridBagConstraints.BOTH;
		gbc_tf_valor.insets = new Insets(0, 0, 0, 5);
		gbc_tf_valor.gridx = 0;
		gbc_tf_valor.gridy = 3;
		add(tf_valor, gbc_tf_valor);
		tf_valor.setColumns(10);
		
		JButton btn_confirme = new JButton("Confirme");
		GridBagConstraints gbc_btn_confirme = new GridBagConstraints();
		gbc_btn_confirme.gridx = 1;
		gbc_btn_confirme.gridy = 3;
		add(btn_confirme, gbc_btn_confirme);

	}

}
