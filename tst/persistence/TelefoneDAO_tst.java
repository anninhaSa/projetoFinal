package persistence;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import persistence.impl.ClienteDAOImpl;
import persistence.impl.TelefoneDAOImpl;
import util.PessoaTeste;
import entity.Cliente;
import entity.Telefone;

public class TelefoneDAO_tst extends TestCase {
    ClienteDAO clienteDAO;
    TelefoneDAO telefoneDAO;
    
    @Before
    protected void setUp() throws Exception {
        super.setUp();
        PessoaTeste.init();
        clienteDAO = new ClienteDAOImpl();
        telefoneDAO = new TelefoneDAOImpl();
        clienteDAO.excluiCliente(PessoaTeste.anna);
        
        excluiListaTelefone();
        
        boolean bOk = clienteDAO.insereCliente(PessoaTeste.anna);
        
        if(bOk) {
            inseteListaTelefone();
        }
    }

    private void excluiListaTelefone() {
        for(Telefone telefone : PessoaTeste.anna.getContato().getListTelefone()) {
            telefoneDAO.excluiTelefone(telefone);
        }
    }

    private void inseteListaTelefone() {
        for(Telefone telefone : PessoaTeste.anna.getContato().getListTelefone()) {
            telefoneDAO.insereTelefone(telefone);
        }
    }
    
    @Test
    public void testColetaClienteByTelefone() {
        List<Telefone> aList = (new TelefoneDAOImpl()).coletaTelefonePeloDDDENumero("21","995582559");
        Cliente cliente = new Cliente();
        
        if(aList != null && aList.size() > 0) {
            cliente = (Cliente) aList.get(0).getContato().getPessoa();
        }
        
        assertEquals(PessoaTeste.anna.getNome(), cliente != null ? cliente.getNome() : "");
    }

}
