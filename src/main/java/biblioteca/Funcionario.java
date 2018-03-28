package biblioteca;

import java.util.InputMismatchException;

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
	
	//https://www.devmedia.com.br/validando-o-cpf-em-uma-aplicacao-java/22097
	public static boolean isCPF(String CPF) { 

	    if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999") ||
	       (CPF.length() != 11))
	       return(false);

	    char dig10, dig11;
	    int sm, i, r, num, peso;


	    try {

	      sm = 0;
	      peso = 10;
	      for (i=0; i<9; i++) {                 
	        num = (int)(CPF.charAt(i) - 48); 
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig10 = '0';
	      else dig10 = (char)(r + 48); 

	      sm = 0;
	      peso = 11;
	      for(i=0; i<10; i++) {
	        num = (int)(CPF.charAt(i) - 48);
	        sm = sm + (num * peso);
	        peso = peso - 1;
	      }

	      r = 11 - (sm % 11);
	      if ((r == 10) || (r == 11))
	         dig11 = '0';
	      else dig11 = (char)(r + 48);

	
	      if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
	         return(true);
	      else return(false);
	    } catch (InputMismatchException erro) {
	        return(false);
	    }
	  }

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(isCPF(cpf))
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
