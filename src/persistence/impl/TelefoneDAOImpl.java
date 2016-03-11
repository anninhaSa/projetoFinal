package persistence.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Telefone;
import persistence.TelefoneDAO;

public class TelefoneDAOImpl implements TelefoneDAO {
    Session     session;
    Transaction transaction;
    Query       query;
    Criteria    criteria;

    @SuppressWarnings("unchecked")
    @Override
    public List<Telefone> coletaTelefonePeloDDDENumero(String ddd, String numTelefone) {
        List<Telefone> listaTelefone = new ArrayList<Telefone>();
        
        if(StringUtils.trimToNull(numTelefone) == null || StringUtils.trimToNull(ddd) == null) {
            return listaTelefone;
        }
        
        session = HibernateUtilImpl.getSessionFactory().openSession();
        query   = session.createQuery("  from Telefone t              \n" +
                                      " where t.ddd      like :param1 \n" +
                                      "   and t.telefone like :param2 ");
        
        query.setString("param1", ddd.trim()     );
        query.setString("param2", numTelefone.trim());
        
        listaTelefone = query.list();
        
        return listaTelefone;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Telefone> coletaTelefonePeloContatoId(Integer contatoId) {
        List<Telefone> listTelefone = new ArrayList<Telefone>();
        
        session = HibernateUtilImpl.getSessionFactory().openSession();
        query   = session.createQuery("  from Telefone t                \n" +
                                      " where t.id_contato like :param1 \n");
        
        query.setInteger("param1", contatoId);
        
        listTelefone = query.list();
        
        return listTelefone;
    }

    @Override
    public boolean insereTelefone(Telefone telefone) {
        boolean bOk = false;
        
        telefone.setIncDH(Calendar.getInstance().getTime());
        telefone.setAltDH(Calendar.getInstance().getTime());
        
        session     = HibernateUtilImpl.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        session.save(telefone);
        
        transaction.commit();
        
        bOk = transaction.wasCommitted();
        
        session.close();
        
        return bOk;
    }

    @Override
    public boolean excluiTelefone(Telefone telefone) {
        boolean bOk = false;
        
        telefone.setAltDH(Calendar.getInstance().getTime());
        
        session     = HibernateUtilImpl.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        session.delete(telefone);
        
        transaction.commit();
        
        bOk = transaction.wasCommitted();
        
        session.close();
        
        return bOk;
    }
}