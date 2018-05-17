package uepb.web.ufab.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import uepb.web.ufab.dao.inter.IAlunoDao;

import uepb.web.ufab.model.Aluno;

	/**
	* <h1>AlunoDao</h1>
	* Persiste dads dos alunos
	*
	* @author  Samuel Rufino e Pablo Monteiro
	* @version 1.0
	* @since   2018-04-20
	*/
@Repository
public class AlunoDaoImpl extends GenericDaoImpl<Aluno> implements IAlunoDao {

		@SuppressWarnings("unchecked")
		public Aluno getAlunoByMatricula(String matricula) {
			String hql = "FROM Aluno as i WHERE i.matricula = ?";
			List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
		
			return items.get(0);
		}

		public void deleteAlunoByMatricula(String matricula) {
			hibernateTemplate.delete(getAlunoByMatricula(matricula));		
		}

		@SuppressWarnings("unchecked")
		public boolean alunoExists(String matricula) {
			String hql = "FROM Aluno as i WHERE i.matricula = ?";	
			List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, matricula);
			return items.size() > 0 ? true : false;
		}

		public void updateAluno(Aluno aluno) {
			Aluno alunoAux = getItemById(aluno.getId());

			alunoAux.setCpf(aluno.getCpf());
			alunoAux.setCurso(aluno.getCurso());
			alunoAux.setEndereco(aluno.getEndereco());
			alunoAux.setMatricula(aluno.getMatricula());
			alunoAux.setNaturalidade(aluno.getNaturalidade());
			alunoAux.setNome(aluno.getNome());
			alunoAux.setNomeDaMae(aluno.getNomeDaMae());
			alunoAux.setSenhaAcesso(aluno.getSenhaAcesso());
			alunoAux.setRg(aluno.getRg());
			super.updateItem(alunoAux);
			
		}
	
	
}
