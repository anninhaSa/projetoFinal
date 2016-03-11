package entity;

import java.io.Serializable;
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

/**
 * Classe com atributos da autenticacao.
 *
 */
@Entity
@SequenceGenerator(name = "seq_autenticacao", sequenceName = "seq_autenticacao")
public class Autenticacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "seq_autenticacao")
	private Integer idAutenticacao;
	
	@Column(length = 15, unique = true)
	private String usuario;
	
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "id_funcionario")
	private Funcionario funcionario;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Autenticacao() {
		setIdAutenticacao(0 );
		setUsuario       ("");
		setSenha         ("");
	}
	
	public Autenticacao(Integer idAutenticacao, String usuario, String senha, Funcionario funcionario) {
		super();
		setIdAutenticacao(idAutenticacao);
		setUsuario       (usuario       );
		setSenha         (senha         );
		setFuncionario   (funcionario   );
	}
	
	public int getIdAutenticacao() {
		return idAutenticacao;
	}

	public void setIdAutenticacao(Integer idAutenticacao) {
		this.idAutenticacao = idAutenticacao;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Coleta a data e a hora da inclusao da autenticacao
	 * @return {@link Date} com a data e a hora da inclusao da autenticacao
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusao da autenticacao.
	 * @param incDH {@link Date} com a data e a hora da inclusao da autenticacao
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteracao da autenticacao
	 * @return {@link Date} com a data e a hora da alteracao da autenticacao
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura data e hora da alteracao da autenticacao
	 * @param altDH {@link Date} com a data e hora da alteracao da autenticacao
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
}