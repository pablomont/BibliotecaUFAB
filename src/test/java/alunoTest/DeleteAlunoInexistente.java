package alunoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.IAlunoService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class DeleteAlunoInexistente {

	@Autowired
	private IAlunoService alunoService;

	@Test(expected = ItemInexistenteException.class)
	public void deleteAlunoInexistente() throws DataAccessException, ItemInexistenteException {
		Aluno aluno2 = new Aluno();
		aluno2.setCpf("1234567826");
		aluno2.setMatricula("555444333");
		Curso curso = new Curso();
		curso.setNome("fisioterapia");
		aluno2.setCurso(curso);
		alunoService.deleteAlunoByMatricula(aluno2.getMatricula());
	}
}
