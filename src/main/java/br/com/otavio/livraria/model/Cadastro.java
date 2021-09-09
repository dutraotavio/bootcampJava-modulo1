package br.com.otavio.livraria.model;

public class Cadastro {

	private String nome;
	private String email;
	private String dataDeNascimento;
	private String curriculo;
	
	public Cadastro() {}

	public Cadastro(String nome, String email, String dataDeNascimento, String curriculo) {
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.curriculo = curriculo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}

}
