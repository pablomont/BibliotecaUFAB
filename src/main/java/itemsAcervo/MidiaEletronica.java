package itemsAcervo;

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
	
	

}
