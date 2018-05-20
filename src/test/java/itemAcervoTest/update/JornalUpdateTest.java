package itemAcervoTest.update;

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
import uepb.web.ufab.model.itemAcervo.Jornal;
import uepb.web.ufab.service.inter.IJornalService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class JornalUpdateTest {

	@Autowired private  IJornalService jornalServiceImpl;
	private Jornal jornal;
	
	@Before
	public void setUp() throws Exception {
		jornal = new Jornal();
		jornal.setEdicao("5ª edição");
		jornal.setNomeItem("Já!");
		
		jornalServiceImpl.addItem(jornal);
	}
	@Test
	public void updateTest() throws ItemDuplicadoException, ItemInexistenteException {
		jornal.setNomeItem("Aqui, Agora!");
		jornalServiceImpl.updateJornal(jornal);
		assertEquals(jornalServiceImpl.getItemById(jornal.getId()).getNomeItem(),"Aqui, Agora!");
	}
	
	@After
	public void removeJornal() throws ItemInexistenteException {
		jornalServiceImpl.deleteItem(jornal.getId());
	}

}
