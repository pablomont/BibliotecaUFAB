package uepb.web.ufab.dao.impl;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.ICursoDao;
import uepb.web.ufab.model.Curso;



	/**
	* <h1>CursosDao</h1>
	* CursosDao é uma caracteristica especifica de um ou mais Alunos
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class CursoDaoImpl extends GenericDaoImpl<Curso> implements ICursoDao {

	public void updateCurso(Curso curso) {
		Curso cursoAux = getItemById(curso.getId());

		
		cursoAux.setArea(curso.getArea());
		cursoAux.setNome(curso.getNome());
		cursoAux.setTipoCurso(curso.getTipoCurso());
		
		super.updateItem(cursoAux);
		
	}

	
	

}
