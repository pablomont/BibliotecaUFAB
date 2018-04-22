package uepb.web.ufab.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    protected int id;	
	
	@Column(name = "RG")
	protected String rg;
	
	@Column(name = "CPF")
	protected String cpf;
	
	@Column(name = "NATURALIDADE")
	protected String naturalidade;
	
	@Column(name = "NOME")
	protected String nome;
	
	@Column(name = "ENDERECO")
	protected String endereco;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getId() {
		return id;
	}
	
	
}
