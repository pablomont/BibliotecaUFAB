package uepb.web.ufab.service.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.inter.ICursoDao;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.ICursoService;

	/**
	* <h1>CursoServiceImpl</h1>
	* CursoServiceImpl Implementa todos os serviços de Curso
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/


@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso> implements ICursoService {

	private ICursoDao cursoDao;
    
	public CursoServiceImpl(){
    	
    }
    
    @Autowired
    public CursoServiceImpl(@Qualifier("cursoDaoImpl") IGenericDao<Curso> genericDao) {
        super(genericDao);
        this.cursoDao = (ICursoDao) genericDao;
    }
	
    @Transactional
	public void updateCurso(Curso curso) {
		cursoDao.updateCurso(curso);
	}

}
