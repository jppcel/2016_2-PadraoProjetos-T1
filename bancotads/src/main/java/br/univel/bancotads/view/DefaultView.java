package br.univel.bancotads.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.DBCreator;
import br.univel.bancotads.Login;
import br.univel.bancotads.SoftwareProperties;

import javax.swing.JMenuBar;
import java.awt.Color;
import java.text.ParseException;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2089990426939743900L;
	private JPanel contentPane;
	private JPanel cards;
	private CardLayout cardlayout = new CardLayout();
	private DBCreator dbc = new DBCreator();
	private SoftwareProperties sp = new SoftwareProperties();

	private final PanelHeader panel_header;
	private final PanelHomeClient panel_homeClient;
	private final PanelPayment panel_payment;
	private final PanelWithdrawalClient panel_withdrawClient;
	private final PanelNewBancario panel_bancarioRegister;
	private final PanelDepositClient panel_depositClient;
	private final PanelHomeBancario panel_homeBancario;
	private final PanelListAccounts panel_listAccounts;
	private final PanelNewClient panel_newClient;
	private final PanelSuccess panel_success;
	private final PanelTransferClient panel_transferClient;
	private final PanelAccounts panel_accounts;
	private final PanelProfissionais panel_profissionais;
	private final PanelBalanco panel_balanco;
	private final PanelAgencias panel_agencias;
	
	private final LoginView login;
	
	private final Login l = new Login(this);
	private JMenu mnSistema;
	private JMenuItem mntmHome;
	private JMenuItem mntmSair;

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public DefaultView() throws ParseException {
		dbc.createDatabase();
		
		setTitle("Banco TADS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 532);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnSistema = new JMenu("Sistema");
		menuBar.add(mnSistema);
		
		mntmHome = new JMenuItem("Home");
		mntmHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(l.getU().getTu().getId() == 1){
					showPanel("homeClient");
				}else{
					showPanel("homeBancario");
				}
			}
		});
		mnSistema.add(mntmHome);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				doLogout();
			}
		});
		mnSistema.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_header = new PanelHeader();
		panel_header.setVisibleFields(false);
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
		
		panel_accounts = new PanelAccounts(this);
		cards.add(panel_accounts, "accounts");
		
		panel_profissionais = new PanelProfissionais(this);
		cards.add(panel_profissionais, "profissionais");
		
		panel_balanco = new PanelBalanco(this);
		cards.add(panel_balanco, "balanco");
		
		panel_agencias = new PanelAgencias(this);
		cards.add(panel_agencias, "agencias");
		
		PanelWhite panel_white = new PanelWhite();
		cards.add(panel_white, "white");

		cardlayout.show(cards, "white");
		
		login = new LoginView(this);
		login.setVisible(true);
		
	}
	
	public PanelHeader getPanel_header() {
		return panel_header;
	}

	public PanelHomeClient getPanel_homeClient() {
		return panel_homeClient;
	}

	public PanelPayment getPanel_payment() {
		return panel_payment;
	}

	public PanelWithdrawalClient getPanel_withdrawClient() {
		return panel_withdrawClient;
	}

	public PanelNewBancario getPanel_bancarioRegister() {
		return panel_bancarioRegister;
	}

	public PanelDepositClient getPanel_depositClient() {
		return panel_depositClient;
	}

	public PanelHomeBancario getPanel_homeBancario() {
		return panel_homeBancario;
	}

	public PanelListAccounts getPanel_listAccounts() {
		return panel_listAccounts;
	}

	public PanelNewClient getPanel_newClient() {
		return panel_newClient;
	}

	public PanelSuccess getPanel_success() {
		return panel_success;
	}

	public PanelTransferClient getPanel_transferClient() {
		return panel_transferClient;
	}

	public PanelAccounts getPanel_accounts() {
		return panel_accounts;
	}

	public PanelProfissionais getPanel_profissionais() {
		return panel_profissionais;
	}

	public PanelBalanco getPanel_balanco() {
		return panel_balanco;
	}

	public PanelAgencias getPanel_agencias() {
		return panel_agencias;
	}

	public void showPanel(String what){
		cardlayout.show(cards, what);
	}
	
	public DefaultView getInstance(){
		return this;
	}

	public Login getL() {
		return l;
	}
	
	public PanelHeader getPanelHeader() {
		return panel_header;
	}
	
	public void doLogout(){
		int dialogResult = JOptionPane.showConfirmDialog(getInstance(), "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
		if(dialogResult == 0){
			l.logout();
			showPanel("white");
			panel_header.setVisibleFields(false);
			login.setVisible(true);
		}
	}

}