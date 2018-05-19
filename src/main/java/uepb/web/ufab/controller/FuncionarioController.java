package uepb.web.ufab.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import uepb.web.ufab.exception.ItemDuplicadoException;
import uepb.web.ufab.model.Aluno;
import uepb.web.ufab.model.Funcionario;

@Controller
public class FuncionarioController {
	
	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	@RequestMapping(value = "funcionarios", method = RequestMethod.GET)
	public ModelAndView loadForm() throws ItemDuplicadoException{
		generateFuncionario();
		ModelAndView m = new ModelAndView();
		m.setViewName("funcionarios");
		m.addObject("funcionarios",funcionarios);
		return m;
	}

	@RequestMapping(value = "cadastrar_funcionario", method = RequestMethod.GET)
	public ModelAndView loadFormCadastro() throws ItemDuplicadoException{
		
		ModelAndView m = new ModelAndView();
		m.setViewName("funcionarioCadastro");
		return m;
	}

	
	
	private void generateFuncionario() {
		Funcionario funcionario;
		
		funcionario = new Funcionario();
		funcionario.setCpf("123456789");
		funcionario.setEmail("pablo.santos@elife.com.br");
		funcionario.setEndereco("Rua São Paulo, 666, Liberdade");
		funcionario.setNaturalidade("Brasileiro");
		funcionario.setNivelAcesso(Funcionario.NivelAcesso.ADMIN);
		funcionario.setNome("Pablo Monteiro Santos");
		funcionario.setNomeUsuario("Paabl");
		funcionario.setRg("3775730");
		funcionario.setSenha("admin");
		funcionario.setTelefone("83988258064");
		funcionarios.add(funcionario);
	}
	
	
}
