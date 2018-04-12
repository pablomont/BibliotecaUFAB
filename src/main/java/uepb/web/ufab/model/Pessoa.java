package uepb.web.ufab.model;

import util.Cpf;

public class Pessoa {
	
	protected String name;
	protected String cpf;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
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
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pessoa [Nome=" + getName() + ", Cpf=" + getCpf() + "]";
	}
	
	
	
	
}
