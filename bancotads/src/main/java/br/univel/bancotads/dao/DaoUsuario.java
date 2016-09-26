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
import br.univel.bancotads.Pessoa;
import br.univel.bancotads.Usuario;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.interfaces.Dao;

public class DaoUsuario implements Dao<Usuario, Integer> {

	public void insert(Usuario t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO usuario (pessoa, username, password, tipoUsuario, conta, dataCriacao, ativo) values (?, ?, ?, ?, ?, ?, true)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, t.getPessoa().getId());
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setInt(3, t.getTu().getId());
			ps.setInt(4, t.getConta().getId());
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Usuario t, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE usuario SET pessoa = ?, username = ?, password = ?, tipoUsuario = ?, conta = ?, dataModificacao = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, t.getPessoa().getId());
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setInt(3, t.getTu().getId());
			ps.setInt(4, t.getConta().getId());
			ps.setDate(5, new Date(new java.util.Date().getTime()));
			ps.setInt(6, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer k) {
		unactivate(k);
	}

	public void unactivate(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE usuario SET ativo = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setBoolean(0, false);
			ps.setInt(1, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void activate(Integer k){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE usuario SET ativo = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setBoolean(0, true);
			ps.setInt(1, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Usuario search(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, k);
			ps.executeQuery();
			Usuario u = new Usuario();
			Pessoa p = new Pessoa();
			Conta C = new Conta();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setIdUsuario(rs.getInt("id"));
				p.setId(rs.getInt("pessoa"));
				u.setPessoa(p);
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				C.setId(rs.getInt("conta"));
				u.setConta(C);
				u.setAtivo(rs.getBoolean("ativo"));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Usuario search(String username){
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE username = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(0, username);
			ps.executeQuery();
			Usuario u = new Usuario();
			Pessoa p = new Pessoa();
			Conta C = new Conta();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setIdUsuario(rs.getInt("id"));
				p.setId(rs.getInt("pessoa"));
				u.setPessoa(p);
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				C.setId(rs.getInt("conta"));
				u.setConta(C);
				u.setAtivo(rs.getBoolean("ativo"));
			}
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Usuario> search(String field, String text) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Usuario> m = new HashMap<Integer, Usuario>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE ").append(field).append(" = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(0, text);
			ps.executeQuery();
			Usuario u = new Usuario();
			Pessoa p = new Pessoa();
			Conta C = new Conta();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.clear();
				u.setIdUsuario(rs.getInt("id"));
				p.setId(rs.getInt("pessoa"));
				u.setPessoa(p);
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				C.setId(rs.getInt("conta"));
				u.setConta(C);
				u.setAtivo(rs.getBoolean("ativo"));
				m.put(rs.getInt("id"), u);
			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Usuario> listAll() {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Usuario> m = new HashMap<Integer, Usuario>();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeQuery();
			Usuario u = new Usuario();
			Pessoa p = new Pessoa();
			Conta C = new Conta();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.clear();
				u.setIdUsuario(rs.getInt("id"));
				p.setId(rs.getInt("pessoa"));
				u.setPessoa(p);
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				C.setId(rs.getInt("conta"));
				u.setConta(C);
				u.setAtivo(rs.getBoolean("ativo"));
				m.put(rs.getInt("id"), u);
			}
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
