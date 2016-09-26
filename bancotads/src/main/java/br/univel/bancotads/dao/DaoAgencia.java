package br.univel.bancotads.dao;

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
		// Não é necessário
	}

	public void update(Agencia t, Integer k) {
		// Não é necessário
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
			ps.setInt(0, k);
			ps.executeQuery();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
			}
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
			ps.setString(0, numeroAgencia);
			ps.executeQuery();
			Agencia a = new Agencia();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				a.setId(rs.getInt("id"));
				a.setNome(rs.getString("name"));
				a.setNumeroAgencia(rs.getString("numeroAgencia"));
			}
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
				m.put(rs.getInt("id"), a);
			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Agencia> search(String field, String text) {
		// TODO Auto-generated method stub
		return null;
	}

}
