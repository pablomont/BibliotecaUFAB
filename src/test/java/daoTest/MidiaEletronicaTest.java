package daoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.LivroDao;
import uepb.web.ufab.dao.MidiaEletronicaDao;
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;
import uepb.web.ufab.model.itemAcervo.Revista;
@ContextConfiguration(classes = { DBConfig.class , MidiaEletronicaDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class MidiaEletronicaTest {

	@Autowired private  MidiaEletronicaDao itemDaoImpl;
	private MidiaEletronica midiaEletronica;

	
	
	@Before
	public void setUp() throws Exception {
		midiaEletronica = new MidiaEletronica();
		midiaEletronica.setTipo(MidiaEletronica.TipoMidia.CD);
		midiaEletronica.setNomeItem("Roberto Carlos");
		
		itemDaoImpl.addItemAcervo(midiaEletronica);
	}
	@Test
	public void testMidiaEletronica() {
		itemDaoImpl.deleteItemAcervo(1);
		assertEquals(0,itemDaoImpl.getAllItems().size());
	}

}
