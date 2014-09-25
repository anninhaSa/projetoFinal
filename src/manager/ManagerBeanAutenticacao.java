package manager;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import process.ProcessaAutenticacao;
import util.Formulario;
import util.StatusRetorno;
import util.Tela;
import util.Util;
import validate.ValidaAutenticacao;
import entity.Autenticacao;

/**
 * Classe respons�vel por gerenciar a tela de Autentica��o.
 */
@ManagedBean( name = "mbAutenticacao" )
@SessionScoped
public class ManagerBeanAutenticacao implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Autenticacao autenticacao;
	
	/**
	 * Construtor da classe {@link ManagerBeanAutenticacao}.
	 */
	public ManagerBeanAutenticacao( )
	{
		setAutenticacao( new Autenticacao( ) );
	}
	
	public static long getSerialversionuid( )
	{
		return serialVersionUID;
	}

	/**
	 * Coleta a autentica��o.
	 * @return {@link Autenticacao}
	 */
	public Autenticacao getAutenticacao( )
	{
		return autenticacao;
	}

	/**
	 * Configura a autentica��o.
	 * @param autenticacao {@link Autenticacao}
	 */
	public void setAutenticacao( Autenticacao autenticacao )
	{
		this.autenticacao = autenticacao;
	}
	
	/**
	 * Efetua login caso o usu�rio e senha estejam corretos.
	 * @return nome da tela caso o login seja efetuado e <code>null</code> caso contr�rio.
	 */
	public String efetuaLogin( )
	{
		FacesContext fc = FacesContext.getCurrentInstance( );
		
		StatusRetorno sRetorno = ValidaAutenticacao.validaLogin( getAutenticacao( ) );
		
		if( sRetorno.isOk( ) )
		{
			sRetorno = new StatusRetorno( );
			
			Autenticacao aux = ProcessaAutenticacao.efetuaLogin( sRetorno, getAutenticacao( ) );
			
			if( aux != null )
			{
				setAutenticacao( aux );
				
				Util.armazenaAutenticacao( fc, getAutenticacao( ) );
				
				return Tela.s_strMenu + "?faces-redirect=true";
			}
		}
		
		fc.addMessage  ( Formulario.s_strFormAutenticacao, new FacesMessage( sRetorno.getMsgErro( ) ) );
		setAutenticacao( new Autenticacao( )                                                          );
		
		return null;
	}
}