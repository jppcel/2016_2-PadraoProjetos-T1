package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelWithdrawalClient extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5590525961143815896L;
	private JTextField tf_valor;
	ClientPasswordView cpv;

	/**
	 * Create the panel.
	 */
	public PanelWithdrawalClient(final DefaultView dv) {
		cpv = new ClientPasswordView(dv);
				
		setBackground(Color.WHITE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{175, 175, 175, 175, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton bnt_50 = new JButton("R$ 50,00");
		bnt_50.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(50), dv);
			}
		});
		GridBagConstraints gbc_bnt_50 = new GridBagConstraints();
		gbc_bnt_50.ipady = 30;
		gbc_bnt_50.fill = GridBagConstraints.HORIZONTAL;
		gbc_bnt_50.gridwidth = 2;
		gbc_bnt_50.insets = new Insets(0, 0, 5, 5);
		gbc_bnt_50.gridx = 0;
		gbc_bnt_50.gridy = 0;
		add(bnt_50, gbc_bnt_50);
		
		JButton btn_300 = new JButton("R$ 300,00");
		btn_300.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(300), dv);
			}
		});
		GridBagConstraints gbc_btn_300 = new GridBagConstraints();
		gbc_btn_300.ipady = 30;
		gbc_btn_300.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_300.gridwidth = 2;
		gbc_btn_300.insets = new Insets(0, 0, 5, 0);
		gbc_btn_300.gridx = 2;
		gbc_btn_300.gridy = 0;
		add(btn_300, gbc_btn_300);
		
		JButton btn_100 = new JButton("R$ 100,00");
		btn_100.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(100), dv);
			}
		});
		GridBagConstraints gbc_btn_100 = new GridBagConstraints();
		gbc_btn_100.ipady = 30;
		gbc_btn_100.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_100.gridwidth = 2;
		gbc_btn_100.insets = new Insets(0, 0, 5, 5);
		gbc_btn_100.gridx = 0;
		gbc_btn_100.gridy = 1;
		add(btn_100, gbc_btn_100);
		
		JButton btn_500 = new JButton("R$ 500,00");
		btn_500.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(500), dv);
			}
		});
		GridBagConstraints gbc_btn_500 = new GridBagConstraints();
		gbc_btn_500.ipady = 30;
		gbc_btn_500.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_500.gridwidth = 2;
		gbc_btn_500.insets = new Insets(0, 0, 5, 0);
		gbc_btn_500.gridx = 2;
		gbc_btn_500.gridy = 1;
		add(btn_500, gbc_btn_500);
		
		JButton btn_200 = new JButton("R$ 200,00");
		btn_200.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(200), dv);
			}
		});
		GridBagConstraints gbc_btn_200 = new GridBagConstraints();
		gbc_btn_200.ipady = 30;
		gbc_btn_200.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_200.gridwidth = 2;
		gbc_btn_200.insets = new Insets(0, 0, 0, 5);
		gbc_btn_200.gridx = 0;
		gbc_btn_200.gridy = 2;
		add(btn_200, gbc_btn_200);
		
		tf_valor = new JTextField();
		GridBagConstraints gbc_tf_valor = new GridBagConstraints();
		gbc_tf_valor.insets = new Insets(0, 0, 0, 5);
		gbc_tf_valor.fill = GridBagConstraints.BOTH;
		gbc_tf_valor.gridx = 2;
		gbc_tf_valor.gridy = 2;
		add(tf_valor, gbc_tf_valor);
		tf_valor.setColumns(10);
		
		JButton btn_sacar = new JButton("Sacar");
		btn_sacar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				efetuaSaque(new BigDecimal(tf_valor.getText()), dv);
			}
		});
		GridBagConstraints gbc_btn_sacar = new GridBagConstraints();
		gbc_btn_sacar.ipady = 30;
		gbc_btn_sacar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btn_sacar.gridx = 3;
		gbc_btn_sacar.gridy = 2;
		add(btn_sacar, gbc_btn_sacar);

	}

	private void efetuaSaque(BigDecimal valor, DefaultView dv){
		cpv.setOperacao("SAQUE: R$ "+valor.setScale(2, RoundingMode.HALF_EVEN));
		dv.setEnabled(false);
		cpv.setVisible(true);
		

		cpv.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if(evt.getPropertyName().equals("setVisible")){
					System.out.println(1);
				}
			}
		});
	}
}
