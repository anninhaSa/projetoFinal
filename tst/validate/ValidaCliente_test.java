package validate;

import junit.framework.TestCase;

import org.junit.Test;

import util.Util;
import entity.Cliente;
import entity.Contato;
import entity.Endereco;

public class ValidaCliente_test extends TestCase{
	ValidaDadosPessoa valida = new ValidaDadosPessoa( );
	
	@Test
	public void test_cliente_valido_totalmente_preenchido( ) {
		assertTrue( valida.validaCliente( coletaClienteValido( ) ).isOk( ) );
	}
	
	//TODO Só os campos obrigatórios preenchidos
	//TODO Um dos campos obrigatórios não preenchido
	
	@Test
	public void test_cliente_nome_vazio( ) {
		Cliente c = coletaClienteValido( );
		
		c.setNome("");
		
		assertFalse( valida.validaCliente( c ).isOk( ) );
	}
	
	@Test
	public void test_cliente_nome_nulo( ) {
		Cliente c = coletaClienteValido( );
		
		c.setNome(null);
		
		assertFalse( valida.validaCliente( c ).isOk( ) );
	}
	
	@Test
	public void test_cliente_CPF_invalido( ) {
		Cliente c = coletaClienteValido( );
		
		c.setCPF( "076.799.577-01" );
		
		assertFalse( valida.validaCliente( c ).isOk( ) );
	}
	
	@Test
	public void test_cliente_CPF_vazio( ) {
		Cliente c = coletaClienteValido( );
		
		c.setCPF( "" );
		
		assertTrue( valida.validaCliente( c ).isOk( ) );
	}
	
	@Test
	public void test_cliente_CPF_nulo( ) {
		Cliente c = coletaClienteValido( );
		
		c.setCPF( null );
		
		assertTrue( valida.validaCliente( c ).isOk( ) );
	}
	
	public Cliente coletaClienteValido( ) {
		Cliente c = new Cliente( "Anna", Util.trataData("03/11/1986"), null, "076.799.177-01" );
		
		c.setContato( new Contato( "annasa03@gmail.com.br", null, null, null, null ) ); 
		
		// É necessário adicionar o contato na pessoa e depois a pessoa no contato. Se isso não for feito o idPessoa do contato será NULL pois a pessoa do contato está NULL.
		c.getContato( ).setPessoa( c );
		
		c.getContato( ).setEndereco( new Endereco( "Rua do Coelho", 773, "casa 3", "Baldeador", "Niterói", "RJ", "24140050" ) );
		c.getContato( ).getEndereco( ).setContato( c.getContato( ) );
		
		c.getContato( ).setTelResidencial( "2126252115" );

		c.getContato( ).setTelComercial( "2132335200" );

		c.getContato( ).setTelCelular( "21995582559" );
		
		return c;
	}
}