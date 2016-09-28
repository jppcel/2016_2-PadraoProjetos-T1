package br.univel.bancotads.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.univel.bancotads.Agencia;
import br.univel.bancotads.Conta;
import br.univel.bancotads.DBConnection;
import br.univel.bancotads.enums.TipoConta;
import br.univel.bancotads.interfaces.Dao;

public class DaoConta implements Dao<Conta, Integer> {

	public void insert(Conta t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO conta (agencia, numeroConta, tipoConta, saldo, dataCriacao) values (?, ?, ?, 0, ?)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, t.getAgencia().getId());
			ps.setString(2, t.getNumeroConta());
			ps.setInt(3, t.getTipoConta().getId());
			ps.setDate(4, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Conta t, Integer k) {
		// sem uso
	}

	public void updateSaldo(BigDecimal bigDecimal, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE conta SET saldo = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setBigDecimal(1, bigDecimal);
			ps.setInt(2, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer k) {
		// Sem uso
	}

	public Conta search(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM conta WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, k);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Conta C = new Conta();
			while(rs.next()){
				C.setId(rs.getInt("id"));
				C.setAgencia(new DaoAgencia().search(rs.getInt("agencia")));
				C.setNumeroConta(rs.getString("numeroConta"));
				C.setUsuario(new DaoUsuario().searchPorConta(rs.getInt("id")));
				C.setTipoConta(TipoConta.values()[rs.getInt("tipoConta")-1]);
				C.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
			return C;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Conta searchConta(String numeroAgencia, String numeroConta){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			Agencia a = new DaoAgencia().search(numeroAgencia);
			sql.append("SELECT * FROM conta WHERE numeroConta = ? AND agencia = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, numeroConta);
			ps.setInt(2, a.getId());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Conta C = new Conta();
			while(rs.next()){
				C.setId(rs.getInt("id"));
				C.setAgencia(a);
				C.setNumeroConta(rs.getString("numeroConta"));
				C.setUsuario(new DaoUsuario().searchPorConta(rs.getInt("id")));
				C.setTipoConta(TipoConta.values()[rs.getInt("tipoConta")-1]);
				C.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
			return C;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Conta> search(String field, String text) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Conta> m = new HashMap<Integer, Conta>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE ").append(field).append(" = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, text);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Conta C = new Conta();
			while(rs.next()){
				C.clear();
				C.setId(rs.getInt("id"));
				C.setAgencia(new DaoAgencia().search(rs.getInt("agencia")));
				C.setNumeroConta(rs.getString("numeroConta"));
				C.setUsuario(new DaoUsuario().searchPorConta(rs.getInt("id")));
				C.setTipoConta(TipoConta.values()[rs.getInt("tipoConta")-1]);
				C.setSaldo(rs.getBigDecimal("saldo"));
				m.put(rs.getInt("id"), C);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Conta> listAll() {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Conta> m = new HashMap<Integer, Conta>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Conta C = new Conta();
			while(rs.next()){
				C.clear();
				C.setId(rs.getInt("id"));
				C.setAgencia(new DaoAgencia().search(rs.getInt("agencia")));
				C.setNumeroConta(rs.getString("numeroConta"));
				C.setUsuario(new DaoUsuario().searchPorConta(rs.getInt("id")));
				C.setTipoConta(TipoConta.values()[rs.getInt("tipoConta")-1]);
				C.setSaldo(rs.getBigDecimal("saldo"));
				m.put(rs.getInt("id"), C);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
