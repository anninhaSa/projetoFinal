package entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos da autentica��o.
 *
 */
@Entity
@SequenceGenerator( name = "seq_autenticacao", sequenceName = "seq_autenticacao" )
public class Autenticacao
{
	@Id
	@GeneratedValue( generator = "seq_autenticacao" )
	private int idAutenticacao;
	
	@Column( length = 15, unique = true )
	private String usuario;
	
	private String senha;
	
	@OneToOne
	@JoinColumn( name = "id_funcionario" )
	private Funcionario funcionario;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Autenticacao}.
	 */
	public Autenticacao( )
	{
		setIdAutenticacao( 0  );
		setUsuario       ( "" );
		setSenha         ( "" );
	}
	
	/**
	 * Construtor da classe {@link Autenticacao} sem o id.
	 * @param usuario usu�rio
	 * @param senha senha
	 * @param funcionario {@link Funcionario}
	 */
	public Autenticacao( String usuario, String senha, Funcionario funcionario )
	{
		super( );
		setUsuario    ( usuario     );
		setSenha      ( senha       );
		setFuncionario( funcionario );
	}

	/**
	 * Construtor da classe {@link Autenticacao} com TODOS os atributos da classe.
	 * @param idAutenticacao id da autentica��o
	 * @param usuario usu�rio
	 * @param senha senha
	 * @param funcionario {@link Funcionario}
	 */
	public Autenticacao( int idAutenticacao, String usuario, String senha, Funcionario funcionario )
	{
		super( );
		setIdAutenticacao( idAutenticacao );
		setUsuario       ( usuario        );
		setSenha         ( senha          );
		setFuncionario   ( funcionario    );
	}
	
	/**
	 * Coleta Id da autentica��o.
	 * @return Id da autentica��o.
	 */
	public int getIdAutenticacao( )
	{
		return idAutenticacao;
	}

	/**
	 * Configura Id da autentica��o.
	 * @param idAutenticacao id da autentica��o.
	 */
	public void setIdAutenticacao( int idAutenticacao )
	{
		this.idAutenticacao = idAutenticacao;
	}

	/**
	 * Coleta o usu�rio.
	 * @return usu�rio
	 */
	public String getUsuario( )
	{
		return usuario;
	}

	/**
	 * Configura o usu�rio.
	 * @param usuario usu�rio
	 */
	public void setUsuario( String usuario )
	{
		this.usuario = usuario;
	}

	/**
	 * Coleta a senha.
	 * @return senha
	 */
	public String getSenha( )
	{
		return senha;
	}

	/**
	 * Configura a senha.
	 * @param senha senha
	 */
	public void setSenha( String senha )
	{
		this.senha = senha;
	}

	/**
	 * Coleta o funcion�rio a quem a autentica��o pertence.
	 * @return {@link Funcionario}
	 */
	public Funcionario getFuncionario( )
	{
		return funcionario;
	}

	/**
	 * Configura o funcion�rio a quem a autentica��o pertence.
	 * @param funcionario {@link Funcionario}
	 */
	public void setFuncionario( Funcionario funcionario )
	{
		this.funcionario = funcionario;
	}

	/**
	 * Coleta a data e a hora da inclus�o da autentica��o
	 * @return {@link Calendar} com a data e a hora da inclus�o da autentica��o
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclus�o da autenti��o.
	 * @param incDH {@link Calendar} com a data e a hora da inclus�o da autentica��o
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da altera��o da autentica��o
	 * @return {@link Calendar} com a data e a hora da altera��o da autentica��o
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura data e hora da altera��o da autentica��o
	 * @param altDH {@link Calendar} com a data e hora da altera��o da autentica��o
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}