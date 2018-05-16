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
	@Column(name="id")
    protected int id;	
	
	@Column(name = "nomeItem")
	protected String nomeItem;
	
	@Temporal(TemporalType.DATE)
	protected Date date;	
	
	
	public int getId() {
		return id;
	}
		
	public void setId(int id){
		this.id = id;
	}

	public String getNomeItem() {
		return nomeItem;
	}

	public void setNomeItem(String nomeItem) {
		this.nomeItem = nomeItem;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
