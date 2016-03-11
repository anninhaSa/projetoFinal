package service;

import java.util.List;

import entity.Telefone;

public interface TelefoneService {
    public List<Telefone> coletaTelefonePeloDDDENumero(String ddd, String numTelefone);
    public List<Telefone> coletaTelefonePeloContatoId(Integer contatoId);
    public boolean incluiTelefone(Telefone telefone);
    public boolean alteraTelefone(Telefone telefone);
}