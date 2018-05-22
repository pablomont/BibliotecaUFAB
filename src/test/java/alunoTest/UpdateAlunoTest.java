package alunoTest;

import static org.junit.Assert.*;

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
public class UpdateAlunoTest {

	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IAlunoService alunoService;
	
	Aluno aluno;
	Aluno aluno2;
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
		
		aluno2 = new Aluno();
		aluno2.setCpf("123456798");
		aluno.setMatricula("444222555");
		
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ci�ncia da Computa��o");
		curso.setTipoCurso(Curso.Tipo.GRA);
		cursoService.addItem(curso);
		
		aluno.setCurso(curso);
		aluno2.setCurso(curso);
		alunoService.addItem(aluno);
		alunoService.addItem(aluno2);
		
		
	}
	
	
	@Test
	public void updateAluno() throws ItemDuplicadoException, ItemInexistenteException {
		aluno.setSenhaAcesso("ROOT0011");
		alunoService.updateAluno(aluno);
		assertEquals(alunoService.getItemById(aluno.getId()).getSenhaAcesso(),"ROOT0011");
	}
	
	@Test(expected = ItemDuplicadoException.class)
	public void updateAlunoMatriculaDuplicada() throws ItemDuplicadoException, ItemInexistenteException {
		aluno2.setMatricula(aluno.getMatricula());
		alunoService.updateAluno(aluno2);
	}
	
	@Test(expected = ItemInexistenteException.class)
	public void updateAlunoInexistente() throws ItemDuplicadoException, ItemInexistenteException{
		Aluno aluno3 = new Aluno();
		aluno3.setCpf("123456");
		aluno3.setMatricula("00022255");
		
		alunoService.updateAluno(aluno3);
	}
	
	@After
	public void deleteAlunos() throws ItemInexistenteException {
		alunoService.deleteItem(aluno.getId());
		alunoService.deleteItem(aluno2.getId());
	}
	
	@After
	public void deleteCurso() throws ItemInexistenteException { 
		cursoService.deleteItem(curso.getId());
	}

}
