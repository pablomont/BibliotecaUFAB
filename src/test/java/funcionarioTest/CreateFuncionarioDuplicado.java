package funcionarioTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Funcionario;
import uepb.web.ufab.service.inter.IFuncionarioService;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class CreateFuncionarioDuplicado {

	@Autowired private IFuncionarioService funcionarioService;
	Funcionario funcionario;
	
	@Before
	public void setUp() throws Exception {
		funcionario = new Funcionario();
		funcionario.setCpf("123456789");
		funcionario.setEmail("pablo.santos@elife.com.br");
		funcionario.setEndereco("Rua São Paulo, 666, Liberdade");
		funcionario.setNaturalidade("Brasileiro");
		funcionario.setNivelAcesso(Funcionario.NivelAcesso.ADMIN);
		funcionario.setNome("Pablo Monteiro Santos");
		funcionario.setNomeUsuario("Paabl");
		funcionario.setRg("3775730");
		funcionario.setSenha("admin");
		funcionario.setTelefone("83988258064");
		
		funcionarioService.addItem(funcionario);
	}

	@Test(expected = ItemDuplicadoException.class)
	public void createFuncionarioDuplicado() throws ItemDuplicadoException {
		funcionarioService.addItem(funcionario);
	}
	
	@After
	public void removeFuncionario() throws ItemInexistenteException {
		funcionarioService.deleteItem(funcionario.getId());
	}

}
