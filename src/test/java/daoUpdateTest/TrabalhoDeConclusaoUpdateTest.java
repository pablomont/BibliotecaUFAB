package daoUpdateTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.TrabalhoDeConclusaoDao;
import uepb.web.ufab.model.itemAcervo.TrabalhoDeConclusao;

@ContextConfiguration(classes = { DBConfig.class , TrabalhoDeConclusaoDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class TrabalhoDeConclusaoUpdateTest {
	
	@Autowired private  TrabalhoDeConclusaoDao trabalhoDeConclusaoDaoImpl;
	private TrabalhoDeConclusao trabalhoDeConclusao;
	
	@Before
	public void setUp() throws Exception {
		trabalhoDeConclusao = new TrabalhoDeConclusao();
		trabalhoDeConclusao.addAutor("George");
		trabalhoDeConclusao.addOrientador("Daniel");
		trabalhoDeConclusao.setLocal("UEPB");
		trabalhoDeConclusao.setTipo(TrabalhoDeConclusao.TipoTrabalho.MONOGRAFIA);
		trabalhoDeConclusao.setNomeItem("Usabilidade em sofwtares educacionais");
		
		trabalhoDeConclusaoDaoImpl.addItemAcervo(trabalhoDeConclusao);
	}
	
	@Test
	public void updateTrabalhoDeConclusao() {
		trabalhoDeConclusao.setNomeItem("Análise de usabilidade na educação");
		trabalhoDeConclusaoDaoImpl.updateItemAcervo(trabalhoDeConclusao);
		assertEquals(trabalhoDeConclusaoDaoImpl.getItemById(trabalhoDeConclusao.getId()).getNomeItem(),"Análise de usabilidade na educação");
	}

	@After
	public void removeTrabalhoDeConclusao() {
		trabalhoDeConclusaoDaoImpl.deleteItemAcervo(trabalhoDeConclusao.getId());
	}
	
}
