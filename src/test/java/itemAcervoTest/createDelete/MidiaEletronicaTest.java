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
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;
import uepb.web.ufab.service.inter.IMidiaEletronicaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class MidiaEletronicaTest {

	@Autowired private  IMidiaEletronicaService midiaEltronicaService;
	private MidiaEletronica midiaEletronica;

	
	
	@Before
	public void setUp() throws Exception {
		midiaEletronica = new MidiaEletronica();
		midiaEletronica.setTipo(MidiaEletronica.TipoMidia.CD);
		midiaEletronica.setNomeItem("Roberto Carlos");
		
		midiaEltronicaService.addItem(midiaEletronica);
	}
	
	@Test
	public void testDeleteEletronica() throws ItemInexistenteException {
		midiaEltronicaService.deleteItem(midiaEletronica.getId());
		assertEquals(0,midiaEltronicaService.getAllItems().size());
	}

}
