package cursoTest;

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
import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.CursoServiceImpl;

@ContextConfiguration(classes = { DBConfig.class , CursoDao.class,CursoServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class UpdateCursoTest {

	@Autowired private CursoServiceImpl cursoServiceImpl;
	private Curso curso;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ciência da Computação");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		
		
		cursoServiceImpl.addItem(curso);
	}
	
	@Test
	public void updateCurso() throws ItemDuplicadoException, ItemInexistenteException {
		curso.setTipoCurso(Curso.Tipo.POS);
		cursoServiceImpl.updateItem(curso);
		assertEquals(cursoServiceImpl.getItemById(curso.getId()).getTipoCurso(),Curso.Tipo.POS);
	}
	
	@After
	public void removeCurso() throws ItemInexistenteException {
		cursoServiceImpl.deleteItem(curso.getId());
	}

}
