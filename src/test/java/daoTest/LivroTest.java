package daoTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
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

	
	@Autowired private LivroDao itemDaoImpl;
	private static Livro livro;
	
	
	@Before
	public void setUp() throws Exception {
		livro = new Livro();
		livro.setNomeItem("COSMOS");
		livro.setTema("Fic��o Cient�fica");
		livro.setEditora("Universe books, inc");
		livro.addAutor("Carl Sagan");
		
		//Adiciona um livro
		itemDaoImpl.addItemAcervo(livro);

	}
	
	@Test
	public void testRemoveLivro() {
		itemDaoImpl.deleteItemAcervo(1);
		assertEquals(0,itemDaoImpl.getAllItems().size());
	}
	
}