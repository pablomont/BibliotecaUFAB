package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.model.itemAcervo.Revista;


@Configuration
@Transactional
@Repository
	/**
	* <h1>RevistaDao</h1>
	* RevistaDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class RevistaDao implements ItemAcervoDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos itens do acervo do tipo Revista
	 *  @return Lista de revistas
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM Revista as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}
	/** @return retorna o item do acervo atraves do
	 *  @param id
	 */
	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(Revista.class, id);
	}
	/** Adiciona um Revista atraves do
	 *  @param itemAcervo
	 */

	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}
	/** Altera as caracteristicas do itemAcervo
	 *  @param itemAcervo
	 */
	public void updateItemAcervo(ItemAcervo itemAcervo) {
		Revista item = (Revista) getItemById(itemAcervo.getId());
		Revista itemAlterado = (Revista)itemAcervo;
		
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setDate(itemAlterado.getDate());
		item.setEditora(item.getEditora());
		item.setNumPaginas(itemAlterado.getNumPaginas());
		item.setEdicao(itemAlterado.getEdicao());
		item.setNomeItem(itemAlterado.getNomeItem());
		hibernateTemplate.update(item);
	}
	/** Deleta o ItemAcervo atraves do ID
	 */
	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
	}
	/** Verifica a existencia do item no acervo atraves do nome do item
	 * @param itemName
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM Revista as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}
}