package br.univel.bancotads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.univel.bancotads.Conta;
import br.univel.bancotads.DBConnection;
import br.univel.bancotads.Movimentacao;
import br.univel.bancotads.enums.TipoOperacao;
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
		// Sem uso
		
	}

	@Override
	public void delete(Integer k) {
		// Sem uso
		
	}

	@Override
	public Movimentacao search(Integer k) {
		// Sem uso
		return null;
	}

	@Override
	public Map<Integer, Movimentacao> search(String field, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	public Map<Integer, Movimentacao> search(Date dinit, Date dend) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Movimentacao> m = new HashMap<Integer, Movimentacao>();
		int i = 0;
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM movimentacao WHERE dataMovimentacao >= ? AND dataMovimentacao <= ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setDate(1, new java.sql.Date(dinit.getTime()));
			ps.setDate(2, new java.sql.Date(dend.getTime()));
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Movimentacao M = null;
			while(rs.next()){
				M = new Movimentacao();
				M.setId(rs.getInt("id"));
				M.setC(new DaoConta().search(rs.getInt("conta")));
				M.setTo(TipoOperacao.values()[rs.getInt("tipoOperacao")-1]);
				M.setU(new DaoUsuario().search(rs.getInt("usuario")));
				M.setValor(rs.getBigDecimal("valor"));
				M.setData(new java.util.Date(rs.getDate("dataMovimentacao").getTime()));
				M.setMotivoMovimentacao(rs.getString("motivoMovimentacao"));
				m.put(i++, M);
			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<Integer, Movimentacao> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
