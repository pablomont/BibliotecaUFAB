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
@Table(name= "TRABALHO_DE_CONCLUSAO")
public class TrabalhoDeConclusao extends ItemAcervo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public enum TipoTrabalho {MONOGRAFIA, TESTE, DISSERTACAO};

	@ElementCollection
    @CollectionTable(
        name = "AUTOR_TCC",
        joinColumns=@JoinColumn(name = "id")      
    )
	@Column(name="NOME_AUTOR")
	private List<String> autores = new ArrayList<String>();
	
	@ElementCollection
    @CollectionTable(
        name = "ORIENTADOR_TCC",
        joinColumns=@JoinColumn(name = "id")      
    )
	@Column(name="NOME_ORIENTADOR")
	private List<String> orientadores = new ArrayList<String>();
	
	@Column(name="LOCAL")
	private String local;
	
	@Enumerated(EnumType.STRING)
	@Column(name="TIPO_TCC")
	private TipoTrabalho tipo;
	
	public List<String> getAutores() {
		return autores;
	}
	public void setAutores(List<String> autores) {
		this.autores = autores;
	}
	public List<String> getOrientadores() {
		return orientadores;
	}
	public void setOrientadores(List<String> orientadores) {
		this.orientadores = orientadores;
	}
	
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public TipoTrabalho getTipo() {
		return tipo;
	}
	public void setTipo(TipoTrabalho tipo) {
		this.tipo = tipo;
	}
	public void addAutor(String autor) {
	
		autores.add(autor);
		
	}
	public void addOrientador(String orientador) {
		
		orientadores.add(orientador);
	}
	
}
