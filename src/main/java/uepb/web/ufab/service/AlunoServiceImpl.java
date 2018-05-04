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
		return alunoDao.getAllItems();

	}
	/** Busca o Aluno
	 *  @return Aluno
	 *  @param id do Alundo 
	 * @throws ItemInexistenteException 
	 */
	public Aluno getItemById(int id) throws ItemInexistenteException {
		
		if(alunoDao.itemExists(id)) {
			Aluno a = alunoDao.getItemById(id);
			logger.info("AlunoService: getItemByid(id) ,id = "+ id +"result: "+a);
			return a;
		}
		else {
			throw new ItemInexistenteException("Aluno inexistente");
		}
	}
	
	
	public Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException {
		
		if(alunoDao.itemExists(matricula)) {
			Aluno a = alunoDao.getAlunoByMatricula(matricula);
			logger.info("AlunoService: getAlunoByMatricula(matricula), matricula = "+ matricula +"result: "+a);
			return a;
		}
		else {
			throw new ItemInexistenteException("Aluno inexistente");
		}	
	}
	
	
	/** Adiciona o Aluno
 	 *  @param aluno 
	 *  @return true se o Aluno existir
	 * @throws ItemDuplicadoException lançada caso o aluno ja exista
	 */
	public boolean addItem(Aluno aluno) throws ItemDuplicadoException {
		
		if (alunoDao.itemExists(aluno.getMatricula())){
			throw new ItemDuplicadoException("Aluno duplicado");
		}
		else {
			alunoDao.addItem(aluno);
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
		
		
		if(!alunoDao.itemExists(aluno.getMatricula()))
			throw new ItemInexistenteException("Aluno não existe");
		
		else {
			Aluno alunoAux = alunoDao.getAlunoByMatricula(aluno.getMatricula());
					
			if(alunoAux.equals(aluno)) {
				alunoDao.updateItem(aluno);
				logger.info("AlunoService: updateItem(aluno), aluno = " + aluno);
			}
			
			else {
				throw new ItemDuplicadoException("Aluno duplicado");
			}	
		}
			
		
	}
	/** Deleta o Aluno atraves do seu id
 	 *  @param id 
	 * @throws ItemInexistenteException 
	 */
	public void deleteItem(int id) throws ItemInexistenteException {
		
		if(!alunoDao.itemExists(id))
			throw new ItemInexistenteException("Aluno não existe");
		
		alunoDao.deleteItemById(id);
		logger.info("AlunoService: deleteItem(id), id = "+id);
	}
	
	public void deleteItemByMatricula(String matricula) throws ItemInexistenteException {
		
		if(!alunoDao.itemExists(matricula))
			throw new ItemInexistenteException("Aluno não existe");
		
		alunoDao.deleteAlunoByMatricula(matricula);
		logger.info("AlunoService: deleteItem(matricula), matricula = "+matricula);
	}

}
