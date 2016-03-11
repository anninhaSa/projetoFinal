package validate;

import org.apache.commons.lang.StringUtils;

import util.StatusRetorno;

public class ValidadorTelefone {
    /**
     * Valida o telefone no formato <code>DDD + telefone</code>.<br><br>
     * <b>Obs.:</b> <i>Telefone não informado (String vazia) é considerado válido, tendo em vista que nem sempre o telefone é uma informação
     * obrigatória.</i>
     * @param telefone telefone no formato <i>ddd + telefone</i>.
     * @return {@link StatusRetorno}
     */
    public StatusRetorno aplica(String telefone) {
        StatusRetorno sRetorno = new StatusRetorno();
        
        telefone = StringUtils.trimToEmpty(telefone);
        
        if(StringUtils.trimToNull(telefone) == null) {
            return sRetorno;
        }
        
        telefone = telefone.replaceAll("[(]", "").replaceAll("[)]", "").replaceAll("[-]", "");
        
        if(!(telefone.matches("[0-9]{10}") || telefone.matches("[0-9]{11}"))) {
            sRetorno.setMsgErro("Telefone invalido!");
        }
        
        return sRetorno;
    }
}