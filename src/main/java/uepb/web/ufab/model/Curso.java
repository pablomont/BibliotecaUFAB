package uepb.web.ufab.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name= "CURSO")
public class Curso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private int id;	
	
	public enum Tipo{GRADUACAO, POS}
	
	public int getId() {
		return id;
	}

	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_CURSO")
	private Tipo tipoCurso;
	
	@Column(name = "NOME_CURSO")
	private String nomeCurso;
	@Column(name = "AREA_CURSO")
	private String areaCurso;

	public String getNome() {
		return nomeCurso;
	}

	public void setNome(String nome) {
		this.nomeCurso = nome;
	}


	public Tipo getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(Tipo tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	public String getArea() {
		return areaCurso;
	}

	public void setArea(String area) {
		this.areaCurso = area;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Curso other = (Curso) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", tipoCurso=" + tipoCurso + ", nomeCurso=" + nomeCurso + ", areaCurso=" + areaCurso
				+ "]";
	}

	
}
