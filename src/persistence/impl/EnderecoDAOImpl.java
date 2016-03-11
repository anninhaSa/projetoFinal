package persistence.impl;

import java.util.Calendar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Endereco;


public class EnderecoDAOImpl {
	Session     session;
	Transaction transaction;
	Query       query;
	
	/**
	 * Insere o {@link Endereco} na base de dados.
	 * @param endereco {@link Endereco}
	 * @return <code>TRUE</code> caso os dados sejam inseridos com sucesso e <code>FALSE</code> caso contrario.
	 */
	public boolean insereEndereco(Endereco endereco) {
		boolean bOk = false;
		
		if(endereco == null)
			return bOk;
		
		endereco.setIncDH(Calendar.getInstance().getTime());
		endereco.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(endereco);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean atualizaEndereco(Endereco endereco) {
		boolean bOk = false;
		
		if(endereco == null)
			return bOk;
		
		endereco.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(endereco);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean excluiEndereco(Endereco endereco) {
		boolean bOk = false;
		
		if( endereco == null )
			return bOk;
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.delete(endereco);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public Endereco coletaEnderecoByIdContato(int idContato) {
		Endereco endereco = new Endereco();
		
		if(idContato == 0) {
			return endereco;
		}
		
		session = HibernateUtilImpl.getSessionFactory().openSession();
		
		query = session.createQuery("  from Endereco e " +
				                    " where e.id_contato :param1 ");
		
		query.setInteger("param1", idContato);
		
		endereco = (Endereco)query.uniqueResult();
		
		session.close();
		
		return endereco;
	}
}