package alunoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.ItemInexistenteException;
import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.AlunoDao;
import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.AlunoServiceImpl;
import uepb.web.ufab.service.CursoServiceImpl;


@ContextConfiguration(classes = { DBConfig.class , AlunoDao.class, CursoDao.class,CursoServiceImpl.class, AlunoServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeleteAlunoInexistente {

	@Autowired private AlunoServiceImpl alunoServiceImpl;

	@Test(expected = ItemInexistenteException.class)
	public void deleteAlunoInexistente() throws DataAccessException, ItemInexistenteException {
		Aluno aluno2 = new Aluno();
		aluno2.setCpf("1234567826");
		aluno2.setMatricula("555444333");
		Curso curso = new Curso();
		curso.setNome("fisioterapia");
		aluno2.setCurso(curso);
		alunoServiceImpl.deleteItemByMatricula(aluno2.getMatricula());
	}
}
