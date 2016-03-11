package service.impl;

import java.util.ArrayList;
import java.util.List;

import persistence.ClienteDAO;
import persistence.impl.ClienteDAOImpl;
import service.ClienteService;
import service.TelefoneService;
import util.StatusRetorno;
import validate.ValidadorPessoa;
import validate.ValidadorTelefone;
import view.ContatoDTO;
import entity.Cliente;
import entity.Telefone;

public class ClienteServiceImpl implements ClienteService {

    private ClienteDAO clienteDao;
    private ValidadorTelefone validadorTelefone;
    private ValidadorPessoa validadorPessoa;
    private TelefoneService telefoneService;

    @Override
    public Cliente coletaClientePeloId(Integer id) {
        clienteDao = new ClienteDAOImpl();
        telefoneService = new TelefoneServiceImpl();
        Cliente cliente = new Cliente();
        
        if(id != null && id != 0) {
            return new Cliente();
        }
        
        cliente = clienteDao.coletaClientePeloId(id);
        cliente.getContato().setListTelefone(telefoneService.coletaTelefonePeloContatoId(cliente.getContato().getIdContato()));
        
        return cliente;
    }

    @Override
    public List<Cliente> coletaClientePeloNome(String nome) {
        clienteDao = new ClienteDAOImpl();
        List<Cliente> listaClientes = clienteDao.coletaClientePeloNome(nome);
        
        for(Cliente cliente : listaClientes) {
            cliente.getContato().setListTelefone(telefoneService.coletaTelefonePeloContatoId(cliente.getContato().getIdContato()));
        }
                
        return listaClientes;
    }

    @Override
    public List<Cliente> coletaClientePeloTelefone(String numTelefone) {
        StatusRetorno sRetorno = validadorTelefone.aplica(numTelefone);
        List<Cliente> listClientes = new ArrayList<Cliente>();
        
        if( sRetorno.isOk( ) ) {
            clienteDao = new ClienteDAOImpl();
            telefoneService = new TelefoneServiceImpl();
            Telefone telefone = ContatoDTO.telefoneToEntity(numTelefone);
            List<Telefone> listaTelefone = telefoneService.coletaTelefonePeloDDDENumero(telefone.getDDD(), telefone.getTelefone());
            
            for(Telefone telefoneAux : listaTelefone) {
                listClientes.add(clienteDao.coletaClientePeloId(telefoneAux.getContato().getPessoa().getIdPessoa()));
            }
            
        }
        
        return listClientes;
    }

    @Override
    public List<Cliente> coletaListaClientes() {
        clienteDao = new ClienteDAOImpl();
        
        List<Cliente> listClientes = new ArrayList<Cliente>();
        
        listClientes = clienteDao.coletaTodosCliente();
        
        return listClientes;
    }

    @Override
    public StatusRetorno incluiCliente(Cliente cliente) {
        validadorPessoa = new ValidadorPessoa();
        clienteDao = new ClienteDAOImpl();
        
        StatusRetorno sRetorno = validadorPessoa.aplica(cliente);
        
        if(sRetorno.isOk()) {
            sRetorno.setbOk(clienteDao.insereCliente(cliente));
        }
        
        return sRetorno;
    }

    @Override
    public StatusRetorno excluiCliente(Cliente cliente) {
        clienteDao = new ClienteDAOImpl();
        StatusRetorno sRetorno = new StatusRetorno();
        
        sRetorno.setbOk(clienteDao.excluiCliente(cliente));
        
        return sRetorno;
    }

    @Override
    public StatusRetorno alteraCliente(Cliente cliente) {
        clienteDao = new ClienteDAOImpl();
        StatusRetorno sRetorno = new StatusRetorno();
        
        sRetorno.setbOk(clienteDao.atualizaCliente(cliente));
        
        return sRetorno;
    }
}