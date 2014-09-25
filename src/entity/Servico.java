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
 * Classe com atributos de cada serviço disponível. 
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
	 * @param idServico código identificador do serviço
	 * @param nomeServico nome do serviço
	 * @param valor valor do serviço
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
	 * Coleta o código identificador do serviço.
	 * @return código identificador do serviço
	 */
	public Integer getIdServico( )
	{
		return idServico;
	}

	/**
	 * Configura o código identificador do serviço.
	 * @param idServico código identificador do serviço
	 */
	public void setIdServico( Integer idServico )
	{
		this.idServico = idServico;
	}

	/**
	 * Coleta o nome do serviço.
	 * @return nome do serviço
	 */
	public String getNomeServico( )
	{
		return nomeServico;
	}

	/**
	 * Configura o nome do serviço.
	 * @param nomeServico nome do serviço
	 */
	public void setNomeServico( String nomeServico )
	{
		this.nomeServico = nomeServico;
	}

	/**
	 * Coleta valor do serviço.
	 * @return valor do serviço
	 */
	public Double getValor( )
	{
		return valor;
	}

	/**
	 * Configura valor do serviço.
	 * @param valor valor do serviço
	 */
	public void setValor( Double valor )
	{
		this.valor = valor;
	}
	
	/**
	 * Coleta a data e a hora da inclusão do serviço
	 * @return {@link Calendar} com a data e a hora da inclusão da autenticação
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusão do serviço
	 * @param incDH {@link Calendar} com a data e a hora da inclusão da autenticação
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteração do serviço
	 * @return {@link Calendar} com a data e a hora da alteração do serviço
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura data e hora da alteração do serviço
	 * @param altDH {@link Date} com a data e hora da alteração do serviço
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}