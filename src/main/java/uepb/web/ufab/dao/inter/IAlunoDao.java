package uepb.web.ufab.dao.inter;

import uepb.web.ufab.model.*;

public interface IAlunoDao extends IGenericDao<Aluno>{

	Aluno getAlunoByMatricula(String matricula);
	void deleteAlunoByMatricula(String matricula);
	boolean itemExists(String matricula);
}
