package daoCreateDeleteTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.RevistaDao;
import uepb.web.ufab.model.itemAcervo.Revista;

@ContextConfiguration(classes = { DBConfig.class , RevistaDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class RevistaTest {

		@Autowired private  RevistaDao revistaDaoImpl;
		private Revista revista;

		
		
		@Before
		public void setUp() throws Exception {
			revista = new Revista();
			revista.setEditora("Abril");
			revista.setEdicao("2ª Edição");
			revista.setNumPaginas(30);	
			revista.setNomeItem("Lula Vs Bolsonaro");
			
			revistaDaoImpl.addItemAcervo(revista);
		}
		@Test
		public void testRemoveRevista() {
			revistaDaoImpl.deleteItemAcervo(1);
			assertEquals(0,revistaDaoImpl.getAllItems().size());
		}

}
