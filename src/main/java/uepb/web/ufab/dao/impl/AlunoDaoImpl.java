package uepb.web.ufab.dao.impl;


import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.IAlunoDao;

import uepb.web.ufab.model.Aluno;

	/**
	* <h1>AlunoDao</h1>
	* AlunoDao é um usuario do acervo
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class AlunoDaoImpl extends GenericDaoImpl<Aluno> implements IAlunoDao {

		public Aluno getAlunoByMatricula(String matricula) {
			// TODO Auto-generated method stub
			return null;
		}

		public void deleteAlunoByMatricula(String matricula) {
			// TODO Auto-generated method stub
			
		}

		public boolean itemExists(String matricula) {
			// TODO Auto-generated method stub
			return false;
		}
	
	
}
