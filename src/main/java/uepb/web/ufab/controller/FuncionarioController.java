package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.service.inter.IFuncionarioService;

@Controller
public class FuncionarioController {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@RequestMapping(value = "funcionarios", method = RequestMethod.GET)
	public ModelAndView loadFormTabela() throws ItemDuplicadoException{
		ModelAndView m = new ModelAndView();
		m.setViewName("funcionarios");
		m.addObject("funcionarios",funcionarioService.getAllItems());
		return m;
	}

	@RequestMapping(value = "funcionario_cadastro", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("funcionario_cadastro");
		return m;
	}

	
	
}
