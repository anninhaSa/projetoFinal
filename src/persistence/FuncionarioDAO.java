package persistence;

import java.util.ArrayList;

import entity.Funcionario;

public interface FuncionarioDAO {
    public boolean insereFuncionario(Funcionario funcionario);
    public boolean atualizaFuncionario(Funcionario funcionario);
    public boolean excluiFuncionario(Funcionario funcionario);
    public Funcionario coletaFuncionarioById(Integer id);
    public ArrayList<Funcionario> coletaFuncionarioPeloNome(String nome);
    public ArrayList<Funcionario> coletaFuncionarioPeloTelefone(String ddd, String telefone);
    public ArrayList<Funcionario> coletaFuncionarioPeloTelefoneENome(String ddd, String telefone, String nome);
    public ArrayList<Funcionario> coletaTodosFuncionario();
}