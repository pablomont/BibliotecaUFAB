package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.dao.inter.IRevistaDao;
import uepb.web.ufab.model.itemAcervo.Revista;
import uepb.web.ufab.service.inter.IRevistaService;

@Service
public class RevistaServiceImpl extends GenericServiceImpl<Revista> implements IRevistaService {

	private IRevistaDao revistaDao;
    
	public RevistaServiceImpl(){
    	
    }
    
    @Autowired
    public RevistaServiceImpl(@Qualifier("revistaDaoImpl") IGenericDao<Revista> genericDao) {
        super(genericDao);
        this.revistaDao = (IRevistaDao) genericDao;
    }
	
    @Transactional
	public void updateRevista(Revista revista) {
		revistaDao.updateRevista(revista);

	}

}
