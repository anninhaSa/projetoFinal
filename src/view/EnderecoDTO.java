package view;

import org.apache.commons.lang.StringUtils;

import entity.Endereco;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos do
 * endereco.
 */
public class EnderecoDTO {
    private Integer    idEndereco;
    private String     logradouro;
    private Integer    numero;
    private String     complemento;
    private String     bairro;
    private String     cidade;
    private String     uf;
    private String     cep;
    private ContatoDTO contato;
    private String     incDH;
    private String     altDH;

    public EnderecoDTO() {
        setIdEndereco (0 );
        setLogradouro ("");
        setNumero     (0 );
        setComplemento("");
        setBairro     ("");
        setCidade     ("");
        setUf         ("");
        setCep        ("");
    }


    public EnderecoDTO(Integer idEndereco, String logradouro, Integer    numero, String complemento, String bairro, String cidade,
                       String  uf,         String cep,        ContatoDTO contato) {
        setIdEndereco (idEndereco );
        setLogradouro (logradouro );
        setNumero     (numero     );
        setComplemento(complemento);
        setBairro     (bairro     );
        setCidade     (cidade     );
        setUf         (uf         );
        setCep        (cep        );
        setContato    (contato    );
    }


    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Endereco [idEndereco=" + idEndereco  + ", logradouro=" + logradouro + ", numero=" + numero +
               ", complemento="        + complemento + ", bairro="     + bairro     + ", cidade=" + cidade +
               ", uf="                 + uf          + ", cep="        + cep        + "]";
    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public ContatoDTO getContato() {
        return contato;
    }

    public void setContato(ContatoDTO contato) {
        this.contato = contato;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * Coleta a data e hora da inclusao do endereco.
     * 
     * @return data e hora da inclusao do endereco
     */
    public String getIncDH() {
        return incDH;
    }

    /**
     * Configura a data e hora da inclusao do endereco.
     * 
     * @param incDH data e hora da inclusao do endereco
     */
    public void setIncDH(String incDH) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e hora da alteracao do endereco.
     * 
     * @return data e hora da alteracao do endereco
     */
    public String getAltDH() {
        return altDH;
    }

    /**
     * Configura a data e hora da alteracao do endereco.
     * 
     * @param altDH data e hora da alteracao do endereco
     */
    public void setAltDH(String altDH) {
        this.altDH = altDH;
    }
    
    public Endereco toEntity() {
        Endereco endereco = null;
        
        if(!StringUtils.isEmpty(this.getLogradouro()) && !StringUtils.isEmpty(this.getBairro()) && 
           !StringUtils.isEmpty(this.getCidade    ()) && !StringUtils.isEmpty(this.getUf    ()) && 
           !StringUtils.isEmpty(this.getCep       ()) &&
           (!StringUtils.isEmpty(this.getComplemento()) || this.getNumero( ) != 0)) {
            
            endereco = new Endereco();
            
            endereco.setIdEndereco(this.getIdEndereco());
            
            endereco.setBairro     (StringUtils.trimToNull(this.getBairro     ()));
            endereco.setCep        (StringUtils.trimToNull(this.getCep        ()));
            endereco.setCidade     (StringUtils.trimToNull(this.getCidade     ()));
            endereco.setComplemento(StringUtils.trimToNull(this.getComplemento()));
            endereco.setLogradouro (StringUtils.trimToNull(this.getLogradouro ()));
            endereco.setUf         (StringUtils.trimToNull(this.getUf         ()));
            endereco.setNumero     (this.getNumero()                             );
        }
        
        return endereco;
    }
}