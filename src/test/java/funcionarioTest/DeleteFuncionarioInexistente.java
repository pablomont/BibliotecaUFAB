package funcionarioTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.ItemInexistenteException;
import uepb.web.ufab.config.DBConfig;
import uepb.web.ufab.dao.FuncionarioDao;
import uepb.web.ufab.model.Funcionario;
import uepb.web.ufab.service.FuncionarioServiceImpl;

@ContextConfiguration(classes = { DBConfig.class , FuncionarioDao.class, FuncionarioServiceImpl.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeleteFuncionarioInexistente {
	
	@Autowired private FuncionarioServiceImpl funcionarioServiceImpl;
	Funcionario funcionario;
	

	@Test(expected = ItemInexistenteException.class)
	public void deleteFuncionarioInexistente() throws ItemInexistenteException {
		funcionario = new Funcionario();
		funcionario.setCpf("10159874563");
		funcionario.setRg("3775698");
		funcionarioServiceImpl.deleteFuncionarioByCpf(funcionario.getCpf());
		
	}

}
