package entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos do atendimento de cada {@link Servico} feito por um cliente({@link Cliente}) com um funcionario 
 * ({@link Funcionario}).
 */
@Entity
@SequenceGenerator(name = "seq_atendimento", sequenceName = "seq_atendimento")
public class Atendimento {
	@Id
	@GeneratedValue(generator = "seq_atendimento")
	private Integer idAtendimento;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date atendimentoDH;
	
	@ManyToOne  
    @JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne  
    @JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne  
    @JoinColumn(name = "id_servico")
	private Servico servico;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Atendimento() {
		setIdAtendimento(0                               );
		setAtendimentoDH(Calendar.getInstance().getTime());
		setCliente      (new Cliente                   ());
		setFuncionario  (new Funcionario               ());
		setServico      (new Servico                   ());
	}

	
	public Atendimento( Integer     idAtendimento, Date    atendimentoDH, Cliente cliente, Funcionario funcionario,   Servico servico ) {
		setIdAtendimento(idAtendimento);
		setAtendimentoDH(atendimentoDH);
		setCliente      (cliente      );
		setFuncionario  (funcionario  );
		setServico      (servico      );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString( )
	 */
	public String toString() {
		return "Atendimento [idAtendimento=" + idAtendimento +
			   ", atendimentoDH="            + atendimentoDH +
			   ", cliente="                  + cliente       +
			   ", funcionario="              + funcionario   +
			   ", servico="                  + servico       + "]";
	}

	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	public void setIdAtendimento(Integer intIdAtendimento) {
		this.idAtendimento = intIdAtendimento;
	}

	/**
	 * Coleta a data e hora de atendimento.
	 * @return data e hora do atendimento
	 */
	public Date getAtendimentoDH() {
		return atendimentoDH;
	}

	/**
	 * Configura a data e a hora do atendimento.
	 * @param atendimentoDH data e hora do atendimento
	 */
	public void setAtendimentoDH(Date atendimentoDH) {
		this.atendimentoDH = atendimentoDH;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	/**
	 * Coleta data e hora da inclusao do atendimento.
	 * @return data e hora da inclusao do atendimento
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusao do atendimento.
	 * @param incDH {@link Date}
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora em que o atendimento foi alterado.
	 * @return {@link Date} com a data e a hora da alteracao do atendimento
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura a data e a hora da alteracao do atendimento.
	 * @param altDH {@link Date} com a data e a hora da alteracao do atendimento
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
}