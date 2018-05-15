package uepb.web.ufab.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.service.inter.IAlunoService;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;



//import uepb.web.ufab.model.itemAcervo.ItemAcervo;
//import uepb.web.ufab.service.IService;



@Controller
public class AlunoController {

	
	
	@Autowired
	private IAlunoService alunoService;
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ModelAndView loadForm(@ModelAttribute("itemForm")Aluno aluno){
		ModelAndView m = new ModelAndView();
		m.setViewName("formItem");
		Aluno a = new Aluno();
		a.setMatricula("1420830141");
		a.setNome("Pablo");
		try {
			alunoService.addItem(a);
		} catch (ItemDuplicadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		m.addObject("items",alunoService.getAllItems());
		return m;
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
