package uepb.web.ufab.dao;

import java.util.List;

public interface IDao<T> {
	List<T> getAllItems();
    T getItemById(int id);
    void addItem(T itemAcervo);
    void updateItem(T itemAcervo);
    void deleteItemById(int id);
    boolean itemExists(String itemName);
    
}
