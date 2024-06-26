package entidade;

public class Usuario {
	private String nome;
	private String email;
	private String senha;
	private int nvAcesso;
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public int getNvAcesso() {
		return nvAcesso;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void setNvAcesso(int nvAcesso) {
		this.nvAcesso = nvAcesso;
	}
}
