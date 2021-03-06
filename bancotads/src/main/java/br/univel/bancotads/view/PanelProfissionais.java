package br.univel.bancotads.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import br.univel.bancotads.Usuario;
import br.univel.bancotads.dao.DaoUsuario;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.model.BancarioModel;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class PanelProfissionais extends JPanel {
	private DaoUsuario dUsuario;
	private Map<Integer, Usuario> listaUsuario;
	private JTable tbFuncionarios;
	
	public PanelProfissionais(final DefaultView df) {
		setLayout(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("homeBancario");
			}
		});
		btnVoltar.setBounds(571, 363, 117, 25);
		add(btnVoltar);
		
		JButton btnAddFuncionario = new JButton("");
		btnAddFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("bancarioRegister");
				df.clearBancario();
			}
		});
		btnAddFuncionario.setIcon(new ImageIcon(PanelProfissionais.class.getResource("/org/freedesktop/tango/32x32/actions/list-add.png")));
		btnAddFuncionario.setBounds(456, 363, 55, 25);
		add(btnAddFuncionario);
		
		JButton btnRemoveFuncionario = new JButton("");
		btnRemoveFuncionario.setIcon(new ImageIcon(PanelProfissionais.class.getResource("/org/freedesktop/tango/22x22/actions/list-remove.png")));
		btnRemoveFuncionario.setBounds(350, 363, 55, 25);
		add(btnRemoveFuncionario);
		
		JButton btnEditFuncionario = new JButton("");
		btnEditFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Usuario uAlt = dUsuario.search(tbFuncionarios.getValueAt(tbFuncionarios.getSelectedRow(), 1).toString());
				df.editarBancario(uAlt);
				df.showPanel("bancarioRegister");
				
			}
		});
		btnEditFuncionario.setIcon(new ImageIcon(PanelProfissionais.class.getResource("/org/freedesktop/tango/22x22/categories/applications-graphics.png")));
		btnEditFuncionario.setBounds(403, 363, 55, 25);
		add(btnEditFuncionario);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 676, 339);
		add(scrollPane);
		
		tbFuncionarios = new JTable();
		tbFuncionarios.setPreferredSize(new Dimension(450, 400));
		scrollPane.setViewportView(tbFuncionarios);
		updateTable();
		
	}
	
	public void updateTable(){
		this.dUsuario = new DaoUsuario();
		this.listaUsuario = dUsuario.search(TipoUsuario.BANCARIO);
		BancarioModel model = new BancarioModel(listaUsuario);
	    tbFuncionarios.setModel(model);
	}
}
