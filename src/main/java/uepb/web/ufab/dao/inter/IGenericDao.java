package uepb.web.ufab.dao.inter;

import java.util.List;

import uepb.web.ufab.model.EntidadeBase;

public interface IGenericDao<T extends EntidadeBase> {
	List<T> getAllItems();
    T getItemById(int id);
    void addItem(T item);
    void updateItem(T item);
    void deleteItemById(int id);
    boolean itemExists(int id);
    
}
