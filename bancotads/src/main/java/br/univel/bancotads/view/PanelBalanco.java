package br.univel.bancotads.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.Dimension;

public class PanelBalanco extends JPanel{
	private JTextField tfDepositos;
	private JTextField tfSaques;
	private JTextField tfCaixa;
	private JTextField tfDatainicio;
	private JTextField tfDatafim;
	private JTable table;
	
	public PanelBalanco(final DefaultView df) {
		setLayout(null);
		final Calendar calendar = Calendar.getInstance();
		final DateFormat ndf = new SimpleDateFormat("dd/MM/yyyy");
		
		JButton btVoltar = new JButton("Voltar");
		btVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				df.showPanel("homeBancario");
			}
		});
		btVoltar.setBounds(622, 366, 78, 25);
		add(btVoltar);
		
		JLabel jlDepositos = new JLabel("Total de depósitos:");
		jlDepositos.setBounds(22, 294, 144, 15);
		add(jlDepositos);
		
		JLabel jlSaques = new JLabel("Total de saques:");
		jlSaques.setBounds(39, 321, 127, 15);
		add(jlSaques);
		
		tfDepositos = new JTextField();
		tfDepositos.setEditable(false);
		tfDepositos.setBounds(166, 292, 78, 19);
		add(tfDepositos);
		tfDepositos.setColumns(10);
		
		tfSaques = new JTextField();
		tfSaques.setEditable(false);
		tfSaques.setColumns(10);
		tfSaques.setBounds(166, 321, 78, 19);
		add(tfSaques);
		
		JLabel lblTotalEmCaixa = new JLabel("Total em caixa:");
		lblTotalEmCaixa.setBounds(292, 294, 116, 15);
		add(lblTotalEmCaixa);
		
		tfCaixa = new JTextField();
		tfCaixa.setEditable(false);
		tfCaixa.setColumns(10);
		tfCaixa.setBounds(402, 294, 78, 19);
		add(tfCaixa);
		
		tfDatainicio = new JTextField();
		tfDatainicio.setBounds(195, 370, 114, 19);
		add(tfDatainicio);
		tfDatainicio.setColumns(10);
		tfDatainicio.setText(ndf.format(calendar.getTime()));
		
		tfDatafim = new JTextField();
		tfDatafim.setColumns(10);
		tfDatafim.setBounds(313, 370, 114, 19);
		add(tfDatafim);
		tfDatafim.setText(ndf.format(calendar.getTime()));
		
		JButton btremano = new JButton("");
		btremano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatainicio.getText()));
					calendar.add(Calendar.YEAR, -1);
					tfDatainicio.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btremano.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/22x22/actions/media-skip-backward.png")));
		btremano.setBounds(10, 366, 57, 25);
		add(btremano);
		
		JButton btremmes = new JButton("");
		btremmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatainicio.getText()));
					calendar.add(Calendar.MONTH, -1);
					tfDatainicio.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btremmes.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/22x22/actions/media-seek-backward.png")));
		btremmes.setBounds(71, 366, 57, 25);
		add(btremmes);
		
		JButton btremdia = new JButton("");
		btremdia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatainicio.getText()));
					calendar.add(Calendar.DAY_OF_MONTH, -1);
					tfDatainicio.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btremdia.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/22x22/actions/go-previous.png")));
		btremdia.setBounds(132, 366, 57, 25);
		add(btremdia);
		
		JButton btadddia = new JButton("");
		btadddia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatafim.getText()));
					calendar.add(Calendar.DAY_OF_MONTH, 1);
					tfDatafim.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
				
			}
		});
		btadddia.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/22x22/actions/go-next.png")));
		btadddia.setBounds(433, 366, 57, 25);
		add(btadddia);
		
		JButton btnaddmes = new JButton("");
		btnaddmes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatafim.getText()));
					calendar.add(Calendar.MONTH, 1);
					tfDatafim.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnaddmes.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/22x22/actions/media-seek-forward.png")));
		btnaddmes.setBounds(495, 366, 57, 25);
		add(btnaddmes);
		
		JButton btnaddano = new JButton("");
		btnaddano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					calendar.setTime(ndf.parse(tfDatafim.getText()));
					calendar.add(Calendar.YEAR, 1);
					tfDatafim.setText(ndf.format(calendar.getTime()));
				} catch (ParseException e1) {
					e1.printStackTrace();
				} 
			}
		});
		btnaddano.setIcon(new ImageIcon(PanelBalanco.class.getResource("/org/freedesktop/tango/32x32/actions/media-skip-forward.png")));
		btnaddano.setBounds(556, 366, 57, 25);
		add(btnaddano);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 684, 276);
		add(scrollPane);
		
		table = new JTable();
		table.setPreferredSize(new Dimension(450, 400));
		scrollPane.setViewportView(table);
		
	}
}


