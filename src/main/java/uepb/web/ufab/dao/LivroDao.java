package uepb.web.ufab.dao;

import java.util.List;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.model.itemAcervo.Livro;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Configuration
@Transactional
@Repository
	/**
	* <h1>LivroDao</h1>
	* LivroDao � um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class LivroDao implements IDao<ItemAcervo>{

	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos itens do acervo do tipo Livro
	 *  @return Lista de livros
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM Livro as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}
	/** @return retorna o item do acervo atraves do
	 *  @param id
	 */
	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(Livro.class, id);
	}
	/** Adiciona um Livro atraves do
	 *  @param itemAcervo
	 */

	public void addItem(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}
	/** Altera as caracteristicas do itemAcervo
	 *  @param itemAcervo
	 */
	public void updateItem(ItemAcervo itemAcervo) {
		Livro item = (Livro) getItemById(itemAcervo.getId());
		Livro itemAlterado = (Livro)itemAcervo;
		
		item.setAutores(itemAlterado.getAutores());
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setArea(itemAlterado.getArea());
		item.setDate(itemAlterado.getDate());
		item.setEditora(item.getEditora());
		item.setIsbn(itemAlterado.getIsbn());
		item.setNumPaginas(itemAlterado.getNumPaginas());
		item.setTema(itemAlterado.getTema());
		hibernateTemplate.update(item);
	}

	/** Deleta o ItemAcervo atraves do ID
	 */
	public void deleteItemById(int id) {
		hibernateTemplate.delete(getItemById(id));
	}

	/** Verifica a existencia do item no acervo atraves do nome do item
	 * @param itemName
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemExists(String itemName) {
		String hql = "FROM Livro as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}
	
}