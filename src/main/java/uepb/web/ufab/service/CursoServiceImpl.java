package uepb.web.ufab.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import uepb.web.ufab.dao.CursoDao;
import uepb.web.ufab.model.Curso;

@Transactional
@Service
@Configuration
public class CursoServiceImpl implements IService<Curso> {
	
	@Autowired
	private CursoDao cursoDao;

	public List<Curso> getAllItems() {
		return cursoDao.getAllCursos();
	}

	public Curso getItemById(int id) {
		return cursoDao.getCursoById(id);
	}

	public boolean addItem(Curso curso) {
		if (cursoDao.cursoExists(curso.getNome())){
	         return false;
      } else {
    	  cursoDao.addCurso(curso);
	         return true;
      }   
	}

	public void updateItem(Curso curso) {
		cursoDao.updateCurso(curso);
	}

	public void deleteItem(int id) {
		cursoDao.deleteCurso(id);
	}
}
