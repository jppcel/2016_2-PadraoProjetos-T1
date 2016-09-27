package br.univel.bancotads.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import br.univel.bancotads.Login;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5320876147202606774L;
	private JPanel contentPane;
	private JTextField tf_usuario;
	private JPasswordField tf_senha;
	private JLabel lblNewLabel_1;


	/**
	 * Create the frame.
	 */
	public LoginView(final DefaultView dv) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/org/freedesktop/tango/22x22/apps/system-users.png")));
		setResizable(false);
		setAlwaysOnTop(true);
		setTitle("Login - Banco TADS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		lblNewLabel_1 = new JLabel("Login");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tf_usuario = new JTextField();
		tf_usuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					makeLogin(dv);
				}
			}
		});
		tf_usuario.setToolTipText("Usuário");
		GridBagConstraints gbc_tf_usuario = new GridBagConstraints();
		gbc_tf_usuario.insets = new Insets(0, 0, 5, 0);
		gbc_tf_usuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_usuario.gridx = 0;
		gbc_tf_usuario.gridy = 1;
		contentPane.add(tf_usuario, gbc_tf_usuario);
		tf_usuario.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Senha");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		tf_senha = new JPasswordField();
		tf_senha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					makeLogin(dv);
				}
			}
		});
		tf_senha.setToolTipText("Senha");
		GridBagConstraints gbc_tf_senha = new GridBagConstraints();
		gbc_tf_senha.insets = new Insets(0, 0, 5, 0);
		gbc_tf_senha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_senha.gridx = 0;
		gbc_tf_senha.gridy = 3;
		contentPane.add(tf_senha, gbc_tf_senha);
		tf_senha.setColumns(10);
		
		JButton btn_login = new JButton("Login");
		btn_login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				makeLogin(dv);
			}
		});
		GridBagConstraints gbc_btn_login = new GridBagConstraints();
		gbc_btn_login.anchor = GridBagConstraints.EAST;
		gbc_btn_login.gridx = 0;
		gbc_btn_login.gridy = 4;
		contentPane.add(btn_login, gbc_btn_login);
	}
	
	private void makeLogin(final DefaultView dv){
		if(!tf_usuario.getText().isEmpty()){
			if(!String.copyValueOf(tf_senha.getPassword()).isEmpty()){
				final Login l = dv.getL();
				l.setLogin(tf_usuario.getText());
				if(l.hasLogin()){
					l.setSenha(String.copyValueOf(tf_senha.getPassword()));
					if(!l.checkSenha()){
						tf_usuario.setText("");
						tf_senha.setText("");
						JOptionPane.showMessageDialog(dv, "Usuário ou senha incorretos!");
					}else{
						l.setInitialPanel();
						setVisible(false);
					}
				}else{
					tf_usuario.setText("");
					tf_senha.setText("");
					JOptionPane.showMessageDialog(dv, "Usuário inexistente!");
				}
			}else{
				JOptionPane.showMessageDialog(dv, "O campo de senha é obrigatório!");
			}
		}else{
			JOptionPane.showMessageDialog(dv, "O campo de login é obrigatório!");
		}
	}
}
