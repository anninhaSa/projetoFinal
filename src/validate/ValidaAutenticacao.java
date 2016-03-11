package validate;

import org.apache.commons.lang.StringUtils;

import util.StatusRetorno;
import entity.Autenticacao;

/**
 * Classe responsável por validar a autenticação (Login e Logout).
 */
public class ValidaAutenticacao
{
	public static final String s_strMsgErroDefault = "Usuário/Senha inválido!";
	
	/**
	 * Verifica se o login é válido.
	 * @param autenticacao {@link Autenticacao}
	 * @return {@link StatusRetorno}
	 */
	public static StatusRetorno validaLogin(Autenticacao autenticacao) {
		StatusRetorno sRet = new StatusRetorno();
		
		if(autenticacao == null) {
			sRet.setMsgErro(s_strMsgErroDefault);
			
			return sRet;
		}
		
		if(StringUtils.isEmpty(autenticacao.getUsuario()) || StringUtils.isEmpty(autenticacao.getSenha())) {
			sRet.setMsgErro(s_strMsgErroDefault);
			
			return sRet;
		} else {
			autenticacao.setUsuario(autenticacao.getUsuario().trim());
			autenticacao.setSenha  (autenticacao.getSenha  ().trim());
		}
		
		if(!isnStringPadronizada(autenticacao.getUsuario()) || !isnStringPadronizada(autenticacao.getSenha())) {
			sRet.setMsgErro(s_strMsgErroDefault);
			
			return sRet;
		}
		
		return sRet;
	}
	
	/**
	 * Verifica se a string obedece o padrão abaixo:
	 * <ul>
	 * 	<li>Contém apenas letras e/ou números</li>
	 *  <li>Tem no mánimo 4 caracteres e no máximo 8</li>
	 * </ul>
	 * @param string string a ser validada
	 * @return <code>TRUE</code> caso a {@link String} obedeça o padrão e <code>FALSE</code> caso contrário.
	 */
	private static boolean isnStringPadronizada(String str) {
		boolean bOk = false;
		
		if( str != null )
			//Expressão regular responsável por validar o padrão descrito acima.
			bOk = str.matches( "[a-zA-Z0-9]{4,8}" );
		
		return bOk;
	}
}