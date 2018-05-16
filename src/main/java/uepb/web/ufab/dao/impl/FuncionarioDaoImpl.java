package uepb.web.ufab.dao.impl;

import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.IFuncionarioDao;
import uepb.web.ufab.model.Funcionario;




	/**
	* <h1>FuncionarioDao</h1>
	* FuncionarioDao é um usuario do acervo
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

	
}
