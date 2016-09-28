package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.Pessoa;
import br.univel.bancotads.dao.DaoPessoa;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.model.BancarioModel;
import br.univel.bancotads.model.PessoaModel;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class FramePesquisaCliente extends JFrame {

	private JPanel contentPane;
	private JTable jtPessoa;
	private DaoPessoa dPessoa;
	private Map<Integer, Pessoa> listaPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePesquisaCliente frame = new FramePesquisaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePesquisaCliente() {
		updateTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 688, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(555, 355, 117, 25);
		contentPane.add(btnCancelar);
		
		JButton button = new JButton("Selecionar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(425, 355, 117, 25);
		contentPane.add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 660, 331);
		contentPane.add(scrollPane);
		
		jtPessoa = new JTable();
		jtPessoa.setSize(new Dimension(450, 400));
		scrollPane.setViewportView(jtPessoa);
	}
	public void updateTable(){
		this.dPessoa = new DaoPessoa();
		this.listaPessoa = dPessoa.listAll();
		PessoaModel model = new PessoaModel(listaPessoa);
		jtPessoa.setModel(model);
	}
}
