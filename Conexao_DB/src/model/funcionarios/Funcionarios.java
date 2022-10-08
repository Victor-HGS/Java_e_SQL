package model.funcionarios;

public class Funcionarios {
	
	// Atributos dos funcionários para inclusão no Database
	private int id;
	private String primeiro_nome;
	private String ultimo_nome;
	private String email;
	private String cpf;
	private String telefone;
	
	// Getters e Setters dos atributos
	
	// Id dos funcionários
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	
	// Primeiro nome dos funcionários
	public String getPrimeiro_nome() {
		return primeiro_nome;
	}
	public void setPrimeiro_nome(String primeiro_nome) {
		this.primeiro_nome = primeiro_nome;
	}
	
	// Último nome dos funcionários
	public String getUltimo_nome() {
		return ultimo_nome;
	}
	public void setUltimo_nome(String ultimo_nome) {
		this.ultimo_nome = ultimo_nome;
	}
	
	// E-mail dos funcionários
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// CPF dos funcionários
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	// Telefone dos funcionários
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
}
