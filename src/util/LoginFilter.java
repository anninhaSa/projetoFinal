package util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Autenticacao;

/**
 * Classe responsável por validar se o acesso as páginas é feito por um usário logado.
 */
public class LoginFilter implements Filter
{
	@Override
	public void destroy( )
	{ }
	
	@Override
	public void init( FilterConfig arg0 ) throws ServletException
	{ }

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain )
	throws IOException, ServletException
	{
		HttpServletRequest  hreq    = (HttpServletRequest)  request;
        HttpServletResponse hresp   = (HttpServletResponse) response;
        HttpSession         session = hreq.getSession( );
        
        hreq.getPathInfo( );
        String paginaAtual = new String( hreq.getRequestURL( ) );
        
        if( ( !paginaAtual.endsWith( Tela.s_strAutenticacao ) ) && ( paginaAtual.endsWith( ".jsf" ) ) )
        {
        	Autenticacao autenticacao = null;
        	
        	Object obj = session.getAttribute( Util.s_strSSNAutenticacao );
        	
        	if( obj != null && obj instanceof Autenticacao )
    			autenticacao = (Autenticacao)obj;
        	
        	if( autenticacao == null || autenticacao.getFuncionario( ) == null ||
        		autenticacao.getFuncionario( ).getNome( ) == null )
        	{
        		hresp.sendRedirect( Tela.s_strAutenticacao );
        		
                return;
        	}
        }
        
        chain.doFilter( request, response );
	}
}