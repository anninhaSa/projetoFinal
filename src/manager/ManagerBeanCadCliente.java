package manager;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistence.ClienteDAO;
import util.Formulario;
import util.StatusRetorno;
import util.Util;
import validate.ValidaDadosPessoa;
import entity.Cliente;

/**
 * Classe responsável por gerenciar a tela de <i>Cadastro de Cliente</i>.
 */
@ManagedBean( name = "mbCadCliente" )
@SessionScoped
public class ManagerBeanCadCliente extends TrataLogin implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cliente> clientes;
	private String             nome;
	private String             telefone;
	private Cliente            cliente;
	private Cliente            clienteSelected;
	private String             data;
	private String             celular;
	private String             telResidencial;
	private String             telComercial;
	
	/**
	 * Construtor da classe.
	 */
	public ManagerBeanCadCliente( )
	{
		setClientes       ( new ArrayList<Cliente>( ) );
		setNome           ( ""                        );
		setTelefone       ( ""                        );
		setClienteSelected( new Cliente( )            );
		setCliente        ( new Cliente( )            );
		
		inicializaVariaveis( );
	}

	@SuppressWarnings( "unchecked" )
	public String busca( )
	{
		FacesContext  fc       = FacesContext.getCurrentInstance( );
		String        msg      = "";
		StatusRetorno sRetorno = new StatusRetorno( );
		
		clientes = new ArrayList<Cliente>( );
		
		try
		{
			nome     = Util.trataString( nome     );
			telefone = Util.trataString( telefone );
			
			if( !Util.isnEmptyOrNull( nome ) && !Util.isnEmptyOrNull( telefone ) )
			{
				telefone = telefone.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" );
				ValidaDadosPessoa.validaTelefone( telefone, sRetorno );
				
				if( sRetorno.isOk( ) )
					clientes = (new ClienteDAO( )).coletaClienteByTelefoneAndNome( telefone, nome );
			}
			else if( !Util.isnEmptyOrNull( nome ) )
			{
				clientes = (new ClienteDAO( )).coletaClienteByNome( nome );
			}
			else if( !Util.isnEmptyOrNull( telefone ) )
			{
				telefone = telefone.replaceAll( "[(]", "" ).replaceAll( "[)]", "" ).replaceAll( "[-]", "" );
				ValidaDadosPessoa.validaTelefone( telefone, sRetorno );
				
				if( sRetorno.isOk( ) )
					clientes = (new ClienteDAO( )).coletaClienteByTelefone( telefone );
			}
			else
				clientes = (ArrayList<Cliente>) (new ClienteDAO( )).coletaTodasAsPessoas( );
		}
		catch( Exception ex )
		{
			msg = "Erro: " + ex.getMessage( );
			ex.printStackTrace( );
		}
		
		fc.addMessage( Formulario.s_strFormBuscaCliente, new FacesMessage( msg ) );
		
		return null;
	}
	
	public String incluiCliente( )
	{
		FacesContext  fc       = FacesContext.getCurrentInstance( );
		ClienteDAO    cliDao   = new ClienteDAO( );
		StatusRetorno sRetorno = new StatusRetorno( );
		
		try
		{
			ValidaDadosPessoa valida = new ValidaDadosPessoa( );
			
			valida.setDataNasc( data );
			
			sRetorno = valida.validaCliente( cliente );
			
			if( sRetorno.isOk( ) )
				sRetorno.setbOk( cliDao.insereCliente( cliente ) );
			
		}
		catch( Exception ex )
		{
			ex.printStackTrace( );
		}
		finally
		{
			if( sRetorno.isOk( ) )
			{
				fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso", null));
				
				if( cliente != null && clientes != null )
				{
					cliente = cliDao.coletaClienteById(cliente.getIdPessoa( ));
					clientes.add( cliente );
				}
			}
			else
				fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, sRetorno.getMsgErro( ).replace("/n", "<br>"), null));

			cliente = new Cliente( );
			
			inicializaVariaveis( );
		}
		
		return null;
	}
	
	public String excluiCliente( )
	{
		ClienteDAO    cliDao   = new ClienteDAO( );
		FacesContext  fc       = FacesContext.getCurrentInstance( );
		
		if( clienteSelected != null && cliDao.excluiCliente( clienteSelected ) )
		{
			fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso", null));
			
			if( clienteSelected != null && clientes != null )
				clientes.remove( clienteSelected );
		}
		else
			fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível excluir o cliente!", null));
		
		return null;
	}
	
	public String alteraCliente( )
	{
		ClienteDAO        cliDao = new ClienteDAO( );
		FacesContext      fc     = FacesContext.getCurrentInstance( );
		ValidaDadosPessoa valida = new ValidaDadosPessoa( );
		String            msg    = "";
		
		if( clienteSelected != null )
		{
			StatusRetorno sRetorno = valida.validaCliente(clienteSelected);
			
			if( sRetorno.isOk( ) && cliDao.atualizaCliente( clienteSelected ) )
				msg = "Cliente alterado com sucesso!";
			else
				msg = sRetorno.getMsgErro( ).replaceAll( "\n", "<br>" );
		}
		else
			msg = "Não foi possível alterar o cliente!";
		
		fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		
		return null;
	}
	
	public void inicializaVariaveis( )
	{
		setData          ( "" );
		setCelular       ( "" );
		setTelResidencial( "" );
		setTelComercial  ( "" );
	}
	
	/**
	 * Coleta os clientes
	 * @return {@link ArrayList} de {@link Cliente}.
	 */
	public ArrayList<Cliente> getClientes( )
	{
		return clientes;
	}

	/**
	 * Configura os clientes.
	 * @param clientes {@link ArrayList} de {@link Cliente}
	 */
	public void setClientes( ArrayList<Cliente> clientes )
	{
		this.clientes = clientes;
	}
	
	/**
	 * Coleta o nome do cliente informado na busca.
	 * @return nome do cliente
	 */
	public String getNome( )
	{
		return nome;
	}

	/**
	 * Configura o nome do cliente na busca.
	 * @param nome nome do cliente
	 */
	public void setNome( String nome )
	{
		this.nome = nome;
	}

	/**
	 * Coleta o telefone do cliente na busca.
	 * @return telefone do cliente
	 */
	public String getTelefone( )
	{
		return telefone;
	}

	/**
	 * Configura o telefone do cliente na busca.
	 * @param telefone telefone do cliente
	 */
	public void setTelefone( String telefone )
	{
		this.telefone = telefone;
	}

	/**
	 * Coleta o {@link Cliente} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @return {@link Cliente}
	 */
	public Cliente getCliente( )
	{
		return cliente;
	}

	/**
	 * Configura o {@link Cliente} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @param cliente {@link Cliente}
	 */
	public void setCliente( Cliente cliente )
	{
		this.cliente = cliente;
	}

	/**
	 * Coleta o {@link Cliente} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @return {@link Cliente}
	 */
	public Cliente getClienteSelected( )
	{
		return clienteSelected;
	}

	/**
	 * Configura o {@link Cliente} selecionado na <code>dataTable</code> da tela de Cadastro de cliente.
	 * @param clienteSelected {@link Cliente}
	 */
	public void setClienteSelected( Cliente clienteSelected )
	{
		this.clienteSelected = clienteSelected;
	}

	/**
	 * Coleta a data informada na tela.
	 * @return Data em forma de {@link String}
	 */
	public String getData( )
	{
		return data;
	}

	/**
	 * Configura a data informada na tela
	 * @param data data em {@link String}
	 */
	public void setData( String data ) 
	{
		this.data = data;
	}

	/**
	 * Coleta o serial.
	 * @return serial
	 */
	public static long getSerialversionuid( )
	{
		return serialVersionUID;
	}
	
	/**
	 * Coleta o celular.
	 * @return celuar com DDD.
	 */
	public String getCelular( )
	{
		return celular;
	}

	/**
	 * Configura o celular
	 * @param celular número do celular com DDD
	 */
	public void setCelular( String celular )
	{
		this.celular = celular;
	}

	/**
	 * Coleta o telefone residencial.
	 * @return telefone residencial com DDD
	 */
	public String getTelResidencial( )
	{
		return telResidencial;
	}

	/**
	 * Configura o telefone residencial.
	 * @param telResidencial telefone residencial com DDD
	 */
	public void setTelResidencial( String telResidencial )
	{
		this.telResidencial = telResidencial;
	}

	/**
	 * Coleta telefone comercial.
	 * @return telefone comercial com DDD
	 */
	public String getTelComercial( )
	{
		return telComercial;
	}
	
	/**
	 * Coleta telefone comercial.
	 * @param telComercial telefone comercial com DDD
	 */
	public void setTelComercial( String telComercial )
	{
		this.telComercial = telComercial;
	}
}