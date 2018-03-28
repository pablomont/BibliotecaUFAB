package biblioteca;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import biblioteca.Funcionario.NivelAcesso;
import itemsAcervo.AnalDeCongresso;
import itemsAcervo.AnalDeCongresso.TipoAnal;
import itemsAcervo.Jornal;
import itemsAcervo.Livro;
import itemsAcervo.MidiaEletronica;
import itemsAcervo.MidiaEletronica.TipoMidia;
import itemsAcervo.Revista;
import itemsAcervo.TrabalhoDeConclusao;
import itemsAcervo.TrabalhoDeConclusao.TipoTrabalho;

public class TestBibliotecaUS01 {

	Biblioteca biblioteca;
	
	@Before
	public void setUp() throws Exception {
		biblioteca = new Biblioteca(new Funcionario("Pablo",NivelAcesso.ADMIN));
		biblioteca.addFuncionario(new Funcionario("Samuel",NivelAcesso.OPERADOR));
		
		biblioteca.criarItem(new Livro("978-85-359-2988-1","Cosmos"));
		biblioteca.criarItem(new MidiaEletronica(TipoMidia.DVD,"Telecurso 2000"));
		biblioteca.criarItem(new Revista("Enem Curiosidadea"));
		biblioteca.criarItem(new TrabalhoDeConclusao("Internet das Coisas: estudo do simulador COOJA",TipoTrabalho.MONOGRAFIA));
		biblioteca.criarItem(new Jornal("Jornal da Paraíba"));
		biblioteca.criarItem(new AnalDeCongresso(TipoAnal.ARTIGO, "Utilização do HFACS na análise de acidentes industriais"));
	}
	
	@Test
	public void test() {
		assertEquals(biblioteca.getItemsAcervo().size(),6);
	}

}
