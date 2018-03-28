package itemsAcervo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LivroTest {

	Livro livro;
	
	@Before
	public void setUp() throws Exception {
		
		livro  = new Livro("978-85-359-2988-1","Cosmos");
		livro.setAnoDePublicacao(1980);
		livro.setEditora("SCHWARCZ S.A");
		livro.setArea("Ciência");
		livro.setTema("Divulgação científica");
		livro.addAutor("Carl Sagan");	
	}
	

	@Test(expected =IllegalArgumentException.class)
	public void testAddAutorExistente() {
		livro.addAutor("Carl Sagan");
		
	}
	
	@Test(expected =IllegalArgumentException.class)
	public void testRemoveAutorInexistente() {
		livro.removeAutor("Pablo Monteiro");
	}
	
	
	public void validateIsbn() {
		assertFalse(livro.validateIsbn13("123456"));	
	}

}
