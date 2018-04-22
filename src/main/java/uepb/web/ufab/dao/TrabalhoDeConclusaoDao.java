package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;


@Configuration
@Transactional
@Repository
public class TrabalhoDeConclusaoDao implements ItemDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<ItemAcervo> getAllItems() {
		String hql = "FROM TrabalhoDeConclusao as i ORDER BY i.id";
		return (List<ItemAcervo>) hibernateTemplate.find(hql);
	}

	public ItemAcervo getItemById(int id) {
		return hibernateTemplate.get(TrabalhoDeConclusao.class, id);
	}


	public void addItemAcervo(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);
	}

	public void updateItemAcervo(ItemAcervo itemAcervo) {
		TrabalhoDeConclusao item = (TrabalhoDeConclusao) getItemById(itemAcervo.getId());
		TrabalhoDeConclusao itemAlterado = (TrabalhoDeConclusao)itemAcervo;
		
		item.setAutores(itemAlterado.getAutores());
		item.setNomeItem(itemAlterado.getNomeItem());
		item.setDate(itemAlterado.getDate());
		item.setLocal(itemAlterado.getLocal());
		item.setOrientadores(itemAlterado.getOrientadores());
		item.setTipo(itemAlterado.getTipo());
		hibernateTemplate.update(item);
	}

	public void deleteItemAcervo(int id) {
		hibernateTemplate.delete(getItemById(id));
	}

	@SuppressWarnings("unchecked")
	public boolean itemAcervoExists(String itemName) {
		String hql = "FROM TRABALHO_DE_CONCLUSAO as i WHERE i.nomeItem = ?";
		List<ItemAcervo> items = (List<ItemAcervo>) hibernateTemplate.find(hql, itemName);
		return items.size() > 0 ? true : false;
	}

}
