package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.CursoDao;
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
		return cursoDao.getAllCursos();
	}
	/** Busca o Curso
	 *  @return Curso
	 *  @param id do curso
	 */
	public Curso getItemById(int id) {
		
		Curso c = cursoDao.getCursoById(id);
		logger.info("CursoService: getItemByid(id), id = " + id +"result: "+c);
		return c;
	}
	/** Adiciona o Curso
 	 *  @param curso 
 	 *  @return false se o Curso não existir
	 *  @return true se o Curso existir
	 */
	public boolean addItem(Curso curso) {
		if (cursoDao.cursoExists(curso.getNome())){
	         return false;
      } else {
    	  cursoDao.addCurso(curso);
    	  logger.info("CursoService: addItem(curso), curso = " + curso);
	         return true;
      }   
	}
	/** Atualiza o Curso
 	 *  @param curso 
	 */
	public void updateItem(Curso curso) {
		cursoDao.updateCurso(curso);
		logger.info("CursoService: updateItem(curso), curso = " + curso);
	}
	/** Deleta o Item do Curso 
 	 *  @param id do curso
	 */
	public void deleteItem(int id) {
		cursoDao.deleteCurso(id);
		logger.info("cursoService: deleteItem(id), id = " + id);
	}
}
