package persistence;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import util.Util;
import entity.Cliente;
import entity.Contato;
import entity.Endereco;

public class ClienteDAO_tst extends TestCase
{
	@Test
	public void testInsereCliente( )
	{
		boolean    bOk = false;
		ClienteDAO cd  = new ClienteDAO( );
		
		Cliente c = new Cliente( "Anna", Util.trataData("03/11/1986"), null, null );
		
		c.setContato( new Contato( "annasa03@gmail.com.br", null, null, null, null, null, null, null ) ); 
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
//		c.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 3", "Baldeador", "Niterói", "RJ", "24140050" ) );
//		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "26252115" );

		c.getContato( ).setDddComercial( "21"       );
		c.getContato( ).setTelComercial( "32335200" );

		c.getContato( ).setDddCelular( "21"        );
		c.getContato( ).setTelCelular( "995582559" );
		
		bOk = cd.insereCliente( c );
		
		c = new Cliente( "Leda", Util.trataData("26/08/2008"), null, null );
		
		c.setContato( new Contato( "leda.maria@gmail.com.br", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
//		c.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 1", "Baldeador", "Niterói", "RJ", "24140050" ) );
//		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "36015662" );
		
		bOk = bOk && cd.insereCliente( c );
		
		assertTrue( bOk );
		
		c = new Cliente( "Deny", Util.trataData("15/05/1935"), null, null );
		
		c.setContato( new Contato( "deny.lopes@gmail.com.br", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
//		c.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocaiúva", 647, "casa 1", "Caramujo", "Niterói", "RJ", "24140050" ) );
//		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "26257133" );
		
		bOk = bOk && cd.insereCliente( c );
		
		c = new Cliente( "Denise", Util.trataData("04/08/1955"), null, null );
		
		c.setContato( new Contato( "denise.bastos@gmail.com.br", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
//		c.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocaiúva", 647, "casa 1", "Caramujo", "Niterói", "RJ", "24140050" ) );
//		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "26257133" );
		
		bOk = bOk && cd.insereCliente( c );
		
		c = new Cliente( "Vítor", Util.trataData("29/05/1995"), null, null );
		
		c.setContato( new Contato( "vitor.oliveira@gmail.com.br", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
//		c.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocaiúva", 647, "casa 2", "Caramujo", "Niterói", "RJ", "24140050" ) );
//		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "26279364" );
		
		bOk = bOk && cd.insereCliente( c );
		
		c = new Cliente( "Kamilla", Util.trataData("22/06/1997"), null, null );
		
		c.setContato( new Contato( "kamilla.bastos@gmail.com.br", null, null, null, null, null, null, null ) );
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
		c.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 1", "Baldeador", "Niterói", "RJ", "24140050" ) );
		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setDddResidencial( "21"       );
		c.getContato( ).setTelResidencial( "36015662" );
		
		bOk = bOk && cd.insereCliente( c );
		
		assertTrue( bOk );
	}

	@Test
	public void testColetaClienteById( )
	{
		Cliente cliente = ( new ClienteDAO( ) ).coletaClienteById( 2 );
		
		assertEquals( "Anna", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testColetaClienteByNome( )
	{
		ArrayList<Cliente> aList = ( new ClienteDAO( ) ).coletaClienteByNome( "Kamilla" );
		Cliente            cliente = new Cliente( );
		
		if( aList != null && aList.size( ) > 0 )
			cliente = aList.get( 0 );
		
		assertEquals( "Kamilla", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testColetaClienteByTelefone( )
	{
		ArrayList<Cliente> aList = ( new ClienteDAO( ) ).coletaClienteByTelefone( "21", "26279364" );
		Cliente            cliente = new Cliente( );
		
		if( aList != null && aList.size( ) > 0 )
			cliente = aList.get( 0 );
		
		assertEquals( "Vítor", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testColetaClienteByTelefoneAndNome( )
	{
		ArrayList<Cliente> aList = ( new ClienteDAO( ) ).coletaClienteByTelefoneAndNome( "21", "36015662", "Leda" );
		Cliente            cliente = new Cliente( );
		
		if( aList != null && aList.size( ) > 0 )
			cliente = aList.get( 0 );
		
		assertEquals( "Leda", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testAtualizaCliente( )
	{
		Cliente cliente = ( new ClienteDAO( ) ).coletaClienteById( 6 );
		
		cliente.getContato( ).setDddCelular( "21"        );
		cliente.getContato( ).setTelCelular( "980913746" );
		
		boolean bOk = ( new ClienteDAO( ) ).atualizaCliente( cliente );
		
		assertTrue( bOk );
	}

//	@Test
//	public void testExcluiCliente( )
//	{
//		fail("Not yet implemented");
//	}
}