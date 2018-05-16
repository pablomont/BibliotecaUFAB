package uepb.web.ufab.dao.inter;

import uepb.web.ufab.model.Funcionario;

public interface IFuncionarioDao extends IGenericDao<Funcionario> {
	void updateFuncionario(Funcionario funcionario);
}
