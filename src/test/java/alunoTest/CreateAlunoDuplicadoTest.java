package alunoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.IAlunoService;
import uepb.web.ufab.service.inter.ICursoService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration

public class CreateAlunoDuplicadoTest {

	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IAlunoService alunoService;


	Aluno aluno;
	Curso curso;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		aluno.setCpf("10190673494");
		aluno.setEndereco("Rua s�o paulo, 666");
		aluno.setMatricula("142083011");
		aluno.setNaturalidade("Brasileiro");
		aluno.setNome("Pablo Monteiro Santos");
		aluno.setNomeDaMae("Cl�udia Monteiro Santos");
		aluno.setRg("3775630");
		aluno.setSenhaAcesso("admin");
		
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ci�ncia da Computa��o");
		curso.setTipoCurso(Curso.Tipo.GRA);
		cursoService.addItem(curso);
		
		aluno.setCurso(curso);
		alunoService.addItem(aluno);
		
		
	}

	@Test(expected = ItemDuplicadoException.class)
	public void createAlunoDuplicado() throws ItemDuplicadoException {
		alunoService.addItem(aluno);
	}
	
	@After
	public void removeAlunoECurso() throws ItemInexistenteException {
		alunoService.deleteItem(aluno.getId());
		cursoService.deleteItem(curso.getId());
	}
}
