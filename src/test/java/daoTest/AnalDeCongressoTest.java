package daoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.AnalDeCongressoDao;
import uepb.web.ufab.dao.LivroDao;
import uepb.web.ufab.dao.TrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
@ContextConfiguration(classes = { DBConfig.class , AnalDeCongressoDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AnalDeCongressoTest {

	@Autowired private  AnalDeCongressoDao itemDaoImpl;
	private AnalDeCongresso analdecongressoDao;

	
	
	@Before
	public void setUp() throws Exception {
		analdecongressoDao = new AnalDeCongresso();
		analdecongressoDao.setTipo(AnalDeCongresso.TipoAnal.ARTIGO);
		analdecongressoDao.addAutor("PABLO");
		analdecongressoDao.setLocal("UEPB");
		
		itemDaoImpl.addItemAcervo(analdecongressoDao);
	}
	@Test
	public void testRemoveAnalDeCongresso() {
		itemDaoImpl.deleteItemAcervo(1);
		assertEquals(0,itemDaoImpl.getAllItems().size());
	}

}
