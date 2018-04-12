package uepb.web.ufab.model;



public class Aluno extends Pessoa{
	private Curso curso;
	
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}
	
}
