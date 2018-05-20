package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.IAnalDeCongressoService;

@Controller
public class AnalDeCongressoController {

	@Autowired
	private IAnalDeCongressoService analDeCongressoService;
	
	@RequestMapping(value = "anais_de_congresso", method = RequestMethod.GET)
	public ModelAndView loadFormTabela() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/anais_de_congresso");
		m.addObject("anais_de_congresso",analDeCongressoService.getAllItems());
		return m;
	}

	@RequestMapping(value = "anais_de_congresso_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/anal_de_congresso_cadastro");
		return m;
	}
	
}
