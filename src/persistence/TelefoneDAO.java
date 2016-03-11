package persistence;

import java.util.List;

import entity.Telefone;

public interface TelefoneDAO {
    public List<Telefone> coletaTelefonePeloDDDENumero(String ddd, String telefone);
    public List<Telefone> coletaTelefonePeloContatoId(Integer contatoId);
    public boolean insereTelefone(Telefone telefone);
    public boolean excluiTelefone(Telefone telefone);
}