package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.event.ChangeListener;

import br.univel.bancotads.Conta;
import br.univel.bancotads.Usuario;
import br.univel.bancotads.dao.DaoConta;

import javax.swing.event.ChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PanelDepositClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 786740380643754010L;
	final JCheckBox chckbxContaLogada;
	private JTextField tf_ag;
	private JTextField tf_conta;
	private JTextField textField_2;
	private JTextField tf_titular;
	private JTextField tf_tipoConta;
	private final DefaultView dv;

	/**
	 * Create the panel.
	 */
	public PanelDepositClient(final DefaultView dv) {
		this.dv = dv;
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_2 = new JLabel("Informe o valor a ser depositado:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 0;
		add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("AG:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Conta:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tf_ag = new JTextField();
		tf_ag.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkConta();
			}
		});
		tf_ag.setEditable(false);
		tf_ag.setEnabled(false);
		GridBagConstraints gbc_tf_ag = new GridBagConstraints();
		gbc_tf_ag.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ag.gridx = 0;
		gbc_tf_ag.gridy = 3;
		add(tf_ag, gbc_tf_ag);
		tf_ag.setColumns(10);
		
		tf_conta = new JTextField();
		tf_conta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkConta();
			}
		});
		tf_conta.setEditable(false);
		tf_conta.setEnabled(false);
		GridBagConstraints gbc_tf_conta = new GridBagConstraints();
		gbc_tf_conta.insets = new Insets(0, 0, 5, 5);
		gbc_tf_conta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_conta.gridx = 1;
		gbc_tf_conta.gridy = 3;
		add(tf_conta, gbc_tf_conta);
		tf_conta.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tipo Conta");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tf_tipoConta = new JTextField();
		tf_tipoConta.setEditable(false);
		GridBagConstraints gbc_tf_tipoConta = new GridBagConstraints();
		gbc_tf_tipoConta.gridwidth = 2;
		gbc_tf_tipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_tf_tipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tipoConta.gridx = 0;
		gbc_tf_tipoConta.gridy = 5;
		add(tf_tipoConta, gbc_tf_tipoConta);
		tf_tipoConta.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Titular");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tf_titular = new JTextField();
		tf_titular.setEditable(false);
		GridBagConstraints gbc_tf_titular = new GridBagConstraints();
		gbc_tf_titular.gridwidth = 2;
		gbc_tf_titular.insets = new Insets(0, 0, 0, 5);
		gbc_tf_titular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_titular.gridx = 0;
		gbc_tf_titular.gridy = 7;
		add(tf_titular, gbc_tf_titular);
		tf_titular.setColumns(10);

		
		JButton btnNewButton = new JButton("Confirme");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.ipady = 20;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 3;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);

		chckbxContaLogada = new JCheckBox("Conta Logada");
		chckbxContaLogada.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				alterCampos();
			}
		});
		chckbxContaLogada.setSelected(true);
		GridBagConstraints gbc_chckbxContaLogada = new GridBagConstraints();
		gbc_chckbxContaLogada.anchor = GridBagConstraints.WEST;
		gbc_chckbxContaLogada.gridwidth = 2;
		gbc_chckbxContaLogada.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxContaLogada.gridx = 0;
		gbc_chckbxContaLogada.gridy = 1;
		add(chckbxContaLogada, gbc_chckbxContaLogada);

	}
	
	public void alterCampos(){
		if(chckbxContaLogada.isSelected()){
			tf_ag.setEnabled(false);
			tf_ag.setEditable(false);
			tf_conta.setEnabled(false);
			tf_conta.setEditable(false);
			Usuario u = dv.getL().getU();
			Conta c = u.getConta();
			tf_ag.setText(c.getAgencia().getNumeroAgencia());
			tf_conta.setText(c.getNumeroConta());
			tf_tipoConta.setText(c.getTipoConta().getNome());
			tf_titular.setText(u.getPessoa().getNome());
		}else{
			tf_ag.setEnabled(true);
			tf_ag.setEditable(true);
			tf_ag.setText("");
			tf_conta.setEnabled(true);
			tf_conta.setEditable(true);
			tf_conta.setText("");
			tf_tipoConta.setText("");
			tf_titular.setText("");
		}
	}
	
	public void checkConta(){
		if(!tf_ag.getText().isEmpty() && !tf_conta.getText().isEmpty()){
			DaoConta daoc = new DaoConta();
			Conta c = daoc.searchConta(tf_ag.getText(), tf_conta.getText());
			if(c != null){
				tf_tipoConta.setText(c.getTipoConta().getNome());
				tf_titular.setText(c.getUsuario().getPessoa().getNome());
			}else{
				tf_tipoConta.setText("");
				tf_titular.setText("");
			}
		}
	}

}
