package uepb.web.ufab.model.itemAcervo;

import java.io.Serializable;

public class MidiaEletronica extends ItemAcervo implements Serializable {
	
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
