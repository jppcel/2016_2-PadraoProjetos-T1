package br.univel.bancotads.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.univel.bancotads.Agencia;
import br.univel.bancotads.DBConnection;
import br.univel.bancotads.interfaces.Dao;

public class DaoAgencia implements Dao<Agencia, Integer> {

	public void insert(Agencia t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO agencia (name, numeroAgencia, cidade, saldo) values (?, ?, ?, 0.00);");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, t.getNome());
			ps.setString(2, t.getNumeroAgencia());
			ps.setString(3, t.getCidade());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Agencia t, Integer k){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE agencia SET name = ?, numeroAgencia = ? cidade = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, t.getNome());
			ps.setString(2, t.getNumeroAgencia());
			ps.setString(3, t.getCidade());
			ps.setInt(4, k);
			ps.executeUpdate();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
				a.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(BigDecimal t, Integer k){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE agencia SET saldo = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setBigDecimal(1, t);
			ps.setInt(2, k);
			ps.executeUpdate();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
				a.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer k) {
		// Não é necessário
	}

	public Agencia search(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM agencia WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, k);
			ps.executeQuery();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
				a.setCidade(rs.getString("cidade"));
				a.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Agencia search(String numeroAgencia){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM agencia WHERE numeroAgencia = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, numeroAgencia);
			ps.executeQuery();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
				a.setCidade(rs.getString("cidade"));
				a.setSaldo(rs.getBigDecimal("saldo"));
			}
			rs.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Agencia> listAll() {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Agencia> m = new HashMap<Integer, Agencia>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM agencia");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Agencia a = new Agencia();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
				a.setCidade(rs.getString("cidade"));
				a.setSaldo(rs.getBigDecimal("saldo"));
				m.put(rs.getInt("id"), a);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Agencia> search(String field, String text) {
		return null;
	}

}
