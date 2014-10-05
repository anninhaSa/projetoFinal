package util;

/**
 * Classe com os atributos mais utilizados nos retornos de valida��es.
 */
public class StatusRetorno
{
	private String  msgErro;
	private String  msgAviso;
	private boolean bOk;
	
	public StatusRetorno( )
	{
		msgAviso = "";
		msgErro  = "";
		bOk      = true;
	}

	/**
	 * Coleta mensagem de erro.
	 * @return mensagem de erro
	 */
	public String getMsgErro( )
	{
		return msgErro;
	}

	/**
	 * Configura mensagem de erro.
	 * @param msgErro mensagem de erro
	 */
	public void setMsgErro( String msgErro )
	{
		setbOk( false );
		this.msgErro += (!Util.isnEmptyOrNull( this.msgErro ) ? "/n" : "") + msgErro;
	}

	/**
	 * Coleta a mensagem de aviso.
	 * @return mensagem de aviso
	 */
	public String getMsgAviso( )
	{
		return msgAviso;
	}

	/**
	 * Configura mensagem de aviso.
	 * @param msgAviso mensagem de aviso.
	 */
	public void setMsgAviso( String msgAviso )
	{
		this.msgAviso += (!Util.isnEmptyOrNull(this.msgAviso) ? "\n" : "") + msgAviso;
	}

	/**
	 * Informa a situa��o do retorno.
	 * @return <code>TRUE</code> caso a situ��o do retorno esteja v�lido e <code>False</code>
	 * caso contr�rio.
	 */
	public boolean isOk( )
	{
		return bOk;
	}

	/**
	 * Configura a situa��o do retorno.
	 * @param bOk <code>TRUE</code> caso a situ��o do retorno esteja v�lido e <code>False</code>
	 * caso contr�rio.
	 */
	public void setbOk( boolean bOk )
	{
		this.bOk = bOk;
	}
}