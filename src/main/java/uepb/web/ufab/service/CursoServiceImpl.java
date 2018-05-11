package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Curso;

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
public class CursoServiceImpl implements IService<Curso> {
	
	private static final Logger logger = LogManager.getLogger(CursoServiceImpl.class);
	
	
	@Autowired
	private CursoDao cursoDao;
	/** Busca todos os Cursos
	 *  @return Lista de Cursos
	 */
	public List<Curso> getAllItems() {
		logger.info("CursoService: getAllItems()");
		return cursoDao.getAllItems();
	}
	/** Busca o Curso
	 *  @return Curso
	 *  @param id do curso
	 */
	public Curso getItemById(int id) throws ItemInexistenteException{
		
		if(!cursoDao.itemExists(id))
			throw new ItemInexistenteException("Curso inexistente");
		
		Curso c = cursoDao.getItemById(id);
		logger.info("CursoService: getItemByid(id), id = " + id +"result: "+c);
		return c;
	}
	/** Adiciona o Curso ao BD
 	 *  @param curso 
 	 *  @return false se o Curso não existir
	 *  @return true se o Curso existir
	 */
	public boolean addItem(Curso curso)  throws ItemDuplicadoException{
		if (cursoDao.itemExists(curso.getId())){
			throw new ItemDuplicadoException("Curso duplicado");
		}
		else {
			cursoDao.addItem(curso);
			logger.info("CursoService: addItem(curso), curso = " + curso);
			return true;       
		}   
		
	}
	/** Atualiza o Curso
 	 *  @param curso 
	 */
	public void updateItem(Curso curso) throws ItemDuplicadoException, ItemInexistenteException {
		
		if(!cursoDao.itemExists(curso.getId()))
			throw new ItemInexistenteException("Curso não existe");
		
		else {
			Curso cursoAux = cursoDao.getItemById(curso.getId());
					
			if(cursoAux.equals(curso)) {
				cursoDao.updateItem(curso);
				logger.info("CursoService: updateItem(curso), curso = " + curso);
			}
			
			else {
				throw new ItemDuplicadoException("Curso duplicado");
			}	
		}
			
		
	}
	/** Deleta o Item do Curso 
 	 *  @param id do curso
	 */
	public void deleteItem(int id) throws ItemInexistenteException{
		if(!cursoDao.itemExists(id))
			throw new ItemInexistenteException("Curso não existe");
		
		cursoDao.deleteItemById(id);
		logger.info("CursoService: deleteItem(id), id = "+id);
	}
}
