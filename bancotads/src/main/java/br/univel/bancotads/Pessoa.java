package br.univel.bancotads;

import java.util.Date;

import br.univel.bancotads.enums.EstadoCivil;
import br.univel.bancotads.enums.Genero;

public class Pessoa {
	private String nome;
	private String sobrenome;
	private EstadoCivil estadoCivil;
	private Genero genero;
	private String nacionalidade;
	private String naturalidade;
	private Date dataNascimento;
	private String cpf; // Devido a diversos motivos, como por exemplo, números começados por 0 e etc.
	private String rg;
	private String orgaoExpeditor;
	private Date dataExpedicao;
	private String email;
	private String telefone;
	private String celular;
	private String telefoneComercial;
	private String ramalTelefoneComercial;
	private String telefoneRecado;
	private String pessoaRecado;
	private String nomeMae;
	private String nomePai;
	private String enderecoLogradouro;
	private String enderecoNumero; // Pode ser S/N(Sem número)
	private String enderecoComplemento;
	private String enderecoBairro;
	private String enderecoCidade;
	private String enderecoEstado;
	private String enderecoPais;
	private String enderecoCEP; // Devido a diversos motivos, como por exemplo, números começados por 0 e etc.

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getNaturalidade() {
		return naturalidade;
	}
	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}
	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}
	public Date getDataExpedicao() {
		return dataExpedicao;
	}
	public void setDataExpedicao(Date dataExpedicao) {
		this.dataExpedicao = dataExpedicao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getTelefoneComercial() {
		return telefoneComercial;
	}
	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}
	public String getRamalTelefoneComercial() {
		return ramalTelefoneComercial;
	}
	public void setRamalTelefoneComercial(String ramalTelefoneComercial) {
		this.ramalTelefoneComercial = ramalTelefoneComercial;
	}
	public String getTelefoneRecado() {
		return telefoneRecado;
	}
	public void setTelefoneRecado(String telefoneRecado) {
		this.telefoneRecado = telefoneRecado;
	}
	public String getPessoaRecado() {
		return pessoaRecado;
	}
	public void setPessoaRecado(String pessoaRecado) {
		this.pessoaRecado = pessoaRecado;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getEnderecoLogradouro() {
		return enderecoLogradouro;
	}
	public void setEnderecoLogradouro(String enderecoLogradouro) {
		this.enderecoLogradouro = enderecoLogradouro;
	}
	public String getEnderecoNumero() {
		return enderecoNumero;
	}
	public void setEnderecoNumero(String enderecoNumero) {
		this.enderecoNumero = enderecoNumero;
	}
	public String getEnderecoComplemento() {
		return enderecoComplemento;
	}
	public void setEnderecoComplemento(String enderecoComplemento) {
		this.enderecoComplemento = enderecoComplemento;
	}
	public String getEnderecoBairro() {
		return enderecoBairro;
	}
	public void setEnderecoBairro(String enderecoBairro) {
		this.enderecoBairro = enderecoBairro;
	}
	public String getEnderecoCidade() {
		return enderecoCidade;
	}
	public void setEnderecoCidade(String enderecoCidade) {
		this.enderecoCidade = enderecoCidade;
	}
	public String getEnderecoEstado() {
		return enderecoEstado;
	}
	public void setEnderecoEstado(String enderecoEstado) {
		this.enderecoEstado = enderecoEstado;
	}
	public String getEnderecoPais() {
		return enderecoPais;
	}
	public void setEnderecoPais(String enderecoPais) {
		this.enderecoPais = enderecoPais;
	}
	public String getEnderecoCEP() {
		return enderecoCEP;
	}
	public void setEnderecoCEP(String enderecoCEP) {
		this.enderecoCEP = enderecoCEP;
	}	
}
