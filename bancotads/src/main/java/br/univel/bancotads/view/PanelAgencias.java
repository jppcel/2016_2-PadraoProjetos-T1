package br.univel.bancotads.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAgencias extends JPanel {
	private JTable table;
	
	public PanelAgencias(final DefaultView df){
		setLayout(null);
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("homeBancario");
			}
		});
		btVoltar.setBounds(605, 366, 85, 25);
		add(btVoltar);
		
		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(PanelAgencias.class.getResource("/org/freedesktop/tango/22x22/actions/list-remove.png")));
		btnRemover.setBounds(365, 366, 55, 25);
		add(btnRemover);
		
		JButton btEditar = new JButton("");
		btEditar.setIcon(new ImageIcon(PanelAgencias.class.getResource("/org/freedesktop/tango/22x22/categories/applications-graphics.png")));
		btEditar.setBounds(418, 366, 55, 25);
		add(btEditar);
		
		JButton btAdd = new JButton("");
		btAdd.setIcon(new ImageIcon(PanelAgencias.class.getResource("/org/freedesktop/tango/22x22/actions/list-add.png")));
		btAdd.setBounds(471, 366, 55, 25);
		add(btAdd);
		
		table = new JTable();
		table.setBounds(12, 12, 678, 345);
		add(table);
		
	}
	
	

}
