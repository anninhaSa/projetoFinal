package persistence;

import java.util.Date;

import junit.framework.TestCase;

import org.junit.Test;

import entity.Contato;
import entity.Endereco;
import entity.Funcionario;

public class FuncionarioDAO_tst extends TestCase
{
	@SuppressWarnings("deprecation")
	@Test
	public void testInsereFuncionario( )
	{
		Funcionario    f  = new Funcionario( "Daisy", new Date( "1958/09/13" ), null, null );
		
		FuncionarioDAO fd = new FuncionarioDAO( );
		
		f.setContato( new Contato( "daisysa@outlook.com", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		f.getContato( ).setPessoa( f );
		
		f.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 3", "Baldeador", "Niterói", "RJ", "24140050" ) );
		f.getContato( ).getEndereco( ).setContato( f.getContato( ) );
		
		f.getContato( ).setDddResidencial( "21"       );
		f.getContato( ).setTelResidencial( "26252115" );
		
		f.getContato( ).setDddComercial( "21"       );
		f.getContato( ).setTelComercial( "22247133" );
		
		f.getContato( ).setDddCelular( "21"        );
		f.getContato( ).setTelCelular( "996936801" );
		
		boolean bOk = fd.insereFuncionario( f );
		
		System.out.println( f );
		
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