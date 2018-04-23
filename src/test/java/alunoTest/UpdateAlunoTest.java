package alunoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.ItemDuplicadoException;
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
public class UpdateAlunoTest {

	@Autowired private AlunoServiceImpl alunoServiceImpl;
	@Autowired private CursoServiceImpl cursoServiceImpl;
	
	Aluno aluno;
	Aluno aluno2;
	Curso curso;
	
	@Before
	public void setUp() throws Exception {
		aluno = new Aluno();
		aluno.setCpf("10190673494");
		aluno.setEndereco("Rua são paulo, 666");
		aluno.setMatricula("142083011");
		aluno.setNaturalidade("Brasileiro");
		aluno.setNome("Pablo Monteiro Santos");
		aluno.setNomeDaMae("Cláudia Monteiro Santos");
		aluno.setRg("3775630");
		aluno.setSenhaAcesso("admin");
		
		aluno2 = new Aluno();
		aluno2.setCpf("123456798");
		aluno.setMatricula("444222555");
		
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ciência da Computação");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		cursoServiceImpl.addItem(curso);
		
		aluno.setCurso(curso);
		aluno2.setCurso(curso);
		alunoServiceImpl.addItem(aluno);
		alunoServiceImpl.addItem(aluno2);
		
		
	}
	
	
	@Test
	public void updateAluno() throws ItemDuplicadoException, ItemInexistenteException {
		aluno.setSenhaAcesso("ROOT0011");
		alunoServiceImpl.updateItem(aluno);
		assertEquals(alunoServiceImpl.getItemById(aluno.getId()).getSenhaAcesso(),"ROOT0011");
	}
	
	@Test(expected = ItemDuplicadoException.class)
	public void updateAlunoMatriculaDuplicada() throws ItemDuplicadoException, ItemInexistenteException {
		aluno2.setMatricula(aluno.getMatricula());
		alunoServiceImpl.updateItem(aluno2);
	}
	
	
	@Test(expected = ItemInexistenteException.class)
	public void updateAlunoInexistente() throws ItemDuplicadoException, ItemInexistenteException{
		Aluno aluno3 = new Aluno();
		aluno3.setCpf("123456");
		aluno3.setMatricula("00022255");
		
		alunoServiceImpl.updateItem(aluno3);
	}
	
	@After
	public void deleteAlunos() {
		alunoServiceImpl.deleteItem(aluno.getId());
		alunoServiceImpl.deleteItem(aluno2.getId());
	}
	
	@After
	public void deleteCurso() { 
		cursoServiceImpl.deleteItem(curso.getId());
	}

}
