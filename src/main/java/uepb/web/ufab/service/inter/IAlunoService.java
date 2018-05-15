package uepb.web.ufab.service.inter;

import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;

public interface IAlunoService extends IGenericService<Aluno> {

	Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException;
	void deleteAlunoByMatricula(String matricula) throws ItemInexistenteException;
}
