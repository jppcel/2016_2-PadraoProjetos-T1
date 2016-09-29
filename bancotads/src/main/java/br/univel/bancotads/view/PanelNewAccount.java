package br.univel.bancotads.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import br.univel.bancotads.Pessoa;
import br.univel.bancotads.Usuario;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class PanelNewAccount extends JPanel {
	private JTextField tfNome;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private Pessoa P;
	private JFormattedTextField tfcpf;
	private JFormattedTextField tfdataNasc;
	private MaskFormatter mfdata;
	
	public PanelNewAccount(final DefaultView df) throws ParseException{
		setLayout(null);
		this.mfdata = new MaskFormatter("##/##/####");
		mfdata.setPlaceholderCharacter('_');
		tfNome = new JTextField();
		tfNome.setBounds(133, 37, 464, 19);
		add(tfNome);
		tfNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(132, 22, 70, 15);
		add(lblNome);
		
		tfdataNasc = new JFormattedTextField((AbstractFormatter) null);
		tfdataNasc.setBounds(133, 78, 134, 19);
		add(tfdataNasc);
		
		JLabel lblDataNasc = new JLabel("Data Nasc.:");
		lblDataNasc.setBounds(132, 61, 85, 15);
		add(lblDataNasc);
		
		tfcpf = new JFormattedTextField((AbstractFormatter) null);
		tfcpf.setBounds(331, 78, 266, 19);
		add(tfcpf);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(332, 61, 85, 15);
		add(lblCpf);
		
		JLabel lblAgencia = new JLabel("Agencia:");
		lblAgencia.setBounds(133, 109, 85, 15);
		add(lblAgencia);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 129, 134, 19);
		add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(331, 126, 266, 24);
		add(comboBox);
		
		JLabel lblTipoDeConta = new JLabel("Tipo de Conta:");
		lblTipoDeConta.setBounds(331, 109, 134, 15);
		add(lblTipoDeConta);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(134, 175, 464, 19);
		add(textField_2);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setDisplayedMnemonic('*');
		lblUsername.setBounds(133, 160, 134, 15);
		add(lblUsername);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(133, 236, 134, 19);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(297, 236, 168, 19);
		add(passwordField_1);
		
		JLabel lblSenhaDeAcesso = new JLabel("Senha de Acesso:");
		lblSenhaDeAcesso.setBounds(132, 219, 135, 15);
		add(lblSenhaDeAcesso);
		
		JLabel lblSenhaDeOperaes = new JLabel("Senha de Operações:");
		lblSenhaDeOperaes.setBounds(296, 219, 169, 15);
		add(lblSenhaDeOperaes);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("homeBancario");
			}
		});
		btnVoltar.setBounds(563, 421, 117, 25);
		add(btnVoltar);
		
		JButton btnConfirme = new JButton("Confirme");
		btnConfirme.setBounds(297, 267, 168, 25);
		add(btnConfirme);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		button.setIcon(new ImageIcon(PanelNewAccount.class.getResource("/org/freedesktop/tango/22x22/actions/edit-find.png")));
		button.setBounds(606, 34, 43, 25);
		add(button);
		
	}
	public void setUsuario(Pessoa p) throws ParseException{
		
		this.P = p;
		tfNome.setText(P.getNome());
		tfNome.setEditable(false);
		tfdataNasc.setEditable(false);
		tfcpf.setText(P.getCpf());
		tfcpf.setEditable(false);
		final Calendar calendar = Calendar.getInstance();
		final DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
		tfdataNasc.setText((ndf.format(P.getDataNascimento())).toString());
		
	}
	public void pesquisar(){
		FramePesquisaCliente fp = new FramePesquisaCliente(this);
		fp.setVisible(true);
	}
}
