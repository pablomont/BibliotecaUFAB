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

	public void criarItem(ItemAcervo item) {
		
		//if(!itemsAcervo.contains(item) && usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			itemsAcervo.add(item);
		//}
	}
	
	public void editarItem(ItemAcervo itemAntigo, ItemAcervo itemAlterado) {
		if(itemsAcervo.contains(itemAntigo) && usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			int index = itemsAcervo.indexOf(itemAntigo);
			itemsAcervo.set(index, itemAlterado);
		}
	}
	
	public void excluirItem(ItemAcervo item) {
		if(itemsAcervo.contains(item) && usuarioAtualDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			itemsAcervo.remove(item);
		}
	}

	
	public void addFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}

	public Funcionario getUsuarioAtualDoSistema() {
		return usuarioAtualDoSistema;
	}


	public void setUsuarioAtualDoSistema(Funcionario usuarioDoSistema) {
		this.usuarioAtualDoSistema = usuarioDoSistema;
	}


	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
}
