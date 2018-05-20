package itemAcervoTest.update;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;
import uepb.web.ufab.service.inter.ITrabalhoDeConclusaoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class TrabalhoDeConclusaoUpdateTest {

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
	public void updateTrabalhoDeConclusao() throws ItemDuplicadoException, ItemInexistenteException {
		trabalhoDeconclusao.setNomeItem("Análise de usabilidade na educação");
		trabalhoDeConclusaoService.updateTrabalhoDeConclusao(trabalhoDeconclusao);
		assertEquals(trabalhoDeConclusaoService.getItemById(trabalhoDeconclusao.getId()).getNomeItem(),"Análise de usabilidade na educação");
	}
	

	@After
	public void testRemoveTrabalhoDeConclusao() throws ItemInexistenteException {
		trabalhoDeConclusaoService.deleteItem(trabalhoDeconclusao.getId());
	}

}
