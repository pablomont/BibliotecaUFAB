package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;


@Configuration
@Transactional
@Repository
	/**
	* <h1>RevistaDao</h1>
	* TrabalhoDeConclusaoDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class TrabalhoDeConclusaoDao implements ItemAcervoDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos itens do acervo do tipo Revista
	 *  @return Lista de acervo passado pelo
	 *  @param hql 
	 */
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM TrabalhoDeConclusao as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}
	/** @return retorna o item do acervo atraves do
	 *  @param id
	 */
	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(TrabalhoDeConclusao.class, id);
	}
	/** Adiciona um Revista atraves do
	 *  @param itemAcervo
	 */
	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}
	/** Altera as caracteristicas do itemAcervo
	 *  @param itemAlterado 
	 */
	public void updateItemAcervo(ItemAcervo itemAcervo) {
		TrabalhoDeConclusao item = (TrabalhoDeConclusao) getItemById(itemAcervo.getId());
		TrabalhoDeConclusao itemAlterado = (TrabalhoDeConclusao)itemAcervo;
		
		item.setAutores(itemAlterado.getAutores());
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setDate(itemAlterado.getDate());
		item.setLocal(itemAlterado.getLocal());
		item.setOrientadores(itemAlterado.getOrientadores());
		item.setTipo(itemAlterado.getTipo());
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
		String hql = "FROM TrabalhoDeConclusao as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}

}