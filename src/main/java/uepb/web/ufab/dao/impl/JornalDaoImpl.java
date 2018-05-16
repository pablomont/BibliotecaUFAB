package uepb.web.ufab.dao.impl;


import org.springframework.stereotype.Repository;
import uepb.web.ufab.dao.inter.IJornalDao;
import uepb.web.ufab.model.itemAcervo.Jornal;

@Repository
	/**
	* <h1>JornalDao</h1>
	* JornalDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class JornalDaoImpl extends GenericDaoImpl<Jornal> implements IJornalDao {

	public void updateJornal(Jornal jornal) {
		Jornal item = getItemById(jornal.getId());
		
		item.setNomeItem(jornal.getNomeItem());
		item.setEdicao(jornal.getEdicao());
		item.setDate(jornal.getDate());
		super.updateItem(item);
		
	}

	
}