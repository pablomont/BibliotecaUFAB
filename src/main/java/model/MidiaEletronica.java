package model;

public class MidiaEletronica implements ItemAcervo {
	
	public enum TipoMidia {CD, DVD};
	private String titulo;
	private TipoMidia tipo;
	private String dataGravacao;
	
	
	public MidiaEletronica(TipoMidia tipo, String titulo) {
		setTipo(tipo);
		setTitulo(titulo);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public TipoMidia getTipo() {
		return tipo;
	}
	public void setTipo(TipoMidia tipo) {
		this.tipo = tipo;
	}
	public String getDataGravacao() {
		return dataGravacao;
	}
	public void setDataGravacao(String dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		MidiaEletronica other = (MidiaEletronica) obj;
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
