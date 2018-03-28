package biblioteca;


public class Funcionario {

	public enum NivelAcesso {ADMIN,OPERADOR}
	private NivelAcesso nivelAcesso;
	private String nome;
	
	public Funcionario(NivelAcesso nivelAcesso) {
		this.setnivelAcesso(nivelAcesso);
	}
	
	public Funcionario(String nome, NivelAcesso nivelAcesso) {
		this.setnivelAcesso(nivelAcesso);
		setNome(nome);
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
	
	
}
