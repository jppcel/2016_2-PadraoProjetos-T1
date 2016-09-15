package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2089990426939743900L;
	private JPanel contentPane;
	private JPanel cards;
	private CardLayout cardlayout = new CardLayout();

	/**
	 * Create the frame.
	 */
	public DefaultView() {
		setTitle("Banco TADS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel_homeClient = new PanelHomeClient(this);
		JPanel panel_payment = new PanelPayment(this);
		JPanel panel_withdrawClient = new PanelWithdrawalClient(this);
		
		
		JPanel panel = new PanelHeader();
		contentPane.add(panel, BorderLayout.NORTH);
		
		cards = new JPanel();
		cards.setLayout(cardlayout);
		contentPane.add(cards, BorderLayout.CENTER);

		cards.add(panel_homeClient, "home");
		cards.add(panel_payment, "teste");
		cards.add(panel_withdrawClient, "teste");
		cardlayout.show(cards, "home");
		
		
		/*JPanel panel_1 = new PanelHomeCliente();
		contentPane.add(panel_1, BorderLayout.CENTER); */
	}
	
	public void showPanel(String what){
		cardlayout.show(cards, what);
	}

}