package validate;

import util.StatusRetorno;
import util.Util;
import entity.Autenticacao;

/**
 * Classe respons�vel por validar a autentica��o (Login e Logout).
 */
public class ValidaAutenticacao
{
	public static String s_strMsgErroDefault = "Usu�rio/Senha inv�lido!";
	
	/**
	 * Verifica se o login � v�lido.
	 * @param autenticacao {@link Autenticacao}
	 * @return {@link StatusRetorno}
	 */
	public static StatusRetorno validaLogin( Autenticacao autenticacao )
	{
		StatusRetorno sRet = new StatusRetorno( );
		
		if( autenticacao == null )
		{
			sRet.setMsgErro( s_strMsgErroDefault );
			
			return sRet;
		}
		
		if( Util.isnEmptyOrNull( autenticacao.getUsuario( ) ) || Util.isnEmptyOrNull( autenticacao.getSenha( ) ) )
		{
			sRet.setMsgErro( s_strMsgErroDefault );
			
			return sRet;
		}
		else
		{
			autenticacao.setUsuario( autenticacao.getUsuario( ).trim( ) );
			autenticacao.setSenha  ( autenticacao.getSenha  ( ).trim( ) );
		}
		
		if( !isnStringPadronizada( autenticacao.getUsuario( ) ) || !isnStringPadronizada( autenticacao.getSenha( ) ) )
		{
			sRet.setMsgErro( s_strMsgErroDefault );
			
			return sRet;
		}
		
		return sRet;
	}
	
	/**
	 * Verifica se a string obedece o padr�o abaixo:
	 * <ul>
	 * 	<li>Cont�m apenas letras e/ou n�meros</li>
	 *  <li>Tem no m�nimo 4 caracteres e no m�ximo 8</li>
	 * </ul>
	 * @param string string a ser validada
	 * @return <code>TRUE</code> caso a {@link String} obede�a o padr�o e <code>FALSE</code> caso contr�rio.
	 */
	private static boolean isnStringPadronizada( String str )
	{
		boolean bOk = false;
		
		if( str != null )
			//Express�o regular respons�vel por validar o padr�o descrito acima.
			bOk = str.matches( "[a-zA-Z0-9]{4,8}" );
		
		return bOk;
	}
}