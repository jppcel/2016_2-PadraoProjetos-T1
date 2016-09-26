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
import br.univel.bancotads.enums.TipoConta;
import br.univel.bancotads.enums.TipoUsuario;
import br.univel.bancotads.interfaces.Dao;

public class DaoConta implements Dao<Conta, Integer> {

	public void insert(Conta t) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("INSERT INTO conta (agencia, numeroConta, tipoConta, saldo, dataCriacao) values (?, ?, ?, 0, ?)");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, t.getAgencia().getId());
			ps.setString(1, t.getNumeroConta());
			ps.setInt(2, t.getTipoConta().getId());
			ps.setDate(3, new Date(new java.util.Date().getTime()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void update(Conta t, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE conta SET tipoConta = ?, dataModificacao = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, );
			ps.setDate(1, new Date(new java.util.Date().getTime()));
			ps.setInt(2, k);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateSaldo(Integer v, Integer k) {
		StringBuilder sql = new StringBuilder();
		try {
			Connection c = DBConnection.openConnection();
			sql.append("UPDATE conta SET saldo = ? WHERE id = ?");
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.setInt(0, v);
			ps.setInt(1, k);
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
			ps.setInt(0, k);
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			Conta C = new Conta();
			while(rs.next()){
				C.setId(rs.getInt("id"));
				C.setAgencia(new DaoAgencia().search(rs.getInt("agencia")));
				C.setNumeroConta(rs.getString("numeroConta"));
				C.setTipoConta(TipoConta.values()[rs.getInt("tipoConta")]);
				C.setSaldo(rs.getBigDecimal("saldo"));
			}
			return C;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Conta search(String username){
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

	public Map<Integer, Conta> search(String field, String text) {
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

	public Map<Integer, Conta> listAll() {
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
