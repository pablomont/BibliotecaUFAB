package uepb.web.ufab.model.itemAcervo;

public class Revista extends ItemAcervo {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String editora;
	private String edicao;
	private int numPaginas;
	
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	public int getNumPaginas() {
		return numPaginas;
	}
	public void setNumPaginas(int numPaginas) {
		this.numPaginas = numPaginas;
	}
	

}
