package entity;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos do contato da Pessoa.
 */
@Entity
@SequenceGenerator( name = "seq_contato", sequenceName = "seq_contato" )
public class Contato
{
	@Id
	@GeneratedValue( generator = "seq_contato" )
	private Integer idContato;
	
	@Column( length = 11 )
	private String telCelular;
	
	@Column( length = 10 )
	private String telComercial;
	
	@Column( length = 10 )
	private String telResidencial;
	
	@Column( length = 70 )
	private String email;
	
	@OneToOne  ( cascade = CascadeType.ALL )
	@JoinColumn( name    = "id_pessoa"     )
	private Pessoa pessoa;
	
	@OneToOne( mappedBy = "contato", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Endereco endereco;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Contato} (inicializa todos os atributos). 
	 */
	public Contato( )
	{
		setIdContato     ( 0               );
		setTelCelular    ( ""              );
		setTelComercial  ( ""              );
		setTelResidencial( ""              );
		setEmail         ( ""              );
		setEndereco      ( new Endereco( ) );
	}

	/**
	 * Construtor da classe {@link Contato} com os atributos DA CLASSE parametrizados.
	 * @param idContato código identificador do contato
	 * @param telCelular telefone celular
	 * @param telComercial telefone comercial
	 * @param telResidencial telefone residencial
	 * @param email email
	 */
	public Contato( Integer idContato, String telCelular, String telComercial, String telResidencial, String email )
	{
		setIdContato     ( idContato       );
		setTelCelular    ( telCelular      );
		setTelComercial  ( telComercial    );
		setTelResidencial( telResidencial  );
		setEmail         ( email           );
		setEndereco      ( new Endereco( ) );
	}
	
	/**
	 * Construtor da classe {@link Contato} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Contato}).
	 * @param idContato código identificador do contato
	 * @param email email
	 * @param pessoa {@link Pessoa}
	 * @param endereco {@link Endereco}
	 * @param telCelular telefone celular
	 * @param telComercial telefone comercial
	 * @param telResidencial telefone residencial
	 */
	public Contato( Integer idContato, String email, Pessoa pessoa, Endereco endereco, String telCelular, String telComercial, String telResidencial )
	{
		setIdContato     ( idContato      );
		setEmail         ( email          );
		setPessoa        ( pessoa         );
		setEndereco      ( endereco       );
		setTelCelular    ( telCelular     );
		setTelComercial  ( telComercial   );
		setTelResidencial( telResidencial );
	}
	
	/**
	 * Construtor da classe {@link Contato}.
	 * @param email email
	 * @param endereco {@link Endereco}
	 * @param telCelular telefone celular
	 * @param telComercial telefone comercial
	 * @param telResidencial telefone residencial
	 */
	public Contato( String email, Endereco endereco, String telCelular, String telComercial, String telResidencial )
	{
		setEmail         ( email          );
		setEndereco      ( endereco       );
		setTelCelular    ( telCelular     );
		setTelComercial  ( telComercial   );
		setTelResidencial( telResidencial );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString( )
	{
		return "Contato [idContato=" + idContato      + ", telCelular=" + telCelular + ", telComercial=" + telComercial +
				", telResidencial="  + telResidencial + ", email="      + email      + ", endereco="     + endereco     + "]";
	}

	/**
	 * Coleta código identificador do contato.
	 * @return código identificador do contato
	 */
	public Integer getIdContato( )
	{
		return idContato;
	}

	/**
	 * Configura Código identificador do contato.
	 * @param idContato Código identificador do contato
	 */
	public void setIdContato( Integer idContato )
	{
		this.idContato = idContato;
	}

	/**
	 * Coleta o telefone celular
	 * @return telefone celular
	 */
	public String getTelCelular( )
	{
		return telCelular;
	}

	/**
	 * Configura o telefone celular
	 * @param telCelular telefone celular
	 */
	public void setTelCelular( String telCelular )
	{
		this.telCelular = telCelular;
	}

	/**
	 * Coleta o telefone comercial
	 * @return telefone comercial
	 */
	public String getTelComercial( )
	{
		return telComercial;
	}

	/**
	 * Configura o telefone comercial
	 * @param telComercial telefone comercial
	 */
	public void setTelComercial( String telComercial )
	{
		this.telComercial = telComercial;
	}

	/**
	 * Coleta o telefone residencial
	 * @return telefone residencial
	 */
	public String getTelResidencial( )
	{
		return telResidencial;
	}

	/**
	 * Configura o telefone residencial
	 * @param telResidencial telefone residencial
	 */
	public void setTelResidencial( String telResidencial )
	{
		this.telResidencial = telResidencial;
	}

	/**
	 * Coleta email.
	 * @return email
	 */
	public String getEmail( )
	{
		return email;
	}

	/**
	 * Configura o email.
	 * @param email email
	 */
	public void setEmail( String email )
	{
		this.email = email;
	}

	/**
	 * Coleta {@link Pessoa}.
	 * @return {@link Pessoa}
	 */
	public Pessoa getPessoa( )
	{
		return pessoa;
	}

	/**
	 * Configura a {@link Pessoa}.
	 * @param pessoa {@link Pessoa}
	 */
	public void setPessoa( Pessoa pessoa )
	{
		this.pessoa = pessoa;
	}

	/**
	 * Coleta o {@link Endereco}.
	 * @return {@link Endereco}
	 */
	public Endereco getEndereco( )
	{
		return endereco;
	}

	/**
	 * Configura o {@link Endereco}.
	 * @param endereco {@link Endereco}
	 */
	public void setEndereco( Endereco endereco )
	{
		this.endereco = endereco;
	}

	/**
	 * Coleta a data e a hora da inclusão do contato.
	 * @return {@link Calendar} com a data e hora da inclusão do contato
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusão do contato.
	 * @param incDH data e hora da inclusão
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da alteração do contato.
	 * @return {@link Calendar} data e hora da alteração do contato
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura a data e a hora da alteração do contato.
	 * @param altDH {@link Calendar} data e hora da alteração do contato
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}