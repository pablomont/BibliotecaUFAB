package uepb.web.ufab.dao;

import java.util.List;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;

public interface ItemDao {
	List<ItemAcervo> getAllItems();
    ItemAcervo getItemById(int id);
    void addItemAcervo(ItemAcervo itemAcervo);
    void updateItemAcervo(ItemAcervo itemAcervo);
    void deleteItemAcervo(int id);
    boolean itemAcervoExists(String itemName);
}
