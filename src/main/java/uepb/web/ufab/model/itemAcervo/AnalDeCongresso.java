package uepb.web.ufab.model.itemAcervo;


import java.util.List;

public class AnalDeCongresso extends ItemAcervo {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipoAnal {ARTIGO, POSTER , RESUMO};
	private TipoAnal tipo;
	private String local;
	private List<String> autores;
	

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public AnalDeCongresso() {
	
	}
	

	public TipoAnal getTipo() {
		return tipo;
	}

	public void setTipo(TipoAnal tipo) {
		this.tipo = tipo;
	}

	
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public void addAtributes(ItemAcervo itemAcervo) {
		// TODO Auto-generated method stub
		
	}

}
