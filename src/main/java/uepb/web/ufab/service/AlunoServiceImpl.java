package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import exception.ItemDuplicadoException;
import exception.ItemInexistenteException;
import uepb.web.ufab.dao.AlunoDao;
import uepb.web.ufab.model.Aluno;


@Transactional
@Service
@Configuration
	/**
	* <h1>AlunoServiceImpl</h1>
	* AlunoServiceImpl Implementa todos os serviços para o usuario Aluno
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AlunoServiceImpl implements IService<Aluno> {

	
	private static final Logger logger = LogManager.getLogger(AlunoServiceImpl.class);
	
	@Autowired
	private AlunoDao alunoDao;
	/** Busca todos os alunos
	 *  @return Lista dos alunos
	 */
	public List<Aluno> getAllItems() {
		logger.info("AlunoService: getAllItems()");
		return alunoDao.getAllAlunos();
	}
	/** Busca o Aluno
	 *  @return Aluno
	 *  @param id do Alundo 
	 */
	public Aluno getItemById(int id) {
		Aluno a = alunoDao.getAlunoById(id);
		logger.info("AlunoService: getItemByid(id) ,id = "+ id +"result: "+a);
		return a;
	}
	
	
	public Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException {
		Aluno a = alunoDao.getAlunoByMatricula(matricula);
		logger.info("AlunoService: getItemByid(id) ,id = "+ matricula +"result: "+a);
		return a;
	}
	
	
	/** Adiciona o Aluno pelo
 	 *  @param aluno 
	 *  @return true se o Aluno existir
	 * @throws ItemDuplicadoException lançada caso o aluno ja exista
	 */
	public boolean addItem(Aluno aluno) throws ItemDuplicadoException {
		
		if (alunoDao.alunoExists(aluno.getMatricula())){
			throw new ItemDuplicadoException("Aluno duplicado");
		}
		else {
			alunoDao.addAluno(aluno);
			logger.info("AlunoService: addItem(aluno), aluno = " + aluno);
			return true;
	        
		}   
	}
	/** Atualiza o Aluno
 	 *  @param aluno 
	 * @throws ItemDuplicadoException 
	 * @throws ItemInexistenteException 
	 */
	public void updateItem(Aluno aluno) throws ItemDuplicadoException, ItemInexistenteException {
		Aluno alunoAux = alunoDao.getAlunoByMatricula(aluno.getMatricula());
		
		if(alunoAux.equals(null) || alunoAux.getCpf().equals(aluno.getCpf())) {
			alunoDao.updateAluno(aluno);
			logger.info("AlunoService: updateItem(aluno), aluno = " + aluno);
		}

		else {
			throw new ItemDuplicadoException("Matricula duplicada");
		}
		
		
	}
	/** Deleta o Item do Aluno atraves do seu id
 	 *  @param id 
	 */
	public void deleteItem(int id) {
		
		alunoDao.deleteAlunoById(id);
		logger.info("AlunoService: deleteItem(id), id = "+id);
	}
	
	public void deleteItemByMatricula(String matricula) throws DataAccessException, ItemInexistenteException {
		
		alunoDao.deleteAlunoByMatricula(matricula);
		logger.info("AlunoService: deleteItem(matricula), matricula = "+matricula);
	}

}
