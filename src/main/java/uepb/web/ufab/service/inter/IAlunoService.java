package uepb.web.ufab.service.inter;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;

public interface IAlunoService extends IGenericService<Aluno> {

	Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException;
	void deleteAlunoByMatricula(String matricula) throws ItemInexistenteException;
	void updateAluno(Aluno aluno) throws ItemDuplicadoException, ItemInexistenteException;
	void saveAluno(Aluno aluno)throws ItemDuplicadoException;
	String geraMatricula(Aluno aluno);

}
