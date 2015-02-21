package persistence;

import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.Util;
import entity.Cliente;

/**
 * Classe de acesso a tabela Cliente.
 */
public class ClienteDAO extends PessoaDAO
{
	Session     session;
	Transaction transaction;
	Query       query;
	Criteria    criteria;
	
	/**
	 * Insere cliente na base de dados.
	 * @param cliente {@link Cliente}
	 * @return <code>TRUE</code> caso os dados do cliente seja inserido com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean insereCliente( Cliente cliente )
	{
		boolean bOk = false;
		
		if( cliente == null )
			return bOk;
		
		cliente.setIncDH( Calendar.getInstance( ) );
		cliente.setAltDH( Calendar.getInstance( ) );
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.save( cliente );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Atualiza cliente na base de dados.
	 * @param cliente {@link Cliente}
	 * @return <code>TRUE</code> caso os dados do cliente sejam atualizados com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean atualizaCliente( Cliente cliente )
	{
		boolean bOk = false;
		
		if( cliente == null )
			return bOk;
		
		cliente.setAltDH( Calendar.getInstance( ) );
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.update( cliente );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Exclui cliente da base de dados.
	 * @param cliente {@link Cliente}
	 * @return <code>TRUE</code> caso os dados do cliente seja atualizado com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean excluiCliente( Cliente cliente )
	{
		boolean bOk = false;
		
		if( cliente == null )
			return bOk;
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.delete( cliente );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Coleta o cliente a partir do Id
	 * @param id id do cliente
	 * @return {@link Cliente}
	 */
	public Cliente coletaClienteById( Integer id )
	{
		session = HibernateUtil.getSessionFactory( ).openSession( );
		
		Cliente cliente = (Cliente)session.get( Cliente.class, id );
		
		session.close( );
		
		return cliente;
	}
	
	/**
	 * Coleta todos os clientes que possuma o nome parametrizado.
	 * @param nome nome
	 * @return {@link ArrayList} de {@link Cliente}.
	 */
	@SuppressWarnings( "unchecked" )
	public ArrayList<Cliente> coletaClienteByNome( String nome )
	{
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>( );
		
		if( Util.isnEmptyOrNull( nome ) )
			return listCliente;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Cliente c \n" +
		                               " where upper(c.nome) like '" + nome.trim( ).toUpperCase( ) + "%'" );
		
		listCliente = (ArrayList<Cliente>)query.list( );
		
		session.close( );
		
		return listCliente;
	}
	
	/**
	 * Coleta todos os clientes que possuam o telefone parametrizado.
	 * @param telefone telefone
	 * @return {@link ArrayList} de {@link Cliente}.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> coletaClienteByTelefone( String telefone )
	{
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>( );
		
		if( Util.isnEmptyOrNull( telefone ) )
			return listCliente;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Cliente c                             \n" +
		                               " where c.contato.telCelular     like :param1 \n" +
		                               "    or c.contato.telComercial   like :param2 \n" +
		                               "    or c.contato.telResidencial like :param3" );
		
		query.setString( "param1", telefone.trim( ) );
		query.setString( "param2", telefone.trim( ) );
		query.setString( "param3", telefone.trim( ) );
		
		listCliente = (ArrayList<Cliente>)query.list( );
		
		session.close( );
		
		return listCliente;
	}
	
	/**
	 * Coleta todos os clientes que possuam o telefone e o nome parametrizados.
	 * @param telefone telefone do cliente
	 * @param nome nome do cliente
	 * @return {@link ArrayList} de {@link Cliente}.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> coletaClienteByTelefoneAndNome( String telefone, String nome )
	{
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>( );
		
		if( Util.isnEmptyOrNull( telefone ) || Util.isnEmptyOrNull( nome ) )
			return listCliente;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Cliente c                                  \n" +
		                               " where (   c.contato.telCelular     like :param1  \n" +
		                               "        or c.contato.telComercial   like :param2  \n" +
		                               "        or c.contato.telResidencial like :param3) \n" +
		                               "   and upper(c.nome) like '" + nome.trim( ).toUpperCase( ) + "%' " );
		
		query.setString( "param1", telefone.trim( ) );
		query.setString( "param2", telefone.trim( ) );
		query.setString( "param3", telefone.trim( ) );
		
		listCliente = (ArrayList<Cliente>)query.list( );
		
		session.close( );
		
		return listCliente;
	}
}