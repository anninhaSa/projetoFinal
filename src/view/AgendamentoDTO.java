package view;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos do agendamento de cada servico ({@link ServicoDTO}) feito por um 
 * funcionario ({@link FuncionarioDTO}) a um cliente({@link ClienteDTO})
 */
public class AgendamentoDTO {

    private Integer        idAgenda;
    private String         agendamentoDH;
    private ClienteDTO     cliente;
    private FuncionarioDTO funcionario;
    private ServicoDTO     servico;
    private String         observacao;
    private String         incDH;
    private String         altDH;

    /**
     * Construtor da classe {@link AgendamentoDTO} (inicializa todos os atributos).
     */
    public AgendamentoDTO( ) {
        setIdAgenda     ( 0                     );
        setAtendimentoDH( ""                    );
        setCliente      ( new ClienteDTO    ( ) );
        setFuncionario  ( new FuncionarioDTO( ) );
        setServico      ( new ServicoDTO    ( ) );
        setObservacao   ( ""                    );
    }

    /**
     * Construtor da classe {@link AgendamentoDTO} com os atributos DA CLASSE
     * parametrizados.
     * 
     * @param idAgenda codigo identificador do agendamento
     * @param agendamentoDH data e hora do agendamento
     * @param observacao observacao
     */
    public AgendamentoDTO( Integer idAgenda, String agendamentoDH, String observacao ) {
        setIdAgenda     ( idAgenda              );
        setAtendimentoDH( agendamentoDH         );
        setCliente      ( new ClienteDTO    ( ) );
        setFuncionario  ( new FuncionarioDTO( ) );
        setServico      ( new ServicoDTO    ( ) );
        setObservacao   ( observacao            );
    }

    /**
     * Construtor da classe {@link AgendamentoDTO} com TODOS os atributos parametrizados (os atributos da classe e os objetos de outras 
     * classes que estao relacionados com {@link AgendamentoDTO}).
     * 
     * @param idAgenda codigo identificador do agendamento
     * @param atendimentoDH data e hora do agendamento
     * @param cliente {@link ClienteDTO}
     * @param funcionario {@link FuncionarioDTO}
     * @param servico {@link ServicoDTO}
     * @param observacao observacao
     */
    public AgendamentoDTO( Integer idAgenda, String atendimentoDH, ClienteDTO cliente, FuncionarioDTO funcionario, ServicoDTO servico,
                           String  observacao ) {
        setIdAgenda     ( idAgenda      );
        setAtendimentoDH( atendimentoDH );
        setCliente      ( cliente       );
        setFuncionario  ( funcionario   );
        setServico      ( servico       );
        setObservacao   ( observacao    );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString( ) {
        return "AgendamentoDTO [idAgenda=" + idAgenda    + ", agendamentoDH=" + agendamentoDH + ", cliente="    + cliente    +
               ", funcionario="            + funcionario + ", servico="       + servico       + ", observacao=" + observacao + "]";
    }

    /**
     * Coleta o codigo identificador da agenda.
     * 
     * @return codigo identificador da agenda
     */
    public Integer getIdAgenda( ) {
        return idAgenda;
    }

    /**
     * Configura o codigo identificador da agenda.
     * 
     * @param idAgenda codigo identificador da agenda
     */
    public void setIdAgenda( Integer idAgenda ) {
        this.idAgenda = idAgenda;
    }

    /**
     * Coleta a data e hora atendimento.
     * 
     * @return data e hora atendimento
     */
    public String getAgendamentoDH( ) {
        return agendamentoDH;
    }

    /**
     * Configura a data e a hora do atendimento.
     * 
     * @param agendamentoDH data do atendimento
     */
    public void setAtendimentoDH( String agendamentoDH ) {
        this.agendamentoDH = agendamentoDH;
    }

    /**
     * Coleta o cliente.
     * 
     * @return {@link ClienteDTO}
     */
    public ClienteDTO getCliente( ) {
        return cliente;
    }

    /**
     * Configura o cliente.
     * 
     * @param cliente {@link ClienteDTO}
     */
    public void setCliente( ClienteDTO cliente ) {
        this.cliente = cliente;
    }

    /**
     * Coleta o funcionario
     * 
     * @return {@link FuncionarioDTO}
     */
    public FuncionarioDTO getFuncionario( ) {
        return funcionario;
    }

    /**
     * Configura o funcionario.
     * 
     * @param funcionario {@link FuncionarioDTO}
     */
    public void setFuncionario( FuncionarioDTO funcionario ) {
        this.funcionario = funcionario;
    }

    /**
     * Coleta o servico.
     * 
     * @return {@link ServicoDTO}
     */
    public ServicoDTO getServico( ) {
        return servico;
    }

    /**
     * Configura o servico.
     * 
     * @param servico {@link ServicoDTO}
     */
    public void setServico( ServicoDTO servico ) {
        this.servico = servico;
    }

    /**
     * Coleta as observacoes feitas pelo/sobre o cliente.
     * 
     * @return as observacoes feitas pelo/sobre o cliente.
     */
    public String getObservacao( ) {
        return observacao;
    }

    /**
     * Configura as observacoes feitas pelo/sobre o cliente.
     * 
     * @param observacao observacao
     */
    public void setObservacao( String observacao ) {
        this.observacao = observacao;
    }

    /**
     * Coleta a data e hora da inclusao do cliente.
     * 
     * @return data e hora da inclusao do agendamento.
     */
    public String getIncDH( ) {
        return incDH;
    }

    /**
     * Configura a Data/Hora da inclusao do agendamento.
     * 
     * @param incDH data e hora da inclusao do agendamento.
     */
    public void setIncDH( String incDH ) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e hora da alteracao do agendamento
     * 
     * @return data e hora da alteracao do agendamento
     */
    public String getAltDH( ) {
        return altDH;
    }

    /**
     * Configura a Data/Hora da alteracao do agendamento
     * 
     * @param altDH data e hora da alteracao do agendamento
     */
    public void setAltDH(String altDH) {
        this.altDH = altDH;
    }
}