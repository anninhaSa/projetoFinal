package persistence;

import junit.framework.TestCase;

import org.junit.Test;

import persistence.impl.FuncionarioDAOImpl;
import util.PessoaTeste;

public class FuncionarioDAO_tst extends TestCase {
	@Test
	public void testInsereFuncionario() {
	    FuncionarioDAO fd = new FuncionarioDAOImpl();
	    
	    PessoaTeste.init();
		
		boolean bOk = fd.insereFuncionario(PessoaTeste.daisy);
		
		assertTrue( bOk );
	}

//	@Test
//	public void testAtualizaFuncionario( )
//	{
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testExcluiFuncionario( )
//	{
//		fail("Not yet implemented");
//	}

//	@Test
//	public void testColetaFuncionarioById( )
//	{
//		Funcionario funcionario = (new FuncionarioDAO( )).coletaFuncionarioById( 1 );
//		
//		assertEquals( "Daisy", funcionario != null ? funcionario.getNome( ) : "" );
//	}
}