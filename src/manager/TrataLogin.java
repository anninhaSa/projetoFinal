package manager;

import javax.faces.context.FacesContext;

import process.ProcessaAutenticacao;
import util.Util;
import entity.Autenticacao;

public class TrataLogin
{
	private static final long serialVersionUID = 1L;
	
	private Autenticacao autenticacao;
	private String       strNomeUsrLogado;
	
	/**
	 * Coleta a autenticacao;
	 * @return {@link Autenticacao}
	 */
	public Autenticacao getAutenticacao( )
	{
		return autenticacao;
	}

	/**
	 * Configura a autenticacao.
	 * @param autenticacao {@link Autenticacao}
	 */
	public void setAutenticacao( Autenticacao autenticacao )
	{
		this.autenticacao = autenticacao;
	}
	
	/**
	 * Coleta o nome do usuário logado no sistema.
	 * @return nome do usuário logado no sistema
	 */
	public String getNomeUsrLogado( )
	{
		if( isUsrLogado( FacesContext.getCurrentInstance( ) ) )
			setNomeUsrLogado( getAutenticacao( ).getFuncionario( ).getNome( ) );
		else
			throw new SecurityException( );
			
		return strNomeUsrLogado;
	}
	
	/**
	 * Configura o nome do usuário logado.
	 * @param strNomeUsrLogado nome do usuário logado no sistema
	 */
	public void setNomeUsrLogado( String strNomeUsrLogado )
	{
		this.strNomeUsrLogado = strNomeUsrLogado;
	}
	
	/**
	 * Verifica se o usuário está logado no sistema.
	 * @return <code>TRUE</code> caso exista usuário logado no sistema e <code>FALSE</code> caso contrário.
	 */
	public boolean isUsrLogado( FacesContext fc )
	{
		setAutenticacao( Util.coletaAutenticacao( fc ) );
		
		return getAutenticacao( ) != null;
	}
	
	/**
	 * Efetua logout.
	 * @param fc {@link FacesContext}
	 * @return o nome da página inicial (autenticação) do sistema
	 */
	public String efetuaLogout( )
	{
		return ProcessaAutenticacao.efetuaLogout( FacesContext.getCurrentInstance( ) );
	}

	public static long getSerialversionuid( )
	{
		return serialVersionUID;
	}
}