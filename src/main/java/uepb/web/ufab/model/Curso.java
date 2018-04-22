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

	
}
