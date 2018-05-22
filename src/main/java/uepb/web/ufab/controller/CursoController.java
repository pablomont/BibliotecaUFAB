package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.ICursoService;

@Controller
public class CursoController {
	@Autowired
	private ICursoService cursoService;

	@RequestMapping(value = "cursos", method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("cursoForm")Curso curso) throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("cursos");
		m.addObject("cursos",cursoService.getAllItems());
		return m;
	}
	
	@RequestMapping(value = "curso_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro(@ModelAttribute("cursoForm")Curso curso) throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("curso_cadastro");
		m.addObject("listCursos",cursoService.getAllItems());
		return m;
	}
	
	@RequestMapping(value = "curso_save", method = RequestMethod.POST)
	public ModelAndView saveAluno(@ModelAttribute("cursoForm")Curso curso ){
		try {
			cursoService.addItem(curso);
		} catch (ItemDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView m = new ModelAndView();
		m.setViewName("cursos");
		m.addObject("cursos",cursoService.getAllItems());
		return m;
	}
}
