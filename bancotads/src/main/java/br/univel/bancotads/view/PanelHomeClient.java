package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PanelHomeClient extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1484003892591769942L;
	JButton btn_1, btn_2, btn_3, btn_4, btn_5, btn_6;

	public PanelHomeClient(final DefaultView dv) {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btn_1 = new JButton("1 - Saques");
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dv.showPanel("withdrawal");
			}
		});
		GridBagConstraints gbc_btn_1 = new GridBagConstraints();
		gbc_btn_1.ipady = 30;
		gbc_btn_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_1.insets = new Insets(0, 0, 5, 5);
		gbc_btn_1.gridx = 0;
		gbc_btn_1.gridy = 0;
		add(btn_1, gbc_btn_1);
		
		btn_4 = new JButton("4 - Transferências");
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dv.showPanel("transferClient");
			}
		});
		GridBagConstraints gbc_btn_4 = new GridBagConstraints();
		gbc_btn_4.ipady = 30;
		gbc_btn_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_4.insets = new Insets(0, 0, 5, 0);
		gbc_btn_4.gridx = 1;
		gbc_btn_4.gridy = 0;
		add(btn_4, gbc_btn_4);
		
		btn_2 = new JButton("2 - Saldo");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
		});
		GridBagConstraints gbc_btn_2 = new GridBagConstraints();
		gbc_btn_2.ipady = 30;
		gbc_btn_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_2.insets = new Insets(0, 0, 5, 5);
		gbc_btn_2.gridx = 0;
		gbc_btn_2.gridy = 1;
		add(btn_2, gbc_btn_2);
		
		btn_5 = new JButton("5 - Pagamentos");
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dv.showPanel("payment");
			}
		});
		GridBagConstraints gbc_btn_5 = new GridBagConstraints();
		gbc_btn_5.ipady = 30;
		gbc_btn_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_5.insets = new Insets(0, 0, 5, 0);
		gbc_btn_5.gridx = 1;
		gbc_btn_5.gridy = 1;
		add(btn_5, gbc_btn_5);
		
		btn_3 = new JButton("3 - Depósitos");
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dv.showPanel("depositClient");
			}
		});
		GridBagConstraints gbc_btn_3 = new GridBagConstraints();
		gbc_btn_3.ipady = 30;
		gbc_btn_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_3.insets = new Insets(0, 0, 0, 5);
		gbc_btn_3.gridx = 0;
		gbc_btn_3.gridy = 2;
		add(btn_3, gbc_btn_3);
		
		btn_6 = new JButton("6 - Finalizar");
		btn_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dv.doLogout();
			}
		});
		GridBagConstraints gbc_btn_6 = new GridBagConstraints();
		gbc_btn_6.ipady = 30;
		gbc_btn_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_6.gridx = 1;
		gbc_btn_6.gridy = 2;
		add(btn_6, gbc_btn_6);

	}
	
	public void setButtons(int[] buttons){
		btn_1.setEnabled(false);
		btn_2.setEnabled(false);
		btn_3.setEnabled(false);
		btn_4.setEnabled(false);
		btn_5.setEnabled(false);
		btn_6.setEnabled(false);
		for(int b : buttons){
			switch(b){
				case 1:
					btn_1.setEnabled(true);
					break;
				case 2:
					btn_2.setEnabled(true);
					break;
				case 3:
					btn_3.setEnabled(true);
					break;
				case 4:
					btn_4.setEnabled(true);
					break;
				case 5:
					btn_5.setEnabled(true);
					break;
				case 6:
					btn_6.setEnabled(true);
			}
		}
	}

}
