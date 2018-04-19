package uepb.web.ufab.model.itemAcervo;

public class MidiaEletronica extends ItemAcervo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum TipoMidia {CD, DVD};
	
	private TipoMidia tipo;

	public TipoMidia getTipo() {
		return tipo;
	}
	public void setTipo(TipoMidia tipo) {
		this.tipo = tipo;
	}


}
