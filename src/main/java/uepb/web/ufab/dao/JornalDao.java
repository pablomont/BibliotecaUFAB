package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.model.itemAcervo.Jornal;



@Configuration
@Transactional
@Repository
	/**
	* <h1>JornalDao</h1>
	* JornalDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class JornalDao implements ItemAcervoDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos itens do acervo do tipo Jornal
	 *  @return Lista de acervo passado pelo
	 *  @param hql 
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM Jornal as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}
	/** @return retorna o item do acervo atraves do
	 *  @param id
	 */
	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(Jornal.class, id);
	}
	
	/** Adiciona um Jornal atraves do
	 *  @param itemAcervo
	 */
	
	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}
	/** Altera as caracteristicas do itemAcervo
	 *  @param itemAlterado 
	 */
	public void updateItemAcervo(ItemAcervo itemAcervo) {
		Jornal item = (Jornal) getItemById(itemAcervo.getId());
		Jornal itemAlterado = (Jornal)itemAcervo;
		
		
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setEdicao(itemAlterado.getEdicao());
		item.setDate(itemAlterado.getDate());
		hibernateTemplate.update(item);
	}
	/** Deleta o ItemAcervo atraves do ID
	 */
	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
	}
	/** Verifica a existencia do item no acervo atraves do
	 * @param itemName
	 * @param hql
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM Jornal as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}
}