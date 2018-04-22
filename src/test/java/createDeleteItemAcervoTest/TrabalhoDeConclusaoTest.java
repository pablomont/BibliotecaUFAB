package createDeleteItemAcervoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.TrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
import uepb.web.ufab.service.ItemServiceImpl;
@ContextConfiguration(classes = { DBConfig.class , TrabalhoDeConclusaoDao.class ,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TrabalhoDeConclusaoTest {

		@Autowired private  ItemServiceImpl itemServiceImpl;
		private TrabalhoDeConclusao trabalhoDeconclusao;

		@Before
		public void setUp() throws Exception {
			trabalhoDeconclusao = new TrabalhoDeConclusao();
			trabalhoDeconclusao.addAutor("George");
			trabalhoDeconclusao.addOrientador("Daniel");
			trabalhoDeconclusao.setLocal("UEPB");
			trabalhoDeconclusao.setTipo(TrabalhoDeConclusao.TipoTrabalho.MONOGRAFIA);
			
			itemServiceImpl.addItem(trabalhoDeconclusao);
		}
		
		
		@Test
		public void testRemoveTrabalhoDeConclusao() {
			itemServiceImpl.deleteItem(trabalhoDeconclusao.getId());
			assertEquals(0,itemServiceImpl.getAllItems().size());
		}

}
