package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.IRevistaService;

@Controller
public class RevistaController {
	@Autowired
	IRevistaService revistaService;
	
	
	@RequestMapping(value = "revistas", method = RequestMethod.GET)
	public ModelAndView loadForm() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/revistas");
		m.addObject("revistas",revistaService.getAllItems());
		return m;
	}
	

	@RequestMapping(value = "revista_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/revista_cadastro");
		return m;
	}
}
