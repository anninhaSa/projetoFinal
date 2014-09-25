package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import entity.Autenticacao;

/**
 * Classe utilitária.
 */
public class Util
{
	
	/**
	 * Autenticacao armazenada na sessão.
	 */
	public static final String s_strSSNAutenticacao = "strSSNAutenticacao";
	
	/**
	 * Verifica se a {@link String} está vazia ou nula.
	 * @param str string a ser validada
	 * @return <code>TRUE</code> caso esteja vazia/nula e <code>FALSE</code> caso contrário.
	 */
	public static boolean isnEmptyOrNull( String str )
	{
		boolean bEmptyOrNul = str == null || str.isEmpty( );
		
		return bEmptyOrNul;
	}
	
	/**
	 * Armazena autenticação na sessão.
	 * @param fc {@link FacesContext}
	 * @param autenticacao {@link Autenticacao} 
	 */
	public static void armazenaAutenticacao( FacesContext fc, Autenticacao autenticacao )
	{
		armazenaObjSessao( fc, s_strSSNAutenticacao, autenticacao );
	}
	
	/**
	 * Armazena objeto na sessão.
	 * @param fc {@link FacesContext}
	 * @param strNomeObj nome do objeto na sessão
	 * @param obj {@link Object}
	 */
	public static void armazenaObjSessao( FacesContext fc, String strNomeObj, Object obj )
	{
		fc.getExternalContext( ).getSessionMap( ).put( strNomeObj, obj );
	}
	
	/**
	 * Coleta autenticação da sessão.
	 * @return {@link Autenticacao} caso exista usuário logado no sistema e <code>null</code> caso contrário.
	 */
	public static Autenticacao coletaAutenticacao( FacesContext fc )
	{
		Autenticacao autenticacao = null;
		
		Object obj = coletaObjSessao( fc, s_strSSNAutenticacao );
		
		if( obj != null && obj instanceof Autenticacao )
			autenticacao = (Autenticacao)obj;
		
		return autenticacao;
	}
	
	/**
	 * Coleta objeto da sessão.
	 * @param fc {@link FacesContext}
	 * @param strNomeObj nome do objeto a ser armazenado na sessão
	 * @return {@link Object} caso o objeto esteja armazenado na sessão e <code>null</code> caso contrário.
	 */
	public static Object coletaObjSessao( FacesContext fc, String strNomeObj )
	{
		return fc.getExternalContext( ).getSessionMap( ).get( strNomeObj );
	}
	
	/**
	 * Trata campo String
	 * @param str String a ser tratada
	 * @return caso a {@link String} esteja nula, será retorna uma string vazia, caso contrário a string original será retornada sem espaço no final
	 * (caso exista).
	 */
	public static String trataString( String str )
	{
		return Util.isnEmptyOrNull( str ) ? null : str.trim( );
	}
	
	/**
	 * Trata data no formato dd/mm/aaaa
	 * @param strData
	 * @return
	 */
	public static Date trataData( String strData )
	{
		if( Util.isnEmptyOrNull( strData) ) 
			return null;
		
		try
		{
			return (new SimpleDateFormat( "dd/MM/yyyy" )).parse( strData );
		}
		catch ( Exception e )
		{
			return null;
		}
	}
}