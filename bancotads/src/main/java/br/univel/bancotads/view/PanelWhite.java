package br.univel.bancotads.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

public class PanelWhite extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8294584221931770298L;

	/**
	 * Create the panel.
	 */
	public PanelWhite() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0};
		gridBagLayout.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{Double.MIN_VALUE};
		setLayout(gridBagLayout);
	}

}
