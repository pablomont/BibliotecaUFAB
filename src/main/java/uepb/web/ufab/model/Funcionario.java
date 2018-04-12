package uepb.web.ufab.model;


public class Funcionario extends Pessoa {

	public enum NivelAcesso {ADMIN,OPERADOR}
	private NivelAcesso nivelAcesso;
	
	public Funcionario() {
	
	}
	
	public NivelAcesso getnivelAcesso() {
		return nivelAcesso;
	}


	public void setnivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}

	
	@Override
	public String toString() {
		return "Funcionario [nome=" + name + ", cpf=" + cpf + "]";
	}
	
	
	
}
