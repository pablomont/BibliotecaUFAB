package uepb.web.ufab.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.model.itemAcervo.ItemAcervo;

@Configuration
@Transactional
@Repository
public class CursoDao {

	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@SuppressWarnings("unchecked")
	public List<Curso> getAllCursos() {
		String hql = "FROM Curso as i ORDER BY i.id";
		return (List<Curso>) hibernateTemplate.find(hql);
	}

	public Curso getCursoById(int id) {
		return hibernateTemplate.get(Curso.class, id);
	}

	public void addCurso(ItemAcervo itemAcervo) {
		hibernateTemplate.save(itemAcervo);

	}

	public void updateCurso(Curso curso) {
		Curso cursoAux = getCursoById(curso.getId());

		
		cursoAux.setArea(curso.getArea());
		cursoAux.setNome(curso.getNome());
		cursoAux.setTipoCurso(curso.getTipoCurso());
		
		hibernateTemplate.update(cursoAux);

	}

	public void deleteCurso(int id) {
		hibernateTemplate.delete(getCursoById(id));
	}

	@SuppressWarnings("unchecked")
	public boolean cursoExists(String cursoName) {
		String hql = "FROM Curso as i WHERE i.nomeItem = ?";	
		List<Curso> items = (List<Curso>) hibernateTemplate.find(hql, cursoName);
		return items.size() > 0 ? true : false;
	}

}
