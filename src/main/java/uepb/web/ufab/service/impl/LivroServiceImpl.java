package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.dao.inter.ILivroDao;
import uepb.web.ufab.model.itemAcervo.Livro;
import uepb.web.ufab.service.inter.ILivroService;

@Service
public class LivroServiceImpl extends GenericServiceImpl<Livro> implements ILivroService {

	private ILivroDao livroDao;
    
	public LivroServiceImpl(){
    	
    }
    
    @Autowired
    public LivroServiceImpl(@Qualifier("livroDaoImpl") IGenericDao<Livro> genericDao) {
        super(genericDao);
        this.livroDao = (ILivroDao) genericDao;
    }
	
    @Transactional
	public void updateLivro(Livro Livro) {
		livroDao.updateLivro(Livro);
	}

}
