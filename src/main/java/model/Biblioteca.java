package model;

import java.util.ArrayList;
import java.util.List;

import exception.AcessoNegadoException;
import exception.ItemExistenteException;
import exception.ItemInexistenteException;
import model.Funcionario.NivelAcesso;

public class Biblioteca {

	private List<ItemAcervo> itemsAcervo;
	private List<Funcionario> funcionarios;
	private List<Curso> cursos;
	private Funcionario usuarioAtualDoSistema;
	
	public Biblioteca(Funcionario funcionario) {
		itemsAcervo = new ArrayList<ItemAcervo>();
		funcionarios = new ArrayList<Funcionario>();
		cursos = new ArrayList<Curso>();
		
		setUsuarioAtualDoSistema(funcionario);
	}
	

	public void criarItem(ItemAcervo item) throws AcessoNegadoException, ItemExistenteException{
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(!itemsAcervo.contains(item)) 
			itemsAcervo.add(item);	
		else
			throw new ItemExistenteException("O item já existe");
		
	}
	
	public void editarItem(ItemAcervo item, ItemAcervo itemAlterado) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(itemsAcervo.contains(item)) {
			int index = itemsAcervo.indexOf(item);
			itemsAcervo.set(index, itemAlterado);
		}
		else
			throw new ItemInexistenteException("O item não existe");
		
	}
	
	public void removeItem(ItemAcervo item) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(itemsAcervo.contains(item)) {
			itemsAcervo.remove(item);
		}
		
		else
			throw new ItemInexistenteException("O item não existe");
	}
	
	public List<ItemAcervo> getItemsAcervo() {
		return itemsAcervo;
	}
	
	public void addFuncionario(Funcionario funcionario) {
		if(!funcionarios.contains(funcionario))
		funcionarios.add(funcionario);
		
		else
			throw new IllegalArgumentException("O Funcionário já existe na biblioteca");
	}
	
	
	public void editFuncionario(Funcionario funcionario, Funcionario funcionarioAlterado) throws AcessoNegadoException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(funcionarios.contains(funcionario)) {
			int index = funcionarios.indexOf(funcionario);
			funcionarios.set(index, funcionarioAlterado);
		}
		else
			throw new IllegalArgumentException("O funcionário não existe");
		
	}
	
	
	public void removeFuncionario(Funcionario funcionario) throws AcessoNegadoException{
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(funcionarios.contains(funcionario)) {
			funcionarios.remove(funcionario);
		}
		
		else
			throw  new IllegalArgumentException("O funcionario não existe");
	}


	public Funcionario getUsuarioAtualDoSistema() {
		return usuarioAtualDoSistema;
	}
	

	public void setUsuarioAtualDoSistema(Funcionario usuarioDoSistema) {
		int index = funcionarios.indexOf(usuarioDoSistema);
		
		if(index == -1)
			throw new IllegalArgumentException("O Funcionário não existe na biblioteca");
		
		this.usuarioAtualDoSistema = usuarioDoSistema;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void addCurso(Curso curso) {
		if(!cursos.contains(curso)) 
			cursos.add(curso);	
		else
			throw new IllegalArgumentException("O curso já exsite");	
	}
	
	public void editCurso(Curso curso, Curso cursoAlterado) throws AcessoNegadoException {
		
		if(cursos.contains(curso)) {
			int index = cursos.indexOf(curso);
			cursos.set(index, cursoAlterado);
		}
		else
			throw new IllegalArgumentException("O curso não existe");	
	}
	
	public void removeCurso(Curso curso) throws AcessoNegadoException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(cursos.contains(curso)) {
			cursos.remove(curso);
		}
		
		else
			throw new IllegalArgumentException("O curso não existe");	
	}
		
}
