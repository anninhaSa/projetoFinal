package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.apache.commons.lang.StringUtils;

import view.ClienteDTO;

/**
 * Classe com os atributos do cliente.
 */
@Entity
public class Cliente extends Pessoa {
	@Column(length = 250)
	private String observacao;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Agendamento> listAgendamento;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Atendimento> listAtendimento;
	
	public Cliente() {
		super();
		setTpPessoa       (s_nCliente                  );
		setListAgendamento(new ArrayList<Agendamento>());
		setListAtendimento(new ArrayList<Atendimento>());
		setObservacao     (new String()                );
	}
	
	public Cliente(Integer idPessoa, String  nome,    Date              dataNasc,        String            rg,
		           String  cpf,      Contato contato, List<Agendamento> listAgendamento, List<Atendimento> listAtendimento,
		           String  observacao) {
		setTpPessoa       (s_nCliente     );
		setIdPessoa       (idPessoa       );
		setNome           (nome           );
		setDataNasc       (dataNasc       );
		setRG             (rg             );
		setCPF            (cpf            );
		setContato        (contato        );
		setListAgendamento(listAgendamento);
		setListAtendimento(listAtendimento);
		setObservacao     (observacao     );
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Agendamento> getListAgendamento() {
		return listAgendamento;
	}
	
	public void setListAgendamento(List<Agendamento> listAgendamento) {
		this.listAgendamento = listAgendamento;
	}
	
	public List<Atendimento> getListAtendimento() {
		return listAtendimento;
	}
	
	public void setListAtendimento(List<Atendimento> listAtendimento) {
		this.listAtendimento = listAtendimento;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString() + ", observacao=" + observacao + "]";
	}
	
	public ClienteDTO toView() {
	    ClienteDTO clienteDTO = (ClienteDTO) super.toView();
	    
	    clienteDTO.setTpPessoa  (Pessoa.s_nCliente                            );
	    clienteDTO.setObservacao(StringUtils.trimToEmpty(this.getObservacao()));
	    
	    return clienteDTO;
	}
}