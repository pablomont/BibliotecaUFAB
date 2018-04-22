package uepb.web.ufab.model.itemAcervo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity 
@Table(name= "MIDIA_ELETRONICA")
public class MidiaEletronica extends ItemAcervo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum TipoMidia {CD, DVD};
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_MIDIA")
	private TipoMidia tipo;

	public TipoMidia getTipo() {
		return tipo;
	}
	public void setTipo(TipoMidia tipo) {
		this.tipo = tipo;
	}


}
