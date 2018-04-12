package uepb.web.ufab.model;

public class Curso {

	public enum Tipo{GRADUAÇÃO, POS}
	
	private Tipo tipoCurso;
	private String nome;
	private String area;

	public Curso() {
		
	}
	
	

	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Tipo getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(Tipo tipoCurso) {
		this.tipoCurso = tipoCurso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoCurso == null) ? 0 : tipoCurso.hashCode());
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
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipoCurso != other.tipoCurso)
			return false;
		return true;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "Curso [nome=" + getNome() + "]";
	}
	
	
		
}
