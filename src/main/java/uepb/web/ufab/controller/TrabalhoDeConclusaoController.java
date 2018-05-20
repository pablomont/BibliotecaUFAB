package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.ITrabalhoDeConclusaoService;

@Controller
public class TrabalhoDeConclusaoController {
	@Autowired
	ITrabalhoDeConclusaoService trabalhoDeConclusaoService;
	
	
	@RequestMapping(value = "tccs", method = RequestMethod.GET)
	public ModelAndView loadFormTabela() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/tccs");
		m.addObject("tccs",trabalhoDeConclusaoService.getAllItems());
		return m;
	}

	@RequestMapping(value = "tcc_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("itemAcervo/tcc_cadastro");
		return m;
	}
}
