package view;

import java.util.Calendar;

import entity.Atendimento;

/**
 * Classe (da camada de visao) com atributos do atendimento de cada {@link ServicoDTO} realizado por um funcionario ({@link FuncionarioDTO})
 * a um cliente({@link ClienteDTO})
 */
public class AtendimentoDTO {

	private Integer idAtendimento;
	private String atendimentoDH;
	private ClienteDTO cliente;
	private FuncionarioDTO funcionario;
	private ServicoDTO servico;
	private String incDH;
	private String altDH;

	/**
	 * Construtor da classe {@link Atendimento} (inicializa todos os atributos).
	 */
	public AtendimentoDTO() {
		setIdAtendimento(0);
		setAtendimentoDH("");
		setCliente(new ClienteDTO());
		setFuncionario(new FuncionarioDTO());
		setServico(new ServicoDTO());
	}

	/**
	 * Construtor da classe {@link AtendimentoDTO} com os atributos DA CLASSE
	 * parametrizados.
	 * 
	 * @param idAtendimento codigo identificador do atendimento
	 * @param atendimentoDH data e hora do atendimento
	 */
	public AtendimentoDTO(Integer idAtendimento, String atendimentoDH) {
		setIdAtendimento(idAtendimento);
		setAtendimentoDH(atendimentoDH);
		setCliente(new ClienteDTO());
		setFuncionario(new FuncionarioDTO());
		setServico(new ServicoDTO());
	}

	/**
	 * Construtor da classe {@link AtendimentoDTO} com TODOS os atributos
	 * parametrizados (os atributos da classe e os objetos de outras classes que
	 * estao relacionados com {@link AtendimentoDTO}).
	 * 
	 * @param idAtendimento codigo identificador do atendimento
	 * @param atendimentoDH data e hora do atendimento
	 * @param cliente {@link ClienteDTO}
	 * @param funcionario {@link FuncionarioDTO}
	 * @param servico {@link ServicoDTO}
	 */
	public AtendimentoDTO(Integer idAtendimento, String atendimentoDH, ClienteDTO cliente, FuncionarioDTO funcionario, ServicoDTO servico) {
		setIdAtendimento(idAtendimento);
		setAtendimentoDH(atendimentoDH);
		setCliente(cliente);
		setFuncionario(funcionario);
		setServico(servico);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString( )
	 */
	public String toString() {
		return "Atendimento [idAtendimento=" + idAtendimento
				+ ", atendimentoDH=" + atendimentoDH + ", cliente=" + cliente
				+ ", funcionario=" + funcionario + ", servico=" + servico + "]";
	}

	/**
	 * Coleta o codigo identificador do atendimento.
	 * 
	 * @return codigo identificador do atendimento
	 */
	public Integer getIdAtendimento() {
		return idAtendimento;
	}

	/**
	 * Configura o codigo identificador do atendimento.
	 * 
	 * @param intIdAtendimento codigo identificador do atendimento
	 */
	public void setIdAtendimento(Integer intIdAtendimento) {
		this.idAtendimento = intIdAtendimento;
	}

	/**
	 * Coleta a data e hora de atendimento.
	 * 
	 * @return data e hora do atendimento
	 */
	public String getAtendimentoDH() {
		return atendimentoDH;
	}

	/**
	 * Configura a data e a hora do atendimento.
	 * 
	 * @param atendimentoDH data e hora do atendimento
	 */
	public void setAtendimentoDH(String atendimentoDH) {
		this.atendimentoDH = atendimentoDH;
	}

	/**
	 * Coleta o cliente.
	 * 
	 * @return {@link ClienteDTO}
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * Configura o cliente.
	 * 
	 * @param cliente {@link ClienteDTO}
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	/**
	 * Coleta o funcionario.
	 * 
	 * @return {@link FuncionarioDTO}
	 */
	public FuncionarioDTO getFuncionario() {
		return funcionario;
	}

	/**
	 * Configura o funcionario.
	 * 
	 * @param funcionario {@link FuncionarioDTO}
	 */
	public void setFuncionario(FuncionarioDTO funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Coleta o {@link ServicoDTO}.
	 * 
	 * @return {@link ServicoDTO}
	 */
	public ServicoDTO getServico() {
		return servico;
	}

	/**
	 * Configura o {@link ServicoDTO}.
	 * 
	 * @param servico {@link ServicoDTO}
	 */
	public void setServico(ServicoDTO servico) {
		this.servico = servico;
	}

	/**
	 * Coleta data e hora da inclusao do atendimento.
	 * 
	 * @return data e hora da inclusao do atendimento
	 */
	public String getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusao do atendimento.
	 * 
	 * @param incDH {@link Calendar}
	 */
	public void setIncDH(String incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora em que o atendimento foi alterado.
	 * 
	 * @return {@link String} com a data e a hora da alteracao do atendimento
	 */
	public String getAltDH() {
		return altDH;
	}

	/**
	 * Configura a data e a hora da alteracao do atendimento.
	 * 
	 * @param altDH {@link String} com a data e a hora da alteracao do atendimento
	 */
	public void setAltDH(String altDH) {
		this.altDH = altDH;
	}

}
