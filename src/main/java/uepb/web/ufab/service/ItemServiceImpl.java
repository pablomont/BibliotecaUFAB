package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.IDao;
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

	private static final Logger logger = LogManager.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private IDao<ItemAcervo> itemDao;
	/** Busca todos os itens
	 *  @return Lista de itens
	 */
	public List<ItemAcervo> getAllItems() {
		logger.info("ItemService: getAllItems()");
		return itemDao.getAllItems();
	}

	/** Busca o item
	 *  @return item
	 *  @param id do item
	 */
	public ItemAcervo getItemById(int id) {
		ItemAcervo i = itemDao.getItemById(id);
		logger.info("ItemService: getItemByid(id), id = " + id +"result: "+i);
		return i;
	}

	/** Atualiza o item do acervo
	 * @param itemAcervo
	 */
	public void updateItem(ItemAcervo itemAcervo) {
		itemDao.updateItem(itemAcervo);
		logger.info("ItemService: addItem(itemAcervo), itemAcervo = " + itemAcervo);
	}
	
	/** Deleta o item
 	 *  @param id do item
	 */
	public void deleteItem(int id) {
		itemDao.deleteItemById(id);
		logger.info("ItemService: deleteItem(id), id = " + id);
	}

	/** Adiciona o item 
 	 *  @param itemAcervo 
 	 *  @return false se o item não existir
	 *  @return true se o item existir 
	 */
	public synchronized boolean addItem(ItemAcervo itemAcervo) {
		if (itemDao.itemExists(itemAcervo.getNomeItem())){
	         return false;
       } else {
       	itemDao.addItem(itemAcervo);
       	logger.info("ItemService: addItem(itemAcervo), itemaAcervo = " + itemAcervo);
	         return true;
       }   
	}

	
}
