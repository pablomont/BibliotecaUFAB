package uepb.web.ufab.dao.inter;

import java.util.List;


public interface IGenericDao<T> {
	List<T> getAllItems();
    T getItemById(int id);
    void addItem(T item);
    void deleteItemById(int id);
    boolean itemExists(int id);
    
}
