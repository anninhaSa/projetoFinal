package persistence;

import junit.framework.TestCase;

import org.junit.Test;

import entity.Autenticacao;
import entity.Funcionario;

public class AutenticacaoDao_tst extends TestCase
{
	@Test
	public void testInsereAutenticacao( )
	{
		Funcionario  f   = (Funcionario)(new FuncionarioDAO( )).coletaPessoaByCelular("21", "996936801").get(0);
		Autenticacao a   = new Autenticacao( "daisy", "daisy", f );
		boolean      bOk = (new AutenticacaoDao( )).insereAutenticacao( a );
		
		assertTrue( bOk );
	}

	@Test
	public void testColetaAutenticacao( )
	{
//		Funcionario  f   = (Funcionario)(new FuncionarioDAO( )).coletaPessoaByCelular("21", "996936801").get(0);
		Autenticacao a = new Autenticacao( "daisy", "daisy", null );
		
	 	Autenticacao b = (new AutenticacaoDao()).coletaAutenticacao( a );
	 	
	 	System.out.println( b );
	 	
	 	assertNotNull( b );
	}
}
