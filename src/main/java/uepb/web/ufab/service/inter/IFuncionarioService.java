package uepb.web.ufab.service.inter;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Funcionario;

public interface IFuncionarioService extends IGenericService<Funcionario> {
	void updateFuncionario(Funcionario funcionario) throws ItemInexistenteException, ItemDuplicadoException;

}
