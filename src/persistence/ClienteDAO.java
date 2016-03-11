package persistence;

import java.util.ArrayList;

import entity.Cliente;

public interface ClienteDAO {
    public boolean insereCliente(Cliente cliente);
    public boolean atualizaCliente(Cliente cliente);
    public boolean excluiCliente(Cliente cliente);
    public Cliente coletaClientePeloId(Integer id);
    public ArrayList<Cliente> coletaClientePeloNome(String nome);
    public ArrayList<Cliente> coletaTodosCliente();
}