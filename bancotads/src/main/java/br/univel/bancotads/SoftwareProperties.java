package br.univel.bancotads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class SoftwareProperties {
	private Properties p = new Properties();
	private String name = "config.properties";
	
	public SoftwareProperties(){
		File file = new File(name);
		if(!file.exists()){
			recordDefault();
		}else{
			readFile();
		}
	}
	
	public void recordDefault(){
		p.setProperty("DBname", "BancoTADS_test");
		p.setProperty("DBusername", "sa");
		p.setProperty("DBpassword", "sa");
		p.setProperty("DBIP", "~");
		recordInFile();
	}
	
	public String getProperty(String key){
		return p.getProperty(key);
	}
	
	public void setProperty(String key, String value){
		p.setProperty(key, value);
		recordInFile();
	}
	
	private void recordInFile(){
		try {
			p.store(new FileWriter(new File(name)), "Banco TADS infs");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void readFile(){
		try {
			p.load(new FileReader(new File(name)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
