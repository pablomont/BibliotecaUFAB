package uepb.web.ufab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

	@RequestMapping(value = "/home", method = RequestMethod.POST)
	public ModelAndView loginSucces(){
		ModelAndView m = new ModelAndView();
		m.setViewName("home");
		return m;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView logout(){
		ModelAndView m = new ModelAndView();
		m.setViewName("index");
		return m;
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView loadHome(){
		ModelAndView m = new ModelAndView();
		m.setViewName("home");
		return m;
	}
}
