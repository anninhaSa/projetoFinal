package util;

import java.util.ArrayList;

import entity.Cliente;
import entity.Contato;
import entity.Endereco;
import entity.Funcionario;
import entity.Telefone;

public class PessoaTeste {
    public static Cliente anna;
    public static Cliente leda;
    public static Cliente deny;
    public static Cliente denise;
    public static Cliente vitor;
    public static Cliente kamilla;
    
    public static Funcionario daisy;
        
    public static void init() {
        
        anna = new Cliente(null, "Anna", Util.converteStringParaDate("03/11/1986"), null, null, null, null, null, null);
        anna.setContato(new Contato(null, "annasa03@gmail.com.br", anna, null, new ArrayList<Telefone>())); 
        anna.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 3", "Baldeador", "Niteroi", "RJ", "24140050", anna.getContato()));
        anna.getContato().getListTelefone().add(new Telefone(null, "21", "26252115",  Telefone.s_nTpResidencial, anna.getContato()));
        anna.getContato().getListTelefone().add(new Telefone(null, "21", "32335200",  Telefone.s_nTpComercial,   anna.getContato()));
        anna.getContato().getListTelefone().add(new Telefone(null, "21", "995582559", Telefone.s_nTpCelular,     anna.getContato()));
        
        leda = new Cliente(null, "Leda", Util.converteStringParaDate("26/08/2008"), null, null, null, null, null, null);
        leda.setContato(new Contato(null, "leda.maria@gmail.com.br", leda, null, new ArrayList<Telefone>()));
        leda.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 1", "Baldeador", "Niteroi", "RJ", "24140050", leda.getContato()));
        leda.getContato().getListTelefone().add(new Telefone(null, "21", "36015662", Telefone.s_nTpResidencial, leda.getContato()));
        
        deny = new Cliente(null, "Deny", Util.converteStringParaDate("15/05/1935"), null, null, null, null, null, null);
        deny.setContato(new Contato(null, "deny.lopes@gmail.com.br", deny, null, new ArrayList<Telefone>()));
        deny.getContato().setEndereco(new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 1", "Caramujo", "Niteroi", "RJ", "24140050", deny.getContato()));
        deny.getContato().getListTelefone().add(new Telefone(null, "21", "26257133", Telefone.s_nTpResidencial, deny.getContato()));
        
        denise = new Cliente(null, "Denise", Util.converteStringParaDate("04/08/1955"), null, null, null, null, null, null);
        denise.setContato(new Contato(null, "denise.bastos@gmail.com.br", denise, null, new ArrayList<Telefone>()));
        denise.getContato().setEndereco(new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 1", "Caramujo", "Niteroi", "RJ", "24140050", denise.getContato()));
        denise.getContato().getListTelefone().add(new Telefone(null, "21", "26257133", Telefone.s_nTpResidencial, denise.getContato()));
        
        vitor = new Cliente(null, "Vitor", Util.converteStringParaDate("29/05/1995"), null, null, null, null, null, null);
        vitor.setContato(new Contato(null, "vitor.oliveira@gmail.com.br", vitor, null, new ArrayList<Telefone>()));
        vitor.getContato().setEndereco(new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 2", "Caramujo", "Niteroi", "RJ", "24140050", vitor.getContato()));
        vitor.getContato().getListTelefone().add(new Telefone(null, "21", "26279364", Telefone.s_nTpResidencial, vitor.getContato()));
        
        kamilla = new Cliente(null, "Kamilla", Util.converteStringParaDate("22/06/1997"), null, null, null, null, null, null);
        kamilla.setContato(new Contato(null, "kamilla.bastos@gmail.com.br", kamilla, null, new ArrayList<Telefone>()));
        kamilla.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 1", "Baldeador", "Niteroi", "RJ", "24140050", kamilla.getContato()));
        kamilla.getContato().getListTelefone().add(new Telefone(null, "21", "36015662", Telefone.s_nTpResidencial, kamilla.getContato()));
        
        daisy = new Funcionario(null, "Daisy", Util.converteStringParaDate("13/09/1958"), null, null, null, null, null, null);
        daisy.setContato(new Contato(null, "daisysa@outlook.com", daisy, null, new ArrayList<Telefone>()));
        daisy.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 3", "Baldeador", "Niteroi", "RJ", "24140050", daisy.getContato()));
        daisy.getContato().getListTelefone().add(new Telefone(null, "21", "26252115",  Telefone.s_nTpResidencial, daisy.getContato()));
        daisy.getContato().getListTelefone().add(new Telefone(null, "21", "22247133",  Telefone.s_nTpComercial,   daisy.getContato()));
        daisy.getContato().getListTelefone().add(new Telefone(null, "21", "996936801", Telefone.s_nTpCelular,     daisy.getContato()));
    }
}