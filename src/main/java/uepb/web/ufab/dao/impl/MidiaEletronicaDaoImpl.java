package uepb.web.ufab.dao.impl;

import org.springframework.stereotype.Repository;
import uepb.web.ufab.dao.inter.IMidiaEletronicaDao;
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;




	/**
	* <h1>MidiaEletronicaDao</h1>
	* MidiaEletronicaDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class MidiaEletronicaDaoImpl extends GenericDaoImpl<MidiaEletronica> implements IMidiaEletronicaDao {

	public void updateMidiaEletronica(MidiaEletronica midiaEletronica) {
		MidiaEletronica item = (MidiaEletronica) getItemById(midiaEletronica.getId());
		
		item.setNomeItem(midiaEletronica.getNomeItem());
		item.setDate(midiaEletronica.getDate());
		item.setTipo(midiaEletronica.getTipo());
		super.updateItem(item);
	}

	

}