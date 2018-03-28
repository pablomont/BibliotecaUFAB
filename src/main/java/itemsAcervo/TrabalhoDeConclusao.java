package itemsAcervo;

import java.util.List;

public class TrabalhoDeConclusao implements ItemAcervo {
	
	public enum TipoTrabalho {MONOGRAFIA, TESTE, DISSERTACAO};
	
	private String titulo;
	private List<String> autores;
	private List<String> orientadores;
	private String anoDefesa;
	private String local;
	private TipoTrabalho tipo;
	

	public TrabalhoDeConclusao(String titulo, TipoTrabalho tipo) {
		super();
		setTitulo(titulo);
		setTipo(tipo);
	}

	public void addAutor(String autor) {
		if(!autores.contains(autor)) {
			autores.add(autor);
		}
		else
			throw new IllegalArgumentException("Autor já existente");
	}
	
	public void removeAutor(String autor) {
		if(autores.contains(autor)) {
			autores.remove(autor);
		}
		else
			throw new IllegalArgumentException("Autor inexistente");
	}
	
	
	public void addOrientador(String orientador) {
		if(!autores.contains(orientador)) {
			autores.add(orientador);
		}
		else
			throw new IllegalArgumentException("Orientador já existente");
	}
	
	public void removeOrientador(String orientador) {
		if(autores.contains(orientador)) {
			autores.remove(orientador);
		}
		else
			throw new IllegalArgumentException("Orientador inexistente");
	}
	
	
	public TrabalhoDeConclusao(TipoTrabalho tipo) {
		setTipo(tipo);
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
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
	public String getAnoDefesa() {
		return anoDefesa;
	}
	public void setAnoDefesa(String anoDefesa) {
		this.anoDefesa = anoDefesa;
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

	

	
	
	
}
