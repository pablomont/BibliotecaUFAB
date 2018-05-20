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
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.service.inter.IAnalDeCongressoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class AnalDeCongressoUpdateTest{

	@Autowired private  IAnalDeCongressoService analDeCongressoService;
	private AnalDeCongresso analDecongresso;
	
	@Before
	public void setUp() throws Exception {
		analDecongresso = new AnalDeCongresso();
		analDecongresso.setTipo(AnalDeCongresso.TipoAnal.ARTIGO);
		analDecongresso.addAutor("PABLO");
		analDecongresso.setLocal("UEPB");
		analDecongresso.setNomeItem("CBA 2018");
		
		analDeCongressoService.addItem(analDecongresso);
	}
	
	@Test
	public void updateAnalDeCongresso() throws ItemDuplicadoException, ItemInexistenteException {
		analDecongresso.setNomeItem("CBA 2019");
		analDeCongressoService.updateAnalDeCongresso(analDecongresso);
		assertEquals(analDeCongressoService.getItemById(analDecongresso.getId()).getNomeItem(),"CBA 2019");
	}
	
	@After
	public void testRemoveAnalDeCongresso() throws ItemInexistenteException {
		analDeCongressoService.deleteItem(analDecongresso.getId());
	}
	
}
