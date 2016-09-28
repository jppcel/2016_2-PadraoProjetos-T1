package br.univel.bancotads.view;

import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

public class PanelNewAgencia extends JPanel{
	private JTextField tfNome;
	public PanelNewAgencia (final DefaultView df){
		setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setBounds(235, 105, 258, 19);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel jlNome = new JLabel("Nome");
		jlNome.setBounds(235, 86, 70, 15);
		add(jlNome);
		
	}

}
