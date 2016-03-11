package validate;

import org.apache.commons.lang.StringUtils;

import util.StatusRetorno;
import entity.Endereco;

public class ValidadorEndereco {
    public StatusRetorno aplica(Endereco endereco) {
        StatusRetorno sRet = new StatusRetorno();
        
        if(endereco != null) {
            if(StringUtils.isEmpty(endereco.getLogradouro ()) &&
               StringUtils.isEmpty(endereco.getComplemento()) &&
               StringUtils.isEmpty(endereco.getBairro     ()) &&
               StringUtils.isEmpty(endereco.getCidade     ()) &&
               StringUtils.isEmpty(endereco.getUf         ()) &&
               StringUtils.isEmpty(endereco.getCep        ()) &&
               endereco.getNumero( ) == 0 ) {
                return sRet;
            } else {
                if(StringUtils.isEmpty(endereco.getLogradouro ()) ||
                   StringUtils.isEmpty(endereco.getBairro     ()) ||
                   StringUtils.isEmpty(endereco.getCidade     ()) ||
                   StringUtils.isEmpty(endereco.getUf         ()) ||
                   StringUtils.isEmpty(endereco.getCep        ()) ||
                   (StringUtils.isEmpty(endereco.getComplemento()) && endereco.getNumero( ) == 0)) {
                    sRet.setMsgErro("Endereço inválido!");
                }
            }
        }
        
        return sRet;
    }
}