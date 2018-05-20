package uepb.web.ufab.model.itemAcervo;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity 
@Table(name= "ANAL_DE_CONGRESSO")
public class AnalDeCongresso extends ItemAcervo implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum TipoAnal {ARTIGO, POSTER , RESUMO};
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_ANAL")
	private TipoAnal tipo;
	
	@Column(name="LOCAL")
	private String local;
	
	@ElementCollection
    @CollectionTable(
        name = "AUTOR_ANAL",
        joinColumns=@JoinColumn(name = "id")      
    )
	private List<String> autores = new ArrayList<String>();
	

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
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

	public void addAutor(String autor) {
		autores.add(autor);
	}

}
