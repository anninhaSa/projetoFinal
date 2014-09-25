package entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos de cada servi�o dispon�vel. 
 */
@Entity
@SequenceGenerator( name = "seq_servico", sequenceName = "seq_servico" )
public class Servico
{
	@Id
	@GeneratedValue( generator = "seq_servico" )
	private Integer idServico;
	
	@Column( name = "nomeServico", length = 50 )
	private String nomeServico;
	
	@Column( name = "valor" )
	private Double valor;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Servico} (inicializa todos os atributos).
	 */
	public Servico( )
	{
		setIdServico  ( 0  ); 
		setNomeServico( "" );
		setValor      ( 0. );
	}

	/**
	 * Construtor da classe {@link Servico} com os atributos da classe.
	 * @param idServico c�digo identificador do servi�o
	 * @param nomeServico nome do servi�o
	 * @param valor valor do servi�o
	 */
	public Servico( Integer idServico, String nomeServico, Double valor )
	{
		setIdServico  ( idServico   );
		setNomeServico( nomeServico );
		setValor      ( valor       );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString( )
	{
		return "Servico [idServico=" + idServico + ", nomeServico=" + nomeServico + "]";
	}

	/**
	 * Coleta o c�digo identificador do servi�o.
	 * @return c�digo identificador do servi�o
	 */
	public Integer getIdServico( )
	{
		return idServico;
	}

	/**
	 * Configura o c�digo identificador do servi�o.
	 * @param idServico c�digo identificador do servi�o
	 */
	public void setIdServico( Integer idServico )
	{
		this.idServico = idServico;
	}

	/**
	 * Coleta o nome do servi�o.
	 * @return nome do servi�o
	 */
	public String getNomeServico( )
	{
		return nomeServico;
	}

	/**
	 * Configura o nome do servi�o.
	 * @param nomeServico nome do servi�o
	 */
	public void setNomeServico( String nomeServico )
	{
		this.nomeServico = nomeServico;
	}

	/**
	 * Coleta valor do servi�o.
	 * @return valor do servi�o
	 */
	public Double getValor( )
	{
		return valor;
	}

	/**
	 * Configura valor do servi�o.
	 * @param valor valor do servi�o
	 */
	public void setValor( Double valor )
	{
		this.valor = valor;
	}
	
	/**
	 * Coleta a data e a hora da inclus�o do servi�o
	 * @return {@link Calendar} com a data e a hora da inclus�o da autentica��o
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclus�o do servi�o
	 * @param incDH {@link Calendar} com a data e a hora da inclus�o da autentica��o
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da altera��o do servi�o
	 * @return {@link Calendar} com a data e a hora da altera��o do servi�o
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura data e hora da altera��o do servi�o
	 * @param altDH {@link Date} com a data e hora da altera��o do servi�o
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}