package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import exception.ItemDuplicadoException;
import exception.ItemInexistenteException;
import uepb.web.ufab.dao.FuncionarioDao;
import uepb.web.ufab.model.Funcionario;


@Transactional
@Service
@Configuration
	/**
	* <h1>CursoServiceImpl</h1>
	* CursoServiceImpl Implementa todos os serviços de Curso
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class FuncionarioServiceImpl implements IService<Funcionario> {

	private static final Logger logger = LogManager.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioDao funcionarioDao;
	/** Busca os Funcionarios
	 *  @return Lista de Funcionarios
	 */
	public List<Funcionario> getAllItems() {
		logger.info("FuncionarioService: getAllItems()");
		return funcionarioDao.getAllItems();
	}
	/** Busca o Funcionario
	 *  @return Funcionário
	 *  @param id do funcionario
	 */
	public Funcionario getItemById(int id) throws ItemInexistenteException{
		Funcionario f = funcionarioDao.getItemById(id);
		logger.info("FuncionarioService: getItemByid(id), id = " + id +"result: "+f);
		return f;
	}
	/** Adiciona o Funcionario
 	 *  @param funcionario 
 	 *  @return false se o Funcionario não existir
	 *  @return true se o Funcionario existir 
	 */
	public boolean addItem(Funcionario funcionario) throws ItemDuplicadoException{
		if (funcionarioDao.itemExists(funcionario.getId())){
			return false;
		}
		else {
			funcionarioDao.addItem(funcionario);
			 logger.info("FuncionarioService: addItem(funcionario), funcionario = " + funcionario);
	        return true;
		}   
	}
	/** Atualiza o Funcionario
 	 *  @param funcionario 
	 */
	public void updateItem(Funcionario funcionario) throws ItemDuplicadoException, ItemInexistenteException{
		funcionarioDao.updateItem(funcionario);
		logger.info("FuncionarioService: updateItem(funcionario), funcionario = " + funcionario);
		
	}
	/** Deleta o Funcionario
 	 *  @param id do funcionario
	 */
	public void deleteItem(int id) throws ItemInexistenteException{
		funcionarioDao.deleteItemById(id);
		logger.info("FuncionarioService: deleteItem(id), id = " + id);	
	}
}
