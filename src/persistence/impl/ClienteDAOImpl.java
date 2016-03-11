package persistence.impl;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.ClienteDAO;
import entity.Cliente;

/**
 * Classe de acesso a tabela Cliente.
 */
public class ClienteDAOImpl implements ClienteDAO {
	Session     session;
	Transaction transaction;
	Query       query;
	Criteria    criteria;
	
	public boolean insereCliente(Cliente cliente) {
		boolean bOk = false;
		
		cliente.setIncDH(Calendar.getInstance().getTime());
		cliente.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(cliente);
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean atualizaCliente(Cliente cliente) {
		boolean bOk = false;
		
		if(cliente == null) {
		    return bOk;
		}
		
		cliente.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(cliente);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean excluiCliente(Cliente cliente) {
		boolean bOk = false;
		
		if(cliente == null) {
		    return bOk;
		}
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.delete(cliente);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public Cliente coletaClientePeloId(Integer id) {
		session = HibernateUtilImpl.getSessionFactory().openSession();
		
		Cliente cliente = (Cliente)session.get(Cliente.class, id);
		
		session.close();
		
		return cliente;
	}
	
	@SuppressWarnings("unchecked")
    public ArrayList<Cliente> coletaClientePeloNome(String nome) {
		ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
		
		if(StringUtils.trimToNull(nome) == null) {
			return listCliente;
		}
		
		session = HibernateUtilImpl.getSessionFactory().openSession();
		query   = session.createQuery("  from Cliente c \n" +
		                              " where upper(c.nome) like '" + nome.trim().toUpperCase() + "%'" );
		
		listCliente = (ArrayList<Cliente>)query.list();
		
		session.close();
		
		return listCliente;
	}
	
    @SuppressWarnings("unchecked")
    public ArrayList<Cliente> coletaTodosCliente() {
        ArrayList<Cliente> listCliente = new ArrayList<Cliente>();
        
        session = HibernateUtilImpl.getSessionFactory().openSession();
        query   = session.createQuery(" from Cliente c ");
        
        listCliente = (ArrayList<Cliente>)query.list();
        
        session.close();
        
        return listCliente;
    }
}