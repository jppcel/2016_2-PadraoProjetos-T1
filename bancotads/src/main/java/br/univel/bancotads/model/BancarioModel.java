package br.univel.bancotads.model;

import java.util.Map;
import java.util.Map.Entry;

import javax.swing.table.AbstractTableModel;
import br.univel.bancotads.Usuario;
	
	public class BancarioModel extends AbstractTableModel {
	    
	    private Map<Integer,Usuario> lista;
	    
	    private String[] columnNames = {"Nome", "Username"};
	    
	    @Override
	    public String getColumnName(int index) {
	        return columnNames[index];
	    }

	    public BancarioModel(Map<Integer,Usuario> listaU) {
	        this.lista = listaU;
	    }

	    public int getRowCount() {
	        return lista.size();
	    }

	    public int getColumnCount() {
			return 2;
	    }

	   public Object getValueAt(int row, int col) {
		   Usuario u = lista.get(row);

			switch (col) {
				case 0:
					return u.getPessoa().getNome();
				case 1:
					return u.getUsername();
	        }          
			return null;
	    }
	    
	}




