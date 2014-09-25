package entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos do atendimento de cada {@link Servico} feito por um cliente({@link Cliente})
 * com um funcionário ({@link Funcionario}).
 */
@Entity
@SequenceGenerator( name = "seq_atendimento", sequenceName = "seq_atendimento" )
public class Atendimento
{
	@Id
	@GeneratedValue( generator = "seq_atendimento" )
	private Integer idAtendimento;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar atendimentoDH;
	
	@ManyToOne  
    @JoinColumn( name = "id_cliente" )
	private Cliente cliente;
	
	@ManyToOne  
    @JoinColumn( name = "id_funcionario" )
	private Funcionario funcionario;
	
	@ManyToOne  
    @JoinColumn( name = "id_servico" )
	private Servico servico;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Atendimento} (inicializa todos os atributos).
	 */
	public Atendimento( )
	{
		setIdAtendimento( 0                       );
		setAtendimentoDH( Calendar.getInstance( ) );
		setCliente      ( new Cliente         ( ) );
		setFuncionario  ( new Funcionario     ( ) );
		setServico      ( new Servico         ( ) );
	}

	/**
	 * Construtor da classe {@link Atendimento} com os atributos DA CLASSE parametrizados.
	 * @param idAtendimento código identificador do atendimento
	 * @param atendimentoDH data e hora do atendimento
	 */
	public Atendimento( Integer idAtendimento, Calendar atendimentoDH )
	{
		setIdAtendimento( idAtendimento      );
		setAtendimentoDH( atendimentoDH      );
		setCliente      ( new Cliente    ( ) );
		setFuncionario  ( new Funcionario( ) );
		setServico      ( new Servico    ( ) );
	}
	
	/**
	 * Construtor da classe {@link Atendimento} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Atendimento}).
	 * @param idAtendimento código identificador do atendimento
	 * @param atendimentoDH data e hora do atendimento
	 * @param cliente {@link Cliente}
	 * @param funcionario {@link Funcionario}
	 * @param servico {@link Servico}
	 */
	public Atendimento( Integer     idAtendimento, Calendar atendimentoDH, Cliente cliente,
						Funcionario funcionario,   Servico  servico )
	{
		setIdAtendimento( idAtendimento  );
		setAtendimentoDH( atendimentoDH  );
		setCliente      ( cliente        );
		setFuncionario  ( funcionario    );
		setServico      ( servico        );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString( )
	 */
	public String toString( )
	{
		return "Atendimento [idAtendimento=" + idAtendimento +
			   ", atendimentoDH="            + atendimentoDH +
			   ", cliente="                  + cliente       +
			   ", funcionario="              + funcionario   +
			   ", servico="                  + servico       + "]";
	}

	/**
	 * Coleta o código identificador do atendimento.
	 * @return código identificador do atendimento
	 */
	public Integer getIdAtendimento( )
	{
		return idAtendimento;
	}

	/**
	 * Configura o código identificador do atendimento.
	 * @param intIdAtendimento código identificador do atendimento
	 */
	public void setIdAtendimento( Integer intIdAtendimento )
	{
		this.idAtendimento = intIdAtendimento;
	}

	/**
	 * Coleta a data e hora de atendimento.
	 * @return data e hora do atendimento
	 */
	public Calendar getAtendimentoDH( )
	{
		return atendimentoDH;
	}

	/**
	 * Configura a data e a hora do atendimento.
	 * @param atendimentoDH data e hora do atendimento
	 */
	public void setAtendimentoDH( Calendar atendimentoDH )
	{
		this.atendimentoDH = atendimentoDH;
	}

	/**
	 * Coleta o cliente.
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
	 * Coleta o funcionário.
	 * @return {@link Funcionario}
	 */
	public Funcionario getFuncionario( )
	{
		return funcionario;
	}

	/**
	 * Configura o funcionário.
	 * @param funcionario {@link Funcionario}
	 */
	public void setFuncionario( Funcionario funcionario )
	{
		this.funcionario = funcionario;
	}

	/**
	 * Coleta o {@link Servico}.
	 * @return {@link Servico}
	 */
	public Servico getServico( )
	{
		return servico;
	}

	/**
	 * Configura o {@link Servico}.
	 * @param servico {@link Servico}
	 */
	public void setServico( Servico servico )
	{
		this.servico = servico;
	}

	/**
	 * Coleta data e hora da inclusão do atendimento.
	 * @return data e hora da inclusão do atendimento
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusão do atendimento.
	 * @param incDH {@link Calendar}
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora em que o atendimento foi alterado.
	 * @return {@link Calendar} com a data e a hora da alteração do atendimento
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura a data e a hora da alteração do atendimento.
	 * @param altDH {@link Calendar} com a data e a hora da alteração do atendimento
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}