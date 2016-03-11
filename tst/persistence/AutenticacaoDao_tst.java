package persistence;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import persistence.impl.AutenticacaoDaoImpl;
import persistence.impl.FuncionarioDAOImpl;
import util.PessoaTeste;
import entity.Autenticacao;
import entity.Funcionario;

public class AutenticacaoDao_tst extends TestCase {
    
    FuncionarioDAO funcionarioDAO;
    
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        funcionarioDAO = new FuncionarioDAOImpl();
    }
    
	@Test
	public void testInsereAutenticacao() {
	    PessoaTeste.init();
	    
	    List<Funcionario> funcionario = funcionarioDAO.coletaFuncionarioPeloTelefone("21", "996936801");
	    
		Funcionario  f   = funcionario.get(0);
		Autenticacao a   = new Autenticacao(null, "daisy", "daisy", f);
		boolean      bOk = (new AutenticacaoDaoImpl()).insereAutenticacao(a);
		
		assertTrue(bOk);
	}

//	@Test
//	public void testColetaAutenticacao() {
////		Funcionario  f   = (Funcionario)(new FuncionarioDAO( )).coletaPessoaByCelular("21", "996936801").get(0);
//		Autenticacao a = new Autenticacao(null, "daisy", "daisy", null);
//		
//	 	Autenticacao b = (new AutenticacaoDaoImpl()).coletaAutenticacao(a);
//	 	
//	 	assertNotNull(b);
//	}
}
