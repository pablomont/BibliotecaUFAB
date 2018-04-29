package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;


@Configuration
@Transactional
@Repository
	/**
	* <h1>AlunoDao</h1>
	* AlunoDao é um usuario do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AlunoDao implements IDao<Aluno> {
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos os Aluno
	 *  @return Lista de Alunos 
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Aluno> getAllItems() {
		String hql = "FROM Aluno as i ORDER BY i.id";
		return (List<Aluno>) hibernateTemplate.find(hql);
	}
	/** @return retorna o Aluno especificado pelo id
	 *  @param id 
	 */
	public Aluno getItemById(int id) {
		return hibernateTemplate.get(Aluno.class, id);
	}
	
	
	/** @return retorna o Aluno especificado pela matricula
	 *  @param matricula 
	 * @throws ItemInexistenteException 
	 */
	
	@SuppressWarnings("unchecked")
	public Aluno getAlunoByMatricula(String matricula)  {
		String hql = "FROM Aluno as i WHERE i.matricula = ?";
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
	
		return items.get(0);
	}
	
	
	/** Adiciona um Aluno 
	 *  @param aluno
	 */
	public void addItem(Aluno aluno) {
		hibernateTemplate.save(aluno);

	}
	/** Altera as caracteristicas do Aluno
	 *  @param aluno 
	 */
	public void updateItem(Aluno aluno) {
		Aluno alunoAux = getItemById(aluno.getId());

		alunoAux.setCpf(aluno.getCpf());
		alunoAux.setCurso(aluno.getCurso());
		alunoAux.setEndereco(aluno.getEndereco());
		alunoAux.setMatricula(aluno.getMatricula());
		alunoAux.setNaturalidade(aluno.getNaturalidade());
		alunoAux.setNome(aluno.getNome());
		alunoAux.setNomeDaMae(aluno.getNomeDaMae());
		alunoAux.setSenhaAcesso(aluno.getSenhaAcesso());
		alunoAux.setRg(aluno.getRg());
		hibernateTemplate.update(alunoAux);

	}
	/** Deleta o Aluno atraves do id
	 *@param id/
	 **/
	public void deleteItemById(int id) {
		hibernateTemplate.delete(getItemById(id));
	}
	
	public void deleteAlunoByMatricula(String matricula) {
		hibernateTemplate.delete(getAlunoByMatricula(matricula));
	}
	
	
	/** Verifica a existencia do Aluno através  do seu cpf
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemExists(String matricula) {
		String hql = "FROM Aluno as i WHERE i.matricula = ?";	
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
		return items.size() > 0 ? true : false;
	}
	
	/** Verifica a existencia do Aluno através  do seu cpf
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean itemExists(int id) {
		String hql = "FROM Aluno as i WHERE i.id = ?";	
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, id);
		return items.size() > 0 ? true : false;
	}
	
	
	
	
}
