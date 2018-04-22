package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

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
	/** Busca o Aluno
	 *  @return Lista de Alunos passado pelo
	 *  @param hql 
	 */
	@SuppressWarnings("unchecked")
	public List<Aluno> getAllAlunos() {
		String hql = "FROM Aluno as i ORDER BY i.id";
		return (List<Aluno>) hibernateTemplate.find(hql);
	}
	/** @return retorna o Aluno atraves do
	 *  @param id
	 */
	public Aluno getAlunoById(int id) {
		return hibernateTemplate.get(Aluno.class, id);
	}
	/** Adiciona um Aluno atraves do
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
	 */
	public void deleteAluno(int id) {
		hibernateTemplate.delete(getAlunoById(id));
	}
	/** Verifica a existencia do Aluno atraves do
	 * @param cpf
	 * @param hql
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean alunoExists(String cpf) {
		String hql = "FROM Aluno as i WHERE i.cpf = ?";	
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, cpf);
		return items.size() > 0 ? true : false;
	}
}
