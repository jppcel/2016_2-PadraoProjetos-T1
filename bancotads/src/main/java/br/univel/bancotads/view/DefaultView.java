package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

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
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DefaultView frame = new DefaultView();
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
		
		JPanel panel_1 = new PanelHomeCliente(cardlayout, cards);
		JPanel panel_2 = new PanelPayment();
		JPanel panel_3 = new PanelSaqueCliente();
		
		
		JPanel panel = new PanelHeader();
		contentPane.add(panel, BorderLayout.NORTH);
		
		cards = new JPanel();
		cards.setLayout(cardlayout);
		contentPane.add(cards, BorderLayout.CENTER);

		cards.add(panel_1, "home");
		cards.add(panel_3, "teste");
		cardlayout.show(cards, "home");
		
		
		/*JPanel panel_1 = new PanelHomeCliente();
		contentPane.add(panel_1, BorderLayout.CENTER); */
	}

}