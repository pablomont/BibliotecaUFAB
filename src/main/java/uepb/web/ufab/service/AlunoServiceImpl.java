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
public class AlunoServiceImpl implements IService<Aluno> {

	
	@Autowired
	private AlunoDao alunoDao;
	
	public List<Aluno> getAllItems() {
		return alunoDao.getAllAlunos();
	}

	public Aluno getItemById(int id) {
		return alunoDao.getAlunoById(id);
	}

	public boolean addItem(Aluno aluno) {
		if (alunoDao.alunoExists(aluno.getCpf())){
			return false;
		}
		else {
			alunoDao.addAluno(aluno);
	        return true;
		}   
	}

	public void updateItem(Aluno aluno) {
		alunoDao.updateAluno(aluno);
		
	}

	public void deleteItem(int id) {
		alunoDao.deleteAluno(id);
		
	}

}
