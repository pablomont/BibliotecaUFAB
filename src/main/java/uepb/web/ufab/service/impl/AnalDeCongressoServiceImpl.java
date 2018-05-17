package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.inter.IAnalDeCongressoDao;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.service.inter.IAnalDeCongressoService;

@Service
public class AnalDeCongressoServiceImpl extends GenericServiceImpl<AnalDeCongresso> implements IAnalDeCongressoService {

	private IAnalDeCongressoDao analDeCongressoDao;
    
	public AnalDeCongressoServiceImpl(){
    	
    }
    
    @Autowired
    public AnalDeCongressoServiceImpl(@Qualifier("analDeCongressoDaoImpl") IGenericDao<AnalDeCongresso> genericDao) {
        super(genericDao);
        this.analDeCongressoDao = (IAnalDeCongressoDao) genericDao;
    }
	
    @Transactional
	public void updateAnalDeCongresso(AnalDeCongresso analDeCongresso) {
    	analDeCongressoDao.updateAnalDeCongresso(analDeCongresso);
	}


}
