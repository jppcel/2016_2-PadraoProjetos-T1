package br.univel.bancotads.view;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;

import br.univel.bancotads.enums.TipoConta;
import br.univel.bancotads.enums.Genero;

public class PanelNewClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1447292700870339929L;
	
	private JTextField tf_senhaoperacoes;
	private JTextField tf_senhaacesso;
	private JTextField tf_username;
	private JTextField tf_agencia;
	private JTextField tf_idade;
	private JTextField tf_cpf;
	private JTextField tf_nome;

	/**
	 * Create the panel.
	 */
	public PanelNewClient(final DefaultView df) {
		setBackground(Color.WHITE);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(81dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(125dlu;default):grow"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel_7 = new JLabel("Nome:");
		add(lblNewLabel_7, "2, 4, 7, 1");
		
		tf_nome = new JTextField();
		add(tf_nome, "2, 6, 7, 1, fill, default");
		tf_nome.setColumns(10);
		
		JLabel lblGnero = new JLabel("Gênero");
		add(lblGnero, "2, 8, 7, 1");
		
		JComboBox cb_genero = new JComboBox(Genero.values());
		add(cb_genero, "2, 10, 7, 1, fill, default");
		
		JLabel lblNewLabel_5 = new JLabel("Data de Nascimento:");
		add(lblNewLabel_5, "2, 12");
		
		JLabel lblNewLabel_6 = new JLabel("CPF:");
		add(lblNewLabel_6, "4, 12, 5, 1");
		
		tf_idade = new JTextField();
		add(tf_idade, "2, 14, fill, default");
		tf_idade.setColumns(10);
		
		tf_cpf = new JTextField();
		add(tf_cpf, "4, 14, 5, 1");
		tf_cpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Agência:");
		add(lblNewLabel_3, "2, 16");
		
		JLabel lblNewLabel_4 = new JLabel("Tipo Conta:");
		add(lblNewLabel_4, "4, 16, 5, 1");
		
		tf_agencia = new JTextField();
		add(tf_agencia, "2, 18, fill, default");
		tf_agencia.setColumns(10);
		
		JComboBox cb_tipoconta = new JComboBox(TipoConta.values());
		add(cb_tipoconta, "4, 18, 5, 1, fill, default");
		
		
		JLabel lblNewLabel_2 = new JLabel("Username:");
		add(lblNewLabel_2, "2, 20, 7, 1");
		
		tf_username = new JTextField();
		add(tf_username, "2, 22, 7, 1, fill, default");
		tf_username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha Acesso");
		add(lblNewLabel, "2, 24, 3, 1");
		
		JLabel lblNewLabel_1 = new JLabel("Senha Operações");
		add(lblNewLabel_1, "6, 24, 3, 1");
		
		tf_senhaacesso = new JTextField();
		add(tf_senhaacesso, "2, 26, 3, 1, fill, default");
		tf_senhaacesso.setColumns(10);
		
		tf_senhaoperacoes = new JTextField();
		add(tf_senhaoperacoes, "6, 26, 3, 1, fill, default");
		tf_senhaoperacoes.setColumns(10);
		
		JButton btn_confirme = new JButton("Confirme");
		add(btn_confirme, "8, 28, center, center");

	}

}
