package daoCreateDeleteTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.JornalDao;
import uepb.web.ufab.model.itemAcervo.Jornal;

@ContextConfiguration(classes = { DBConfig.class , JornalDao.class })
@RunWith(SpringJUnit4ClassRunner.class)

public class JornalTest {

	@Autowired private  JornalDao jornalDaoImpl;
	private Jornal jornal;
	
	@Before
	public void setUp() throws Exception {
		jornal = new Jornal();
		jornal.setEdicao("5ª edição");
		jornal.setNomeItem("Já!");
		
		jornalDaoImpl.addItemAcervo(jornal);
	}
	@Test
	public void testDeleteJornal() {
		jornalDaoImpl.deleteItemAcervo(jornal.getId());
		assertEquals(0,jornalDaoImpl.getAllItems().size());
	}

}
