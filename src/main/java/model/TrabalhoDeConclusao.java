package model;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((anoDefesa == null) ? 0 : anoDefesa.hashCode());
		result = prime * result + ((autores == null) ? 0 : autores.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		result = prime * result + ((orientadores == null) ? 0 : orientadores.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
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
		TrabalhoDeConclusao other = (TrabalhoDeConclusao) obj;
		if (anoDefesa == null) {
			if (other.anoDefesa != null)
				return false;
		} else if (!anoDefesa.equals(other.anoDefesa))
			return false;
		if (autores == null) {
			if (other.autores != null)
				return false;
		} else if (!autores.equals(other.autores))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		if (orientadores == null) {
			if (other.orientadores != null)
				return false;
		} else if (!orientadores.equals(other.orientadores))
			return false;
		if (tipo != other.tipo)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	

	
	
	
}
