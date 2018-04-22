package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;


@Configuration
@Transactional
@Repository
	/**
	* <h1>AnalDeCongressoDao</h1>
	* AnalDeCongressoDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AnalDeCongressoDao implements ItemAcervoDao {
	

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	/** Busca todos itens do acervo do tipo AnalDeCongresso
	 *  @return Lista de acervo
	 *
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM AnalDeCongresso as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}
	/** @return retorna o item do acervo atraves do
	 *  @param id
	 */
	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(AnalDeCongresso.class, id);
	}

	/** Adiciona um AnalDeCongresso atraves do
	 *  @param itemAcervo
	 */
	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}
	/** Altera as caracteristicas do itemAcervo
	 *  @param itemAcervo
	 */
	public void updateItemAcervo(ItemAcervo itemAcervo) {
		AnalDeCongresso item = (AnalDeCongresso) getItemById(itemAcervo.getId());
		AnalDeCongresso itemAlterado = (AnalDeCongresso)itemAcervo;
		
		item.setAutores(itemAlterado.getAutores());
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setLocal(itemAlterado.getLocal());
		item.setDate(itemAlterado.getDate());
		item.setTipo(itemAlterado.getTipo());
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
		String hql = "FROM AnalDeCongresso as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}

}