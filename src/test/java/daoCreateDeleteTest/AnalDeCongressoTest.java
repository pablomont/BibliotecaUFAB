package daoCreateDeleteTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.AnalDeCongressoDao;
import uepb.web.ufab.model.itemAcervo.AnalDeCongresso;
@ContextConfiguration(classes = { DBConfig.class , AnalDeCongressoDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class AnalDeCongressoTest {

	@Autowired private  AnalDeCongressoDao analDeCongressoImpl;
	private AnalDeCongresso analdecongresso;

	
	
	@Before
	public void setUp() throws Exception {
		analdecongresso = new AnalDeCongresso();
		analdecongresso.setTipo(AnalDeCongresso.TipoAnal.ARTIGO);
		analdecongresso.addAutor("PABLO");
		analdecongresso.setLocal("UEPB");
		analdecongresso.setNomeItem("CBA 2018");
		
		analDeCongressoImpl.addItemAcervo(analdecongresso);
	}
	@Test
	public void testRemoveAnalDeCongresso() {
		analDeCongressoImpl.deleteItemAcervo(1);
		assertEquals(0,analDeCongressoImpl.getAllItems().size());
	}


}
