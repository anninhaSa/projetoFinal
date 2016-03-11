package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

import util.Util;
import view.ContatoDTO;

/**
 * Classe com atributos do contato da Pessoa.
 */
@Entity
@SequenceGenerator(name = "seq_contato", sequenceName = "seq_contato")
public class Contato {
	@Id
	@GeneratedValue(generator = "seq_contato")
	@Column(name="id_contato")
	private Integer idContato;
	
	@Column(length = 70)
	private String email;
	
	@OneToOne  (cascade = CascadeType.ALL)
	@JoinColumn(name    = "id_pessoa"    )
	private Pessoa pessoa;
	
	@OneToOne(mappedBy = "contato", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Endereco endereco;
	
	@OneToMany(mappedBy = "contato", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Telefone> listTelefone;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Contato() {
		setIdContato   (0                        );
		setEmail       (""                       );
		setEndereco    (new Endereco           ());
		setListTelefone(new ArrayList<Telefone>());
	}

	public Contato(Integer idContato, String email, Pessoa pessoa, Endereco endereco, List<Telefone> listTelefone) {
		setIdContato   (idContato   );
		setEmail       (email       );
		setPessoa      (pessoa      );
		setEndereco    (endereco    );
        setListTelefone(listTelefone);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Contato [idContato=" + idContato + ", listTelefone=" + listTelefone + ", email=" + email + ", endereco=" + endereco + "]";
	}

	public Integer getIdContato() {
		return idContato;
	}

	public void setIdContato(Integer idContato) {
		this.idContato = idContato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	/**
	 * Coleta a data e a hora da inclusao do contato.
	 * @return {@link Date} com a data e hora da inclusao do contato
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusao do contato.
	 * @param incDH data e hora da inclusao
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da alteracao do contato.
	 * @return {@link Date} data e hora da alteracao do contato
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura a data e a hora da alteracao do contato.
	 * @param altDH {@link Date} data e hora da alteracao do contato
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}

    public List<Telefone> getListTelefone() {
        return listTelefone;
    }

    public void setListTelefone(List<Telefone> listTelefone) {
        this.listTelefone = listTelefone;
    }
    
    public void addTelefone(Telefone telefone) {
        if(getListTelefone() == null) {
            setListTelefone(new ArrayList<Telefone>());
        }
        
        getListTelefone().add(telefone);
    }
    
    public ContatoDTO toView() {
        ContatoDTO contatoDTO = new ContatoDTO();
        
        contatoDTO.setIdContato(this.getIdContato());
        
        if(this.getEndereco() != null) {
            contatoDTO.setEndereco(this.getEndereco().toView());
            contatoDTO.getEndereco().setContato(contatoDTO);
        }
        
        for(Telefone telefone : this.getListTelefone()) {
            if(telefone.getTipo().equals(Telefone.s_nTpCelular)) {
                contatoDTO.setTelCelular(telefone.toView());
            } else if(telefone.getTipo().equals(Telefone.s_nTpComercial)) {
                contatoDTO.setTelComercial(telefone.toView());
            } else if(telefone.getTipo().equals(Telefone.s_nTpResidencial)) {
                contatoDTO.setTelResidencial(telefone.toView());
            }
        }
        
        contatoDTO.setEmail(StringUtils.trimToEmpty    (this.getEmail()));
        contatoDTO.setIncDH(Util.converteDateParaString(this.getIncDH()));
        contatoDTO.setAltDH(Util.converteDateParaString(this.getAltDH()));
        
        return contatoDTO;
    }
    
    public Telefone getCelular() {
        Telefone telefone = null;
        
        for(Telefone tel : this.getListTelefone()) {
            if(tel.getTipo().equals(Telefone.s_nTpCelular)) {
                telefone = tel;
                break;
            }
        }
        
        return telefone;
    }
    
    public Telefone getTelComercial() {
        Telefone telefone = null;
        
        for(Telefone tel : this.getListTelefone()) {
            if(tel.getTipo().equals(Telefone.s_nTpComercial)) {
                telefone = tel;
                break;
            }
        }
        
        return telefone;
    }
    
    public Telefone getTelResidencial() {
        Telefone telefone = null;
        
        for(Telefone tel : this.getListTelefone()) {
            if(tel.getTipo().equals(Telefone.s_nTpResidencial)) {
                telefone = tel;
                break;
            }
        }
        
        return telefone;
    }
}