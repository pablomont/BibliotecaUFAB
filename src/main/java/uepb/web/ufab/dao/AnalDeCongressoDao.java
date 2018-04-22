package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;



@Configuration
@Transactional
@Repository

public class AnalDeCongressoDao implements ItemDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM AnalDeCongresso as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}

	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(AnalDeCongresso.class, id);
	}


	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}

	public void updateItemAcervo(ItemAcervo itemAcervo) {
		AnalDeCongresso item = (AnalDeCongresso) getItemById(itemAcervo.getId());
		AnalDeCongresso itemAlterado = (AnalDeCongresso)itemAcervo;
		
		item.setAutores(itemAlterado.getAutores());
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setLocal(itemAlterado.getLocal());
		item.setDate(itemAlterado.getDate());
		item.setTipo(itemAlterado.getTipo());
		hibernateTemplate.update(item);
	}

	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
	}

	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM ANAL_DE_CONGRESSO as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}

}
