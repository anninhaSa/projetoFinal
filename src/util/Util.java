package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import entity.Autenticacao;

/**
 * Classe utilitaria.
 */
public class Util {
	
	/**
	 * Autenticacao armazenada na sessao.
	 */
	public static final String s_strSSNAutenticacao = "strSSNAutenticacao";
	
	/**
	 * Armazena autenticacao na sessao.
	 * @param fc {@link FacesContext}
	 * @param autenticacao {@link Autenticacao} 
	 */
	public static void armazenaAutenticacao(FacesContext fc, Autenticacao autenticacao) {
		armazenaObjSessao(fc, s_strSSNAutenticacao, autenticacao);
	}
	
	/**
	 * Armazena objeto na sessao.
	 * @param fc {@link FacesContext}
	 * @param strNomeObj nome do objeto na sessao
	 * @param obj {@link Object}
	 */
	public static void armazenaObjSessao(FacesContext fc, String strNomeObj, Object obj) {
		fc.getExternalContext().getSessionMap().put(strNomeObj, obj);
	}
	
	/**
	 * Coleta autenticacao da sessao.
	 * @return {@link Autenticacao} caso exista usuario logado no sistema e <code>null</code> caso contrario.
	 */
	public static Autenticacao coletaAutenticacao(FacesContext fc) {
		Autenticacao autenticacao = null;
		
		Object obj = coletaObjSessao(fc, s_strSSNAutenticacao);
		
		if(obj != null && obj instanceof Autenticacao) {
			autenticacao = (Autenticacao)obj;
		}
		
		return autenticacao;
	}
	
	/**
	 * Coleta objeto da sessao.
	 * @param fc {@link FacesContext}
	 * @param strNomeObj nome do objeto a ser armazenado na sess�o
	 * @return {@link Object} caso o objeto esteja armazenado na sess�o e <code>null</code> caso contr�rio.
	 */
	public static Object coletaObjSessao(FacesContext fc, String strNomeObj) {
		return fc.getExternalContext().getSessionMap().get(strNomeObj);
	}
	
	public static Date converteStringParaDate(String data) {
		if(StringUtils.trimToNull(data) == null) 
			return null;
		
		try {
			return (new SimpleDateFormat("dd/MM/yyyy HH:mm")).parse(data);
		} catch (Exception e) {
			return null;
		}
	}
    
    public static String converteDateParaString(Date data) {
        if(data == null) 
            return "";
        
        try {
            return (new SimpleDateFormat("dd/MM/yyyy HH:mm")).format(data);
        } catch (Exception e) {
            return "";
        }
    }
}