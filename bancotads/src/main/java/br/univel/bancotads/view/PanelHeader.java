package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
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

	/**
	 * Create the panel.
	 */
	public PanelHeader() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblBancoTads = new JLabel("Banco TADS");
		lblBancoTads.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lblBancoTads = new GridBagConstraints();
		gbc_lblBancoTads.insets = new Insets(0, 0, 5, 5);
		gbc_lblBancoTads.gridx = 3;
		gbc_lblBancoTads.gridy = 0;
		add(lblBancoTads, gbc_lblBancoTads);
		
		
		JLabel lblNewLabel = new JLabel(new Date().toLocaleString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.ipadx = 10;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAquiSuaNota = new JLabel("Aqui sua nota não é zero!");
		GridBagConstraints gbc_lblAquiSuaNota = new GridBagConstraints();
		gbc_lblAquiSuaNota.insets = new Insets(0, 0, 0, 5);
		gbc_lblAquiSuaNota.gridx = 3;
		gbc_lblAquiSuaNota.gridy = 1;
		add(lblAquiSuaNota, gbc_lblAquiSuaNota);

	}

}
