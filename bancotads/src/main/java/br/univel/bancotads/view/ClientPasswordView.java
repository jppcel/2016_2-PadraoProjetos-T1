package br.univel.bancotads.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.Login;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JSeparator;

public class ClientPasswordView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7334626293156765251L;
	private JPanel contentPane;
	private JPasswordField textField;
	private JLabel lb_operacao;
	
	private void addValue(int value){
		if(this.textField.getDocument().getLength() < 6){
			this.textField.setText(String.copyValueOf(this.textField.getPassword()) + value);
		}
	}

	/**
	 * Create the frame.
	 */
	public ClientPasswordView(final DefaultView dv) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				dv.setEnabled(true);
			}
		});
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Senha Operações - Banco TADS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 418, 163);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lb_operacao = new JLabel("[OPERAÇÃO]");
		lb_operacao.setFont(new Font("Dialog", Font.BOLD, 18));
		GridBagConstraints gbc_lb_operacao = new GridBagConstraints();
		gbc_lb_operacao.gridwidth = 7;
		gbc_lb_operacao.insets = new Insets(0, 0, 5, 0);
		gbc_lb_operacao.gridx = 0;
		gbc_lb_operacao.gridy = 0;
		contentPane.add(lb_operacao, gbc_lb_operacao);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 7;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		contentPane.add(separator, gbc_separator);
		
		JLabel lblDigiteSuaSenha = new JLabel("Digite sua senha utilizando o teclado virtual");
		GridBagConstraints gbc_lblDigiteSuaSenha = new GridBagConstraints();
		gbc_lblDigiteSuaSenha.gridwidth = 7;
		gbc_lblDigiteSuaSenha.insets = new Insets(0, 0, 5, 0);
		gbc_lblDigiteSuaSenha.gridx = 0;
		gbc_lblDigiteSuaSenha.gridy = 2;
		contentPane.add(lblDigiteSuaSenha, gbc_lblDigiteSuaSenha);
		
		textField = new JPasswordField();
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 3;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("0");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(0);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 3;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(1);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 3;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton button = new JButton("2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(2);
			}
		});
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 4;
		gbc_button.gridy = 3;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("3");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(3);
			}
		});
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 3;
		contentPane.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("4");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(4);
			}
		});
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 6;
		gbc_button_2.gridy = 3;
		contentPane.add(button_2, gbc_button_2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				final Login l = dv.getL();
				Boolean ok = l.checkSenhaOperacoes(String.copyValueOf(textField.getPassword()));
				if(ok){
					dv.setEnabled(true);
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(dv, "Senha incorreta!");
				}
				textField.setText("");
			}
		});
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 0;
		gbc_btnConfirmar.gridy = 4;
		contentPane.add(btnConfirmar, gbc_btnConfirmar);
		
		JButton button_3 = new JButton("5");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(5);
			}
		});
		
		JButton btn_limpar = new JButton("Limpar");
		btn_limpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		GridBagConstraints gbc_btn_limpar = new GridBagConstraints();
		gbc_btn_limpar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_limpar.gridx = 1;
		gbc_btn_limpar.gridy = 4;
		contentPane.add(btn_limpar, gbc_btn_limpar);
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 2;
		gbc_button_3.gridy = 4;
		contentPane.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("6");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(6);
			}
		});
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 3;
		gbc_button_4.gridy = 4;
		contentPane.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("7");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(7);
			}
		});
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 0, 5);
		gbc_button_5.gridx = 4;
		gbc_button_5.gridy = 4;
		contentPane.add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("8");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(8);
			}
		});
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 0, 5);
		gbc_button_6.gridx = 5;
		gbc_button_6.gridy = 4;
		contentPane.add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("9");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addValue(9);
			}
		});
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.gridx = 6;
		gbc_button_7.gridy = 4;
		contentPane.add(button_7, gbc_button_7);
	}
	public void setOperacao(String operacao){
		lb_operacao.setText(operacao);
	}
}
