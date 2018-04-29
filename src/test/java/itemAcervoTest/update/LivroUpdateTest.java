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
import uepb.web.ufab.dao.LivroDao;
import uepb.web.ufab.model.itemAcervo.Livro;
import uepb.web.ufab.service.ItemServiceImpl;

@ContextConfiguration(classes = { DBConfig.class ,LivroDao.class,ItemServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class LivroUpdateTest{
	
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
	public void updateLivro() throws ItemDuplicadoException, ItemInexistenteException{
		livro.setNomeItem("COSMOS UMA ODISSEIA NO ESPAÇO");
		itemServiceImpl.updateItem(livro);
		assertEquals(itemServiceImpl.getItemById(livro.getId()).getNomeItem(),"COSMOS UMA ODISSEIA NO ESPAÇO");
	}

	
	@After
	public void testRemoveLivro() throws ItemInexistenteException {
		itemServiceImpl.deleteItem(livro.getId());
	}
}
