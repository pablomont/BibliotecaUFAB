package uepb.web.ufab.service.inter;

import java.util.List;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;

public interface IGenericService<T> {
     
     List<T> getAllItems();
     T getItemById(int id) throws ItemInexistenteException;
     boolean addItem(T item) throws ItemDuplicadoException;
     void updateItem(T item) throws ItemDuplicadoException, ItemInexistenteException;
     void deleteItem(int id) throws ItemInexistenteException;
}

