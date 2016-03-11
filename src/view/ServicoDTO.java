package view;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos de cada servico disponivel.
 */
public class ServicoDTO {
    private Integer idServico;
    private String  nomeServico;
    private Double  valor;
    private String  incDH;
    private String  altDH;

    /**
     * Construtor da classe {@link ServicoDTO} (inicializa todos os atributos).
     */
    public ServicoDTO( ) {
        setIdServico  ( 0  );
        setNomeServico( "" );
        setValor      ( 0. );
    }

    /**
     * Construtor da classe {@link ServicoDTO} com os atributos da classe.
     * 
     * @param idServico codigo identificador do servico
     * @param nomeServico nome do servico
     * @param valor valor do servico
     */
    public ServicoDTO( Integer idServico, String nomeServico, Double valor ) {
        setIdServico  ( idServico   );
        setNomeServico( nomeServico );
        setValor      ( valor       );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString( ) {
        return "Servico [idServico=" + idServico + ", nomeServico=" + nomeServico + "]";
    }

    /**
     * Coleta o codigo identificador do servico.
     * 
     * @return codigo identificador do servico
     */
    public Integer getIdServico( ) {
        return idServico;
    }

    /**
     * Configura o codigo identificador do servico.
     * 
     * @param idServico codigo identificador do servico
     */
    public void setIdServico( Integer idServico ) {
        this.idServico = idServico;
    }

    /**
     * Coleta o nome do servico.
     * 
     * @return nome do servico
     */
    public String getNomeServico( ) {
        return nomeServico;
    }

    /**
     * Configura o nome do servico.
     * 
     * @param nomeServico nome do servico
     */
    public void setNomeServico( String nomeServico ) {
        this.nomeServico = nomeServico;
    }

    /**
     * Coleta valor do servico.
     * 
     * @return valor do servico
     */
    public Double getValor( ) {
        return valor;
    }

    /**
     * Configura valor do servico.
     * 
     * @param valor valor do servico
     */
    public void setValor( Double valor ) {
        this.valor = valor;
    }

    /**
     * Coleta a data e a hora da inclusao do servico
     * 
     * @return data e a hora da inclusao da autenticacao
     */
    public String getIncDH( ) {
        return incDH;
    }

    /**
     * Configura a data e a hora da inclusao do servico
     * 
     * @param incDH data e a hora da inclusao da autenticacao
     */
    public void setIncDH( String incDH ) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e a hora da alteracao do servico
     * 
     * @return data e a hora da alteracao do servico
     */
    public String getAltDH( ) {
        return altDH;
    }

    /**
     * Configura data e hora da alteracao do servico
     * 
     * @param altDH data e hora da alteracao do servico
     */
    public void setAltDH( String altDH ) {
        this.altDH = altDH;
    }
}