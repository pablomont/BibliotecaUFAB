package funcionarioTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.FuncionarioDao;
import uepb.web.ufab.model.Funcionario;
import uepb.web.ufab.service.FuncionarioServiceImpl;


@ContextConfiguration(classes = { DBConfig.class , FuncionarioDao.class, FuncionarioServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class FuncionarioUpdateTest {

	@Autowired private FuncionarioServiceImpl funcionarioServiceImpl;
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
		
		funcionarioServiceImpl.addItem(funcionario);
	}
	
	
	@Test
	public void updateFuncionario() {
		funcionario.setNivelAcesso(Funcionario.NivelAcesso.OPERADOR);
		funcionarioServiceImpl.updateItem(funcionario);
		assertEquals(funcionarioServiceImpl.getItemById(funcionario.getId()).getNivelAcesso(),Funcionario.NivelAcesso.OPERADOR);
	}

	@After
	public void deleteFuncionario() {
		funcionarioServiceImpl.deleteItem(funcionario.getId());
	}

}
