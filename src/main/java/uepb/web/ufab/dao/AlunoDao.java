package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataAccessException;
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
public class AlunoDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca todos os Aluno
	 *  @return Lista de Alunos 
	 *  
	 */
	@SuppressWarnings("unchecked")
	public List<Aluno> getAllAlunos() {
		String hql = "FROM Aluno as i ORDER BY i.id";
		return (List<Aluno>) hibernateTemplate.find(hql);
	}
	/** @return retorna o Aluno especificado pelo id
	 *  @param id 
	 */
	public Aluno getAlunoById(int id) {
		return hibernateTemplate.get(Aluno.class, id);
	}
	
	
	/** @return retorna o Aluno especificado pela matricula
	 *  @param matricula 
	 * @throws ItemInexistenteException 
	 */
	
	@SuppressWarnings("unchecked")
	public Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException {
		String hql = "FROM Aluno as i WHERE i.matricula = ?";
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
		
		if(items.size() == 0) {
			throw new ItemInexistenteException("Matricula inexistente");
		}
		
		return items.get(0);
	}
	
	
	/** Adiciona um Aluno 
	 *  @param aluno
	 */
	public void addAluno(Aluno aluno) {
		hibernateTemplate.save(aluno);

	}
	/** Altera as caracteristicas do Aluno
	 *  @param aluno 
	 */
	public void updateAluno(Aluno aluno) {
		Aluno alunoAux = getAlunoById(aluno.getId());

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
	public void deleteAlunoById(int id) {
		hibernateTemplate.delete(getAlunoById(id));
	}
	
	public void deleteAlunoByMatricula(String matricula) throws DataAccessException, ItemInexistenteException {
		hibernateTemplate.delete(getAlunoByMatricula(matricula));
	}
	
	
	/** Verifica a existencia do Aluno através  do seu cpf
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean alunoExists(String matricula) {
		String hql = "FROM Aluno as i WHERE i.matricula = ?";	
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
		return items.size() > 0 ? true : false;
	}
}
