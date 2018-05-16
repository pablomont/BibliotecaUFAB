package uepb.web.ufab.dao.inter;

import uepb.web.ufab.model.itemAcervo.Livro;

public interface ILivroDao extends IGenericDao<Livro> {
	void updateLivro(Livro Livro);
}
