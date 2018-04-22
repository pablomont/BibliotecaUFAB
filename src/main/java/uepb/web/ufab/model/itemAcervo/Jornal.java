package uepb.web.ufab.model.itemAcervo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity 
@Table(name= "JORNAL")
public class Jornal extends ItemAcervo implements Serializable{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "EDICAO")
	private String edicao;
		

	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

}
