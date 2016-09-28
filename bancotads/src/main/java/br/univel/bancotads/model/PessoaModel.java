package br.univel.bancotads.model;

import java.util.Map;

import javax.swing.table.AbstractTableModel;

import br.univel.bancotads.Pessoa;
import br.univel.bancotads.Usuario;

public class PessoaModel extends AbstractTableModel{
	
	private Map<Integer,Pessoa> lista;
    
    private String[] columnNames = {"Nome", "CPF"};
    
    @Override
    public String getColumnName(int index) {
        return columnNames[index];
    }

    public PessoaModel(Map<Integer,Pessoa> listaP) {
        this.lista = listaP;
    }

    public int getRowCount() {
        return lista.size();
    }

    public int getColumnCount() {
		return 2;
    }

   public Object getValueAt(int row, int col) {
	   Pessoa p = lista.get(row);

		switch (col) {
			case 0:
				return p.getNome();
			case 1:
				return p.getCpf();
        }          
		return null;
    }

}
