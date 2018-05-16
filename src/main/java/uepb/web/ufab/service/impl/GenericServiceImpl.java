package uepb.web.ufab.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.EntidadeBase;
import uepb.web.ufab.service.inter.IGenericService;

@Service
public class GenericServiceImpl<T extends EntidadeBase> implements IGenericService<T> {

	//TODO logar os métodos
	//private static final Logger logger = LogManager.getLogger(CursoServiceImpl.class);
	
	private IGenericDao<T> genericDao;
	 
    public GenericServiceImpl(IGenericDao<T> genericDao) {
        this.genericDao = genericDao;
    }
 
    public GenericServiceImpl() {
    	
    }
	
    @Transactional
	public List<T> getAllItems() {
		return genericDao.getAllItems();
	}

    @Transactional
	public T getItemById(int id) throws ItemInexistenteException {
		if(!genericDao.itemExists(id))
			throw new ItemInexistenteException("Elemento inexistente");
		
		return genericDao.getItemById(id);
	
	}

    @Transactional
	public boolean addItem(T item) throws ItemDuplicadoException {
		if (genericDao.itemExists(item.getId())){
			throw new ItemDuplicadoException("Elemento duplicado");
		}
		else {
			genericDao.addItem(item);
			// TODO logar
			//logger.info("CursoService: addItem(curso), curso = " + curso);
			return true;       
		}   
	}

    @Transactional
	public void deleteItem(int id) throws ItemInexistenteException {
		if(!genericDao.itemExists(id))
			throw new ItemInexistenteException("Elemento não existe");
		
		genericDao.deleteItemById(id);
		
	}


}
