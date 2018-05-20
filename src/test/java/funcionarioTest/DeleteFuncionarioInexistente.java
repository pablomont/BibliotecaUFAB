package funcionarioTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import uepb.web.ufab.config.AppConfig;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Funcionario;
import uepb.web.ufab.service.inter.IFuncionarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@WebAppConfiguration
public class DeleteFuncionarioInexistente {
	
	@Autowired private IFuncionarioService funcionarioService;
	Funcionario funcionario;
	

	@Test(expected = ItemInexistenteException.class)
	public void deleteFuncionarioInexistente() throws ItemInexistenteException {
		funcionario = new Funcionario();
		funcionario.setCpf("10159874563");
		funcionario.setRg("3775698");
		funcionarioService.deleteFuncionarioByCpf(funcionario.getCpf());
		
	}

}
