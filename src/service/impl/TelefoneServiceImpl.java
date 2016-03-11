package service.impl;

import java.util.ArrayList;
import java.util.List;

import persistence.TelefoneDAO;
import persistence.impl.TelefoneDAOImpl;
import entity.Telefone;
import service.TelefoneService;
import util.StatusRetorno;
import validate.ValidadorTelefone;

public class TelefoneServiceImpl implements TelefoneService {

    private TelefoneDAO telefoneDao;
    private ValidadorTelefone validadorTelefone;
    
    @Override
    public List<Telefone> coletaTelefonePeloDDDENumero(String ddd, String numTelefone) {
        List<Telefone> listaTelefone = new ArrayList<Telefone>();
        validadorTelefone = new ValidadorTelefone();
        
        StatusRetorno sRetorno = validadorTelefone.aplica(ddd + numTelefone);
        
        if(sRetorno.isOk()) {
            listaTelefone = telefoneDao.coletaTelefonePeloDDDENumero(ddd, numTelefone);
        }
        
        return listaTelefone;
    }

    @Override
    public List<Telefone> coletaTelefonePeloContatoId(Integer contatoId) {
        List<Telefone> listaTelefone = new ArrayList<Telefone>();
        
        listaTelefone = telefoneDao.coletaTelefonePeloContatoId(contatoId);
        
        return listaTelefone;
    }

    @Override
    public boolean incluiTelefone(Telefone telefone) {
        validadorTelefone = new ValidadorTelefone();
        telefoneDao = new TelefoneDAOImpl();
        
        boolean bOk = telefoneDao.insereTelefone(telefone);
        
        return bOk;
    }

    @Override
    public boolean alteraTelefone(Telefone telefone) {
        validadorTelefone = new ValidadorTelefone();
        telefoneDao = new TelefoneDAOImpl();
        
        boolean bOk = telefoneDao.excluiTelefone(telefone);
        
        return bOk;
    }
}