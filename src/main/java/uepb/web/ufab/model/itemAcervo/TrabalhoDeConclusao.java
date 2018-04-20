package uepb.web.ufab.model.itemAcervo;

import java.util.List;

public class TrabalhoDeConclusao extends ItemAcervo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum TipoTrabalho {MONOGRAFIA, TESTE, DISSERTACAO};

	private List<String> autores;
	private List<String> orientadores;
	private String local;
	private TipoTrabalho tipo;
	
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public List<String> getOrientadores() {
		return orientadores;
	}
	public void setOrientadores(List<String> orientadores) {
		this.orientadores = orientadores;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public TipoTrabalho getTipo() {
		return tipo;
	}
	public void setTipo(TipoTrabalho tipo) {
		this.tipo = tipo;
	}
	public void addAutor(String autor) {
		autores.add(autor);
	}
	public void addOrientador(String orientador) {
		autores.add(orientador);
	}

	
}
