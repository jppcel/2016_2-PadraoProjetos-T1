package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.DBCreator;
import br.univel.bancotads.SoftwareProperties;

import javax.swing.JMenuBar;
import java.awt.Color;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2089990426939743900L;
	private JPanel contentPane;
	private JPanel cards;
	private CardLayout cardlayout = new CardLayout();
	DBCreator dbc = new DBCreator();
	SoftwareProperties sp = new SoftwareProperties();
	
	final PanelHomeClient panel_homeClient;
	final PanelPayment panel_payment;
	final PanelWithdrawalClient panel_withdrawClient;
	final PanelNewBancario panel_bancarioRegister;
	final PanelDepositClient panel_depositClient;
	final PanelHomeBancario panel_homeBancario;
	final PanelListAccounts panel_listAccounts;
	final PanelNewClient panel_newClient;
	final PanelSuccess panel_success;
	final PanelTransferClient panel_transferClient;
	final PanelHeader panel_header;
	
	final LoginView login;

	/**
	 * Create the frame.
	 */
	public DefaultView() {
		dbc.createDatabase();
		
		setTitle("Banco TADS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		panel_header = new PanelHeader();
		contentPane.add(panel_header, BorderLayout.NORTH);
		
		cards = new JPanel();
		cards.setLayout(cardlayout);
		contentPane.add(cards, BorderLayout.CENTER);
		
		panel_bancarioRegister = new PanelNewBancario(this);
		cards.add(panel_bancarioRegister, "bancarioRegister");
		
		panel_depositClient = new PanelDepositClient(this);
		cards.add(panel_depositClient, "depositClient");
		
		panel_homeBancario = new PanelHomeBancario(this);
		cards.add(panel_homeBancario, "homeBancario");
		
		panel_homeClient = new PanelHomeClient(this);
		cards.add(panel_homeClient, "homeClient");
		
		panel_listAccounts = new PanelListAccounts(this);
		cards.add(panel_listAccounts, "listAccounts");
		
		panel_newClient = new PanelNewClient(this);
		cards.add(panel_newClient, "newClient");
		
		panel_payment = new PanelPayment(this);
		cards.add(panel_payment, "payment");
		
		panel_success = new PanelSuccess(this);
		cards.add(panel_success, "success");
		
		panel_transferClient = new PanelTransferClient(this);
		cards.add(panel_transferClient, "transferClient");
		
		panel_withdrawClient = new PanelWithdrawalClient(this);
		cards.add(panel_withdrawClient, "withdrawal");
		
		PanelWhite panel_white = new PanelWhite();
		cards.add(panel_white, "white");
		

		cardlayout.show(cards, "white");
		
		panel_header.setVisibleFields(false);
		
		login = new LoginView();
		login.setVisible(true);
		
		
	}
	
	public void showPanel(String what){
		cardlayout.show(cards, what);
	}

}