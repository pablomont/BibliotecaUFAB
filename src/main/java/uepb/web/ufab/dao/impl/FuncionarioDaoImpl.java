package uepb.web.ufab.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.IFuncionarioDao;
import uepb.web.ufab.model.Funcionario;




	/**
	* <h1>FuncionarioDao</h1>
	* Persiste dados dos funcionarios
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class FuncionarioDaoImpl extends GenericDaoImpl<Funcionario> implements IFuncionarioDao {

	public void updateFuncionario(Funcionario funcionario) {
		Funcionario funcionarioAux = getItemById(funcionario.getId());

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
		
		super.updateItem(funcionarioAux);
	}

	@SuppressWarnings("unchecked")
	public boolean funcionarioExists(String cpf) {
		String hql = "FROM Funcionario as i WHERE i.cpf = ?";	
		List<Funcionario> items = (List<Funcionario>) hibernateTemplate.find(hql, cpf);
		return items.size() > 0 ? true : false;
	}

	public void deleteFuncionarioByCpf(String cpf) {
		hibernateTemplate.delete(getFuncionarioByCpf(cpf));
		
	}

	@SuppressWarnings("unchecked")
	public Funcionario getFuncionarioByCpf(String cpf) {
		String hql = "FROM Funcionario as i WHERE i.cpf = ?";
		List<Funcionario> items = (List<Funcionario>) hibernateTemplate.find(hql, cpf);
	
		return items.get(0);
	}

	
}
