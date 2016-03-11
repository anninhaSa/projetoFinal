package persistence.impl;

import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.CriptografaSenha;
import entity.Autenticacao;

/**
 * Classe de acesso a tabela Autenticacao (Login/Logout).
 */
public class AutenticacaoDaoImpl {
	Session     session;
	Transaction transaction;
	Query       query;
	
	/**
	 * Insere autenticacao.
	 * @param autenticacao {@link Autenticacao}
	 * @return <code>TRUE</code> caso a autenticacao seja inserida com sucesso e <code>FALSE</code> caso contrario.
	 */
	public boolean insereAutenticacao(Autenticacao autenticacao) {
		boolean bOk = false;
		
		if( autenticacao != null ) {
			autenticacao.setSenha(CriptografaSenha.getSenhaCriptografada( autenticacao.getSenha()));
			autenticacao.setIncDH(Calendar.getInstance().getTime()                                );
			autenticacao.setAltDH(Calendar.getInstance().getTime()                                );
		}
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(autenticacao);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	/**
	 * Coleta autenticacao.
	 * @param autenticacao {@link Autenticacao}
	 * @return {@link Autenticacao} caso a autenticacao informada esteja correta e <code>NULL</code> caso contrario.
	 */
	public Autenticacao coletaAutenticacao(Autenticacao autenticacao) {
		autenticacao.setSenha(CriptografaSenha.getSenhaCriptografada(autenticacao.getSenha()));
		
		session = HibernateUtilImpl.getSessionFactory( ).openSession( );
		query   = session.createQuery("  from Autenticacao a      \n" +
									  " where a.usuario = :param1 \n" +
									  "   and a.senha   = :param2 "   );
		
		query.setString("param1", autenticacao.getUsuario());
		query.setString("param2", autenticacao.getSenha  ());
		
		Autenticacao autenticacaoResposta = (Autenticacao)query.uniqueResult();
		
		session.close();
		
		return autenticacaoResposta;
	}
}