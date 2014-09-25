package util;

import org.jcommon.encryption.SimpleMD5;

/**
 * Classe respons�vel por criptografar senha.
 */
public class CriptografaSenha
{
	/**
	 * Coleta senha criptografada.
	 * @param senha senha
	 * @return senha criptografada em hexadecimal.
	 */
	public static String getSenhaCriptografada( String senha )
	{
		SimpleMD5 md5 = new SimpleMD5( senha, "" );
		
		return md5.toHexString( );
	}
}
