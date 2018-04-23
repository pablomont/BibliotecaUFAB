package itemAcervoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.MidiaEletronicaDao;
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;
import uepb.web.ufab.service.ItemServiceImpl;
@ContextConfiguration(classes = { DBConfig.class , MidiaEletronicaDao.class ,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class MidiaEletronicaTest {

	@Autowired private  ItemServiceImpl itemServiceImpl;
	private MidiaEletronica midiaEletronica;

	
	
	@Before
	public void setUp() throws Exception {
		midiaEletronica = new MidiaEletronica();
		midiaEletronica.setTipo(MidiaEletronica.TipoMidia.CD);
		midiaEletronica.setNomeItem("Roberto Carlos");
		
		itemServiceImpl.addItemAcervo(midiaEletronica);
	}
	
	@Test
	public void testDeleteEletronica() {
		itemServiceImpl.deleteItemAcervo(midiaEletronica.getId());
		assertEquals(0,itemServiceImpl.getAllItems().size());
	}

}
