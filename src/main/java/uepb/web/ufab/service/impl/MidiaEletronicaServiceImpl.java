package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.dao.inter.IMidiaEletronicaDao;
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;
import uepb.web.ufab.service.inter.IMidiaEletronicaService;


@Service
public class MidiaEletronicaServiceImpl extends GenericServiceImpl<MidiaEletronica> implements IMidiaEletronicaService {

	private IMidiaEletronicaDao midiaEletronicaDao;
    
	public MidiaEletronicaServiceImpl(){
    	
    }
    
    @Autowired
    public MidiaEletronicaServiceImpl(@Qualifier("midiaEletronicaDaoImpl") IGenericDao<MidiaEletronica> genericDao) {
        super(genericDao);
        this.midiaEletronicaDao = (IMidiaEletronicaDao) genericDao;
    }
	
    @Transactional
	public void updateMidiaEletronica(MidiaEletronica midiaEletronica) {
		midiaEletronicaDao.updateMidiaEletronica(midiaEletronica);

	}

}
