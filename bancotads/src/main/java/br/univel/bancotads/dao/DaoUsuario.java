package br.univel.bancotads.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import br.univel.bancotads.DBConnection;
import br.univel.bancotads.Usuario;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.interfaces.Dao;

public class DaoUsuario implements Dao<Usuario, Integer> {

	public void insert(Usuario t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO usuario (pessoa, username, password, passwordOperacoes, tipoUsuario, conta, dataCriacao, ativo) values (?, ?, ?, ?, ?, ?, ?, true)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, t.getPessoa().getId());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getPasswordOperacoes());
			ps.setInt(5, t.getTu().getId());
			if(t.getTu().getId() == TipoUsuario.CLIENTE.getId()){
				ps.setInt(6, t.getConta().getId());
			}else{
				ps.setNull(6, java.sql.Types.INTEGER);
			}
			ps.setDate(7, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Usuario t, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE usuario SET pessoa = ?, username = ?, password = ?, passwordOperacoes = ?, tipoUsuario = ?, conta = ?, dataModificacao = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, t.getPessoa().getId());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getPasswordOperacoes());
			ps.setInt(5, t.getTu().getId());
			if(t.getTu().getId() == TipoUsuario.CLIENTE.getId()){
				ps.setInt(6, t.getConta().getId());
			}else{
				ps.setNull(6, java.sql.Types.INTEGER);
			}
			ps.setDate(7, new Date(new java.util.Date().getTime()));
			ps.setInt(8, k);
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
			ps.setBoolean(1, true);
			ps.setInt(2, k);
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
			ps.setInt(1, k);
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId()){
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				}
				u.setAtivo(rs.getBoolean("ativo"));
			}
			rs.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Usuario searchPorConta(Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE conta = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, k);
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId())
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				u.setAtivo(rs.getBoolean("ativo"));
			}
			rs.close();
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
			ps.setString(1, username);
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")-1]);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId())
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				u.setAtivo(rs.getBoolean("ativo"));
			}
			rs.close();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Usuario> search(TipoUsuario tu) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Usuario> m = new HashMap<Integer, Usuario>();
		int i = 0;
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE tipoUsuario = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(1, tu.getId());
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.clear();
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(tu);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId())
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				u.setAtivo(rs.getBoolean("ativo"));
				m.put(i++, u);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Usuario> search(String field, String text) {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Usuario> m = new HashMap<Integer, Usuario>();
		int i = 0;
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario WHERE ").append(field).append(" = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setString(1, text);
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.clear();
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId())
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				u.setAtivo(rs.getBoolean("ativo"));
				m.put(i++, u);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Map<Integer, Usuario> listAll() {
		StringBuilder sql = new StringBuilder();
		Map<Integer, Usuario> m = new HashMap<Integer, Usuario>();
		int i = 0;
		try {
			Connection c = DBConnection.openConnection();
			sql.append("SELECT * FROM usuario");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeQuery();
			Usuario u = new Usuario();
			DaoPessoa daop = new DaoPessoa();
			ResultSet rs = ps.getResultSet();
			while(rs.next()){
				u.clear();
				u.setIdUsuario(rs.getInt("id"));
				u.setPessoa(daop.search(rs.getInt("pessoa")));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setPasswordOperacoes(rs.getString("passwordOperacoes"));
				u.setTu(TipoUsuario.values()[rs.getInt("tipoUsuario")]);
				if(u.getTu().getId() == TipoUsuario.CLIENTE.getId())
					u.setConta(new DaoConta().search(rs.getInt("conta")));
				u.setAtivo(rs.getBoolean("ativo"));
				m.put(i++, u);
			}
			rs.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
