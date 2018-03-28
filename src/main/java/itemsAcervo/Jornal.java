package itemsAcervo;


public class Jornal implements ItemAcervo {
	
	private String titulo;
	private String data;
	private String edicao;
	
	
	public Jornal(String titulo) {
		setTitulo(titulo);
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getEdicao() {
		return edicao;
	}
	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}
	
	
	
	

}
