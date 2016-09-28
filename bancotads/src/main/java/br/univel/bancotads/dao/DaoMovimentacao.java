package br.univel.bancotads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import br.univel.bancotads.DBConnection;
import br.univel.bancotads.Movimentacao;
import br.univel.bancotads.interfaces.Dao;

public class DaoMovimentacao implements Dao<Movimentacao, Integer> {

	@Override
	public void insert(Movimentacao t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO movimentacao (conta, tipoOperacao, usuario, valor, dataMovimentacao, motivoMovimentacao) values (?, ?, ?, ?, ?, ?)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, t.getC().getId());
			ps.setInt(2, t.getTo().getId());
			ps.setInt(3, t.getU().getIdUsuario());
			ps.setBigDecimal(4, t.getValor());
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.setString(6, t.getMotivoMovimentacao());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Movimentacao t, Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movimentacao search(Integer k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Movimentacao> search(String field, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, Movimentacao> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
