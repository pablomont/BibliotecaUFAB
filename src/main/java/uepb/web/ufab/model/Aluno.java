package uepb.web.ufab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity 
@Table(name= "ALUNO")
public class Aluno extends Pessoa{
	
	
	public enum PeriodoIngresso {S1, S2};
	
	@Enumerated(EnumType.STRING)
	@Column(name="PERIODO_INGRESSO")
	private PeriodoIngresso periodoIngresso;

	
	public PeriodoIngresso getPeriodoIngresso() {
		return periodoIngresso;
	}

	public void setPeriodoIngresso(PeriodoIngresso periodoIngresso) {
		this.periodoIngresso = periodoIngresso;
	}

	public String getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(String anoIngresso) {
		this.anoIngresso = anoIngresso;
	}

	@ManyToOne
    @JoinColumn(name = "CURSO_ID")
	private Curso curso;
	
	@Column(name = "ANO_INGRESSO")
	private String anoIngresso;
	
	@Column(unique=true,name = "MATRICULA")
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

	@Override
	public String toString() {
		return "Aluno [curso=" + curso + ", matricula=" + matricula + ", nomeDaMae=" + nomeDaMae + ", senhaAcesso="
				+ senhaAcesso + ", id=" + id + ", rg=" + rg + ", cpf=" + cpf + ", naturalidade=" + naturalidade
				+ ", nome=" + nome + ", endereco=" + endereco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
