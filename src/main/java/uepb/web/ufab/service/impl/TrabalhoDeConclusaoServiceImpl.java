package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.dao.inter.ITrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
import uepb.web.ufab.service.inter.ITrabalhoDeConclusaoService;

@Service
public class TrabalhoDeConclusaoServiceImpl extends GenericServiceImpl<TrabalhoDeConclusao>
		implements ITrabalhoDeConclusaoService {

	
	private ITrabalhoDeConclusaoDao trabalhoDeConclusaDao;
    
	public TrabalhoDeConclusaoServiceImpl(){
    	
    }
    
    @Autowired
    public TrabalhoDeConclusaoServiceImpl(@Qualifier("trabalhoDeConclusaoDaoImpl") IGenericDao<TrabalhoDeConclusao> genericDao) {
        super(genericDao);
        this.trabalhoDeConclusaDao = (ITrabalhoDeConclusaoDao) genericDao;
    }
	
    @Transactional
	public void updateTrabalhoDeConclusao(TrabalhoDeConclusao trabalhoDeConclusao) {
		trabalhoDeConclusaDao.updateTrabalhoDeConclusao(trabalhoDeConclusao);
		
	}


}
