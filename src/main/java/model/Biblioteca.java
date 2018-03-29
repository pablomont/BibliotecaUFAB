package model;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import exception.AcessoNegadoException;
import exception.ItemExistenteException;
import exception.ItemInexistenteException;
import model.Funcionario.NivelAcesso;

public class Biblioteca {

	private List<ItemAcervo> itemsAcervo;
	private List<Funcionario> funcionarios;
	private List<Curso> cursos;
	private Funcionario usuarioAtualDoSistema;
	
	private static final Logger logger = LogManager.getLogger(Biblioteca.class);
	
	public Biblioteca() {
		itemsAcervo = new ArrayList<ItemAcervo>();
		funcionarios = new ArrayList<Funcionario>();
		cursos = new ArrayList<Curso>();
	}
	

	public void criarItem(ItemAcervo item) throws AcessoNegadoException, ItemExistenteException{
		
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(!itemsAcervo.contains(item)) {
			itemsAcervo.add(item);
			logger.info("Adicionado "+item.toString()+"  no Método criarItem");
		}
			
		else
			throw new ItemExistenteException("O item já existe");
		
	}
	
	public void editarItem(ItemAcervo item, ItemAcervo itemAlterado) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(itemsAcervo.contains(item)) {
			int index = itemsAcervo.indexOf(item);
			itemsAcervo.set(index, itemAlterado);
			logger.info("Editado "+item.toString()+ "no Método editarItem");
		}
		else
			throw new ItemInexistenteException("O item não existe");
		
	}
	
	public void removeItem(ItemAcervo item) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(itemsAcervo.contains(item)) {
			itemsAcervo.remove(item);
			logger.info("Removido "+item.toString()+ "no Método removerItem");
		}
		
		else
			throw new ItemInexistenteException("O item não existe");
	}
	
	public List<ItemAcervo> getItemsAcervo() {
		return itemsAcervo;
	}
	
	public void addFuncionario(Funcionario funcionario) {
		if(!funcionarios.contains(funcionario)) {
			funcionarios.add(funcionario);
			logger.info("Adicinado "+funcionario.toString()+ "no Método addFuncionario");
			
		}
		
		else
			throw new IllegalArgumentException("O Funcionário já existe na biblioteca");
	}
	
	
	public void editFuncionario(Funcionario funcionario, Funcionario funcionarioAlterado) throws AcessoNegadoException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(funcionarios.contains(funcionario)) {
			int index = funcionarios.indexOf(funcionario);
			funcionarios.set(index, funcionarioAlterado);
			logger.info("Editado "+funcionario.toString()+ "no Método editFuncionario");
		}
		else
			throw new IllegalArgumentException("O funcionário não existe");
		
	}
	
	
	public void removeFuncionario(Funcionario funcionario) throws AcessoNegadoException{
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(funcionarios.contains(funcionario)) {
			funcionarios.remove(funcionario);
			logger.info("Removido "+funcionario.toString()+ "no Método removeFuncionario");
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
		logger.info("Alterado o usuarioAtualDoSitema por "+usuarioDoSistema.toString()+ "no Método setUsuarioAtualDoSistema");
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void addCurso(Curso curso) {
		if(!cursos.contains(curso)) {
			cursos.add(curso);	
			logger.info("Adicionado o curso "+ curso +" no método addCurso");
		}
			
		else
			throw new IllegalArgumentException("O curso já exsite");	
	}
	
	public void editCurso(Curso curso, Curso cursoAlterado) throws AcessoNegadoException {
		
		if(cursos.contains(curso)) {
			int index = cursos.indexOf(curso);
			cursos.set(index, cursoAlterado);
			logger.info("Editado o curso "+ curso +" no método editCurso");
		}
		else
			throw new IllegalArgumentException("O curso não existe");	
	}
	
	public void removeCurso(Curso curso) throws AcessoNegadoException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(cursos.contains(curso)) {
			cursos.remove(curso);
			logger.info("Removido o curso "+ curso +" no método removeCurso");
		}
		
		else
			throw new IllegalArgumentException("O curso não existe");	
	}
		
}
