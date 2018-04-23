package uepb.web.ufab.service;

import java.util.List;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;

public interface ItemService {
     
     List<ItemAcervo> getAllItems();
     ItemAcervo getItemById(int id);
     boolean addItemAcervo(ItemAcervo itemAcervo);
     void updateItemAcervo(ItemAcervo itemAcervo);
     void deleteItemAcervo(int id);
}

