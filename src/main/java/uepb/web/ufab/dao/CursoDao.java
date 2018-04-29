package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.Curso;

@Configuration
@Transactional
@Repository

	/**
	* <h1>CursosDao</h1>
	* CursosDao é uma caracteristica especifica de um ou mais Alunos
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class CursoDao implements IDao<Curso> {

	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca os Cursos
	 *  @return Cursos dos Alunos 
	 */
	@SuppressWarnings("unchecked")
	public List<Curso> getAllItems() {
		String hql = "FROM Curso as i ORDER BY i.id";
		return (List<Curso>) hibernateTemplate.find(hql);
	}
	/** @return retorna o Curso do Aluno atraves do
	 *  @param id
	 */
	public Curso getItemById(int id) {
		return hibernateTemplate.get(Curso.class, id);
	}
	/** Adiciona um Curso atraves do
	 *  @param itemAcervo
	 */
	public void addItem(Curso itemAcervo) {
		hibernateTemplate.save(itemAcervo);

	}
	/** Altera as caracteristicas do Curso
	 *  @param curso 
	 */
	public void updateItem(Curso curso) {
		Curso cursoAux = getItemById(curso.getId());

		
		cursoAux.setArea(curso.getArea());
		cursoAux.setNome(curso.getNome());
		cursoAux.setTipoCurso(curso.getTipoCurso());
		
		hibernateTemplate.update(cursoAux);

	}
	/** Deleta o Curso atraves do ID
	 */
	public void deleteItemById(int id) {
		hibernateTemplate.delete(getItemById(id));
	}
	/** Verifica a existencia do item no acervo atraves do nome do item
	 * @param cursoName
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemExists(String cursoName) {
		String hql = "FROM Curso as i WHERE i.nomeCurso = ?";	
		List<Curso> items = (List<Curso>) hibernateTemplate.find(hql, cursoName);
		return items.size() > 0 ? true : false;
	}

}
