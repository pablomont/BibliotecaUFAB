package uepb.web.ufab.model.itemAcervo;

import java.util.ArrayList;
import java.util.List;

public class Livro extends ItemAcervo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;
	private List<String> autores = new ArrayList<String>();
	private String editora;
	private int numPaginas;
	private String area;
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

}
