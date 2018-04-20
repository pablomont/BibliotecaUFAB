package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;

import uepb.web.ufab.model.itemAcervo.MidiaEletronica;


@Configuration
@Transactional
@Repository
public class MidiaEletronicaDao implements ItemDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM MIDIA_ELETRONICA as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}

	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(MidiaEletronica.class, id);
	}


	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}

	public void updateItemAcervo(ItemAcervo itemAcervo) {
		ItemAcervo item = getItemById(itemAcervo.getId());
	
		//item.clone(itemAcervo);
		//item.addAtritubes(itemAcervo);
//		i.setUsername(person.getUsername());
//		i.setPassword(person.getPassword());
//		i.setAge(person.getAge());
//		i.setGender(person.getGender());
//		i.setCity(person.getCity());
		hibernateTemplate.update(itemAcervo);
	}

	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
	}

	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM MIDIA_ELETRONICA as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}

}
