package uepb.web.ufab.model.itemAcervo;

import java.io.Serializable;

public class Jornal extends ItemAcervo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String edicao;
		

	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}


	

}
