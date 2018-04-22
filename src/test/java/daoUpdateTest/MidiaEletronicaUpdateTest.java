package daoUpdateTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.MidiaEletronicaDao;
import uepb.web.ufab.model.itemAcervo.MidiaEletronica;


@ContextConfiguration(classes = { DBConfig.class , MidiaEletronicaDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class MidiaEletronicaUpdateTest {

	@Autowired private  MidiaEletronicaDao midiaEletronicaDaoImpl;
	private MidiaEletronica midiaEletronica;

	
	
	@Before
	public void setUp() throws Exception {
		midiaEletronica = new MidiaEletronica();
		midiaEletronica.setTipo(MidiaEletronica.TipoMidia.CD);
		midiaEletronica.setNomeItem("Roberto Carlos");

		
		midiaEletronicaDaoImpl.addItemAcervo(midiaEletronica);
	}
	
	@Test
	public void updateMidiaEletronica() {
		midiaEletronica.setNomeItem("Michael Jackson");
		midiaEletronicaDaoImpl.updateItemAcervo(midiaEletronica);
		assertEquals(midiaEletronicaDaoImpl.getItemById(midiaEletronica.getId()).getNomeItem(),"Michael Jackson");
	}
	
	@After
	public void removeTrabalhoDeConclusao() {
		midiaEletronicaDaoImpl.deleteItemAcervo(midiaEletronica.getId());
	}

}
