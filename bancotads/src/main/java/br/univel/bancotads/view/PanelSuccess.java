package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;

public class PanelSuccess extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403642595368760634L;

	/**
	 * Create the panel.
	 */
	public PanelSuccess(final DefaultView df, String operacao, Float valor) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Operação "+operacao+" realizada com sucesso!");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Valor: R$ "+valor);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JButton btn_retornar = new JButton("Retornar");
		GridBagConstraints gbc_btn_retornar = new GridBagConstraints();
		gbc_btn_retornar.insets = new Insets(0, 0, 5, 0);
		gbc_btn_retornar.anchor = GridBagConstraints.EAST;
		gbc_btn_retornar.gridx = 1;
		gbc_btn_retornar.gridy = 1;
		add(btn_retornar, gbc_btn_retornar);
		
		JButton btn_imprimir = new JButton("Imprimir");
		GridBagConstraints gbc_btn_imprimir = new GridBagConstraints();
		gbc_btn_imprimir.anchor = GridBagConstraints.EAST;
		gbc_btn_imprimir.gridx = 1;
		gbc_btn_imprimir.gridy = 9;
		add(btn_imprimir, gbc_btn_imprimir);

	}
}
