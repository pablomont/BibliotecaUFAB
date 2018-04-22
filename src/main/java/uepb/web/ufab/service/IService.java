package uepb.web.ufab.service;

import java.util.List;

public interface IService<T> {
     
     List<T> getAllItems();
     T getItemById(int id);
     boolean addItemAcervo(T itemAcervo);
     void updateItemAcervo(T itemAcervo);
     void deleteItemAcervo(int id);
}

