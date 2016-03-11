package entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe com atributos de cada servico disponivel. 
 */
@Entity
@SequenceGenerator(name = "seq_servico", sequenceName = "seq_servico")
public class Servico {
	@Id
	@GeneratedValue(generator = "seq_servico")
	private Integer idServico;
	
	@Column(name = "nomeServico", length = 50)
	private String nomeServico;
	
	@Column(name = "valor")
	private Double valor;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Servico() {
		setIdServico  (0 ); 
		setNomeServico("");
		setValor      (0.);
	}

	public Servico(Integer idServico, String nomeServico, Double valor) {
		setIdServico  (idServico  );
		setNomeServico(nomeServico);
		setValor      (valor      );
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Servico [idServico=" + idServico + ", nomeServico=" + nomeServico + "]";
	}

	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public String getNomeServico() {
		return nomeServico;
	}

	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	/**
	 * Coleta a data e a hora da inclusao do servico
	 * @return {@link Date} com a data e a hora da inclusao da autenticacao
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusao do servico
	 * @param incDH {@link Date} com a data e a hora da inclusao da autenticacao
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteracao do servico
	 * @return {@link Date} com a data e a hora da alteracao do servico
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura data e hora da alteracao do servico
	 * @param altDH {@link Date} com a data e hora da alteracao do servico
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
}