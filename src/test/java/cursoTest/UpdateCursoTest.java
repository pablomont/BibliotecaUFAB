package cursoTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.CursoServiceImpl;

@ContextConfiguration(classes = { DBConfig.class , CursoDao.class,CursoServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UpdateCursoTest {

	@Autowired private CursoServiceImpl cursoServiceImpl;
	private Curso curso;
	//private Curso curso2;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ciência da Computação");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		
//		curso2 = new Curso();
//		curso2.setArea("HUMANAS");
//		curso2.setNome("HISTÓRIA");
//	
		
		
		cursoServiceImpl.addItem(curso);
		//cursoServiceImpl.addItem(curso2);
	}
	
	@Test
	public void updateCurso() throws ItemDuplicadoException, ItemInexistenteException {
		curso.setTipoCurso(Curso.Tipo.POS);
		cursoServiceImpl.updateItem(curso);
		assertEquals(cursoServiceImpl.getItemById(curso.getId()).getTipoCurso(),Curso.Tipo.POS);
	}
	
	//@Test(expected = ItemDuplicadoException.class)
//	public void updateCursoDuplicado() throws ItemDuplicadoException, ItemInexistenteException {
//		curso2.setMatricula(aluno.getMatricula());
//		alunoServiceImpl.updateItem(aluno2);
//	}
//	
//	@Test(expected = ItemInexistenteException.class)
//	public void updateAlunoInexistente() throws ItemDuplicadoException, ItemInexistenteException{
//		Aluno aluno3 = new Aluno();
//		aluno3.setCpf("123456");
//		aluno3.setMatricula("00022255");
//		
//		alunoServiceImpl.updateItem(aluno3);
//	}
//	
	
	@After
	public void removeCurso() throws ItemInexistenteException {
		cursoServiceImpl.deleteItem(curso.getId());
	}

}
