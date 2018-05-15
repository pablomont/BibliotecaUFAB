package uepb.web.ufab.service.impl;



import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.inter.IAlunoDao;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.service.inter.IAlunoService;



@Transactional
@Service
	/**
	* <h1>AlunoServiceImpl</h1>
	* AlunoServiceImpl Implementa todos os serviços para o usuario Aluno
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
public class AlunoServiceImpl extends GenericServiceImpl<Aluno> implements IAlunoService {

	private IAlunoDao alunoDao;
    public AlunoServiceImpl(){
    	
    }
    
    @Autowired
    public AlunoServiceImpl(@Qualifier("alunoDaoImpl") IGenericDao<Aluno> genericDao) {
        super(genericDao);
        this.alunoDao = (IAlunoDao) genericDao;
    }
	
	
	public Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException {
		if(alunoDao.itemExists(matricula)) {
			Aluno a = alunoDao.getAlunoByMatricula(matricula);
			return a;
		}
		else {
			throw new ItemInexistenteException("Aluno inexistente");
		}	
	}

	public void deleteAlunoByMatricula(String matricula) throws ItemInexistenteException {
		if(!alunoDao.itemExists(matricula))
			throw new ItemInexistenteException("Aluno não existe");
		
		alunoDao.deleteAlunoByMatricula(matricula);
		
	}

	

}
