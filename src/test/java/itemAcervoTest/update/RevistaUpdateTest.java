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
import uepb.web.ufab.model.itemAcervo.Revista;
import uepb.web.ufab.service.inter.IRevistaService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class RevistaUpdateTest {

	@Autowired private  IRevistaService revistaService;
	private Revista revista;
	
	@Before
	public void setUp() throws Exception {
		revista = new Revista();
		revista.setEditora("Abril");
		revista.setEdicao("2ª Edição");
		revista.setNumPaginas(30);	
		revista.setNomeItem("Lula Vs Bolsonaro");
		
		revistaService.addItem(revista);
	}
	
	@Test
	public void updateRevista() throws ItemDuplicadoException, ItemInexistenteException {
		revista.setNomeItem("Lula vs Bolsomito");
		revistaService.updateRevista(revista);
		assertEquals(revistaService.getItemById(revista.getId()).getNomeItem(),"Lula vs Bolsomito");
	}
	
	@After
	public void removeLivra() throws ItemInexistenteException {
		revistaService.deleteItem(revista.getId());
	}

}
