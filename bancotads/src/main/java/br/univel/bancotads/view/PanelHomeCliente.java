package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelHomeCliente extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelHomeCliente() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btn_1 = new JButton("1 - Saques");
		GridBagConstraints gbc_btn_1 = new GridBagConstraints();
		gbc_btn_1.ipady = 30;
		gbc_btn_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_1.insets = new Insets(0, 0, 5, 5);
		gbc_btn_1.gridx = 0;
		gbc_btn_1.gridy = 0;
		add(btn_1, gbc_btn_1);
		
		JButton btn_4 = new JButton("4 - Transferências");
		GridBagConstraints gbc_btn_4 = new GridBagConstraints();
		gbc_btn_4.ipady = 30;
		gbc_btn_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_4.insets = new Insets(0, 0, 5, 0);
		gbc_btn_4.gridx = 1;
		gbc_btn_4.gridy = 0;
		add(btn_4, gbc_btn_4);
		
		JButton btn_2 = new JButton("2 - Saldo");
		GridBagConstraints gbc_btn_2 = new GridBagConstraints();
		gbc_btn_2.ipady = 30;
		gbc_btn_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_2.insets = new Insets(0, 0, 5, 5);
		gbc_btn_2.gridx = 0;
		gbc_btn_2.gridy = 1;
		add(btn_2, gbc_btn_2);
		
		JButton btn_5 = new JButton("5 - Pagamentos");
		GridBagConstraints gbc_btn_5 = new GridBagConstraints();
		gbc_btn_5.ipady = 30;
		gbc_btn_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_5.insets = new Insets(0, 0, 5, 0);
		gbc_btn_5.gridx = 1;
		gbc_btn_5.gridy = 1;
		add(btn_5, gbc_btn_5);
		
		JButton btn_3 = new JButton("3 - Depósitos");
		GridBagConstraints gbc_btn_3 = new GridBagConstraints();
		gbc_btn_3.ipady = 30;
		gbc_btn_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_3.insets = new Insets(0, 0, 0, 5);
		gbc_btn_3.gridx = 0;
		gbc_btn_3.gridy = 2;
		add(btn_3, gbc_btn_3);
		
		JButton btn_6 = new JButton("6 - Finalizar");
		GridBagConstraints gbc_btn_6 = new GridBagConstraints();
		gbc_btn_6.ipady = 30;
		gbc_btn_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_6.gridx = 1;
		gbc_btn_6.gridy = 2;
		add(btn_6, gbc_btn_6);

	}

}