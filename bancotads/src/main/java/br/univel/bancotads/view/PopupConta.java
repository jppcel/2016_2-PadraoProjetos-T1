package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PopupConta extends JFrame {

	private JPanel contentPane;
	private JTextField tf_ag;
	private JTextField tf_conta;
	private JTextField tf_titular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopupConta frame = new PopupConta();
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
	public PopupConta() {
		setTitle("Banco TADS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 327, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblAg = new JLabel("AG:");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 0;
		gbc_lblAg.gridy = 0;
		contentPane.add(lblAg, gbc_lblAg);
		
		JLabel lblConta = new JLabel("Conta:");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 0);
		gbc_lblConta.gridx = 1;
		gbc_lblConta.gridy = 0;
		contentPane.add(lblConta, gbc_lblConta);
		
		tf_ag = new JTextField();
		GridBagConstraints gbc_tf_ag = new GridBagConstraints();
		gbc_tf_ag.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ag.fill = GridBagConstraints.BOTH;
		gbc_tf_ag.gridx = 0;
		gbc_tf_ag.gridy = 1;
		contentPane.add(tf_ag, gbc_tf_ag);
		tf_ag.setColumns(10);
		
		tf_conta = new JTextField();
		GridBagConstraints gbc_tf_conta = new GridBagConstraints();
		gbc_tf_conta.insets = new Insets(0, 0, 5, 0);
		gbc_tf_conta.fill = GridBagConstraints.BOTH;
		gbc_tf_conta.gridx = 1;
		gbc_tf_conta.gridy = 1;
		contentPane.add(tf_conta, gbc_tf_conta);
		tf_conta.setColumns(10);
		
		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.gridwidth = 2;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 0);
		gbc_lblTipoConta.gridx = 0;
		gbc_lblTipoConta.gridy = 2;
		contentPane.add(lblTipoConta, gbc_lblTipoConta);
		
		JComboBox cb_tipoconta = new JComboBox();
		GridBagConstraints gbc_cb_tipoconta = new GridBagConstraints();
		gbc_cb_tipoconta.gridwidth = 2;
		gbc_cb_tipoconta.insets = new Insets(0, 0, 5, 0);
		gbc_cb_tipoconta.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_tipoconta.gridx = 0;
		gbc_cb_tipoconta.gridy = 3;
		contentPane.add(cb_tipoconta, gbc_cb_tipoconta);
		
		JLabel lblTitular = new JLabel("Titular");
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.gridwidth = 2;
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 0);
		gbc_lblTitular.gridx = 0;
		gbc_lblTitular.gridy = 4;
		contentPane.add(lblTitular, gbc_lblTitular);
		
		tf_titular = new JTextField();
		tf_titular.setEnabled(false);
		tf_titular.setEditable(false);
		GridBagConstraints gbc_tf_titular = new GridBagConstraints();
		gbc_tf_titular.gridwidth = 2;
		gbc_tf_titular.insets = new Insets(0, 0, 5, 5);
		gbc_tf_titular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_titular.gridx = 0;
		gbc_tf_titular.gridy = 5;
		contentPane.add(tf_titular, gbc_tf_titular);
		tf_titular.setColumns(10);
		
		JButton btn_confirme = new JButton("Confirme");
		GridBagConstraints gbc_btn_confirme = new GridBagConstraints();
		gbc_btn_confirme.anchor = GridBagConstraints.EAST;
		gbc_btn_confirme.gridx = 1;
		gbc_btn_confirme.gridy = 6;
		contentPane.add(btn_confirme, gbc_btn_confirme);
	}
}
