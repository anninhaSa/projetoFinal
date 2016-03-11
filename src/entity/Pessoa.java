package entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.apache.commons.lang.StringUtils;

import util.Util;
import view.PessoaDTO;

/**
 * Classe com atributos da pessoa (cliente e funcionario).
 */
@Entity
@Inheritance      (strategy = InheritanceType.JOINED                   )
@SequenceGenerator(name     = "seq_pessoa", sequenceName = "seq_pessoa")
public class Pessoa {
	public static final transient int s_nCliente       = 1;
	public static final transient int s_nFuncionario   = 2;
	public static final transient int s_nAdministrador = 3;
	
	@Id
	@GeneratedValue(generator = "seq_pessoa")
	private Integer idPessoa;
	
	@Column(length = 90)
	private String nome;
	
	@Temporal(value = TemporalType.DATE)
	private Date dataNasc;
	
	private String rg;
	
	@Column(length = 11)
	private String cpf;
	
	private Integer tpPessoa;
	
	@OneToOne(mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Contato contato;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date incDH;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date altDH;
	
	public Pessoa() {
		setIdPessoa(0            );
		setNome    (""           );
		setDataNasc(new Date()   );
		setRG      (""           );
		setCPF     (""           );
		setTpPessoa(0            );
		setContato (new Contato());
	}
	
	/**
	 * Construtor da classe {@link Pessoa} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estao relacionados com 
	 * {@link Pessoa}).
	 * @param idPessoa Codigo identificador da pessoa
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param tpPessoa Tipo de Pessoa:
	 * <div style="margin-left: 60px">
	 *            <ul> 
	 *                <li>1 - Cliente</li> 
	 *                <li>2 - Funcionario</li>
	 *                <li>3 - Administrador</li>
	 *            </ul>
	 * </div>
	 * @param contato {@link Contato}
	 */
	public Pessoa(Integer idPessoa, String  nome,     Date    dataNasc, String rg,
			      String  cpf,      Integer tpPessoa, Contato contato) {
		setIdPessoa(idPessoa);
		setNome    (nome    );
		setDataNasc(dataNasc);
		setRG      (rg      );
		setCPF     (cpf     );
		setTpPessoa(tpPessoa);
		setContato (contato );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome="     + nome     +
			   ", dataNasc="       + dataNasc + ", rg="       + rg       +
			   ", cpf="            + cpf      + ", tpPessoa=" + tpPessoa +
			   ", contato="        + contato  + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean bEquals = false;
		Pessoa  p;
		
		if(obj instanceof Pessoa) {
			p = (Pessoa)obj;
			
			bEquals = p.getNome().equals(this.getNome());
		}
		
		return bEquals;
	}
	
	public Integer getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getRG() {
		return rg;
	}

	public void setRG(String rg) {
		this.rg = rg;
	}

	public String getCPF() {
		return cpf;
	}

	public void setCPF(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * Coleta tipo de pessoa.
	 * @return <b>1</b> caso o tipo de pessoa seja <i>Cliente</i>, <b>2</b> caso seja 
	 * <i>Funcionario</i> e <b>3</b> caso seja <i>Administrador</i>.
	 */
	public Integer getTpPessoa() {
		return tpPessoa;
	}

	/**
	 * Configura tipo de pessoa.
	 * <ul> 
	 *     <li>1 - Cliente</li> 
	 *     <li>2 - Funcionario</li>
	 *     <li>3 - Administrador</li>
	 * </ul>
	 * @param tpPessoa tipo de pessoa
	 */
	public void setTpPessoa(Integer tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
	
	/**
	 * Coleta a data e a hora da inclusao da pessoa
	 * @return {@link Date} com a data e a hora da inclusao da pessoa
	 */
	public Date getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusao da pessoa
	 * @param incDH {@link Date} com a data e a hora da inclusao da pessoa
	 */
	public void setIncDH(Date incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteracao da pessoa
	 * @return {@link Date} com a data e a hora da alteracao da pessoa
	 */
	public Date getAltDH() {
		return altDH;
	}

	/**
	 * Configura data e hora da alteracao da pessoa
	 * @param altDH {@link Date} com a data e hora da alteracao da pessoa
	 */
	public void setAltDH(Date altDH) {
		this.altDH = altDH;
	}
	
	public PessoaDTO toView() {
	    PessoaDTO pessoaDTO = new PessoaDTO();
	    
	    pessoaDTO.setIdPessoa(this.getIdPessoa());
	    
	    if(this.getContato() != null) {
	        pessoaDTO.setContato(this.getContato().toView());
	        pessoaDTO.getContato().setPessoa(pessoaDTO);
	    }
	    
	    pessoaDTO.setTpPessoa(this.getTpPessoa()                             );
	    pessoaDTO.setNome    (StringUtils.trimToEmpty    (this.getNome    ()));
	    pessoaDTO.setRG      (StringUtils.trimToEmpty    (this.getRG      ()));
	    pessoaDTO.setCPF     (StringUtils.trimToEmpty    (this.getCPF     ()));
	    pessoaDTO.setDataNasc(Util.converteDateParaString(this.getDataNasc()));
	    pessoaDTO.setIncDH   (Util.converteDateParaString(this.getIncDH   ()));
	    pessoaDTO.setIncDH   (Util.converteDateParaString(this.getIncDH   ()));
	    pessoaDTO.setAltDH   (Util.converteDateParaString(this.getAltDH   ()));
	    
	    return pessoaDTO;
	}
}