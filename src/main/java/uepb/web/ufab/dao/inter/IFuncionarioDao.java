package uepb.web.ufab.dao.inter;

import uepb.web.ufab.model.Funcionario;

public interface IFuncionarioDao extends IGenericDao<Funcionario> {
	Funcionario getFuncionarioByCpf(String cpf);
	void updateFuncionario(Funcionario funcionario);
	boolean funcionarioExists(String cpf);
	void deleteFuncionarioByCpf(String cpf);
}
