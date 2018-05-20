package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.IJornalService;

@Controller
public class JornalController {

	@Autowired
	IJornalService jornalService;
	
	@RequestMapping(value = "jornais", method = RequestMethod.GET)
	public ModelAndView loadForm() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/jornais");
		m.addObject("jornais",jornalService.getAllItems());
		return m;
	}
	

	@RequestMapping(value = "jornal_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/jornal_cadastro");
		return m;
	}
}
