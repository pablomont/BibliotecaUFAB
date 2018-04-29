package itemAcervoTest.update;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.JornalDao;
import uepb.web.ufab.model.itemAcervo.Jornal;
import uepb.web.ufab.service.ItemServiceImpl;
@ContextConfiguration(classes = { DBConfig.class , JornalDao.class,ItemServiceImpl.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class JornalUpdateTest {

	@Autowired private  ItemServiceImpl itemServiceImpl;
	private Jornal jornal;
	
	@Before
	public void setUp() throws Exception {
		jornal = new Jornal();
		jornal.setEdicao("5ª edição");
		jornal.setNomeItem("Já!");
		
		itemServiceImpl.addItem(jornal);
	}
	@Test
	public void updateTest() {
		jornal.setNomeItem("Aqui, Agora!");
		itemServiceImpl.updateItem(jornal);
		assertEquals(itemServiceImpl.getItemById(jornal.getId()).getNomeItem(),"Aqui, Agora!");
	}
	
	@After
	public void removeJornal() {
		itemServiceImpl.deleteItem(jornal.getId());
	}

}
