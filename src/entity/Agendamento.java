package entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos do agendamento de cada {@link Servico} feito por um cliente({@link Cliente})
 * com um funcion�rio ({@link Funcionario}). 
 */
@Entity
@SequenceGenerator( name = "seq_agenda", sequenceName = "seq_agenda" )
public class Agendamento
{
	@Id
	@GeneratedValue( generator = "seq_agenda" )
	private Integer idAgenda;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar agendamentoDH;
	
	@ManyToOne  
    @JoinColumn( name = "id_cliente" )
	private Cliente cliente;
	
	@ManyToOne  
    @JoinColumn( name = "id_funcionario" )
	private Funcionario funcionario;
	
	@ManyToOne  
    @JoinColumn( name = "id_servico" )
	private Servico servico;
	
	@Column( length = 250 )
	private String observacao;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Agendamento} (inicializa todos os atributos).
	 */
	public Agendamento( )
	{
		setIdAgenda     ( 0                  );
		setAtendimentoDH( null               );
		setCliente      ( new Cliente    ( ) );
		setFuncionario  ( new Funcionario( ) ); 
		setServico      ( new Servico    ( ) );
		setObservacao   ( new String     ( ) );
	}

	/**
	 * Construtor da classe {@link Agendamento} com os atributos DA CLASSE parametrizados.
	 * @param idAgenda c�digo identificador do agendamento
	 * @param agendamentoDH data e hora do agendamento
	 * @param observacao observa��o 
	 */
	public Agendamento( Integer idAgenda, Calendar agendamentoDH, String observacao )
	{
		setIdAgenda     ( idAgenda           );
		setAtendimentoDH( agendamentoDH      );
		setCliente      ( new Cliente    ( ) );
		setFuncionario  ( new Funcionario( ) ); 
		setServico      ( new Servico    ( ) );
		setObservacao   ( observacao         );
	}

	/**
	 * Construtor da classe {@link Agendamento} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que est�o relacionados com 
	 * {@link Agendamento}).
	 * @param idAgenda c�digo identificador do agendamento
	 * @param atendimentoDH data e hora do agendamento
	 * @param cliente {@link Cliente}
	 * @param funcionario {@link Funcionario}
	 * @param servico {@link Servico}
	 * @param observacao observa��o 
	 */
	public Agendamento( Integer     idAgenda,    Calendar atendimentoDH, Cliente cliente,
			            Funcionario funcionario, Servico  servico,       String  observacao )
	{
		setIdAgenda     ( idAgenda      );
		setAtendimentoDH( atendimentoDH );
		setCliente      ( cliente       );
		setFuncionario  ( funcionario   );
		setServico      ( servico       );
		setObservacao   ( observacao    );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString( )
	{
		return "Agendamento [idAgenda=" + idAgenda + ", agendamentoDH=" + agendamentoDH +
			   ", cliente="             + cliente  + ", funcionario="   + funcionario   +
			   ", servico="             + servico  + ", observacao="    + observacao    + "]";
	}

	/**
	 * Coleta o c�digo identificador da agenda.
	 * @return c�digo identificador da agenda
	 */
	public Integer getIdAgenda( )
	{
		return idAgenda;
	}

	/**
	 * Configura o c�digo identificador da agenda.
	 * @param idAgenda c�digo identificador da agenda
	 */
	public void setIdAgenda( Integer idAgenda )
	{
		this.idAgenda = idAgenda;
	}

	/**
	 * Coleta a data e hora atendimento.
	 * @return data e hora atendimento
	 */
	public Calendar getAgendamentoDH( )
	{
		return agendamentoDH;
	}
	
	/**
	 * Configura a data e a hora do atendimento.
	 * @param agendamentoDH data do atendimento
	 */
	public void setAtendimentoDH( Calendar agendamentoDH )
	{
		this.agendamentoDH = agendamentoDH;
	}

	/**
	 * Coleta o cliente
	 * @return {@link Cliente}
	 */
	public Cliente getCliente( )
	{
		return cliente;
	}

	/**
	 * Configura o cliente.
	 * @param cliente {@link Cliente}
	 */
	public void setCliente( Cliente cliente )
	{
		this.cliente = cliente;
	}

	/**
	 * Coleta o funcion�rio
	 * @return {@link Funcionario}
	 */
	public Funcionario getFuncionario( )
	{
		return funcionario;
	}

	/**
	 * Configura o funcion�rio.
	 * @param funcionario {@link Funcionario}
	 */
	public void setFuncionario( Funcionario funcionario )
	{
		this.funcionario = funcionario;
	}

	/**
	 * Coleta o servi�o
	 * @return {@link Servico}
	 */
	public Servico getServico( )
	{
		return servico;
	}

	/**
	 * Configura o servi�o.
	 * @param servico {@link Servico}
	 */
	public void setServico( Servico servico )
	{
		this.servico = servico;
	}
	
	/**
	 * Coleta as observa��es feitas a respeito do cliente.
	 * @return {@link String} com as observa��es do cliente.
	 */
	public String getObservacao( )
	{
		return observacao;
	}

	/**
	 * Configura a observa��o feita a respeito do cliente.
	 * @param observacao observa��o
	 */
	public void setObservacao( String observacao )
	{
		this.observacao = observacao;
	}

	/**
	 * Coleta a data e hora da inclus�o do cliente.
	 * @return {@link Calendar} com a data e hora da inclus�o do agendamento.
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a Data/Hora da inclus�o do agendamento.
	 * @param incDH data e hora da inclus�o do agendamento.
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da altera��o do agendamento
	 * @return {@link Calendar} com a data e hora da altera��o do agendamento
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura a Data/Hora da altera��o do agendamento
	 * @param altDH {@link Calendar} com a data e hora da altera��o do agendamento
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}