package uepb.web.ufab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.dao.AlunoDao;
import uepb.web.ufab.model.Aluno;


@Controller
public class AlunoController {

	
	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("alunoForm")Aluno aluno /* BindingResult result , Model model*/){
		ModelAndView m = new ModelAndView();
        m.setViewName("formAluno");
        m.addObject("alunos", AlunoDao.alunos);
        
    	return m;
	}
	
	@RequestMapping(value = "/alunos", method = RequestMethod.POST)
    public ModelAndView saveOrUpdate(@ModelAttribute("alunoForm")Aluno aluno /* BindingResult result , Model model*/) {
		AlunoDao.alunos.add(aluno);
		ModelAndView m = new ModelAndView();
		m.addObject("alunos", AlunoDao.alunos);
        m.setViewName("formAluno");
        
    	return m;
    }
	
	
}
