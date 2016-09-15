package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ClientPasswordView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientPasswordView frame = new ClientPasswordView();
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
	public ClientPasswordView() {
		setTitle("Senha Internet - Banco TADS");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblDigiteSuaSenha = new JLabel("Digite sua senha utilizando o teclado virtual");
		GridBagConstraints gbc_lblDigiteSuaSenha = new GridBagConstraints();
		gbc_lblDigiteSuaSenha.gridwidth = 4;
		gbc_lblDigiteSuaSenha.insets = new Insets(0, 0, 5, 5);
		gbc_lblDigiteSuaSenha.gridx = 0;
		gbc_lblDigiteSuaSenha.gridy = 0;
		contentPane.add(lblDigiteSuaSenha, gbc_lblDigiteSuaSenha);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		contentPane.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("0");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("1");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton button = new JButton("2");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridx = 3;
		gbc_button.gridy = 1;
		contentPane.add(button, gbc_button);
		
		JButton button_1 = new JButton("3");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 1;
		contentPane.add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("4");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.insets = new Insets(0, 0, 5, 0);
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 1;
		contentPane.add(button_2, gbc_button_2);
		
		JButton btnConfirmar = new JButton("Confirmar");
		GridBagConstraints gbc_btnConfirmar = new GridBagConstraints();
		gbc_btnConfirmar.anchor = GridBagConstraints.WEST;
		gbc_btnConfirmar.insets = new Insets(0, 0, 0, 5);
		gbc_btnConfirmar.gridx = 0;
		gbc_btnConfirmar.gridy = 2;
		contentPane.add(btnConfirmar, gbc_btnConfirmar);
		
		JButton button_3 = new JButton("5");
		GridBagConstraints gbc_button_3 = new GridBagConstraints();
		gbc_button_3.insets = new Insets(0, 0, 0, 5);
		gbc_button_3.gridx = 1;
		gbc_button_3.gridy = 2;
		contentPane.add(button_3, gbc_button_3);
		
		JButton button_4 = new JButton("6");
		GridBagConstraints gbc_button_4 = new GridBagConstraints();
		gbc_button_4.insets = new Insets(0, 0, 0, 5);
		gbc_button_4.gridx = 2;
		gbc_button_4.gridy = 2;
		contentPane.add(button_4, gbc_button_4);
		
		JButton button_5 = new JButton("7");
		GridBagConstraints gbc_button_5 = new GridBagConstraints();
		gbc_button_5.insets = new Insets(0, 0, 0, 5);
		gbc_button_5.gridx = 3;
		gbc_button_5.gridy = 2;
		contentPane.add(button_5, gbc_button_5);
		
		JButton button_6 = new JButton("8");
		GridBagConstraints gbc_button_6 = new GridBagConstraints();
		gbc_button_6.insets = new Insets(0, 0, 0, 5);
		gbc_button_6.gridx = 4;
		gbc_button_6.gridy = 2;
		contentPane.add(button_6, gbc_button_6);
		
		JButton button_7 = new JButton("9");
		GridBagConstraints gbc_button_7 = new GridBagConstraints();
		gbc_button_7.gridx = 5;
		gbc_button_7.gridy = 2;
		contentPane.add(button_7, gbc_button_7);
	}
}
