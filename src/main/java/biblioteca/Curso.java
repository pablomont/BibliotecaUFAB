package biblioteca;

public class Curso {

	public enum Tipo{GRADUA��O, POS}
	
	private Tipo tipoCurso;

	public Curso(Tipo tipoCurso) {
		setTipoCurso(tipoCurso);
	}

	public Tipo getTipoCurso() {
		return tipoCurso;
	}

	public void setTipoCurso(Tipo tipoCurso) {
		this.tipoCurso = tipoCurso;
	}
	
	
	
}
