package view;

import java.util.ArrayList;
import java.util.List;

import entity.Cliente;
import entity.Pessoa;

public class ClienteDTO extends PessoaDTO {

	private String observacao;
	private List<AgendamentoDTO> listAgendamento;
	private List<AtendimentoDTO> listAtendimento;

	/**
	 * Construtor da classe {@link ClienteDTO}.
	 */
	public ClienteDTO() {
		super();
		setTpPessoa(Pessoa.s_nCliente);
		setListAgendamento(new ArrayList<AgendamentoDTO>());
		setListAtendimento(new ArrayList<AtendimentoDTO>());
		setObservacao(new String());
	}

	/**
	 * Construtor da classe {@link ClienteDTO} com os atributos da classe basica ({@link PessoaDTO}) parametrizados.
	 * 
	 * @param idPessoa Codigo identificador da pessoa
	 * @param nome Nome da Pessoa
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param contato {@link ContatoDTO}
	 * @param observacao observacao
	 */
	public ClienteDTO(Integer idPessoa, String nome, String dataNasc, String rg, String cpf, ContatoDTO contato, String observacao) {
		setTpPessoa(Pessoa.s_nCliente);
		setIdPessoa(idPessoa);
		setNome(nome);
		setDataNasc(dataNasc);
		setRG(rg);
		setCPF(cpf);
		setContato(contato);
		setListAgendamento(new ArrayList<AgendamentoDTO>());
		setListAtendimento(new ArrayList<AtendimentoDTO>());
		setObservacao(observacao);
	}

	/**
	 * Construtor da classe {@link Cliente} com TODOS os atributos
	 * parametrizados (os atributos da classe e os objetos de outras classes que
	 * estao relacionados com {@link Cliente}).
	 * 
	 * @param idPessoa Codigo identificador da pessoa
	 * @param nome Nome da Pessoa
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param contato {@link ContatoDTO}
	 * @param listAgendamento lista com os {@link AgendamentoDTO}s do cliente
	 * @param listAtendimento lista com os {@link AtendimentoDTO}s do cliente
	 * @param strObservacao observacao
	 */
	public ClienteDTO(Integer idPessoa, String nome, String dataNasc, String rg,
			String cpf, ContatoDTO contato, List<AgendamentoDTO> listAgendamento,
			List<AtendimentoDTO> listAtendimento, String observacao) {
		setTpPessoa(Pessoa.s_nCliente);
		setIdPessoa(idPessoa);
		setNome(nome);
		setDataNasc(dataNasc);
		setRG(rg);
		setCPF(cpf);
		setContato(contato);
		setListAgendamento(listAgendamento);
		setListAtendimento(listAtendimento);
		setObservacao(observacao);
	}

	/**
	 * Construtor da classe {@link ClienteDTO} com TODOS os atributos
	 * parametrizados (os atributos da classe e os objetos de outras classes que
	 * estao relacionados com {@link ClienteDTO}).
	 * 
	 * @param nome Nome da Pessoa
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 */
	public ClienteDTO(String nome, String dataNasc, String rg, String cpf) {
		setTpPessoa(Pessoa.s_nCliente);
		setNome(nome);
		setDataNasc(dataNasc);
		setRG(rg);
		setCPF(cpf);
	}

	/**
	 * Coleta as observacoes feitas a respeito do cliente.
	 * 
	 * @return as observacoes feitas sobre/pelo cliente.
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * Configura a observacao feita a respeito do cliente.
	 * 
	 * @param observacao observacao
	 */
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	/**
	 * Coleta a lista de agendamento do cliente.
	 * 
	 * @return lista do tipo {@link AgendamentoDTO};
	 */
	public List<AgendamentoDTO> getListAgendamento() {
		return listAgendamento;
	}

	/**
	 * Configura a lista de agendamento do cliente.
	 * 
	 * @param listAgendamento lista do tipo {@link AgendamentoDTO}
	 */
	public void setListAgendamento(List<AgendamentoDTO> listAgendamento) {
		this.listAgendamento = listAgendamento;
	}

	/**
	 * Coleta a lista de atendimento do cliente
	 * 
	 * @return lista do tipo {@link AtendimentoDTO}
	 */
	public List<AtendimentoDTO> getListAtendimento() {
		return listAtendimento;
	}

	/**
	 * Configura a lista de atendimento do cliente.
	 * 
	 * @param listAtendimento lista do tipo {@link AtendimentoDTO}
	 */
	public void setListAtendimento(List<AtendimentoDTO> listAtendimento) {
		this.listAtendimento = listAtendimento;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + ", observacao=" + observacao + "]";
	}
}