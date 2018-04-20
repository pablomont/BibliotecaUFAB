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
import uepb.web.ufab.dao.TrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.Revista;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
@ContextConfiguration(classes = { DBConfig.class , TrabalhoDeConclusaoDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class TrabalhoDeConclusaoTest {

		@Autowired private  TrabalhoDeConclusaoDao itemDaoImpl;
		private TrabalhoDeConclusao trabalhodeconclusao;

		
		
		@Before
		public void setUp() throws Exception {
			trabalhodeconclusao = new TrabalhoDeConclusao();
			trabalhodeconclusao.addAutor("George");
			trabalhodeconclusao.addOrientador("Daniel");
			trabalhodeconclusao.setLocal("UEPB");
			trabalhodeconclusao.setTipo(TrabalhoDeConclusao.TipoTrabalho.MONOGRAFIA);
			
			itemDaoImpl.addItemAcervo(trabalhodeconclusao);
		}
		@Test
		public void testRemoveRevista() {
			itemDaoImpl.deleteItemAcervo(1);
			assertEquals(0,itemDaoImpl.getAllItems().size());
		}

}
