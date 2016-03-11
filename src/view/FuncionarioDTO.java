package view;

import java.util.ArrayList;
import java.util.List;

import entity.Funcionario;
import entity.Pessoa;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos do funcionario.
 */
public class FuncionarioDTO extends PessoaDTO {
    private List<AgendamentoDTO> listAgendamento;
    private List<AtendimentoDTO> listAtendimento;
    private AutenticacaoDTO      autenticacao;

    public FuncionarioDTO() {
        super();
        setTpPessoa       (Pessoa.s_nFuncionario          );
        setListAgendamento(new ArrayList<AgendamentoDTO>());
        setListAtendimento(new ArrayList<AtendimentoDTO>());
        setAutenticacao   (new AutenticacaoDTO          ());
    }

    public FuncionarioDTO(Integer              intIdPessoa,     String               strNome,         String          dtDataNasc,
                          String               strRG,           String               strCPF,          ContatoDTO      contato,
                          List<AgendamentoDTO> listAgendamento, List<AtendimentoDTO> listAtendimento, AutenticacaoDTO autenticacao) {
        setTpPessoa       (Pessoa.s_nFuncionario);
        setIdPessoa       (intIdPessoa          );
        setNome           (strNome              );
        setDataNasc       (dtDataNasc           );
        setRG             (strRG                );
        setCPF            (strCPF               );
        setContato        (contato              );
        setListAgendamento(listAgendamento      );
        setListAtendimento(listAtendimento      );
        setAutenticacao   (autenticacao         );
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

    public AutenticacaoDTO getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(AutenticacaoDTO autenticacao) {
        this.autenticacao = autenticacao;
    }
    
    public Funcionario toEntity() {
        Funcionario funcionario = (Funcionario) super.toEntity();
        
        funcionario.setTpPessoa(Pessoa.s_nFuncionario);
        
        return funcionario;
    }
}