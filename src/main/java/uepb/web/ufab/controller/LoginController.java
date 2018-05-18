package uepb.web.ufab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.model.Aluno;

@Controller
public class LoginController {

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView loadHome(){
		ModelAndView m = new ModelAndView();
		m.setViewName("home");
		return m;
	}
}
