package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import uepb.web.ufab.model.Aluno;


@Configuration
@Transactional
@Repository
public class AlunoDao {
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Aluno> getAllAlunos() {
		String hql = "FROM Aluno as i ORDER BY i.id";
		return (List<Aluno>) hibernateTemplate.find(hql);
	}

	public Aluno getAlunoById(int id) {
		return hibernateTemplate.get(Aluno.class, id);
	}

	public void addAluno(Aluno aluno) {
		hibernateTemplate.save(aluno);

	}

	public void updateAluno(Aluno aluno) {
		Aluno alunoAux = getAlunoById(aluno.getId());

		alunoAux.setCpf(aluno.getCpf());
		alunoAux.setCurso(aluno.getCurso());
		alunoAux.setEndereco(aluno.getEndereco());
		alunoAux.setMatricula(aluno.getMatricula());
		alunoAux.setNaturalidade(aluno.getNaturalidade());
		alunoAux.setNome(aluno.getNome());
		alunoAux.setNomeDaMae(aluno.getNomeDaMae());
		alunoAux.setSenhaAcesso(aluno.getSenhaAcesso());
		alunoAux.setRg(aluno.getRg());
		hibernateTemplate.update(alunoAux);

	}

	public void deleteAluno(int id) {
		hibernateTemplate.delete(getAlunoById(id));
	}

	@SuppressWarnings("unchecked")
	public boolean alunoExists(String cpf) {
		String hql = "FROM Aluno as i WHERE i.cpf = ?";	
		List<Aluno> items = (List<Aluno>) hibernateTemplate.find(hql, cpf);
		return items.size() > 0 ? true : false;
	}
}
