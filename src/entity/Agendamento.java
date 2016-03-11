package entity;

import java.util.Date;

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
 * com um funcionario ({@link Funcionario}). 
 */
@Entity
@SequenceGenerator(name = "seq_agenda", sequenceName = "seq_agenda")
public class Agendamento {
	@Id
	@GeneratedValue(generator = "seq_agenda")
	private Integer idAgenda;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date agendamentoDH;
	
	@ManyToOne  
    @JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne  
    @JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	@ManyToOne  
    @JoinColumn(name = "id_servico")
	private Servico servico;
	
	@Column(length = 250)
	private String observacao;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Agendamento() {
		setIdAgenda     (0                );
		setAtendimentoDH(null             );
		setCliente      (new Cliente    ());
		setFuncionario  (new Funcionario()); 
		setServico      (new Servico    ());
		setObservacao   (new String     ());
	}

	public Agendamento(Integer idAgenda, Date atendimentoDH, Cliente cliente, Funcionario funcionario, Servico servico, String  observacao) {
		setIdAgenda     (idAgenda     );
		setAtendimentoDH(atendimentoDH);
		setCliente      (cliente      );
		setFuncionario  (funcionario  );
		setServico      (servico      );
		setObservacao   (observacao   );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Agendamento [idAgenda=" + idAgenda + ", agendamentoDH=" + agendamentoDH +
			   ", cliente="             + cliente  + ", funcionario="   + funcionario   +
			   ", servico="             + servico  + ", observacao="    + observacao    + "]";
	}

	public Integer getIdAgenda() {
		return idAgenda;
	}

	public void setIdAgenda(Integer idAgenda) {
		this.idAgenda = idAgenda;
	}

	/**
	 * Coleta a data e hora atendimento.
	 * @return data e hora atendimento
	 */
	public Date getAgendamentoDH() {
		return agendamentoDH;
	}
	
	/**
	 * Configura a data e a hora do atendimento.
	 * @param agendamentoDH data do atendimento
	 */
	public void setAtendimentoDH(Date agendamentoDH) {
		this.agendamentoDH = agendamentoDH;
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
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * Coleta a data e hora da inclusao do cliente.
	 * @return {@link Date} com a data e hora da inclusao do agendamento.
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a Data/Hora da inclusao do agendamento.
	 * @param incDH data e hora da inclusao do agendamento.
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da alteracao do agendamento
	 * @return {@link Date} com a data e hora da alteracao do agendamento
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura a Data/Hora da alteracao do agendamento
	 * @param altDH {@link Date} com a data e hora da alteracao do agendamento
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
}