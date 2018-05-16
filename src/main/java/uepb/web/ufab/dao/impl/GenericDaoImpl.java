package uepb.web.ufab.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.model.EntidadeBase;

public  abstract class  GenericDaoImpl<T extends EntidadeBase> implements IGenericDao<T> {

	@Autowired
	protected HibernateTemplate  hibernateTemplate;
	
	private Class<T> persistedClass;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
	    ParameterizedType pt = (ParameterizedType) t;
	    persistedClass = (Class) pt.getActualTypeArguments()[0];
	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAllItems() {
		String hql = "FROM "+persistedClass.getName()+" as i ORDER BY i.id";
		return (List<T>) hibernateTemplate.find(hql);
	}

	public T getItemById(int id) {
		return hibernateTemplate.get(persistedClass, id);
	}

	public void addItem(T item) {
		hibernateTemplate.save(item);
	}

	public void updateItem(T item) {
		hibernateTemplate.update(item);
	}

	public void deleteItemById(int id) {
		hibernateTemplate.delete(getItemById(id));
		
	}

	@SuppressWarnings("unchecked")
	public boolean itemExists(int id) {
		String hql = "FROM "+ persistedClass.getName() +" as i WHERE i.id = ?";
		List<T> items = (List<T>) hibernateTemplate.find(hql, id);
		return items.size() > 0 ? true : false;
	}
	
	
}
