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
 * Classe com atributos do endere�o. 
 */
@Entity
@SequenceGenerator( name = "seq_endereco", sequenceName = "seq_endereco" )
public class Endereco
{
	@Id
	@GeneratedValue( generator = "seq_endereco" )
	private Integer idEndereco;
	
	@Column( length = 100 )
	private String logradouro;
	
	private Integer numero;
	
	@Column( length = 50 )
	private String complemento;
	
	@Column( length = 40 )
	private String bairro;
	
	@Column( length = 40 )
	private String cidade;
	
	@Column( length = 2 )
	private String uf;
	
	@Column( length = 8 )
	private String cep;
	
	@OneToOne
	@JoinColumn( name = "id_contato" )
	private Contato contato;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Endereco} (inicializa todos os atributos).
	 */
	public Endereco( )
	{
		setIdEndereco ( 0  );
		setLogradouro ( "" );
		setNumero     ( 0  );
		setComplemento( "" );
		setBairro     ( "" );
		setCidade     ( "" );
		setUF         ( "" );
		setCep        ( "" );
	}

	/**
	 * Construtor da classe {@link Endereco} com os atributos DA CLASSE parametrizados.
	 * @param idEndereco C�digo identificador do endere�o
	 * @param logradouro Logradouro
	 * @param numero N�mero da resid�ncia
	 * @param complemento Complemento
	 * @param bairro Bairro
	 * @param cidade Cidade
	 * @param uf UF
	 * @param cep CEP
	 */
	public Endereco( Integer idEndereco, String logradouro, Integer numero, String complemento,
			         String  bairro,     String cidade,     String  uf,     String cep )
	{
		setIdEndereco ( idEndereco  );
		setLogradouro ( logradouro  );
		setNumero     ( numero      );
		setComplemento( complemento );
		setBairro     ( bairro      );
		setCidade     ( cidade      );
		setUF         ( uf          );
		setCep        ( cep         );
		setContato    ( new Contato( ) );
	}

	/**
	 * Construtor da classe {@link Endereco} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que est�o relacionados com 
	 * {@link Endereco}).
	 * @param idEndereco C�digo identificador do endere�o
	 * @param logradouro Logradouro
	 * @param numero N�mero da resid�ncia
	 * @param complemento Complemento
	 * @param bairro Bairro
	 * @param cidade Cidade
	 * @param uf UF
	 * @param cep CEP
	 * @param contato {@link Contato}
	 */
	public Endereco( Integer idEndereco, String logradouro, Integer numero, String  complemento, String bairro,
			         String  cidade,     String uf,         String  cep,    Contato contato )
	{
		setIdEndereco ( idEndereco  );
		setLogradouro ( logradouro  );
		setNumero     ( numero      );
		setComplemento( complemento );
		setBairro     ( bairro      );
		setCidade     ( cidade      );
		setUF         ( uf          );
		setCep        ( cep         );
		setContato    ( contato     );
	}
	
	/**
	 * Construtor da classe {@link Endereco} somente com os atributos de um endere�o.
	 * @param idEndereco C�digo identificador do endere�o
	 * @param logradouro Logradouro
	 * @param numero N�mero da resid�ncia
	 * @param complemento Complemento
	 * @param bairro Bairro
	 * @param cidade Cidade
	 * @param uf UF
	 * @param cep CEP
	 * @param contato {@link Contato}
	 */
	public Endereco( String logradouro, Integer numero, String  complemento, String bairro,
			         String  cidade,     String uf,         String  cep )
	{
		setLogradouro ( logradouro  );
		setNumero     ( numero      );
		setComplemento( complemento );
		setBairro     ( bairro      );
		setCidade     ( cidade      );
		setUF         ( uf          );
		setCep        ( cep         );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString( )
	{
		return "Endereco [idEndereco=" + idEndereco + ", logradouro="  + logradouro  + 
			   ", numero="             + numero     + ", complemento=" + complemento + 
			   ", bairro="             + bairro     + ", cidade="      + cidade      +
			   ", uf="                 + uf         + ", cep="         + cep         + "]";
	}

	/**
	 * Coleta o c�digo identificador do endere�o.
	 * @return c�digo identificador do endere�o
	 */
	public Integer getIdEndereco( )
	{
		return idEndereco;
	}

	/**
	 * Configura o c�digo identificador do endere�o
	 * @param idEndereco c�digo identificador do endere�o
	 */
	public void setIdEndereco( Integer idEndereco )
	{
		this.idEndereco = idEndereco;
	}

	/**
	 * Coleta o logradouro.
	 * @return rua.
	 */
	public String getLogradouro( )
	{
		return logradouro;
	}

	/**
	 * Configura a rua.
	 * @param rua rua
	 */
	public void setLogradouro( String logradouro )
	{
		this.logradouro = logradouro;
	}

	/**
	 * Configura o n�mero.
	 * @return n�mero
	 */
	public Integer getNumero( )
	{
		return numero;
	}

	/**
	 * Configura o n�mero
	 * @param numero n�mero
	 */
	public void setNumero( Integer numero )
	{
		this.numero = numero;
	}

	/**
	 * Coleta complemento.
	 * @return complemento
	 */
	public String getComplemento( )
	{
		return complemento;
	}

	/**
	 * Configura complemento
	 * @param complemento complemento
	 */
	public void setComplemento( String complemento )
	{
		this.complemento = complemento;
	}

	/**
	 * Coleta bairro.
	 * @return bairro
	 */
	public String getBairro( )
	{
		return bairro;
	}

	/**
	 * Configura bairro.
	 * @param bairro bairro
	 */
	public void setBairro( String bairro )
	{
		this.bairro = bairro;
	}

	/**
	 * Coleta cidade.
	 * @return cidade
	 */
	public String getCidade( )
	{
		return cidade;
	}

	/**
	 * Configura cidade.
	 * @param cidade cidade
	 */
	public void setCidade( String cidade )
	{
		this.cidade = cidade;
	}

	/**
	 * Coleta UF.
	 * @return UF
	 */
	public String getUF( )
	{
		return uf;
	}

	/**
	 * Configura UF.
	 * @param uf
	 */
	public void setUF( String uf )
	{
		this.uf = uf;
	}

	/**
	 * Coleta {@link Contato}.
	 * @return {@link Contato}
	 */
	public Contato getContato( )
	{
		return contato;
	}

	/**
	 * Configura {@link Contato}.
	 * @param contato {@link Contato}
	 */
	public void setContato( Contato contato )
	{
		this.contato = contato;
	}

	/**
	 * Coleta a UF do endere�o
	 * @return UF
	 */
	public String getUf( )
	{
		return uf;
	}

	/**
	 * Configura a UF do endere�o.
	 * @param uf UF
	 */
	public void setUf( String uf )
	{
		this.uf = uf;
	}

	/**
	 * Coleta o CEP do endere�o
	 * @return CEP
	 */
	public String getCep( )
	{
		return cep;
	}

	/**
	 * Coleta o CEP do endere�o
	 * @param cep CEP
	 */
	public void setCep( String cep )
	{
		this.cep = cep;
	}

	/**
	 * Coleta a data e hora da inclus�o do endere�o.
	 * @return {@link Calendar} com a data e hora da inclus�o do endere�o
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e hora da inclus�o do endere�o.
	 * @param incDH {@link Calendar} com a data e hora da inclus�o do endere�o
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da altera��o do endere�o.
	 * @return {@link Calendar} com a data e hora da altera��o do endere�o
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura a data e hora da altera��o do endere�o.
	 * @param altDH {@link Calendar} com a data e hora da altera��o do endere�o
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}