package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.dao.inter.IJornalDao;
import uepb.web.ufab.model.itemAcervo.Jornal;
import uepb.web.ufab.service.inter.IJornalService;

@Service
public class JornalServiceImpl extends GenericServiceImpl<Jornal> implements IJornalService {

	private IJornalDao jornalDao;
    
	public JornalServiceImpl(){
    	
    }
    
    @Autowired
    public JornalServiceImpl(@Qualifier("jornalDaoImpl") IGenericDao<Jornal> genericDao) {
        super(genericDao);
        this.jornalDao = (IJornalDao) genericDao;
    }
	
	
    @Transactional
	public void updateJornal(Jornal jornal) {
		jornalDao.updateJornal(jornal);
	}

}
