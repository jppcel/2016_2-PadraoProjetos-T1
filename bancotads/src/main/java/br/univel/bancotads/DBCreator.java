package br.univel.bancotads;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCreator {
	final String SQLArchive = "database.sql";
	final String SQLArchiveInserts = "dadosIniciais.sql";
	final String SQLArchiveDrop = "drop.sql";
	
	public boolean createDatabase(){
		FileReader fr;
		BufferedReader br;
		
		try {
			Connection c = DBConnection.openConnection();
			PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM INFORMATION_SCHEMA.TABLES where table_schema = 'PUBLIC';");
			ps.executeQuery();
			ResultSet rs = ps.getResultSet();
			rs.next();
			if(rs.getInt("COUNT(*)") == 0){
			
				fr = new FileReader(SQLArchive);
				br = new BufferedReader(fr);
				
				String linha = br.readLine();
				
				StringBuilder sql = new StringBuilder();
				
				while(linha != null){
					sql.append(linha);
					linha = br.readLine();
				}
				
				br.close();
				fr.close();
				fr = new FileReader(SQLArchiveInserts);
				br = new BufferedReader(fr);
				
				linha = br.readLine();
				
				while(linha != null){
					sql.append(linha);
					linha = br.readLine();
				}
				ps = c.prepareStatement(sql.toString());
				ps.executeUpdate();
				
				br.close();
				fr.close();
				
			}
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean dropDatabase(){
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(SQLArchiveDrop);
			br = new BufferedReader(fr);
			
			String linha = br.readLine();
			
			StringBuilder sql = new StringBuilder();
			
			while(linha != null){
				sql.append(linha);
				linha = br.readLine();
			}
			Connection c = DBConnection.openConnection();
			PreparedStatement ps = c.prepareStatement(sql.toString());
			ps.executeUpdate();
			
			br.close();
			fr.close();
			return true;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean restoreDatabaseDefault(){
		if(dropDatabase() && createDatabase()){
			return true;
		}
		throw new RuntimeException("Não foi possível restaurar as tabelas.");
	}
}
