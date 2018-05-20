package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.IMidiaEletronicaService;

@Controller
public class MidiaEletronicaController {
	@Autowired
	IMidiaEletronicaService midiaEletronicaService;
	
	@RequestMapping(value = "midias_eletronicas", method = RequestMethod.GET)
	public ModelAndView loadForm() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/midias_eletronicas");
		m.addObject("midias_eletronicas",midiaEletronicaService.getAllItems());
		return m;
	}
	

	@RequestMapping(value = "midia_eletronica_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/midia_eletronica_cadastro");
		return m;
	}

}
