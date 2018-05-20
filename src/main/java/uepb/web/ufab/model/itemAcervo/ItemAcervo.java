package uepb.web.ufab.model.itemAcervo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uepb.web.ufab.model.EntidadeBase;



@MappedSuperclass
public class ItemAcervo implements EntidadeBase {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
    protected int id;	
	
	@Column(name = "TITULO")
	protected String titulo;
	
	@Temporal(TemporalType.DATE)
	protected Date date;	
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}
		
	public void setId(int id){
		this.id = id;
	}

	public String getNomeItem() {
		return titulo;
	}

	public void setNomeItem(String nomeItem) {
		this.titulo = nomeItem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	
}
