package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.AlunoDao;
import uepb.web.ufab.model.Aluno;


@Transactional
@Service
@Configuration
	/**
	* <h1>AlunoServiceImpl</h1>
	* AlunoServiceImpl Implementa todos os serviços para o usuario Alunos
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AlunoServiceImpl implements IService<Aluno> {

	
	@Autowired
	private AlunoDao alunoDao;
	/** Busca o Item
	 *  @return Lista de Item do aluno passado pelo
	 *  @param alunoDao 
	 */
	public List<Aluno> getAllItems() {
		return alunoDao.getAllAlunos();
	}
	/** Busca o Item
	 *  @return Item passado pelo
	 *  @param id 
	 */
	public Aluno getItemById(int id) {
		return alunoDao.getAlunoById(id);
	}
	/** Adiciona o Item atraves do Cpf para um 
 	 *  @param aluno 
 	 *  @return false se o Aluno não existir
	 *  @return true se o Aluno existir
	 */
	public boolean addItem(Aluno aluno) {
		if (alunoDao.alunoExists(aluno.getCpf())){
			return false;
		}
		else {
			alunoDao.addAluno(aluno);
	        return true;
		}   
	}
	/** Atualiza o Item do 
 	 *  @param aluno 
	 */
	public void updateItem(Aluno aluno) {
		alunoDao.updateAluno(aluno);
		
	}
	/** Deleta o Item do Aluno atraves do 
 	 *  @param id 
	 */
	public void deleteItem(int id) {
		alunoDao.deleteAluno(id);
		
	}

}
