package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.itemAcervo.ItemAcervo;


@Configuration
@Transactional
@Repository
public class JornalDao implements ItemDao {

	public List<ItemAcervo> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public ItemAcervo getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addItemAcervo(ItemAcervo itemAcervo) {
		// TODO Auto-generated method stub

	}

	public void updateItemAcervo(ItemAcervo itemAcervo) {
		// TODO Auto-generated method stub

	}

	public void deleteItemAcervo(int id) {
		// TODO Auto-generated method stub

	}

	public boolean itemAcervoExists(String itemName) {
		// TODO Auto-generated method stub
		return false;
	}

}
