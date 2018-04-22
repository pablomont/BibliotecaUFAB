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
	/**
	* <h1>CursoServiceImpl</h1>
	* CursoServiceImpl Implementa todos os servi�os de Curso
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class FuncionarioServiceImpl implements IService<Funcionario> {

	@Autowired
	private FuncionarioDao funcionarioDao;
	/** Busca o Funcionario
	 *  @return Lista de Funcionario
	 *  @param funcionarioDao 
	 */
	public List<Funcionario> getAllItems() {
		return funcionarioDao.getAllFuncionarios();
	}
	/** Busca o Item
	 *  @return Item passado pelo
	 *  @param id 
	 */
	public Funcionario getItemById(int id) {
		return funcionarioDao.getFuncionarioById(id);
	}
	/** Adiciona o Item atraves do Cpf para o
 	 *  @param funcionario 
 	 *  @return false se o Funcionario n�o existir
	 *  @return true se o Funcionario existir 
	 */
	public boolean addItem(Funcionario funcionario) {
		if (funcionarioDao.funcionarioExists(funcionario.getCpf())){
			return false;
		}
		else {
			funcionarioDao.addFuncionario(funcionario);
	        return true;
		}   
	}
	/** Atualiza o Funcionario do 
 	 *  @param funcionario 
	 */
	public void updateItem(Funcionario funcionario) {
		funcionarioDao.updateFuncionario(funcionario);
		
	}
	/** Deleta o Funcionario atraves do 
 	 *  @param id 
	 */
	public void deleteItem(int id) {
		funcionarioDao.deleteFuncionario(id);
		
	}

}