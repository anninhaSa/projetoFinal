package persistence;

import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.CriptografaSenha;
import entity.Autenticacao;

/**
 * Classe de acesso a tabela Autenticacao (Login/Logout).
 */
public class AutenticacaoDao
{
	Session     session;
	Transaction transaction;
	Query       query;
	
	/**
	 * Insere autenticação.
	 * @param autenticacao {@link Autenticacao}
	 * @return <code>TRUE</code> caso a autenticação seja inserida com sucesso e <code>FALSE</code> caso contrário.
	 */
	public boolean insereAutenticacao( Autenticacao autenticacao )
	{
		boolean bOk = false;
		
		if( autenticacao != null )
		{
			autenticacao.setSenha( CriptografaSenha.getSenhaCriptografada( autenticacao.getSenha( ) ) );
			autenticacao.setIncDH( Calendar.getInstance( )                                            );
			autenticacao.setAltDH( Calendar.getInstance( )                                            );
		}
		
		session     = HibernateUtil.getSessionFactory( ).openSession( );
		transaction = session.beginTransaction( );
		
		session.save( autenticacao );
		
		transaction.commit( );
		
		bOk = transaction.wasCommitted( );
		
		session.close( );
		
		return bOk;
	}
	
	/**
	 * Coleta autenticação.
	 * @param autenticacao {@link Autenticacao}
	 * @return {@link Autenticacao} caso a autenticação informada esteja correta e <code>NULL</code> caso contrário.
	 */
	public Autenticacao coletaAutenticacao( Autenticacao autenticacao )
	{
		autenticacao.setSenha( CriptografaSenha.getSenhaCriptografada( autenticacao.getSenha( ) ) );
		
		session = HibernateUtil.getSessionFactory( ).openSession( );
		query   = session.createQuery( "  from Autenticacao a      \n" +
									   " where a.usuario = :param1 \n" +
									   "   and a.senha   = :param2 "   );
		
		query.setString( "param1", autenticacao.getUsuario( ) );
		query.setString( "param2", autenticacao.getSenha  ( ) );
		
		Autenticacao autenticacaoResposta = (Autenticacao)query.uniqueResult( );
		
		session.close( );
		
		return autenticacaoResposta;
	}
}