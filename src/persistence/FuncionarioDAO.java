package persistence;

import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.Util;
import entity.Cliente;
import entity.Funcionario;

/**
 * Classe de acesso a tabela Funcionario.
 *
 */
public class FuncionarioDAO extends PessoaDAO
{
	Session     session;
	Transaction transaction;
	Query       query;
	Criteria    criteria;
	
	/**
	 * Insere funcionário.
	 * @param funcionario {@link Funcionario}
	 * @return <code>TRUE</code> caso os dados do funcionário seja inserido com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean insereFuncionario( Funcionario funcionario )
	{
		boolean bOk = false;
		
		if( funcionario == null )
			return bOk;

		funcionario.setIncDH( Calendar.getInstance( ) );
		funcionario.setAltDH( Calendar.getInstance( ) );
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.save( funcionario );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Atualiza os dados do funcionário
	 * @param funcionario {@link Funcionario}
	 * @return <code>TRUE</code> caso os dados do cliente sejam atualizados com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean atualizaFuncionario( Funcionario funcionario )
	{
		boolean bOk = false;
		
		if( funcionario == null)
			return bOk;
		
		funcionario.setAltDH( Calendar.getInstance( ) );
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.update( funcionario );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Exclui funcionário.
	 * @param funcionario {@link Funcionario}
	 * @return <code>TRUE</code> caso os dados do cliente seja excluido com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean excluiFuncionario( Funcionario funcionario )
	{
		boolean bOk = false;
		
		if( funcionario == null )
			return bOk;
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.delete( funcionario );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}

	/**
	 * Coleta o funcionário a partir do Id.
	 * @param id identificador
	 * @return {@link Funcionario}
	 */
	public Funcionario coletaFuncionarioById( Integer id )
	{
		session = HibernateUtil.getSessionFactory( ).openSession( );
		
		Funcionario funcionario = (Funcionario)session.get( Funcionario.class, id );
		
		session.close( );
		
		return funcionario;
	}
	
	/**
	 * Coleta todos os funcionários que possuma o nome parametrizado.
	 * @param nome nome
	 * @return {@link ArrayList} de {@link Cliente}.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> coletaFuncionarioByNome( String nome )
	{
		ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>( );
		
		if( Util.isnEmptyOrNull( nome ) )
			return listFuncionario;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Funcionario f \n" +
		                               " where f.nome like '" + nome.trim( ) + "%'" );
		
		listFuncionario = (ArrayList<Funcionario>)query.list( );
		
		session.close( );
		
		return listFuncionario;
	}
	
	/**
	 * Coleta todos os funcionários que possuam o telefone parametrizado.
	 * @param telefone telefone
	 * @return {@link ArrayList} de {@link Funcionario}.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> coletaFuncionarioByTelefone( String telefone )
	{
		ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>( );
		
		if( Util.isnEmptyOrNull( telefone ) )
			return listFuncionario;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Funcionario f                              \n" +
		                               " where (    f.contato.telCelular     like :param1 \n" +
		                               "         or f.contato.telComercial   like :param2 \n" +
		                               "         or f.contato.telResidencial like :param3 )" );
		
		query.setString( "param1", telefone.trim( ) );
		query.setString( "param2", telefone.trim( ) );
		query.setString( "param3", telefone.trim( ) );
		
		listFuncionario = (ArrayList<Funcionario>)query.list( );
		
		session.close( );
		
		return listFuncionario;
	}
	
	/**
	 * Coleta todos os funcionarios que possuam o telefone e o nome parametrizados.
	 * @param telefone telefone do funcionario
	 * @param nome nome do funcionario
	 * @return {@link ArrayList} de {@link Funcionario}.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Cliente> coletaFuncionarioByTelefoneAndNome( String telefone, String nome )
	{
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>( );
		
		if( Util.isnEmptyOrNull( telefone ) || Util.isnEmptyOrNull( nome ) )
			return listCliente;
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Funcionario f                                    \n" +
		                               " where (    f.contato.telCelular     like :param1   \n" +
		                               "         or f.contato.telComercial   like :param2   \n" +
		                               "         or f.contato.telResidencial like :param3 ) \n" +
		                               "   and f.nome like '" + nome.trim( ) + "%' " );
		
		query.setString( "param1", telefone.trim( ) );
		query.setString( "param2", telefone.trim( ) );
		query.setString( "param3", telefone.trim( ) );
		
		listCliente = (ArrayList<Cliente>)query.list( );
		
		session.close( );
		
		return listCliente;
	}
}