package uepb.web.ufab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.ItemDao;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDao itemDao;
	
	public List<ItemAcervo> getAllItemss() {
		return itemDao.getAllItems();
	}

	public ItemAcervo getItemById(int id) {
		ItemAcervo obj = itemDao.getItemById(id);
		return obj;
	}

	
	public void updateItemAcervo(ItemAcervo itemAcervo) {
		itemDao.updateItemAcervo(itemAcervo);
	}

	public void deleteItemAcervo(int id) {
		itemDao.deleteItemAcervo(id);
	}

	public synchronized boolean addItemAcervo(ItemAcervo itemAcervo) {
		if (itemDao.itemAcervoExists(itemAcervo.getNomeItem())){
	         return false;
       } else {
       	itemDao.addItemAcervo(itemAcervo);
	         return true;
       }   
	}

}
