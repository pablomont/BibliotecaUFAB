package uepb.web.ufab.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import uepb.web.ufab.dao.inter.IAlunoDao;
import uepb.web.ufab.dao.inter.IGenericDao;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.service.inter.IAlunoService;




	/**
	* <h1>AlunoServiceImpl</h1>
	* AlunoServiceImpl Implementa todos os servi�os dos Alunos
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/

@Service
public class AlunoServiceImpl extends GenericServiceImpl<Aluno> implements IAlunoService {

	private IAlunoDao alunoDao;
    
	public AlunoServiceImpl(){
    	
    }
    
    @Autowired
    public AlunoServiceImpl(@Qualifier("alunoDaoImpl") IGenericDao<Aluno> genericDao) {
        super(genericDao);
        this.alunoDao = (IAlunoDao) genericDao;
    }
	
    @Transactional
	public Aluno getAlunoByMatricula(String matricula) throws ItemInexistenteException {
		if(alunoDao.alunoExists(matricula)) {
			Aluno a = alunoDao.getAlunoByMatricula(matricula);
			return a;
		}
		else {
			throw new ItemInexistenteException("Aluno inexistente");
		}	
	}

    @Transactional
	public void deleteAlunoByMatricula(String matricula) throws ItemInexistenteException {
		if(!alunoDao.alunoExists(matricula))
			throw new ItemInexistenteException("Aluno n�o existe");
		
		alunoDao.deleteAlunoByMatricula(matricula);
		
	}

    @Transactional
	public void updateAluno(Aluno aluno) throws ItemDuplicadoException, ItemInexistenteException {
		if(!alunoDao.alunoExists(aluno.getMatricula()))
			throw new ItemInexistenteException("Aluno n�o existe");
		
		else {
			Aluno alunoAux = getAlunoByMatricula(aluno.getMatricula());
					
			if(alunoAux.equals(aluno)) {
				alunoDao.updateAluno(aluno);
			}
			
			else {
				throw new ItemDuplicadoException("J� existe um aluno com essa matr�cula");
			}	
		}
		
	}

	public void saveAluno(Aluno aluno) throws ItemDuplicadoException {
		aluno.setMatricula(geraMatricula(aluno));
		super.addItem(aluno);
		
	}

	public String geraMatricula(Aluno aluno) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(aluno.getCurso().getTipoCurso().toString().charAt(0));
		stringBuilder.append(aluno.getCurso().getCodCurso()+"-");
		stringBuilder.append(aluno.getAnoIngresso());
		stringBuilder.append(aluno.getPeriodoIngresso());
		stringBuilder.append(aluno.getRg().substring(0, 3));
		return stringBuilder.toString();
	}


}
