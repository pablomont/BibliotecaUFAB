package uepb.web.ufab.dao.impl;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.dao.inter.IAnalDeCongressoDao;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;




@Repository
	/**
	* <h1>AnalDeCongressoDao</h1>
	* AnalDeCongressoDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AnalDeCongressoDaoImpl extends GenericDaoImpl<AnalDeCongresso> implements IAnalDeCongressoDao {

	public void updateAnalDeCongresso(AnalDeCongresso analDeCongresso) {
		AnalDeCongresso item = getItemById(analDeCongresso.getId());
		
		item.setAutores(analDeCongresso.getAutores());
		item.setNomeItem(analDeCongresso.getNomeItem());
		item.setLocal(analDeCongresso.getLocal());
		item.setDate(analDeCongresso.getDate());
		item.setTipo(analDeCongresso.getTipo());
		super.updateItem(item);
		
	}
	
}