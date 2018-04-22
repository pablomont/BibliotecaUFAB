package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.ItemAcervoDao;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;

@Transactional
@Service
@Configuration
/**
* <h1>CursoServiceImpl</h1>
* CursoServiceImpl Implementa todos os serviços dos itens de acervo
*
* @author  Samuel Rufino e Pablo Monteiro
* @version 1.0
* @since   2018-04-20
*/
public class ItemServiceImpl implements IService<ItemAcervo>{


	@Autowired
	private ItemAcervoDao itemDao;
	/** Busca todos os itens
	 *  @return Lista de itens
	 */
	public List<ItemAcervo> getAllItems() {
		return itemDao.getAllItems();
	}

	/** Busca o item
	 *  @return item
	 *  @param id do item
	 */
	public ItemAcervo getItemById(int id) {
		ItemAcervo obj = itemDao.getItemById(id);
		return obj;
	}

	/** Atualiza o item do acervo
	 * @param itemAcervo
	 */
	public void updateItem(ItemAcervo itemAcervo) {
		itemDao.updateItemAcervo(itemAcervo);
	}
	
	/** Deleta o item
 	 *  @param id do item
	 */
	public void deleteItem(int id) {
		itemDao.deleteItemAcervo(id);
	}

	/** Adiciona o item 
 	 *  @param itemAcervo 
 	 *  @return false se o item não existir
	 *  @return true se o item existir 
	 */
	public synchronized boolean addItem(ItemAcervo itemAcervo) {
		if (itemDao.itemAcervoExists(itemAcervo.getNomeItem())){
	         return false;
       } else {
       	itemDao.addItemAcervo(itemAcervo);
	         return true;
       }   
	}

	
}
