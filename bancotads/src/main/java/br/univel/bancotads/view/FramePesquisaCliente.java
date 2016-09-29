package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.Pessoa;
import br.univel.bancotads.Usuario;
import br.univel.bancotads.dao.DaoPessoa;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.model.BancarioModel;
import br.univel.bancotads.model.PessoaModel;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class FramePesquisaCliente extends JFrame {

	private JPanel contentPane;
	private JTable jtPessoa;
	private DaoPessoa dPessoa;
	private Map<Integer, Pessoa> listaPessoa;
	private PanelNewAccount pAccount;

	public FramePesquisaCliente(final PanelNewAccount pAccount) {
		this.pAccount = pAccount;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btSelect = new JButton("Selecionar");
		btSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DaoPessoa dPessoa = new DaoPessoa();
				Pessoa P = dPessoa.search((Integer) jtPessoa.getValueAt(jtPessoa.getSelectedRow(), 2));
				try {
					pAccount.setUsuario(P);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				close();
			}
		});
		btSelect.setBounds(555, 355, 117, 25);
		contentPane.add(btSelect);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 660, 331);
		contentPane.add(scrollPane);
		
		jtPessoa = new JTable();
		jtPessoa.setSize(new Dimension(450, 400));
		scrollPane.setViewportView(jtPessoa);
		updateTable();
	}
	public void updateTable(){
		this.dPessoa = new DaoPessoa();
		this.listaPessoa = dPessoa.listAll();
		PessoaModel model = new PessoaModel(listaPessoa);
		jtPessoa.setModel(model);
	}
	public void close(){
		this.dispose();
		
	}
}
