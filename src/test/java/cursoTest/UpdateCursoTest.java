package cursoTest;

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
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.ICursoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class UpdateCursoTest {

	@Autowired
	private ICursoService cursoService;
	private Curso curso;
	
	@Before
	public void setUp() throws Exception {
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ciência da Computação");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		
		cursoService.addItem(curso);

	}
	
	@Test
	public void updateCurso() throws ItemDuplicadoException, ItemInexistenteException {
		curso.setTipoCurso(Curso.Tipo.POS);
		cursoService.updateCurso(curso);
		assertEquals(cursoService.getItemById(curso.getId()).getTipoCurso(),Curso.Tipo.POS);
	}

	@After
	public void removeCurso() throws ItemInexistenteException {
		cursoService.deleteItem(curso.getId());
	}

}
