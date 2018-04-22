package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.FuncionarioDao;
import uepb.web.ufab.model.Funcionario;


@Transactional
@Service
@Configuration
public class FuncionarioServiceImpl implements IService<Funcionario> {

	@Autowired
	private FuncionarioDao funcionarioDao;
	
	public List<Funcionario> getAllItems() {
		return funcionarioDao.getAllFuncionarios();
	}

	public Funcionario getItemById(int id) {
		return funcionarioDao.getFuncionarioById(id);
	}

	public boolean addItem(Funcionario funcionario) {
		if (funcionarioDao.funcionarioExists(funcionario.getCpf())){
			return false;
		}
		else {
			funcionarioDao.addFuncionario(funcionario);
	        return true;
		}   
	}

	public void updateItem(Funcionario funcionario) {
		funcionarioDao.updateFuncionario(funcionario);
		
	}

	public void deleteItem(int id) {
		funcionarioDao.deleteFuncionario(id);
		
	}

}
