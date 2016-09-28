package br.univel.bancotads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.univel.bancotads.DBConnection;
import br.univel.bancotads.Pessoa;
import br.univel.bancotads.enums.Genero;
import br.univel.bancotads.interfaces.Dao;

public class DaoPessoa implements Dao<Pessoa, Integer>{

	public void insert(Pessoa t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO pessoa (name, born, cpf, genero, dataCadastro) values (?, ?, ?, ?, ?)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, t.getNome());
			ps.setDate(2, new java.sql.Date(t.getDataNascimento().getTime()));
			ps.setString(3, t.getCpf());
			ps.setInt(4, t.getGenero().getId());
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Pessoa t, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE pessoa SET name = ?, genero = ?, dataModificacao = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, t.getNome());
			ps.setInt(2, t.getGenero().getId());
			ps.setDate(3, new Date(new java.util.Date().getTime()));
			ps.setInt(4, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer k) {
		// Sem uso
		// O desativar está conectado ao usuário
	}

	public Pessoa search(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM pessoa WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, k);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Pessoa p = new Pessoa();
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("name"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNascimento(new java.util.Date(rs.getDate("born").getTime()));
				p.setGenero(Genero.values()[rs.getInt("genero")]);
			}
			rs.close();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Pessoa> search(String field, String text) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Pessoa> m = new HashMap<Integer, Pessoa>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM pessoa WHERE ").append(field).append(" = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, text);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Pessoa p = new Pessoa();
			while(rs.next()){
				p.clear();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("name"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNascimento(new java.util.Date(rs.getDate("born").getTime()));
				p.setGenero(Genero.values()[rs.getInt("genero")]);
				m.put(rs.getInt("id"), p);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Pessoa> listAll() {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Pessoa> m = new HashMap<Integer, Pessoa>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM pessoa");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Pessoa p = new Pessoa();
			while(rs.next()){
				p.clear();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("name"));
				p.setCpf(rs.getString("cpf"));
				p.setDataNascimento(new java.util.Date(rs.getDate("born").getTime()));
				p.setGenero(Genero.values()[rs.getInt("genero")]);
				m.put(rs.getInt("id"), p);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
