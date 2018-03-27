package biblioteca;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Funcionario.NivelAcesso;
import itemsAcervo.ItemAcervo;

public class Biblioteca {

	private List<ItemAcervo> itemsAcervo;
	private List<Funcionario> funcionarios;
	private Funcionario usuarioDoSistema;
	
	public Biblioteca() {
		
		itemsAcervo = new ArrayList<ItemAcervo>();
		funcionarios = new ArrayList<Funcionario>();
	}
	
	
	public void criarItem(ItemAcervo item) {
		
		if(!itemsAcervo.contains(item) && usuarioDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			itemsAcervo.add(item);
		}
	}
	
	public void editarItem(ItemAcervo itemAntigo, ItemAcervo itemAlterado) {
		if(itemsAcervo.contains(itemAntigo) && usuarioDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			int index = itemsAcervo.indexOf(itemAntigo);
			itemsAcervo.set(index, itemAlterado);
		}
	}
	
	public void excluirItem(ItemAcervo item) {
		if(itemsAcervo.contains(item) && usuarioDoSistema.getnivelAcesso().equals(NivelAcesso.ADMIN)) {
			itemsAcervo.remove(item);
		}
	}


	public Funcionario getUsuarioDoSistema() {
		return usuarioDoSistema;
	}


	public void setUsuarioDoSistema(Funcionario usuarioDoSistema) {
		this.usuarioDoSistema = usuarioDoSistema;
	}
	
	
	
	
}
