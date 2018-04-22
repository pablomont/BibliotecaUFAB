package uepb.web.ufab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name= "ALUNO")
public class Aluno extends Pessoa{
	
	@ManyToOne
    @JoinColumn(name = "CURSO_ID")
	private Curso curso;
	
	@Column(name = "MATRICULA")
	private String matricula;
	
	@Column(name = "NOME_DA_MAE")
	private String nomeDaMae;
	
	@Column(name = "SENHA_ACESSO")
	private String senhaAcesso;
	
	public void setCurso(Curso curso){
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}
	
	

}
