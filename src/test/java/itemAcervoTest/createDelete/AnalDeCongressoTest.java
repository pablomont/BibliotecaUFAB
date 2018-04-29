package itemAcervoTest.createDelete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.ItemInexistenteException;
import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.AnalDeCongressoDao;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.service.ItemServiceImpl;
@ContextConfiguration(classes = { DBConfig.class , AnalDeCongressoDao.class,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AnalDeCongressoTest{

	@Autowired private  ItemServiceImpl itemServiceImpl;
	private AnalDeCongresso analDecongresso;
	
	@Before
	public void setUp() throws Exception {
		analDecongresso = new AnalDeCongresso();
		analDecongresso.setTipo(AnalDeCongresso.TipoAnal.ARTIGO);
		analDecongresso.addAutor("PABLO");
		analDecongresso.setLocal("UEPB");
		analDecongresso.setNomeItem("CBA 2018");
		
		itemServiceImpl.addItem(analDecongresso);
	}
		
	
	@Test
	public void testRemoveAnalDeCongresso() throws ItemInexistenteException {
		itemServiceImpl.deleteItem(analDecongresso.getId());
		assertEquals(0,itemServiceImpl.getAllItems().size());
	}


}
