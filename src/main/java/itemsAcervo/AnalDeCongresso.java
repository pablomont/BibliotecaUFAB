package itemsAcervo;

public class AnalDeCongresso implements ItemAcervo {
	
	
	public enum TipoAnal {ARTIGO, POSTER , RESUMO};
	private TipoAnal tipo;
	private String nomeCongresso;
	private String anoPublicacao;
	private String local;
	private String titulo;
	
	public AnalDeCongresso(TipoAnal tipo, String titulo) {
		setTipo(tipo);
		setTitulo(titulo);
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
	
	
	
	
	
	

}
