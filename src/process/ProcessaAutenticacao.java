package process;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import persistence.AutenticacaoDao;
import util.StatusRetorno;
import util.Tela;
import entity.Autenticacao;

/**
 * Classe responsável pelo processamento da autenticação (Login e Logout)
 */
public class ProcessaAutenticacao
{
	/**
	 * Efetua o login.
	 * @param sRetorno {@link StatusRetorno}
	 * @param autenticacao {@link Autenticacao}
	 * @return {@link Autenticacao} caso a autenticação informada esteja correta e <code>NULL</code> caso contrário.
	 */
	public static Autenticacao efetuaLogin( StatusRetorno sRetorno, Autenticacao autenticacao )
	{
		try
		{
			autenticacao = new AutenticacaoDao( ).coletaAutenticacao( autenticacao );
		}
		catch ( Exception e )
		{
			sRetorno.setMsgErro( "Erro ao tentar logar!" );
			System.out.println ( "Erro: " + e            );
		}
		
		return autenticacao;
	}
	
	/**
	 * Efetua o logout.
	 * @param fc {@link FacesContext}
	 * @return o nome da página inicial (autenticação) do sistema
	 */
	public static String efetuaLogout( FacesContext fc )
	{
		HttpSession session = (HttpSession)fc.getExternalContext( ).getSession( false );    
	    session.invalidate( );     
	    
	    return Tela.s_strAutenticacao + "?faces-redirect=true";     
	}
}