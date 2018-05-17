package itemAcervoTest.createDelete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.itemAcervo.Jornal;
import uepb.web.ufab.service.inter.IJornalService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class JornalTest {

	@Autowired private  IJornalService jornalService;
	private Jornal jornal;
	
	@Before
	public void setUp() throws Exception {
		jornal = new Jornal();
		jornal.setEdicao("5ª edição");
		jornal.setNomeItem("Já!");
		
		jornalService.addItem(jornal);
	}
	
	
	@Test
	public void deleteJornal() throws ItemInexistenteException {
		jornalService.deleteItem(jornal.getId());
		assertEquals(0,jornalService.getAllItems().size());
	}

}
