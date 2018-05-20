package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.ILivroService;

@Controller
public class LivroController {

	@Autowired
	ILivroService livroService;
	
	@RequestMapping(value = "livros", method = RequestMethod.GET)
	public ModelAndView loadForm() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/livros");
		m.addObject("livros",livroService.getAllItems());
		return m;
	}
	

	@RequestMapping(value = "livro_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/livro_cadastro");
		return m;
	}
}
