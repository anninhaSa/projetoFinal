package validate;

import java.util.InputMismatchException;

import entity.Cliente;
import util.StatusRetorno;
import util.Util;

/**
 * Classe respons�vel por validar os dados do cliente.
 */
public class ValidaDadosPessoa
{
	private String dataNasc;
	private String celular;
	private String telResidencial;
	private String telComercial;
	
	public ValidaDadosPessoa( )
	{
		setDataNasc      ( "" );
		setCelular       ( "" );
		setTelResidencial( "" );
		setTelComercial  ( "" );
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
			sRet.setMsgErro( "Nome inv�lido!" );
	}
	
	private void validaECfgDataNascimento( Cliente cliente, StatusRetorno sRet )
	{
		if( Util.isnEmptyOrNull( getDataNasc( ) ) )
			return;
		
		cliente.setDataNasc( Util.trataData( getDataNasc( ) ) );
		
		if( cliente.getDataNasc( ) == null )
			sRet.setMsgErro( "Data de Nascimento inv�lida!" );
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
				sRet.setMsgErro( "CPF inv�lido!" );
			}
		}
		catch (InputMismatchException erro)
		{
			sRet.setMsgErro( "CPF inv�lido!" );
		}
	}
	
	public void validaEAjustaContato( Cliente cliente, StatusRetorno sRet )
	{
		if( Util.isnEmptyOrNull( getCelular( true ) ) && Util.isnEmptyOrNull( getTelResidencial( true ) ) && Util.isnEmptyOrNull( getTelComercial( true ) ) )
			sRet.setMsgErro( "Pelo menos um telefone deve ser informado!" );
		else
		{
			if( !Util.isnEmptyOrNull( getCelular( true ) ) && validaTelefone( getCelular( true ), sRet ) )
			{
				cliente.getContato( ).setDddCelular( getCelular( true ).substring( 0, 2 ) );
				cliente.getContato( ).setTelCelular( getCelular( true ).substring( 2    ) );
			}
			
			if( !Util.isnEmptyOrNull( getTelResidencial( true ) ) && validaTelefone( getTelResidencial( true ), sRet ) )
			{
				cliente.getContato( ).setDddResidencial( getTelResidencial( true ).substring( 0, 2 ) );
				cliente.getContato( ).setTelResidencial( getTelResidencial( true ).substring( 2    ) );
			}
			
			if( !Util.isnEmptyOrNull( getTelComercial( true ) ) && validaTelefone( getTelComercial( true ), sRet ) )
			{
				cliente.getContato( ).setDddComercial( getTelComercial( true ).substring( 0, 2 ) );
				cliente.getContato( ).setTelComercial( getTelComercial( true ).substring( 2    ) );
			}
		}
		
		//Valida email
		validaEmail( cliente.getContato( ).getEmail( ), sRet );
		
		//Valida endere�o
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
	 * <b>Obs.:</b> <i>Telefone n�o informado (String vazia) � considerado v�lido, tendo em vista que nem sempre o telefone � uma informa��o obrigat�ria.</i>
	 * @param telefone telefone no formato <i>ddd + telefone</i>.
	 * @param sRet {@link StatusRetorno}
	 * @return <code>TRUE</code> caso o telefone seja v�lido e <code>FALSE</code> caso contr�rio.
	 */
	public static boolean validaTelefone( String telefone, StatusRetorno sRet )
	{
		telefone = Util.trataString( telefone );
		
		if( Util.isnEmptyOrNull( telefone ) )
			return true;
		
		// Verifica se o telefone � constitu�do por n�meros no formato "ddd" + "telefone"
		if( !( telefone.matches( "[0-9]{10}" ) || telefone.matches( "[0-9]{11}" ) ) )
		{
			sRet.setMsgErro( "Telefone inv�lido!" );
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
			sRet.setMsgErro( "e-mail inv�lido!" );
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

	public String getCelular( boolean bSomenteNumeros )
	{
		String strNumTel = !Util.isnEmptyOrNull( celular ) ? celular.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) : celular;
		
		return bSomenteNumeros ? strNumTel : celular;
	}

	public void setCelular( String celular )
	{
		this.celular = celular;
	}

	public String getTelResidencial( boolean bSomenteNumeros )
	{
		String strNumTel = !Util.isnEmptyOrNull( telResidencial ) ? telResidencial.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) : telResidencial;
				
		return bSomenteNumeros ? strNumTel : telResidencial;
	}

	public void setTelResidencial( String telResidencial )
	{
		this.telResidencial = telResidencial;
	}

	public String getTelComercial( boolean bSomenteNumeros )
	{
		String strNumTel = !Util.isnEmptyOrNull( telComercial ) ? telComercial.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" ) : telComercial;
				
		return bSomenteNumeros ? strNumTel : telComercial;
	}

	public void setTelComercial( String telComercial )
	{
		this.telComercial = telComercial;
	}
}