package itemAcervoTest.createDelete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.RevistaDao;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.itemAcervo.Revista;
import uepb.web.ufab.service.ItemServiceImpl;

@ContextConfiguration(classes = { DBConfig.class , RevistaDao.class ,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RevistaTest {

		@Autowired private  ItemServiceImpl itemServiceImpl;
		private Revista revista;

		@Before
		public void setUp() throws Exception {
			revista = new Revista();
			revista.setEditora("Abril");
			revista.setEdicao("2ª Edição");
			revista.setNumPaginas(30);	
			revista.setNomeItem("Lula Vs Bolsonaro");
			
			itemServiceImpl.addItem(revista);
		}
		
		@Test
		public void testRemoveRevista() throws ItemInexistenteException {
			itemServiceImpl.deleteItem(revista.getId());
			assertEquals(0,itemServiceImpl.getAllItems().size());
		}

}
