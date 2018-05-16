package uepb.web.ufab.dao.impl;


import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.IRevistaDao;
import uepb.web.ufab.model.itemAcervo.Revista;



	/**
	* <h1>RevistaDao</h1>
	* RevistaDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class RevistaDaoImpl extends GenericDaoImpl<Revista> implements IRevistaDao {

	public void updateRevista(Revista revista) {
		Revista item = (Revista) getItemById(revista.getId());
		
		
		item.setNomeItem(revista.getNomeItem());
		item.setDate(revista.getDate());
		item.setEditora(revista.getEditora());
		item.setNumPaginas(revista.getNumPaginas());
		item.setEdicao(revista.getEdicao());
		item.setNomeItem(revista.getNomeItem());
		super.updateItem(item);
		
	}

	
}