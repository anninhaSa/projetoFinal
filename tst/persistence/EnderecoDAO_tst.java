package persistence;

import static org.junit.Assert.*;

import org.junit.Test;

import entity.Cliente;
import entity.Endereco;

public class EnderecoDAO_tst {

	@Test
	public void testInsereEndereco( )
	{
		boolean     bOk = true;
		EnderecoDAO ed  = new EnderecoDAO( );
		ClienteDAO  cd  = new ClienteDAO( );
		
		Cliente cliente = cd.coletaClienteByNome( "Anna" ).get( 0 );
		
		cliente.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 3", "Baldeador", "Niter�i", "RJ", "24140050" ) );
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );
		
		bOk = ed.insereEndereco( cliente.getContato( ).getEndereco( ) );
		
		assertTrue( bOk );
		
		cliente = cd.coletaClienteByNome( "Leda" ).get( 0 );
		
		cliente.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 1", "Baldeador", "Niter�i", "RJ", "24140050" ) );
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );
		
		bOk = bOk && ed.insereEndereco( cliente.getContato( ).getEndereco( ) );
		
		assertTrue( bOk );
		
		cliente = cd.coletaClienteByNome( "Deny" ).get( 0 );
		
		cliente.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocai�va", 647, "casa 1", "Caramujo", "Niter�i", "RJ", "24140050" ) );
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );
		
		bOk = bOk && ed.insereEndereco( cliente.getContato( ).getEndereco( ) );
		
		assertTrue( bOk );
		
		cliente = cd.coletaClienteByNome( "Denise" ).get( 0 );
		
		cliente.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocai�va", 647, "casa 1", "Caramujo", "Niter�i", "RJ", "24140050" ) );
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );
		
		bOk = bOk && ed.insereEndereco( cliente.getContato( ).getEndereco( ) );
		
		assertTrue( bOk );
		
		cliente = cd.coletaClienteByNome( "V�tor" ).get( 0 );
		
		cliente.getContato( ).setEndereco( new Endereco( "Rua Quintino Bocai�va", 647, "casa 2", "Caramujo", "Niter�i", "RJ", "24140050" ) );
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );
		
		bOk = bOk && ed.insereEndereco( cliente.getContato( ).getEndereco( ) );
		
		assertTrue( bOk );
	}

	@Test
	public void testAtualizaEndereco() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluiEndereco() {
		fail("Not yet implemented");
	}

	@Test
	public void testColetaEnderecoByIdContato() {
		fail("Not yet implemented");
	}

}
