package model;

import util.Cpf;

public class Aluno {
	private Curso curso;
	private String nome;
	private String cpf;

	public Curso getCurso() {
		return curso;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(Cpf.isCPF(cpf))
			this.cpf = cpf;
		else
			throw new IllegalArgumentException("CPF inválido");
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
