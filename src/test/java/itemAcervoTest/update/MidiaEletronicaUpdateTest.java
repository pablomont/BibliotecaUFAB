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
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;
import uepb.web.ufab.service.inter.IMidiaEletronicaService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class MidiaEletronicaUpdateTest {

	@Autowired private  IMidiaEletronicaService midiaEletronicaService;
	private MidiaEletronica midiaEletronica;

	
	
	@Before
	public void setUp() throws Exception {
		midiaEletronica = new MidiaEletronica();
		midiaEletronica.setTipo(MidiaEletronica.TipoMidia.CD);
		midiaEletronica.setNomeItem("Roberto Carlos");

		
		midiaEletronicaService.addItem(midiaEletronica);
	}
	
	@Test
	public void updateMidiaEletronica() throws ItemDuplicadoException, ItemInexistenteException {
		midiaEletronica.setNomeItem("Michael Jackson");
		midiaEletronicaService.updateMidiaEletronica(midiaEletronica);
		assertEquals(midiaEletronicaService.getItemById(midiaEletronica.getId()).getNomeItem(),"Michael Jackson");
	}
	
	@After
	public void removeTrabalhoDeConclusao() throws ItemInexistenteException {
		midiaEletronicaService.deleteItem(midiaEletronica.getId());
	}

}
