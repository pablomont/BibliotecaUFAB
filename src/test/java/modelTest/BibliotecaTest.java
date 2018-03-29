package modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import org.junit.Test;

import exception.AcessoNegadoException;
import exception.ItemExistenteException;
import exception.ItemInexistenteException;
import model.AnalDeCongresso;
import model.Biblioteca;
import model.Funcionario;
import model.ItemAcervo;
import model.Jornal;
import model.Livro;
import model.MidiaEletronica;
import model.Revista;
import model.TrabalhoDeConclusao;
import model.AnalDeCongresso.TipoAnal;
import model.Funcionario.NivelAcesso;
import model.MidiaEletronica.TipoMidia;
import model.TrabalhoDeConclusao.TipoTrabalho;

public class BibliotecaTest {

	Biblioteca biblioteca;
	Funcionario admin;
	Funcionario operador;
	
	@Before
	public void setUp() throws Exception {
		admin = new Funcionario("Pablo",NivelAcesso.ADMIN,"10190673494");
		operador = new Funcionario("Samuel",NivelAcesso.OPERADOR, "91203647506");
		biblioteca = new Biblioteca();
		biblioteca.addFuncionario(admin);
		biblioteca.addFuncionario(operador);	
		biblioteca.setUsuarioAtualDoSistema(admin);
		biblioteca.criarItem(new Livro("978-85-359-2988-1","Cosmos"));
		biblioteca.criarItem(new MidiaEletronica(TipoMidia.DVD,"Telecurso 2000"));
		biblioteca.criarItem(new Revista("Enem Curiosidadea"));
		biblioteca.criarItem(new TrabalhoDeConclusao("Internet das Coisas: estudo do simulador COOJA",TipoTrabalho.MONOGRAFIA));
		biblioteca.criarItem(new Jornal("Jornal da Paraíba"));
		biblioteca.criarItem(new AnalDeCongresso(TipoAnal.ARTIGO, "Utilização do HFACS na análise de acidentes industriais"));
	}
	
	
	
	@Test
	public void testAdminCreateItem() throws AcessoNegadoException, ItemExistenteException{		
		biblioteca.setUsuarioAtualDoSistema(admin);
		biblioteca.criarItem(new Livro("972-66-010-4598-1","Uma Breve História do Tempo: do Big Bang aos Buracos Negros"));
		
		assertEquals(biblioteca.getItemsAcervo().size(),7);
	}
	
	@Test(expected = AcessoNegadoException.class)
	public void testOperadorCreateItem() throws AcessoNegadoException, ItemExistenteException {		
		biblioteca.setUsuarioAtualDoSistema(operador);
		biblioteca.criarItem(new Livro("972-66-010-4598-1","Uma Breve História do Tempo: do Big Bang aos Buracos Negros"));
	}
	
	@Test(expected = ItemExistenteException.class)
	public void testCreateItemExistente() throws AcessoNegadoException, ItemExistenteException {
		biblioteca.criarItem(new Livro("978-85-359-2988-1","Cosmos"));
	}
	
	@Test
	public void testRemoveItem() throws AcessoNegadoException, ItemInexistenteException {
		biblioteca.removeItem(new Livro("978-85-359-2988-1","Cosmos"));
		assertEquals(biblioteca.getItemsAcervo().size(),5);
	}
	
	@Test(expected = ItemInexistenteException.class)
	public void testRemoveItemInexistente() throws AcessoNegadoException, ItemInexistenteException {
		biblioteca.removeItem(new Livro("973-80-309-2587-1","O Mundo assombrado pelos demônios"));
	}
	
	@Test
	public void testEditItem() throws AcessoNegadoException, ItemInexistenteException {
		ItemAcervo livro = new Livro("978-85-359-2988-1","Cosmos");
		ItemAcervo livroAlterado = new Livro("978-85-359-2988-1","Cosmos, por Carl Sagan");
		
		biblioteca.editarItem(livro, livroAlterado);
		assertEquals(biblioteca.getItemsAcervo().size(),6);
		assertTrue(biblioteca.getItemsAcervo().contains(livroAlterado));
	}
	
}
