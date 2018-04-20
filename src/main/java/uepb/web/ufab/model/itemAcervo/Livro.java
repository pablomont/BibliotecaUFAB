package uepb.web.ufab.model.itemAcervo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity 
@Table(name= "LIVRO")
public class Livro extends ItemAcervo implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name="ISBN")
	private String isbn;
	
	@ElementCollection
    @CollectionTable(
        name = "AUTOR",
        joinColumns=@JoinColumn(name = "id")      
    )
	@Column(name="NOME_AUTOR")
	private List<String> autores = new ArrayList<String>();
	
	@Column(name="EDITORA")
	private String editora;
	
	@Column(name="QTD_PAGINA")
	private int numPaginas;
	
	@Column(name="AREA")
	private String area;
	
	@Column(name="TEMA")
	private String tema;
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public List<String> getAutores() {
		return autores;
	}
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}

	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getTema() {
		return tema;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	
	public void addAutor(String autor){
		getAutores().add(autor);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Livro [isbn=" + isbn + ", autores=" + autores + ", editora=" + editora + ", numPaginas=" + numPaginas
				+ ", area=" + area + ", tema=" + tema + "]";
	}

	@Override
	public void addAtributes(ItemAcervo itemAcervo) {
		Livro livro = (Livro)itemAcervo;
		this.area = livro.area;
		this.autores = livro.autores;
		this.date = livro.date;
		this.editora = livro.editora;
		this.isbn = livro.isbn;
		this.nomeItem = livro.nomeItem;
		this.tema = livro.area;
		
	}

	
	
	
	
}
