 package cursoTest;

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
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.ICursoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class CreateCursoDuplicadoTest {

	@Autowired
	private ICursoService cursoService;
	private Curso curso;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ci�ncia da Computa��o");
		curso.setTipoCurso(Curso.Tipo.GRA);
		
		
		cursoService.addItem(curso);
	}
	
	@Test(expected = ItemDuplicadoException.class)
	public void createCursoDuplicado() throws ItemDuplicadoException {
		cursoService.addItem(curso);
	}
	
	@After
	public void removeCurso() throws ItemInexistenteException {
		cursoService.deleteItem(curso.getId());
	}

}
