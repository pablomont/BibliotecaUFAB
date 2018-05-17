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
import uepb.web.ufab.model.itemAcervo.Livro;
import uepb.web.ufab.service.inter.ILivroService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class LivroTest{
	
	@Autowired private ILivroService livroService;
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
		livroService.addItem(livro);

	}
	
	
	@Test
	public void testRemoveLivro() throws ItemInexistenteException {
		livroService.deleteItem(livro.getId());
		assertEquals(0,livroService.getAllItems().size());
	}
	
}