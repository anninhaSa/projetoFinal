package view;

import org.apache.commons.lang.StringUtils;

import entity.Contato;
import entity.Endereco;
import entity.Telefone;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos do contato da Pessoa.
 */
public class ContatoDTO {
    private Integer     idContato;
    private String      telCelular;
    private String      telComercial;
    private String      telResidencial;
    private String      email;
    private PessoaDTO   pessoa;
    private EnderecoDTO endereco;
    private String      incDH;
    private String      altDH;

    public ContatoDTO() {
        setIdContato     (0                );
        setTelCelular    (""               );
        setTelComercial  (""               );
        setTelResidencial(""               );
        setEmail         (""               );
        setEndereco      (new EnderecoDTO());
    }

    public ContatoDTO(Integer idContato,    String email, PessoaDTO pessoa, EnderecoDTO endereco, String telCelular,
                      String  telComercial, String telResidencial) {
        setIdContato     (idContato     );
        setEmail         (email         );
        setPessoa        (pessoa        );
        setEndereco      (endereco      );
        setTelCelular    (telCelular    );
        setTelComercial  (telComercial  );
        setTelResidencial(telResidencial);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return "Contato [idContato=" + idContato      + ", telCelular=" + telCelular + ", telComercial=" + telComercial + 
                ", telResidencial="  + telResidencial + ", email="      + email      + ", endereco="     + endereco     + "]";
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        this.idContato = idContato;
    }

    public String getTelCelular() {
        return telCelular;
    }

    public void setTelCelular(String telCelular) {
        this.telCelular = telCelular;
    }

    public String getTelComercial() {
        return telComercial;
    }

    public void setTelComercial(String telComercial) {
        this.telComercial = telComercial;
    }

    public String getTelResidencial() {
        return telResidencial;
    }

    public void setTelResidencial(String telResidencial) {
        this.telResidencial = telResidencial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }

    /**
     * Coleta a data e a hora da inclusao do contato.
     * 
     * @return data e hora da inclusao do contato
     */
    public String getIncDH() {
        return incDH;
    }

    /**
     * Configura a data e hora da inclusao do contato.
     * 
     * @param incDH data e hora da inclusao
     */
    public void setIncDH(String incDH) {
        this.incDH = incDH;
    }

    /**
     * Coleta a data e hora da alteracao do contato.
     * 
     * @return data e hora da alteracao do contato
     */
    public String getAltDH() {
        return altDH;
    }

    /**
     * Configura a data e a hora da alteracao do contato.
     * 
     * @param altDH data e hora da alteracao do contato
     */
    public void setAltDH(String altDH) {
        this.altDH = altDH;
    }
    
    public Contato toEntity() {
        Contato contato = new Contato();
        
        contato.setIdContato(this.getIdContato());
        
        if(StringUtils.trimToNull(this.getEmail()) != null) {
            contato.setEmail(StringUtils.trimToNull(this.getEmail()));
        }
        
        if(StringUtils.trimToNull(this.getTelCelular()) != null) {
            Telefone telefone = telefoneToEntity(StringUtils.trimToNull(this.getTelCelular()));
            
            if(telefone != null) {
                telefone.setContato(contato);
                telefone.setTipo(Telefone.s_nTpCelular);
                contato.getListTelefone().add(telefone);
            }
        }
        
        if(StringUtils.trimToNull(this.getTelComercial()) != null) {
            Telefone telefone = telefoneToEntity(StringUtils.trimToNull(this.getTelComercial()));
            
            if(telefone != null) {
                telefone.setContato(contato);
                telefone.setTipo(Telefone.s_nTpComercial);
                contato.getListTelefone().add(telefone);
            }
        }
        
        if(StringUtils.trimToNull(this.getTelResidencial()) != null) {
            Telefone telefone = telefoneToEntity(StringUtils.trimToNull(this.getTelResidencial()));
            
            if(telefone != null) {
                telefone.setContato(contato);
                telefone.setTipo(Telefone.s_nTpResidencial);
                contato.getListTelefone().add(telefone);
            }
        }
        
        if(getEndereco() != null) {
            Endereco endereco = this.getEndereco().toEntity();
            
            if(endereco != null) {
                endereco.setContato(contato);
                contato.setEndereco(endereco);
            }
        }
        
        return contato;
    }
    
    public static Telefone telefoneToEntity(String telefone) {
        Telefone telefoneEntity = null;
        
        telefone = removeMascaraTelefone(telefone);
        
        if(!StringUtils.isEmpty(telefone) && telefone.length() > 2) {
            telefoneEntity = new Telefone();
            telefoneEntity.setDDD(telefone.substring(0, 2));
            telefoneEntity.setTelefone(telefone.substring(2));
        }
        
        return telefoneEntity;
    }

    public static String removeMascaraTelefone(String telefone) {
        return StringUtils.trimToEmpty(telefone).replaceAll("[(]", "").replaceAll("[)]", "").replaceAll("[-]", "");
    }
}