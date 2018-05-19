package uepb.web.ufab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.model.Curso;
import uepb.web.ufab.service.inter.IAlunoService;
import uepb.web.ufab.service.inter.ICursoService;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;



//import uepb.web.ufab.model.itemAcervo.ItemAcervo;
//import uepb.web.ufab.service.IService;

@Controller
public class AlunoController {
	
	
	List<Aluno> alunos = new ArrayList<Aluno>();

//	@Autowired
//	private IAlunoService alunoService;
//	@Autowired
//	private ICursoService cursoService;
//	
	@RequestMapping(value = "alunos", method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("itemForm")Aluno aluno) throws ItemDuplicadoException{
		generateAluno();
		ModelAndView m = new ModelAndView();
		m.setViewName("alunos");
		m.addObject("alunos",alunos);
		return m;
	}
	
	private void generateAluno() throws ItemDuplicadoException{
		Aluno aluno;
		Curso curso;
		aluno = new Aluno();
		aluno.setCpf("10190673494");
		aluno.setEndereco("Rua s�o paulo, 666");
		aluno.setMatricula("142083011");
		aluno.setNaturalidade("Brasileiro");
		aluno.setNome("Pablo Monteiro Santos");
		aluno.setNomeDaMae("Cl�udia Monteiro Santos");
		aluno.setRg("3775630");
		aluno.setSenhaAcesso("admin");
		
		curso = new Curso();
		curso.setArea("Exatas");
		curso.setNome("Ci�ncia da Computa��o");
		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
		alunos.add(aluno);
		//cursoService.addItem(curso);
		
		aluno.setCurso(curso);
		//alunoService.addItem(aluno);
		
	}
	
//	@Autowired
//	private IService itemService;
//	
//	@RequestMapping(value = "/items", method = RequestMethod.GET)
//	public ModelAndView loadForm(@ModelAttribute("itemForm")ItemAcervo item /* BindingResult result , Model model*/){
//		ModelAndView m = new ModelAndView();
//        m.setViewName("formItem");
//       // m.addObject("items", itemService.getAllItemss());
//    	return m;
//	}
//
//	
//	@RequestMapping(value = "/items", method = RequestMethod.POST)
//    public String saveOrUpdate(/*@ModelAttribute("itemForm")*/ItemAcervo  item  /*,BindingResult result , Model model*/) {
//		itemService.addItemAcervo(item);
//
//    	return "redirect:/items";
//    }
	
	
	
}
