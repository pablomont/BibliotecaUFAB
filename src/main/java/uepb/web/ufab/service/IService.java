package uepb.web.ufab.service;

import java.util.List;

public interface IService<T> {
     
     List<T> getAllItems();
     T getItemById(int id);
     boolean addItem(T item);
     void updateItem(T item);
     void deleteItem(int id);
}

