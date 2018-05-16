package uepb.web.ufab.dao.inter;

import uepb.web.ufab.model.Curso;

public interface ICursoDao extends IGenericDao<Curso> {
	void updateCurso(Curso curso);
}
