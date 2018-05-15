package uepb.web.ufab.service.impl;


import javax.transaction.Transactional;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.IGenericService;

@Transactional
@Service
	/**
	* <h1>CursoServiceImpl</h1>
	* CursoServiceImpl Implementa todos os serviços de Curso
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class CursoServiceImpl extends GenericServiceImpl<Curso> implements IGenericService<Curso> {
	
}
