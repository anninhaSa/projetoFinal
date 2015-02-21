package validate;

import java.util.InputMismatchException;

import entity.Cliente;
import util.StatusRetorno;
import util.Util;

/**
 * Classe responsável por validar os dados do cliente.
 */
public class ValidaDadosPessoa
{
	private String dataNasc;
	
	public ValidaDadosPessoa( )
	{
		setDataNasc      ( "" );
	}
	
	public StatusRetorno validaCliente( Cliente cliente )
	{
		StatusRetorno sRet = new StatusRetorno( );
		
		//ValidaNome
		validaNome( cliente, sRet );
		
		//Valida dataNasc;
		validaECfgDataNascimento( cliente, sRet );
		
		//Valida cpf;
		validaEAjustaCPF( cliente, sRet ); 
		
		//Valida contato
		validaEAjustaContato( cliente, sRet );
		
		return sRet;
	}

	private void validaNome( Cliente cliente, StatusRetorno sRet )
	{
		cliente.setNome( Util.trataString( cliente.getNome( ) ) );
		
		if( Util.isnEmptyOrNull( cliente.getNome( ) ) )
			sRet.setMsgErro( "Nome inválido!" );
	}
	
	private void validaECfgDataNascimento( Cliente cliente, StatusRetorno sRet )
	{
		if( Util.isnEmptyOrNull( getDataNasc( ) ) )
			return;
		
		cliente.setDataNasc( Util.trataData( getDataNasc( ) ) );
		
		if( cliente.getDataNasc( ) == null )
			sRet.setMsgErro( "Data de Nascimento inválida!" );
	}
	
	public void validaEAjustaCPF( Cliente cliente, StatusRetorno sRet )
	{
		if( Util.isnEmptyOrNull( cliente.getCPF( ) ) )
			return;
		
		cliente.setCPF( cliente.getCPF( ).replaceAll( "[.]", "" ).replaceAll( "[-]", "" ) );
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if ( cliente.getCPF( ).equals("00000000000") || cliente.getCPF( ).equals("11111111111") || cliente.getCPF( ).equals("22222222222") ||
		     cliente.getCPF( ).equals("33333333333") || cliente.getCPF( ).equals("44444444444") || cliente.getCPF( ).equals("55555555555") ||
		     cliente.getCPF( ).equals("66666666666") || cliente.getCPF( ).equals("77777777777") || cliente.getCPF( ).equals("88888888888") ||
		     cliente.getCPF( ).equals("99999999999") || (cliente.getCPF( ).length() != 11))
			return;

		char dig10,
		     dig11;

		int sm   = 0,
		    i    = 0,
		    r    = 0,
		    num  = 0,
		    peso = 0;

		try
		{
			// Calculo do 1o. Digito Verificador sm = 0; 
			peso = 10;

			for (i=0; i<9; i++)
			{
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num  = (int)( cliente.getCPF( ).charAt( i ) - 48 );
				sm  +=  ( num * peso );
				--peso;
			}

			r = 11 - ( sm % 11 );

			if ( ( r == 10 ) || ( r == 11 ) )
				dig10 = '0';
			else
				dig10 =  (char)( r + 48 );

			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador

			sm   = 0;
			peso = 11;

			for( i=0; i<10; i++ )
			{
				num = (int)( cliente.getCPF( ).charAt( i ) - 48 );
				sm = sm + ( num * peso );
				peso = peso - 1;
			}

			r = 11 - ( sm % 11 );

			if ( ( r == 10 ) || ( r == 11 ) )
				dig11 = '0';
			else
				dig11 = (char)( r + 48 );

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ( ( dig10 == cliente.getCPF( ).charAt( 9 ) ) && ( dig11 == cliente.getCPF( ).charAt( 10 ) ) )
				return;
			else
			{
				sRet.setMsgErro( "CPF inválido!" );
			}
		}
		catch (InputMismatchException erro)
		{
			sRet.setMsgErro( "CPF inválido!" );
		}
	}
	
	public void validaEAjustaContato( Cliente cliente, StatusRetorno sRet )
	{
		if( Util.isnEmptyOrNull( cliente.getContato( ).getTelCelular    ( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getTelResidencial( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getTelComercial  ( ) ) )
			sRet.setMsgErro( "Pelo menos um telefone deve ser informado!" );
		else
		{
			if( !Util.isnEmptyOrNull( cliente.getContato( ).getTelCelular( ) ) &&
				validaTelefone( cliente.getContato( ).getTelCelular( ), sRet ) )
				cliente.getContato( ).setTelCelular( cliente.getContato( ).getTelCelular( ).replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) );
			
			if( !Util.isnEmptyOrNull( cliente.getContato( ).getTelResidencial( ) ) &&
				validaTelefone( cliente.getContato( ).getTelResidencial( ), sRet ) )
				cliente.getContato( ).setTelResidencial( cliente.getContato( ).getTelResidencial( ).replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) );
			
			if( !Util.isnEmptyOrNull( cliente.getContato( ).getTelComercial( ) ) &&
				validaTelefone( cliente.getContato( ).getTelComercial( ), sRet ) )
				cliente.getContato( ).setTelComercial( cliente.getContato( ).getTelComercial( ).replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) );
		}
		
		//Valida email
		validaEmail( cliente.getContato( ).getEmail( ), sRet );
		
		//Valida endereço
		if( sRet.isOk( ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getLogradouro ( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getComplemento( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getBairro     ( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getCidade     ( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getUf         ( ) ) &&
			Util.isnEmptyOrNull( cliente.getContato( ).getEndereco( ).getCep        ( ) ) &&
			cliente.getContato( ).getEndereco( ).getNumero( ) == 0 )
			cliente.getContato( ).setEndereco( null );
	}
	
	/**
	 * Valida o telefone no formato <code>DDD + telefone</code>.<br><br>
	 * <b>Obs.:</b> <i>Telefone não informado (String vazia) é considerado válido, tendo em vista que nem sempre o telefone é uma informação obrigatória.</i>
	 * @param telefone telefone no formato <i>ddd + telefone</i>.
	 * @param sRet {@link StatusRetorno}
	 * @return <code>TRUE</code> caso o telefone seja válido e <code>FALSE</code> caso contrário.
	 */
	public static boolean validaTelefone( String telefone, StatusRetorno sRet )
	{
		telefone = Util.trataString( telefone );
		
		if( Util.isnEmptyOrNull( telefone ) )
			return true;
		
		telefone = telefone.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" );
		
		// Verifica se o telefone é constituído por números no formato "ddd" + "telefone"
		if( !( telefone.matches( "[0-9]{10}" ) || telefone.matches( "[0-9]{11}" ) ) )
		{
			sRet.setMsgErro( "Telefone inválido!" );
			return false;
		}
		
		return true;
	}
	
	private boolean validaEmail( String email, StatusRetorno sRet )
	{
		email = Util.trataString( email );
		
		if( Util.isnEmptyOrNull( email ) )
			return true;
		
		if( !email.matches( "[A-Za-z0-9\\._-]+@[A-Za-z]+\\.[A-Za-z]+" ) )
		{
			sRet.setMsgErro( "e-mail inválido!" );
			return false;
		}
		
		return true;
	}

	public String getDataNasc( )
	{
		return dataNasc;
	}

	public void setDataNasc( String dataNasc )
	{
		this.dataNasc = dataNasc;
	}
}