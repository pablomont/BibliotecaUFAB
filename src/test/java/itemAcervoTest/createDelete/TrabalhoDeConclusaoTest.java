package itemAcervoTest.createDelete;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
import uepb.web.ufab.service.inter.ITrabalhoDeConclusaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class TrabalhoDeConclusaoTest {

		@Autowired private  ITrabalhoDeConclusaoService trabalhoDeConclusaoService;
		private TrabalhoDeConclusao trabalhoDeconclusao;

		@Before
		public void setUp() throws Exception {
			trabalhoDeconclusao = new TrabalhoDeConclusao();
			trabalhoDeconclusao.addAutor("George");
			trabalhoDeconclusao.addOrientador("Daniel");
			trabalhoDeconclusao.setLocal("UEPB");
			trabalhoDeconclusao.setTipo(TrabalhoDeConclusao.TipoTrabalho.MONOGRAFIA);
			
			trabalhoDeConclusaoService.addItem(trabalhoDeconclusao);
		}
		
		
		@Test
		public void testRemoveTrabalhoDeConclusao() throws ItemInexistenteException {
			trabalhoDeConclusaoService.deleteItem(trabalhoDeconclusao.getId());
			assertEquals(0,trabalhoDeConclusaoService.getAllItems().size());
		}

}
