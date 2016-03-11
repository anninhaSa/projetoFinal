package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

import util.Util;
import view.EnderecoDTO;

/**
 * Classe com atributos do endereco.
 */
@Entity
@SequenceGenerator(name = "seq_endereco", sequenceName = "seq_endereco")
public class Endereco {
	@Id
	@GeneratedValue(generator = "seq_endereco")
	private Integer idEndereco;
	
	@Column(length = 100)
	private String logradouro;
	
	private Integer numero;
	
	@Column(length = 50)
	private String complemento;
	
	@Column(length = 40)
	private String bairro;
	
	@Column(length = 40)
	private String cidade;
	
	@Column(length = 2)
	private String uf;
	
	@Column(length = 8)
	private String cep;
	
	@OneToOne
	@JoinColumn(name = "id_contato")
	private Contato contato;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Endereco() {
		setIdEndereco (0 );
		setLogradouro ("");
		setNumero     (0 );
		setComplemento("");
		setBairro     ("");
		setCidade     ("");
		setUf         ("");
		setCep        ("");
	}
	
	public Endereco(Integer idEndereco, String logradouro, Integer numero, String  complemento, String bairro,
			        String  cidade,     String uf,         String  cep,    Contato contato) {
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Endereco [idEndereco=" + idEndereco + ", logradouro="  + logradouro  + 
			   ", numero="             + numero     + ", complemento=" + complemento + 
			   ", bairro="             + bairro     + ", cidade="      + cidade      +
			   ", uf="                 + uf         + ", cep="         + cep         + "]";
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

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
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
	 * @return {@link Date} com a data e hora da inclusao do endereco
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e hora da inclusao do endereco.
	 * @param incDH {@link Date} com a data e hora da inclusao do endereco
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e hora da alteracao do endereco.
	 * @return {@link Date} com a data e hora da alteracao do endereco
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura a data e hora da alteracao do endereco.
	 * @param altDH {@link Date} com a data e hora da alteracao do endereco
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
	
	public EnderecoDTO toView() {
	    EnderecoDTO enderecoDTO = new EnderecoDTO();
	    
	    enderecoDTO.setIdEndereco (this.getIdEndereco()                              );
	    enderecoDTO.setBairro     (StringUtils.trimToEmpty    (this.getBairro     ()));
	    enderecoDTO.setCep        (StringUtils.trimToEmpty    (this.getCep        ()));
	    enderecoDTO.setCidade     (StringUtils.trimToEmpty    (this.getCidade     ()));
	    enderecoDTO.setComplemento(StringUtils.trimToEmpty    (this.getComplemento()));
	    enderecoDTO.setLogradouro (StringUtils.trimToEmpty    (this.getLogradouro ()));
	    enderecoDTO.setNumero     (this.getNumero()                                  );
	    enderecoDTO.setUf         (StringUtils.trimToEmpty    (this.getUf         ()));
	    enderecoDTO.setAltDH      (Util.converteDateParaString(this.getAltDH      ()));
	    enderecoDTO.setIncDH      (Util.converteDateParaString(this.getIncDH      ()));
	    
	    return enderecoDTO;
	}
}