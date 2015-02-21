package util;

import entity.Cliente;
import entity.Funcionario;
import entity.Pessoa;

public class PessoaUtil
{
	/**
	 * Converte {@link Pessoa} em {@link Cliente}. 
	 * @param pessoa {@link Pessoa}
	 * @return {@link Cliente}
	 */
	public static Cliente convertePessoa2Cliente( Pessoa pessoa )
	{
		Cliente cliente = new Cliente( );
		
		//Pessoa
		cliente.setIdPessoa( pessoa.getIdPessoa( ) );
		cliente.setNome    ( pessoa.getNome    ( ) );
		cliente.setDataNasc( pessoa.getDataNasc( ) );
		cliente.setCPF     ( pessoa.getCPF     ( ) );
		cliente.setRG      ( pessoa.getRG      ( ) );
		cliente.setTpPessoa( pessoa.getTpPessoa( ) );
		
		//Contato
		cliente.getContato( ).setPessoa( cliente );
		
		cliente.getContato( ).setIdContato( pessoa.getContato( ).getIdContato( ) );
		cliente.getContato( ).setEmail    ( pessoa.getContato( ).getEmail    ( ) );
		
		//Endereço                                                                          
		cliente.getContato( ).getEndereco( ).setContato( cliente.getContato( ) );             
		                                                                                    
		cliente.getContato( ).getEndereco( ).setIdEndereco ( pessoa.getContato( ).getEndereco( ).getIdEndereco ( ) );
		cliente.getContato( ).getEndereco( ).setLogradouro ( pessoa.getContato( ).getEndereco( ).getLogradouro ( ) );
		cliente.getContato( ).getEndereco( ).setNumero     ( pessoa.getContato( ).getEndereco( ).getNumero     ( ) );
		cliente.getContato( ).getEndereco( ).setComplemento( pessoa.getContato( ).getEndereco( ).getComplemento( ) );
		cliente.getContato( ).getEndereco( ).setBairro     ( pessoa.getContato( ).getEndereco( ).getBairro     ( ) );
		cliente.getContato( ).getEndereco( ).setCidade     ( pessoa.getContato( ).getEndereco( ).getCidade     ( ) );
		cliente.getContato( ).getEndereco( ).setUF         ( pessoa.getContato( ).getEndereco( ).getUF         ( ) );
		cliente.getContato( ).getEndereco( ).setCep        ( pessoa.getContato( ).getEndereco( ).getCep        ( ) );
		
		//Telefone Residencial                                                                
		cliente.getContato( ).setTelResidencial( pessoa.getContato( ).getTelResidencial( ) );
		
		//Telefone Comercial                                                                
		cliente.getContato( ).setTelComercial( pessoa.getContato( ).getTelComercial( ) );
		
		//Celular                                                                    
		cliente.getContato( ).setTelCelular( pessoa.getContato( ).getTelCelular( ) );
		
		return cliente;
	}
	
	/**
	 * Converte {@link Pessoa} em {@link Funcionario}. 
	 * @param pessoa {@link Pessoa}
	 * @return {@link Funcionario}
	 */
	public static Funcionario convertePessoa2Funcionario( Pessoa pessoa )
	{
		Funcionario funcionario = new Funcionario( );
		
		//Pessoa
		funcionario.setIdPessoa( pessoa.getIdPessoa( ) );
		funcionario.setNome    ( pessoa.getNome    ( ) );
		funcionario.setDataNasc( pessoa.getDataNasc( ) );
		funcionario.setCPF     ( pessoa.getCPF     ( ) );
		funcionario.setRG      ( pessoa.getRG      ( ) );
		funcionario.setTpPessoa( pessoa.getTpPessoa( ) );
		
		//Contato
		funcionario.getContato( ).setPessoa( funcionario );
		
		funcionario.getContato( ).setIdContato( pessoa.getContato( ).getIdContato( ) );
		funcionario.getContato( ).setEmail    ( pessoa.getContato( ).getEmail    ( ) );
		
		//Endereço                                                                          
		funcionario.getContato( ).getEndereco( ).setContato( funcionario.getContato( ) );             
		                                                                                    
		funcionario.getContato( ).getEndereco( ).setIdEndereco ( pessoa.getContato( ).getEndereco( ).getIdEndereco ( ) );
		funcionario.getContato( ).getEndereco( ).setLogradouro ( pessoa.getContato( ).getEndereco( ).getLogradouro ( ) );
		funcionario.getContato( ).getEndereco( ).setNumero     ( pessoa.getContato( ).getEndereco( ).getNumero     ( ) );
		funcionario.getContato( ).getEndereco( ).setComplemento( pessoa.getContato( ).getEndereco( ).getComplemento( ) );
		funcionario.getContato( ).getEndereco( ).setBairro     ( pessoa.getContato( ).getEndereco( ).getBairro     ( ) );
		funcionario.getContato( ).getEndereco( ).setCidade     ( pessoa.getContato( ).getEndereco( ).getCidade     ( ) );
		funcionario.getContato( ).getEndereco( ).setUF         ( pessoa.getContato( ).getEndereco( ).getUF         ( ) );
		funcionario.getContato( ).getEndereco( ).setCep        ( pessoa.getContato( ).getEndereco( ).getCep        ( ) );
		
		//Telefone Residencial                                                                
		funcionario.getContato( ).setTelResidencial( pessoa.getContato( ).getTelResidencial( ) );
		
		//Telefone Comercial                                                                
		funcionario.getContato( ).setTelComercial( pessoa.getContato( ).getTelComercial( ) );
		
		//Celular                                                                    
		funcionario.getContato( ).setTelCelular( pessoa.getContato( ).getTelCelular( ) );
		
		return funcionario;
	}
}