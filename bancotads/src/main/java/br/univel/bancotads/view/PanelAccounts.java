package br.univel.bancotads.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;

public class PanelAccounts extends JPanel {
	
	public PanelAccounts(final DefaultView df) {
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("homeBancario");
			}
		});
		btnVoltar.setBounds(625, 363, 77, 25);
		add(btnVoltar);
		
	}
}
