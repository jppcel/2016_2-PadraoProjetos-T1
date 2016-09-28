package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelSuccess extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8403642595368760634L;
	JLabel lb_operacao, lb_valor;

	/**
	 * Create the panel.
	 */
	public PanelSuccess(final DefaultView dv) {
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lb_operacao = new JLabel("Operação [OPERAÇÃO] realizada com sucesso!");
		lb_operacao.setFont(new Font("Dialog", Font.BOLD, 30));
		GridBagConstraints gbc_lb_operacao = new GridBagConstraints();
		gbc_lb_operacao.gridwidth = 3;
		gbc_lb_operacao.insets = new Insets(0, 0, 5, 0);
		gbc_lb_operacao.gridx = 0;
		gbc_lb_operacao.gridy = 0;
		add(lb_operacao, gbc_lb_operacao);
		
		lb_valor = new JLabel("Valor: R$ [VALOR]");
		lb_valor.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lb_valor = new GridBagConstraints();
		gbc_lb_valor.gridwidth = 3;
		gbc_lb_valor.anchor = GridBagConstraints.WEST;
		gbc_lb_valor.insets = new Insets(0, 0, 5, 5);
		gbc_lb_valor.gridx = 0;
		gbc_lb_valor.gridy = 1;
		add(lb_valor, gbc_lb_valor);
		
		JButton btn_retornar = new JButton("Retornar à Home");
		btn_retornar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dv.showPanel("homeClient");
			}
		});
		GridBagConstraints gbc_btn_retornar = new GridBagConstraints();
		gbc_btn_retornar.insets = new Insets(0, 0, 0, 5);
		gbc_btn_retornar.anchor = GridBagConstraints.EAST;
		gbc_btn_retornar.gridx = 1;
		gbc_btn_retornar.gridy = 9;
		add(btn_retornar, gbc_btn_retornar);
		
		JButton btn_imprimir = new JButton("Imprimir");
		GridBagConstraints gbc_btn_imprimir = new GridBagConstraints();
		gbc_btn_imprimir.anchor = GridBagConstraints.WEST;
		gbc_btn_imprimir.gridx = 2;
		gbc_btn_imprimir.gridy = 9;
		add(btn_imprimir, gbc_btn_imprimir);

	}
	
	public void setValor(BigDecimal valor){
		lb_valor.setText("Valor: R$ "+valor.setScale(2, RoundingMode.HALF_EVEN));
	}
	
	public void setOperacao(String operacao){
		lb_operacao.setText("Operação "+operacao+" realizada com sucesso!");
	}
}
