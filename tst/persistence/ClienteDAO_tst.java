package persistence;

import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import persistence.impl.ClienteDAOImpl;
import util.PessoaTeste;
import entity.Cliente;
import entity.Telefone;

public class ClienteDAO_tst extends TestCase {
    ClienteDAO clienteDAO;
    
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        PessoaTeste.init();
        clienteDAO = new ClienteDAOImpl();
        clienteDAO.excluiCliente(PessoaTeste.anna);
        clienteDAO.excluiCliente(PessoaTeste.leda);
        clienteDAO.excluiCliente(PessoaTeste.deny);
        clienteDAO.excluiCliente(PessoaTeste.denise);
        clienteDAO.excluiCliente(PessoaTeste.kamilla);
        clienteDAO.excluiCliente(PessoaTeste.vitor);
    }
    
	@Test
	public void testInsereCliente() {
		boolean bOk = false;
		
		//TESTE INSERT COMPLET CUSTOMER
		bOk = clienteDAO.insereCliente(PessoaTeste.anna);
		
		assertTrue(bOk);
		//TESTE INSERT CUSTOMER WITH ADDRESS
		PessoaTeste.leda.getContato().setEndereco(null);
		bOk = bOk && clienteDAO.insereCliente(PessoaTeste.leda);
		assertTrue(bOk);
		
		// TESTE INSERT CUSTOMER ONLY WHITH RESIDENCIAL PHONE
		bOk = bOk && clienteDAO.insereCliente(PessoaTeste.deny);
		assertTrue(bOk);
		
		//TESTE INSERT CUSTOMER ONLY WITH COMERCIAL PHONE
		bOk = bOk && clienteDAO.insereCliente(PessoaTeste.denise);
        assertTrue(bOk);
		
		//TESTE INSERT CUSTOMER ONLY WITH CELLPHONE
		bOk = bOk && clienteDAO.insereCliente(PessoaTeste.vitor);
        assertTrue(bOk);
		
		//TESTE INSERT CUSTOMER ONLY WITH EMAIL AND NAME
		bOk = bOk && clienteDAO.insereCliente(PessoaTeste.kamilla);
		assertTrue(bOk);
	}

	@Test
	public void testColetaClienteById( )
	{
		Cliente cliente = ( new ClienteDAOImpl( ) ).coletaClientePeloId( 2 );
		
		assertEquals( "Anna", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testColetaClienteByNome( )
	{
		ArrayList<Cliente> aList = ( new ClienteDAOImpl( ) ).coletaClientePeloNome( "Anna" );
		Cliente            cliente = new Cliente( );
		
		if( aList != null && aList.size( ) > 0 )
			cliente = aList.get( 0 );
		
		assertEquals( "Anna", cliente != null ? cliente.getNome( ) : "" );
	}
	
	@Test
	public void testAtualizaCliente( )
	{
		Cliente cliente = ( new ClienteDAOImpl( ) ).coletaClientePeloId( 6 );
		
		cliente.getContato().getListTelefone().add(new Telefone(null, "21", "980913746",Telefone.s_nTpCelular));
		
		boolean bOk = ( new ClienteDAOImpl( ) ).atualizaCliente( cliente );
		
		assertTrue( bOk );
	}

//	@Test
//	public void testExcluiCliente( )
//	{
//		fail("Not yet implemented");
//	}
}