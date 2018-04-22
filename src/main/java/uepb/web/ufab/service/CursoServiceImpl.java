package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Autowired
	private CursoDao cursoDao;
	/** Busca o Curso
	 *  @return Lista de Curso
	 *  @param cursoDao 
	 */
	public List<Curso> getAllItems() {
		return cursoDao.getAllCursos();
	}
	/** Busca o Item
	 *  @return Item passado pelo
	 *  @param id 
	 */
	public Curso getItemById(int id) {
		return cursoDao.getCursoById(id);
	}
	/** Adiciona o Item atraves do Nome para o
 	 *  @param curso 
 	 *  @return false se o Curso não existir
	 *  @return true se o Curso existir
	 */
	public boolean addItem(Curso curso) {
		if (cursoDao.cursoExists(curso.getNome())){
	         return false;
      } else {
    	  cursoDao.addCurso(curso);
	         return true;
      }   
	}
	/** Atualiza o Curso do 
 	 *  @param curso 
	 */
	public void updateItem(Curso curso) {
		cursoDao.updateCurso(curso);
	}
	/** Deleta o Item do Curso atraves do 
 	 *  @param id 
	 */
	public void deleteItem(int id) {
		cursoDao.deleteCurso(id);
	}
}
