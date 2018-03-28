package modelTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Funcionario;
import model.Funcionario.NivelAcesso;
import util.Cpf;

public class FuncioarioTest {

	
	Funcionario samuel;
	Funcionario pablo;
	
	@Before
	public void setUp() throws Exception {
		samuel = new Funcionario("Samuel",NivelAcesso.ADMIN,"10190673494");
		pablo = new Funcionario("Pablo",NivelAcesso.OPERADOR, "91203647506");
		
	}

	@Test
	public void tesFuncionario() {
		assertTrue(samuel.equals(new Funcionario("Samuel",NivelAcesso.ADMIN,"10190673494")));
		assertFalse(samuel.equals(new Funcionario("Samuel",NivelAcesso.ADMIN,"56073421826")));
	}
	
	@Test
	public void testCpfInvalido() {
		assertFalse(Cpf.isCPF("55555555555"));
		assertFalse(Cpf.isCPF("555aaa55522"));
		assertFalse(Cpf.isCPF("101906"));
	}
	
	@Test
	public void testCpfValido() {
		assertTrue(Cpf.isCPF("56073421826"));	
	}
	

}
