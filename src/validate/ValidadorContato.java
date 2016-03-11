package validate;

import org.apache.commons.lang.StringUtils;

import util.StatusRetorno;
import entity.Contato;

public class ValidadorContato {
    ValidadorTelefone validadorTelefone;
    ValidadorEndereco validadorEndereco;
    
    public StatusRetorno aplica(Contato contato) {
        validadorTelefone = new ValidadorTelefone();
        validadorEndereco = new ValidadorEndereco();
        
        StatusRetorno sRet = new StatusRetorno();
        
        if(contato.getCelular() == null && contato.getTelResidencial() == null && contato.getTelComercial() == null) {
            sRet.setMsgErro("Pelo menos um telefone deve ser informado!");
        }
        
        if(sRet.isOk()) {
            sRet = validaEmail(contato.getEmail());
        }
        
        if(sRet.isOk()) {
            sRet = validadorEndereco.aplica(contato.getEndereco());
        }
        
        return sRet;
    }
    
    private StatusRetorno validaEmail(String email) {
        StatusRetorno sRet = new StatusRetorno();
        
        email = StringUtils.trimToEmpty(email);
        
        if(StringUtils.isEmpty(email)) {
            return sRet;
        }
        
        if(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                          "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            sRet.setMsgErro("e-mail inválido!");
        }
        return sRet;
    }
}