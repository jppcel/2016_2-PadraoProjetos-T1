package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

import br.univel.bancotads.Usuario;
import br.univel.bancotads.enums.Genero;
import javax.swing.JFormattedTextField;

public class PanelNewBancario extends JPanel {
	
	private JTextField tf_senhaoperacoes;
	private JTextField tf_senhaacesso;
	private JTextField tf_username;
	private JTextField tf_nome;
	private JFormattedTextField tfDataNasc;
	private JFormattedTextField tfCpf;
	private MaskFormatter mfdata;
	private MaskFormatter mfcpf;
	private Usuario user;

	/**
	 * Create the panel.
	 * @throws ParseException 
	 */
	public PanelNewBancario(final DefaultView df) throws ParseException {
		initmasks();
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_4 = new JLabel("Nome");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 4;
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.ipadx = 50;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 1;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tf_nome = new JTextField();
		GridBagConstraints gbc_tf_nome = new GridBagConstraints();
		gbc_tf_nome.ipadx = 50;
		gbc_tf_nome.gridwidth = 4;
		gbc_tf_nome.insets = new Insets(0, 0, 5, 0);
		gbc_tf_nome.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_nome.gridx = 0;
		gbc_tf_nome.gridy = 2;
		add(tf_nome, gbc_tf_nome);
		tf_nome.setColumns(10);
		
		JLabel lblGnero = new JLabel("Gênero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.WEST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 0;
		gbc_lblGnero.gridy = 3;
		add(lblGnero, gbc_lblGnero);
		
		JComboBox cb_genero = new JComboBox<Object>(Genero.values());
		GridBagConstraints gbc_cb_genero = new GridBagConstraints();
		gbc_cb_genero.gridwidth = 4;
		gbc_cb_genero.insets = new Insets(0, 0, 5, 0);
		gbc_cb_genero.fill = GridBagConstraints.HORIZONTAL;
		gbc_cb_genero.gridx = 0;
		gbc_cb_genero.gridy = 4;
		add(cb_genero, gbc_cb_genero);
		
		
		JLabel lblNewLabel_3 = new JLabel("Data de Nascimento");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 4;
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfDataNasc = new JFormattedTextField(mfdata);
		GridBagConstraints gbc_tfDataNasc = new GridBagConstraints();
		gbc_tfDataNasc.gridwidth = 4;
		gbc_tfDataNasc.insets = new Insets(0, 0, 5, 0);
		gbc_tfDataNasc.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDataNasc.gridx = 0;
		gbc_tfDataNasc.gridy = 6;
		add(tfDataNasc, gbc_tfDataNasc);
		
		JLabel lblCpf = new JLabel("CPF");
		GridBagConstraints gbc_lblCpf = new GridBagConstraints();
		gbc_lblCpf.gridwidth = 4;
		gbc_lblCpf.anchor = GridBagConstraints.WEST;
		gbc_lblCpf.insets = new Insets(0, 0, 5, 0);
		gbc_lblCpf.gridx = 0;
		gbc_lblCpf.gridy = 7;
		add(lblCpf, gbc_lblCpf);
		
		tfCpf = new JFormattedTextField(mfcpf);
		GridBagConstraints gbc_tfCpf = new GridBagConstraints();
		gbc_tfCpf.gridwidth = 4;
		gbc_tfCpf.insets = new Insets(0, 0, 5, 5);
		gbc_tfCpf.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCpf.gridx = 0;
		gbc_tfCpf.gridy = 8;
		add(tfCpf, gbc_tfCpf);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 4;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 9;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tf_username = new JTextField();
		GridBagConstraints gbc_tf_username = new GridBagConstraints();
		gbc_tf_username.gridwidth = 4;
		gbc_tf_username.insets = new Insets(0, 0, 5, 0);
		gbc_tf_username.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_username.gridx = 0;
		gbc_tf_username.gridy = 10;
		add(tf_username, gbc_tf_username);
		tf_username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha Acesso");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 11;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha Operações");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 11;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tf_senhaacesso = new JTextField();
		GridBagConstraints gbc_tf_senhaacesso = new GridBagConstraints();
		gbc_tf_senhaacesso.gridwidth = 2;
		gbc_tf_senhaacesso.insets = new Insets(0, 0, 5, 5);
		gbc_tf_senhaacesso.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_senhaacesso.gridx = 0;
		gbc_tf_senhaacesso.gridy = 12;
		add(tf_senhaacesso, gbc_tf_senhaacesso);
		tf_senhaacesso.setColumns(10);
		
		tf_senhaoperacoes = new JTextField();
		GridBagConstraints gbc_tf_senhaoperacoes = new GridBagConstraints();
		gbc_tf_senhaoperacoes.insets = new Insets(0, 0, 5, 0);
		gbc_tf_senhaoperacoes.gridwidth = 2;
		gbc_tf_senhaoperacoes.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_senhaoperacoes.gridx = 2;
		gbc_tf_senhaoperacoes.gridy = 12;
		add(tf_senhaoperacoes, gbc_tf_senhaoperacoes);
		tf_senhaoperacoes.setColumns(10);
		
		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			df.showPanel("profissionais");
			}
		});
		btnVoltar.setIcon(new ImageIcon(PanelNewBancario.class.getResource("/org/freedesktop/tango/22x22/actions/go-previous.png")));
		GridBagConstraints gbc_btnVoltar = new GridBagConstraints();
		gbc_btnVoltar.insets = new Insets(0, 0, 0, 5);
		gbc_btnVoltar.gridx = 2;
		gbc_btnVoltar.gridy = 13;
		add(btnVoltar, gbc_btnVoltar);
		
		JButton btn_confirme = new JButton("Confirme");
		btn_confirme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf_nome.getText().isEmpty() || tf_username.getText().isEmpty() || tfDataNasc.getText().isEmpty() || tf_senhaacesso.getText().isEmpty()
						|| tf_senhaoperacoes.getText().isEmpty() || tfCpf.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Algum campo está vazio, verificar.");
				}
				else {
					// INSERIR NO BANCO COM OS DADOS
					df.showPanel("profissionais");
				}
			}
		});
		GridBagConstraints gbc_btn_confirme = new GridBagConstraints();
		gbc_btn_confirme.anchor = GridBagConstraints.EAST;
		gbc_btn_confirme.ipady = 20;
		gbc_btn_confirme.gridx = 3;
		gbc_btn_confirme.gridy = 13;
		add(btn_confirme, gbc_btn_confirme);
		

	}

	private void initmasks() throws ParseException {
			MaskFormatter mfdata = new MaskFormatter("##/##/####");
			mfdata.setPlaceholderCharacter('_');
			MaskFormatter mfcpf = new MaskFormatter("###.###.###-##");
			mfcpf.setPlaceholderCharacter('_');
			this.mfdata = mfdata;
			this.mfcpf = mfcpf;
	}
	
	public void editUser(Usuario u){
		this.user = u;
		tf_nome.setText(u.getPessoa().getNome());
		tf_username.setText(u.getUsername());
		tfCpf.setText(u.getPessoa().getCpf());
		final Calendar calendar = Calendar.getInstance();
		final DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
		tfDataNasc.setText((ndf.format(u.getPessoa().getDataNascimento())).toString());
		
		
	}

	public void clearFields() {
		tf_nome.setText("");
		tf_username.setText("");
		tfCpf.setText("");
		tfDataNasc.setText("");
		
	}
}
