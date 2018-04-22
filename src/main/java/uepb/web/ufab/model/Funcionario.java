package uepb.web.ufab.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity 
@Table(name= "ALUNO")
public class Funcionario extends Pessoa{

	public enum NivelAcesso {ADMIN,OPERADOR}
	
	@Enumerated(EnumType.STRING)
	@Column(name="NIVEL_ACESSO")
	private NivelAcesso nivelAcesso;
	

	@Column(name = "EMAIL")
	private String email;
	
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@Column(name = "NOME_USUARIO")
	private String nomeUsuario;
	
	@Column(name = "SENHA")
	private String senha;
	
	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}

	public void setNivelAcesso(NivelAcesso nivelAcesso) {
		this.nivelAcesso = nivelAcesso;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}
