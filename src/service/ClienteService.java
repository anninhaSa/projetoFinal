package service;

import java.util.List;

import util.StatusRetorno;
import entity.Cliente;

public interface ClienteService {
    public Cliente coletaClientePeloId(Integer id);
    public List<Cliente> coletaClientePeloNome(String nome);
    public List<Cliente> coletaClientePeloTelefone(String telefone);
    public List<Cliente> coletaListaClientes();
    public StatusRetorno incluiCliente(Cliente cliente);
    public StatusRetorno excluiCliente(Cliente cliente);
    public StatusRetorno alteraCliente(Cliente cliente);
}
