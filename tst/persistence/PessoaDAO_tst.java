package persistence;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import entity.Cliente;

public class PessoaDAO_tst {

	@SuppressWarnings("unchecked")
	@Test
	public void testColetaPessoaByNome( )
	{
		ArrayList<Cliente> ac = (ArrayList<Cliente>) ( new ClienteDAO( ) ).coletaPessoaByNome( "Anna" );
		
		for( Cliente obj : ac )
			System.out.println( obj );
		
		assertNotNull( ac );
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testColetaPessoaByCelular( )
	{
		ArrayList<Cliente> ac = (ArrayList<Cliente>) ( new ClienteDAO( ) ).coletaPessoaByCelular("21", "995582559" );
		
		for( Cliente obj : ac )
			System.out.println( obj );
		
		assertNotNull( ac );
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testColetaPessoaByNomeAndCelular( )
	{
		ArrayList<Cliente> ac = (ArrayList<Cliente>) ( new ClienteDAO( ) ).coletaPessoaByNomeAndCelular( "Anna", "21", "995582559" );
		
		for( Cliente obj : ac )
			System.out.println( obj );
		
		assertNotNull( ac );
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testColetaTodasAsPessoas( )
	{
		ArrayList<Cliente> ac = (ArrayList<Cliente>) ( new ClienteDAO( ) ).coletaTodasAsPessoas( );
		
		for( Cliente obj : ac )
			System.out.println( obj );
		
		assertNotNull( ac );
	}
}
