package alunoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		cursoServiceImpl.addItem(curso);
		
		aluno.setCurso(curso);
		alunoServiceImpl.addItem(aluno);
		
		
	}
	
	
	@Test
	public void updateAluno() {
		aluno.setSenhaAcesso("ROOT0011");
		alunoServiceImpl.updateItem(aluno);
		assertEquals(alunoServiceImpl.getItemById(aluno.getId()).getSenhaAcesso(),"ROOT0011");
	}
	
	@After
	public void deleteAluno() {
		alunoServiceImpl.deleteItem(aluno.getId());
	}
	
	@After
	public void deleteCurso() { 
		cursoServiceImpl.deleteItem(curso.getId());
	}

}
