package view;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import util.Util;
import entity.Cliente;
import entity.Pessoa;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com os atributos do cliente.
 */
public class ClienteDTO extends PessoaDTO {

	private String observacao;
	private List<AgendamentoDTO> listAgendamento;
	private List<AtendimentoDTO> listAtendimento;

	public ClienteDTO() {
		super();
		setTpPessoa       (Pessoa.s_nCliente              );
		setListAgendamento(new ArrayList<AgendamentoDTO>());
		setListAtendimento(new ArrayList<AtendimentoDTO>());
		setObservacao     (""                             );
	}
	
	public ClienteDTO(Integer idPessoa, String     nome,    String               dataNasc,        String               rg,
	                  String  cpf,      ContatoDTO contato, List<AgendamentoDTO> listAgendamento, List<AtendimentoDTO> listAtendimento,
	                  String  observacao) {
		setTpPessoa       (Pessoa.s_nCliente);
		setIdPessoa       (idPessoa         );
		setNome           (nome             );
		setDataNasc       (dataNasc         );
		setRG             (rg               );
		setCPF            (cpf              );
		setContato        (contato          );
		setListAgendamento(listAgendamento  );
		setListAtendimento(listAtendimento  );
		setObservacao     (observacao       );
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<AgendamentoDTO> getListAgendamento() {
		return listAgendamento;
	}

	public void setListAgendamento(List<AgendamentoDTO> listAgendamento) {
		this.listAgendamento = listAgendamento;
	}

	public List<AtendimentoDTO> getListAtendimento() {
		return listAtendimento;
	}

	public void setListAtendimento(List<AtendimentoDTO> listAtendimento) {
		this.listAtendimento = listAtendimento;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + ", observacao=" + observacao + "]";
	}
	
	public Cliente toEntity() {
	    
	    Cliente cliente = new Cliente(this.getIdPessoa(), this.getNome(), Util.converteStringParaDate(this.getDataNasc()),
	                                  this.getRG(),       this.getCPF(),  this.getContato().toEntity(), null, null, null);
	    
	    cliente.setTpPessoa(Pessoa.s_nCliente);
	    
	    if(StringUtils.trimToNull(this.getObservacao()) != null) {
	        cliente.setObservacao(StringUtils.trimToNull(this.getObservacao()));
	    }
	    
	    return cliente;
	}
}