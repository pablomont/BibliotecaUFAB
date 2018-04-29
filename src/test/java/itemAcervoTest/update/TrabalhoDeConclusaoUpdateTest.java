package itemAcervoTest.update;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.ItemDuplicadoException;
import exception.ItemInexistenteException;
import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.TrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
import uepb.web.ufab.service.ItemServiceImpl;
@ContextConfiguration(classes = { DBConfig.class , TrabalhoDeConclusaoDao.class ,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class TrabalhoDeConclusaoUpdateTest {

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
	public void updateTrabalhoDeConclusao() throws ItemDuplicadoException, ItemInexistenteException {
		trabalhoDeconclusao.setNomeItem("Análise de usabilidade na educação");
		itemServiceImpl.updateItem(trabalhoDeconclusao);
		assertEquals(itemServiceImpl.getItemById(trabalhoDeconclusao.getId()).getNomeItem(),"Análise de usabilidade na educação");
	}
	

	@After
	public void testRemoveTrabalhoDeConclusao() throws ItemInexistenteException {
		itemServiceImpl.deleteItem(trabalhoDeconclusao.getId());
	}

}
