package uepb.web.ufab.dao;

import java.util.List;

public interface IDao<T> {
	List<T> getAllItems();
    T getItemById(int id);
    void addItem(T item);
    void updateItem(T item);
    void deleteItemById(int id);
    boolean itemExists(int id);
    
}
