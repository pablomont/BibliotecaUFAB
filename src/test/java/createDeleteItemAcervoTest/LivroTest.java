package createDeleteItemAcervoTest;

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
import uepb.web.ufab.service.ItemServiceImpl;

@ContextConfiguration(classes = { DBConfig.class ,LivroDao.class,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LivroTest{
	
	@Autowired private ItemServiceImpl itemServiceImpl;
	private Livro livro;
	
	@Before
	public void setUp() throws Exception {
		livro = new Livro();
		livro.setNomeItem("COSMOS");
		livro.setTema("Ficcao Cientifica");
		livro.setEditora("Universe books, inc");
		livro.addAutor("Carl Sagan");
		livro.setArea("Ciencia");
		livro.setNumPaginas(350);
		livro.setIsbn("123456789");
		
		//Adiciona um livro
		itemServiceImpl.addItem(livro);

	}
	
	
	@Test
	public void testRemoveLivro() {
		itemServiceImpl.deleteItem(livro.getId());
		assertEquals(0,itemServiceImpl.getAllItems().size());
	}
	
}