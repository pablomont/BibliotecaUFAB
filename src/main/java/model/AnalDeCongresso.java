package model;

import java.util.ArrayList;
import java.util.List;

public class AnalDeCongresso implements ItemAcervo {
	
	
	public enum TipoAnal {ARTIGO, POSTER , RESUMO};
	private TipoAnal tipo;
	private String nomeCongresso;
	private String anoPublicacao;
	private String local;
	private String titulo;
	private List<String> autores;
	
	
	
	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public AnalDeCongresso(TipoAnal tipo, String titulo) {
		setTipo(tipo);
		setTitulo(titulo);
		autores = new ArrayList<String>();
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

	public TipoAnal getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnal tipo) {
		this.tipo = tipo;
	}

	public String getNomeCongresso() {
		return nomeCongresso;
	}

	public void setNomeCongresso(String nomeCongresso) {
		this.nomeCongresso = nomeCongresso;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomeCongresso == null) ? 0 : nomeCongresso.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		AnalDeCongresso other = (AnalDeCongresso) obj;
		if (nomeCongresso == null) {
			if (other.nomeCongresso != null)
				return false;
		} else if (!nomeCongresso.equals(other.nomeCongresso))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnalDeCongresso [titulo=" + titulo + "]";
	}
	
	
	
	
	
	

}
