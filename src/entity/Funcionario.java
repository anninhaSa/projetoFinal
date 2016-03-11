package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import view.FuncionarioDTO;

/**
 * Classe com atributos do funcionario.
 */
@Entity
public class Funcionario extends Pessoa {
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Agendamento> listAgendamento;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Atendimento> listAtendimento;
	
	@OneToOne(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Autenticacao autenticacao;
	
	public Funcionario() {
		super();
		setTpPessoa       (s_nFuncionario              );
		setListAgendamento(new ArrayList<Agendamento>());
		setListAtendimento(new ArrayList<Atendimento>());
		setAutenticacao   (new Autenticacao()          );
	}
	
	public Funcionario(Integer      intIdPessoa, String  strNome, Date              dtDataNasc,      String            strRG,
                       String       strCPF,      Contato contato, List<Agendamento> listAgendamento, List<Atendimento> listAtendimento,
                       Autenticacao autenticacao) {
		setTpPessoa       (s_nFuncionario );
		setIdPessoa       (intIdPessoa    );
		setNome           (strNome        );
		setDataNasc       (dtDataNasc     );
		setRG             (strRG          );
		setCPF            (strCPF         );
		setContato        (contato        );
		setListAgendamento(listAgendamento);
		setListAtendimento(listAtendimento);
		setAutenticacao   (autenticacao   );
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

	public Autenticacao getAutenticacao() {
		return autenticacao;
	}

	public void setAutenticacao(Autenticacao autenticacao) {
		this.autenticacao = autenticacao;
	}
	
	public FuncionarioDTO toView() {
	    FuncionarioDTO funcionario = (FuncionarioDTO) super.toView();
	    
	    funcionario.setTpPessoa(Pessoa.s_nFuncionario);
	    
	    return funcionario;
	}
}