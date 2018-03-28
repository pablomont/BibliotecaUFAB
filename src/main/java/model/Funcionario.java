package model;

import util.Cpf;

public class Funcionario {

	public enum NivelAcesso {ADMIN,OPERADOR}
	private NivelAcesso nivelAcesso;
	private String nome;
	private String cpf;
	
	
	public Funcionario(String nome, NivelAcesso nivelAcesso, String cpf) {
		setNome(nome);
		setCpf(cpf);
		setnivelAcesso(nivelAcesso);
	}
	
	public NivelAcesso getnivelAcesso() {
		return nivelAcesso;
	}


	public void setnivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
	
}
