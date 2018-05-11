package cursoTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.CursoServiceImpl;

@ContextConfiguration(classes = { DBConfig.class , CursoDao.class,CursoServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeleteCursoInexistente {

	@Autowired private CursoServiceImpl cursoServiceImpl;
	private Curso curso;
	
	@Test(expected = ItemInexistenteException.class)
	public void deleteCursoInexistente() throws ItemInexistenteException {
		curso = new Curso();
		curso.setArea("EXATAS");
		curso.setNome("COMPUTAÇÃO");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		
		cursoServiceImpl.deleteItem(curso.getId());
	}
}
