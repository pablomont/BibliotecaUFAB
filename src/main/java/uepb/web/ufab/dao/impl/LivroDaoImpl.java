package uepb.web.ufab.dao.impl;


import uepb.web.ufab.dao.inter.ILivroDao;
import uepb.web.ufab.model.itemAcervo.Livro;
import org.springframework.stereotype.Repository;



	/**
	* <h1>LivroDao</h1>
	* LivroDao é um dos itens do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class LivroDaoImpl extends GenericDaoImpl<Livro> implements ILivroDao{

	public void updateLivro(Livro livro) {
		Livro item = (Livro) getItemById(livro.getId());
	
		
		item.setAutores(livro.getAutores());
		item.setNomeItem(livro.getNomeItem());
		item.setArea(livro.getArea());
		item.setDate(livro.getDate());
		item.setEditora(livro.getEditora());
		item.setIsbn(livro.getIsbn());
		item.setNumPaginas(livro.getNumPaginas());
		item.setTema(livro.getTema());
		super.updateItem(item);
	}
	
}