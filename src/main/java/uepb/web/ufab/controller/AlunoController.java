package uepb.web.ufab.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.exception.ItemInexistenteException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.service.inter.IAlunoService;



@Controller
public class AlunoController {
	
	@Autowired
	private IAlunoService alunoService;

	
	@RequestMapping(value = "alunos", method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("itemForm")Aluno aluno) throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("alunos");
		m.addObject("alunos",alunoService.getAllItems());
		return m;
	}
	

	@RequestMapping(value = "aluno_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro(@ModelAttribute("alunoForm")Aluno aluno) throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("aluno_cadastro");
		return m;
	}
	
	@RequestMapping(value = "aluno_save", method = RequestMethod.POST)
	public ModelAndView saveAluno(@ModelAttribute("alunoForm")Aluno aluno ){
		try {
			alunoService.addItem(aluno);
		} catch (ItemDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ModelAndView m = new ModelAndView();
		m.setViewName("alunos");
		m.addObject("alunos",alunoService.getAllItems());
		return m;
	}
	
	@RequestMapping(value = "remove_aluno",  method = RequestMethod.GET)
	public ModelAndView removeAluno(int id) {
		
		try {
			alunoService.deleteItem(id);
		} catch (ItemInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView m = new ModelAndView();
		m.setViewName("alunos");
		m.addObject("alunos",alunoService.getAllItems());
		return m;
	}

	

//	private void generateAlunos() throws ItemDuplicadoException{
//		Aluno aluno1;
//		
//		aluno1 = new Aluno();
//		aluno1.setCpf("10190673494");
//		aluno1.setEndereco("Rua paulo, 666");
//		aluno1.setMatricula("142083011");
//		aluno1.setNaturalidade("Brasileiro");
//		aluno1.setNome("Pablo Monteiro Santos");
//		aluno1.setNomeDaMae("Claudia Monteiro Santos");
//		aluno1.setRg("3775630");
//		aluno1.setSenhaAcesso("admin");
//		
//	
//		Curso curso = new Curso();
//		curso.setArea("Exatas");
//		curso.setNome("Ciência da Computação");
//		curso.setTipoCurso(Curso.Tipo.GRADUACAO);
//		
//		cursoService.addItem(curso);
//		
//		aluno1.setCurso(curso);
//	
//		alunoService.addItem(aluno1);
//	
//		
//
//	}
//	
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
