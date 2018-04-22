package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.Funcionario;


@Configuration
@Transactional
@Repository
	/**
	* <h1>FuncionarioDao</h1>
	* FuncionarioDao é um usuario do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class FuncionarioDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	/** Busca os Funcionarios
	 *  @return Lista de Funcionarios
	 */
	@SuppressWarnings("unchecked")
	public List<Funcionario> getAllFuncionarios() {
		String hql = "FROM Funcionario as i ORDER BY i.id";
		return (List<Funcionario>) hibernateTemplate.find(hql);
	}
	/** Busca o Funcionario
	 *  @return Funcionario passado pelo
	 *  @param id 
	 */
	public Funcionario getFuncionarioById(int id) {
		return hibernateTemplate.get(Funcionario.class, id);
	}
	/** Adiciona um Funcionario atraves do
	 *  @param funcionario
	 */
	public void addFuncionario(Funcionario funcionario) {
		hibernateTemplate.save(funcionario);

	}
	/** Altera as caracteristicas do Funcionario
	 *  @param funcionario 
	 */
	public void updateFuncionario(Funcionario funcionario) {
		Funcionario funcionarioAux = getFuncionarioById(funcionario.getId());

		funcionarioAux.setCpf(funcionario.getCpf());
		funcionarioAux.setEmail(funcionario.getEmail());
		funcionarioAux.setNome(funcionario.getNome());
		funcionarioAux.setRg(funcionario.getRg());
		funcionarioAux.setEndereco(funcionario.getEndereco());
		funcionarioAux.setNaturalidade(funcionario.getNaturalidade());
		funcionarioAux.setNivelAcesso(funcionario.getNivelAcesso());
		funcionarioAux.setNomeUsuario(funcionario.getNomeUsuario());
		funcionarioAux.setSenha(funcionario.getSenha());
		funcionarioAux.setTelefone(funcionario.getTelefone());
		
		hibernateTemplate.update(funcionarioAux);

	}
	/** Deleta o Funcionario atraves do id
	 */
	public void deleteFuncionario(int id) {
		hibernateTemplate.delete(getFuncionarioById(id));
	}
	/** Verifica a existencia do item no acervo atraves do seu cpf
	 * @param cpf
	 * @return true or false
	 */
	@SuppressWarnings("unchecked")
	public boolean funcionarioExists(String cpf) {
		String hql = "FROM Funcionario as i WHERE i.cpf = ?";	
		List<Funcionario> items = (List<Funcionario>) hibernateTemplate.find(hql, cpf);
		return items.size() > 0 ? true : false;
	}
}
