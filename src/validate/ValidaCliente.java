package validate;

import java.util.InputMismatchException;

import entity.Cliente;
import util.StatusRetorno;
import util.Util;

/**
 * Classe responsável por validar os dados do cliente.
 */
public class ValidaCliente
{
	public StatusRetorno validaCliente( Cliente cliente )
	{
		StatusRetorno sRet = new StatusRetorno( );
		
		//ValidaNome
		validaNome( cliente, sRet );
		
		//Valida dataNasc;
		
		//TODO Falta testar
		//Valida cpf;
		if( !Util.isnEmptyOrNull( cliente.getCPF( ) ) )
			validaCPF( cliente.getCPF( ), sRet ); 
		
		//Valida contato
			//Valida dddCelular;
			//Valida telCelular;
			//Valida dddComercial;
			//Valida telComercial;
			//Valida dddResidencial;
			//Valida telResidencial;
			//Valida email
			//Valida endereço
				//Valida logradouro
				//Valida número
				//Valida complemento
				//bairro
				//cidade
				//uf
				//cep
		
		return sRet;
	}

	private void validaNome( Cliente cliente, StatusRetorno sRet )
	{
		cliente.setNome( Util.trataString( cliente.getNome( ) ) );
		
		if( Util.isnEmptyOrNull( cliente.getNome( ) ) )
			sRet.setMsgErro( "Nome inválido!" );
	}
	
	public static StatusRetorno validaTelefone( String telefone )
	{
		StatusRetorno sRet = new StatusRetorno( );
		
		telefone = Util.trataString( telefone );
		
		if( Util.isnEmptyOrNull( telefone ) )
			sRet.setMsgErro( "Telefone inválido!" );
		
		if( sRet.isOk( ) && ( telefone.length( ) < 10 || telefone.length( ) > 11 ) )
			sRet.setMsgErro( "Telefone inválido!" );
		
		// Verifica se o telefone é constituído por números no formato "ddd" + "telefone"
		if( sRet.isOk( ) && !( telefone.matches( "[0-9]{10}" ) || telefone.matches( "[0-9]{11}" ) ) )
			sRet.setMsgErro( "Telefone inválido!" );
		
		return sRet;
	}
	
	public void validaCPF( String CPF, StatusRetorno sRet )
	{
		CPF = CPF.replaceAll( "[.]", "" ).replaceAll( "[-]", "" );
		
		// considera-se erro CPF's formados por uma sequencia de numeros iguais 
		if ( CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222") ||
		     CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555") ||
		     CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888") ||
		     CPF.equals("99999999999") || (CPF.length() != 11))
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
				num  = (int)(CPF.charAt(i) - 48);
				sm  +=  (num * peso);
				--peso;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 =  (char)(r + 48);

			// converte no respectivo caractere numerico
			// Calculo do 2o. Digito Verificador

			sm   = 0;
			peso = 11;

			for(i=0; i<10; i++)
			{
				num = (int)(CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);

			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char)(r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
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
}