package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;

import br.univel.bancotads.Conta;
import br.univel.bancotads.Movimentacao;
import br.univel.bancotads.dao.DaoConta;
import br.univel.bancotads.enums.PosSenhaOperacoes;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelTransferClient extends JPanel implements PosSenhaOperacoes {
	/**
	 * 
	 */
	private static final long serialVersionUID = -39087414988179438L;
	private JTextField tf_ag;
	private JTextField tf_conta;
	private JTextField tf_titular;
	private JTextField tf_valor;
	private JTextField tf_tipoConta;
	private int idConta;
	private final DefaultView dv;
	private final ClientPasswordView cpv;
	private BigDecimal valor = null;
	private Movimentacao m;

	/**
	 * Create the panel.
	 */
	public PanelTransferClient(final DefaultView dv) {
		cpv = new ClientPasswordView(dv,this);
		this.dv = dv;
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblContaDeDestinocrdito = new JLabel("Conta de destino/Crédito");
		lblContaDeDestinocrdito.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblContaDeDestinocrdito = new GridBagConstraints();
		gbc_lblContaDeDestinocrdito.gridwidth = 2;
		gbc_lblContaDeDestinocrdito.insets = new Insets(0, 0, 5, 5);
		gbc_lblContaDeDestinocrdito.gridx = 0;
		gbc_lblContaDeDestinocrdito.gridy = 0;
		add(lblContaDeDestinocrdito, gbc_lblContaDeDestinocrdito);
		
		JLabel lblAg = new JLabel("AG:");
		GridBagConstraints gbc_lblAg = new GridBagConstraints();
		gbc_lblAg.anchor = GridBagConstraints.WEST;
		gbc_lblAg.insets = new Insets(0, 0, 5, 5);
		gbc_lblAg.gridx = 0;
		gbc_lblAg.gridy = 1;
		add(lblAg, gbc_lblAg);
		
		JLabel lblConta = new JLabel("Conta:");
		GridBagConstraints gbc_lblConta = new GridBagConstraints();
		gbc_lblConta.anchor = GridBagConstraints.WEST;
		gbc_lblConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblConta.gridx = 1;
		gbc_lblConta.gridy = 1;
		add(lblConta, gbc_lblConta);
		
		tf_ag = new JTextField();
		tf_ag.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkConta();
			}
		});
		GridBagConstraints gbc_tf_ag = new GridBagConstraints();
		gbc_tf_ag.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ag.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ag.gridx = 0;
		gbc_tf_ag.gridy = 2;
		add(tf_ag, gbc_tf_ag);
		tf_ag.setColumns(10);
		
		tf_conta = new JTextField();
		tf_conta.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				checkConta();
			}
		});
		tf_conta.setText("");
		GridBagConstraints gbc_tf_conta = new GridBagConstraints();
		gbc_tf_conta.insets = new Insets(0, 0, 5, 5);
		gbc_tf_conta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_conta.gridx = 1;
		gbc_tf_conta.gridy = 2;
		add(tf_conta, gbc_tf_conta);
		tf_conta.setColumns(10);
		
		JLabel lblTipoConta = new JLabel("Tipo Conta:");
		GridBagConstraints gbc_lblTipoConta = new GridBagConstraints();
		gbc_lblTipoConta.anchor = GridBagConstraints.WEST;
		gbc_lblTipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_lblTipoConta.gridx = 0;
		gbc_lblTipoConta.gridy = 3;
		add(lblTipoConta, gbc_lblTipoConta);
		
		tf_tipoConta = new JTextField();
		tf_tipoConta.setEditable(false);
		GridBagConstraints gbc_tf_tipoConta = new GridBagConstraints();
		gbc_tf_tipoConta.gridwidth = 2;
		gbc_tf_tipoConta.insets = new Insets(0, 0, 5, 5);
		gbc_tf_tipoConta.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_tipoConta.gridx = 0;
		gbc_tf_tipoConta.gridy = 4;
		add(tf_tipoConta, gbc_tf_tipoConta);
		tf_tipoConta.setColumns(10);
		
		JLabel lblTitular = new JLabel("Titular");
		GridBagConstraints gbc_lblTitular = new GridBagConstraints();
		gbc_lblTitular.anchor = GridBagConstraints.WEST;
		gbc_lblTitular.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitular.gridx = 0;
		gbc_lblTitular.gridy = 5;
		add(lblTitular, gbc_lblTitular);
		
		tf_titular = new JTextField();
		tf_titular.setEditable(false);
		GridBagConstraints gbc_tf_titular = new GridBagConstraints();
		gbc_tf_titular.gridwidth = 2;
		gbc_tf_titular.insets = new Insets(0, 0, 5, 5);
		gbc_tf_titular.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_titular.gridx = 0;
		gbc_tf_titular.gridy = 6;
		add(tf_titular, gbc_tf_titular);
		tf_titular.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		GridBagConstraints gbc_lblValor = new GridBagConstraints();
		gbc_lblValor.anchor = GridBagConstraints.WEST;
		gbc_lblValor.insets = new Insets(0, 0, 5, 5);
		gbc_lblValor.gridx = 0;
		gbc_lblValor.gridy = 7;
		add(lblValor, gbc_lblValor);
		
		tf_valor = new JTextField();
		tf_valor.setText("");
		GridBagConstraints gbc_tf_valor = new GridBagConstraints();
		gbc_tf_valor.gridwidth = 2;
		gbc_tf_valor.insets = new Insets(0, 0, 0, 5);
		gbc_tf_valor.fill = GridBagConstraints.BOTH;
		gbc_tf_valor.gridx = 0;
		gbc_tf_valor.gridy = 8;
		add(tf_valor, gbc_tf_valor);
		tf_valor.setColumns(10);
		
		JButton btn_confirme = new JButton("Confirme");
		btn_confirme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaTransferencia();
			}
		});
		GridBagConstraints gbc_btn_confirme = new GridBagConstraints();
		gbc_btn_confirme.ipady = 20;
		gbc_btn_confirme.gridx = 2;
		gbc_btn_confirme.gridy = 8;
		add(btn_confirme, gbc_btn_confirme);

	}

	
	public void efetuaTransferencia(){
		valor = new BigDecimal(tf_valor.getText());
		cpv.setOperacao("TRANSFERÊNCIA: R$ "+valor.setScale(2, RoundingMode.HALF_EVEN));
		dv.setEnabled(false);
		cpv.setVisible(true);
		m = new Movimentacao(dv);
		m.setValor(valor);
		m.setC(new DaoConta().search(idConta));
	}
	
	public void checkConta(){
		if(!tf_ag.getText().isEmpty() && !tf_conta.getText().isEmpty()){
			DaoConta daoc = new DaoConta();
			Conta c = daoc.searchConta(tf_ag.getText(), tf_conta.getText());
			if(c != null){
				tf_tipoConta.setText(c.getTipoConta().getNome());
				tf_titular.setText(c.getUsuario().getPessoa().getNome());
				idConta = c.getId();
			}else{
				idConta = 0;
				tf_tipoConta.setText("");
				tf_titular.setText("");
			}
		}
	}


	@Override
	public void executaOperacao() {
		m.efetuaTransferencia();
		tf_valor.setText("");
		tf_ag.setText("");
		tf_conta.setText("");
	}
}
