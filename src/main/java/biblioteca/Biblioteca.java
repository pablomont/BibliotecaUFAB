package biblioteca;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Funcionario.NivelAcesso;
import itemsAcervo.ItemAcervo;

public class Biblioteca {

	private List<ItemAcervo> itemsAcervo;
	private List<Funcionario> funcionarios;
	private Funcionario usuarioAtualDoSistema;
	
	public Biblioteca(Funcionario funcionario) {
		itemsAcervo = new ArrayList<ItemAcervo>();
		funcionarios = new ArrayList<Funcionario>();
		
		addFuncionario(funcionario);
		setUsuarioAtualDoSistema(funcionario);
	}
	
	
	public List<ItemAcervo> getItemsAcervo() {
		return itemsAcervo;
	}

	public void criarItem(ItemAcervo item) throws AcessoNegadoException, ItemExistenteException{
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(!itemsAcervo.contains(item)) 
			itemsAcervo.add(item);	
		else
			throw new ItemExistenteException("O item já existe");
		
	}
	
	public void editarItem(ItemAcervo itemAntigo, ItemAcervo itemAlterado) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		
		if(itemsAcervo.contains(itemAntigo)) {
			int index = itemsAcervo.indexOf(itemAntigo);
			itemsAcervo.set(index, itemAlterado);
		}
		else
			throw new ItemInexistenteException("O item não existe");
		
		
	}
	
	public void excluirItem(ItemAcervo item) throws AcessoNegadoException, ItemInexistenteException {
		if(!usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN))
			throw new AcessoNegadoException("O nível de acesso deve ser ADMIN");
		
		if(itemsAcervo.contains(item)) {
			itemsAcervo.remove(item);
		}
		
		else
			throw new ItemInexistenteException("O item não existe");
	}

	
	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
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
	
}
