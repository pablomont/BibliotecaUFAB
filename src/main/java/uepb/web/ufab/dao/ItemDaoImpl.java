package uepb.web.ufab.dao;

import java.util.List;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;


@Transactional
@Repository
public class ItemDaoImpl implements ItemDao{

	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItemss() {
		String hql = "FROM ItemAcervo as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}

	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(ItemAcervo.class, id);
	}

	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
		
	}

	public void updateItemAcervo(ItemAcervo itemAcervo) {
//		ItemAcervo i = getItemById(itemAcervo.getId());
//		i.setUsername(person.getUsername());
//		i.setPassword(person.getPassword());
//		i.setAge(person.getAge());
//		i.setGender(person.getGender());
//		i.setCity(person.getCity());
//		hibernateTemplate.update(i);
		
	}

	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
		
	}

	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM ItemAcervo as i WHERE i.itemName = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}
}
