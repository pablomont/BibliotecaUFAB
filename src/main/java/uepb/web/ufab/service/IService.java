package uepb.web.ufab.service;

import java.util.List;

import exception.ItemDuplicadoException;
import exception.ItemInexistenteException;

public interface IService<T> {
     
     List<T> getAllItems();
     T getItemById(int id);
     boolean addItem(T item) throws ItemDuplicadoException;
     void updateItem(T item) throws ItemDuplicadoException, ItemInexistenteException;
     void deleteItem(int id);
}

