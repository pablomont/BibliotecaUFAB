package uepb.web.ufab.service.inter;

import uepb.web.ufab.model.Curso;

public interface ICursoService extends IGenericService<Curso> {
	void updateCurso(Curso curso);
}
