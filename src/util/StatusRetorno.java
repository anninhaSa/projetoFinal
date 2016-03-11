package util;

import org.apache.commons.lang.StringUtils;

/**
 * Classe com os atributos mais utilizados nos retornos de validações.
 */
public class StatusRetorno {
	private String  msgErro;
	private String  msgAviso;
	private boolean bOk;
	
	public StatusRetorno() {
		msgAviso = "";
		msgErro  = "";
		bOk      = true;
	}

	public String getMsgErro() {
		return msgErro;
	}

	public void setMsgErro(String msgErro) {
		setbOk(false);
		this.msgErro += (!StringUtils.isEmpty(this.msgErro) ? "/n" : "") + msgErro;
	}

	public String getMsgAviso() {
		return msgAviso;
	}

	public void setMsgAviso(String msgAviso) {
		this.msgAviso += (!StringUtils.isEmpty(this.msgAviso) ? "\n" : "") + msgAviso;
	}

	public boolean isOk() {
		return bOk;
	}

	public void setbOk(boolean bOk) {
		this.bOk = bOk;
	}
}