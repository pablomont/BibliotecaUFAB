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
import uepb.web.ufab.model.itemAcervo.Livro;


@ContextConfiguration(classes = { DBConfig.class , LivroDao.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class LivroTest {

	
	@Autowired private  LivroDao itemDaoImpl;
	private Livro livro;
	
	
	@Before
	public void setUp() throws Exception {
		livro = new Livro();
		livro.setNomeItem("COSMOS");
		livro.setTema("Ficção Científica");
		livro.setEditora("Universe books, inc");
		livro.addAutor("Carl Sagan");
		
		
		itemDaoImpl.addItemAcervo(livro);
	}
	
//	@Test
//	public void testUpdateLivro() {
//		Livro livro2 = (Livro) itemDaoImpl.getItemById(livro.getId());
//		livro2.setNomeItem("COSMOS UMA ODISSEIA NO ESPAÇO");
//		itemDaoImpl.updateItemAcervo(livro);
//		assertEquals(livro.getNomeItem(),"COSMOS UMA ODISSEIA NO ESPAÇO");
//	}
	
	@Test
	public void testRemoveLivro() {
		itemDaoImpl.deleteItemAcervo(1);
		assertEquals(0,itemDaoImpl.getAllItems().size());
	}
}