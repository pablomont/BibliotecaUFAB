package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.inter.IFuncionarioDao;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Funcionario;
import uepb.web.ufab.service.inter.IFuncionarioService;




	/**
	* <h1>CursoServiceImpl</h1>
	* CursoServiceImpl Implementa todos os serviços de Funcionário
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/


@Service
public class FuncionarioServiceImpl extends GenericServiceImpl<Funcionario> implements IFuncionarioService {

	private IFuncionarioDao funcionarioDao;
    
	public FuncionarioServiceImpl(){
    	
    }
    
    @Autowired
    public FuncionarioServiceImpl(@Qualifier("funcionarioDaoImpl") IGenericDao<Funcionario> genericDao) {
        super(genericDao);
        this.funcionarioDao = (IFuncionarioDao) genericDao;
    }
	
    @Transactional
	public void updateFuncionario(Funcionario funcionario) throws ItemInexistenteException, ItemDuplicadoException {
		if(!funcionarioDao.funcionarioExists(funcionario.getCpf()))
			throw new ItemInexistenteException("Funcionario não existe");
		
		else {
			Funcionario funcionarioAux = funcionarioDao.getFuncionarioByCpf(funcionario.getCpf());
					
			if(funcionarioAux.equals(funcionario)) {
				funcionarioDao.updateFuncionario(funcionario);
			}
			
			else {
				throw new ItemDuplicadoException("Funcionario duplicado");
			}	
		}
	}

	public void deleteFuncionarioByCpf(String cpf) throws ItemInexistenteException {
		if(!funcionarioDao.funcionarioExists(cpf))
			throw new ItemInexistenteException("Funcionario não existe");
		
		funcionarioDao.deleteFuncionarioByCpf(cpf);
		
	}

	
}
