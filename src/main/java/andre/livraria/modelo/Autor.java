package andre.livraria.modelo;

import java.time.LocalDate;

public class Autor {
	
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private String curriculo;

	public Autor(String nome, String email, LocalDate dataNascimento, String curriculo) {
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.curriculo = curriculo;
	}
	
	@Override
	public String toString() {
		String saida =
				(this.nome + ", " +
				this.email + ", " +
				this.dataNascimento + ", " +	
				this.curriculo);
		return saida;
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(String curriculo) {
		this.curriculo = curriculo;
	}
	
	public void cadastra() {
		
	}
	
	public void lista() {
		
	}
	
}
