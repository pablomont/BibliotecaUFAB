package cursoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.ICursoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class DeleteCursoInexistente {

	@Autowired
	private ICursoService cursoService;
	private Curso curso;
	
	@Test(expected = ItemInexistenteException.class)
	public void deleteCursoInexistente() throws ItemInexistenteException {
		curso = new Curso();
		curso.setArea("EXATAS");
		curso.setNome("COMPUTAÇÃO");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		
		cursoService.deleteItem(curso.getId());
	}
}
