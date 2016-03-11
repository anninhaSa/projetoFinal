package persistence.impl;

import java.util.ArrayList;
import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import persistence.FuncionarioDAO;
import entity.Funcionario;

/**
 * Classe de acesso a tabela Funcionario.
 *
 */
public class FuncionarioDAOImpl implements FuncionarioDAO{
	Session     session;
	Transaction transaction;
	Query       query;
	Criteria    criteria;
	
	public boolean insereFuncionario(Funcionario funcionario) {
		boolean bOk = false;
		
		if(funcionario == null) {
			return bOk;
		}

		funcionario.setIncDH(Calendar.getInstance().getTime());
		funcionario.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.save(funcionario);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean atualizaFuncionario(Funcionario funcionario) {
		boolean bOk = false;
		
		if(funcionario == null) {
			return bOk;
		}
		
		funcionario.setAltDH(Calendar.getInstance().getTime());
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.update(funcionario);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}
	
	public boolean excluiFuncionario(Funcionario funcionario) {
		boolean bOk = false;
		
		if(funcionario == null) {
			return bOk;
		}
		
		session     = HibernateUtilImpl.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		
		session.delete(funcionario);
		
		transaction.commit();
		
		bOk = transaction.wasCommitted();
		
		session.close();
		
		return bOk;
	}

	public Funcionario coletaFuncionarioById(Integer id) {
		session = HibernateUtilImpl.getSessionFactory().openSession();
		
		Funcionario funcionario = (Funcionario)session.get(Funcionario.class, id);
		
		session.close();
		
		return funcionario;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> coletaFuncionarioPeloNome(String nome) {
		ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();
		
		if(StringUtils.trimToNull(nome) == null) {
			return listFuncionario;
		}
		
		session = HibernateUtilImpl.getSessionFactory().openSession();
		query   = session.createQuery("  from Funcionario f \n" +
		                              " where upper(f.nome) like '" + nome.trim() + "%'");
		
		listFuncionario = (ArrayList<Funcionario>)query.list();
		
		session.close();
		
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> coletaFuncionarioPeloTelefone(String ddd, String telefone) {
		ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();
		
		if(StringUtils.trimToNull(telefone) == null) {
			return listFuncionario;
		}
		
		session = HibernateUtilImpl.getSessionFactory().openSession();
		query   = session.createQuery("  from Funcionario f                                 \n" +
		                              " where f.contato.listTelefone.ddd      like :param1  \n" +
		                              "   and f.contato.listTelefone.telefone like :param2 ");
		
		query.setString("param1", ddd.trim()     );
		query.setString("param2", telefone.trim());
		
		listFuncionario = (ArrayList<Funcionario>)query.list();
		
		session.close();
		
		return listFuncionario;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Funcionario> coletaFuncionarioPeloTelefoneENome(String ddd, String telefone, String nome) {
		ArrayList<Funcionario> listCliente = new ArrayList<Funcionario>();
		
		if(StringUtils.trimToNull(telefone) == null || StringUtils.trimToNull(nome) == null) {
			return listCliente;
		}
		
		session = HibernateUtilImpl.getSessionFactory().openSession();
		query   = session.createQuery("  from Funcionario f           \n" +
		                              "  join f.listTelefone t        \n" +
		                              " where t.ddd      like :param1 \n" +
		                              "   and t.telefone like :param2 \n" +
		                              "   and upper(f.nome) like '" + nome.trim().toUpperCase() + "%' ");
		
		query.setString("param1", ddd.trim()     );
		query.setString("param2", telefone.trim());
		
		listCliente = (ArrayList<Funcionario>)query.list();
		
		session.close();
		
		return listCliente;
	}

    @SuppressWarnings("unchecked")
    @Override
    public ArrayList<Funcionario> coletaTodosFuncionario() {
        ArrayList<Funcionario> listFuncionario = new ArrayList<Funcionario>();
        
        session = HibernateUtilImpl.getSessionFactory().openSession();
        query   = session.createQuery(" from Funcionario f ");
        
        listFuncionario = (ArrayList<Funcionario>)query.list();
        
        session.close();
        
        return listFuncionario;
    }
}