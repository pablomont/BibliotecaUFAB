package updateDaoTest;

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
public class LivroUpdateTest {

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
	public void updateLivro(){
		livro.setNomeItem("COSMOS UMA ODISSEIA NO ESPA�O");
		itemDaoImpl.updateItemAcervo(livro);
		assertEquals(itemDaoImpl.getItemById(livro.getId()).getNomeItem(),"COSMOS UMA ODISSEIA NO ESPA�O");
	}
	
	
}
