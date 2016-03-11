package view;

import org.apache.commons.lang.StringUtils;

import util.Util;
import entity.Pessoa;

/**
 * Classe (camada de visão - DTO: Data Transfer Object) com atributos da pessoa (cliente e funcionario).
 */
public class PessoaDTO {

	private Integer    idPessoa;
	private String     nome;
	private String     dataNasc;
	private String     rg;
	private String     cpf;
	private Integer    tpPessoa;
	private ContatoDTO contato;
	private String     incDH;
	private String     altDH;

	public PessoaDTO() {
		setIdPessoa(0               );
		setNome    (""              );
		setDataNasc(""              );
		setRG      (""              );
		setCPF     (""              );
		setTpPessoa(0               );
		setContato (new ContatoDTO());
	}

	/**
	 * Construtor da classe {@link PessoaDTO} com TODOS os atributos parametrizados
	 * (os atributos da classe e os objetos de outras classes que estao
	 * relacionados com {@link PessoaDTO}).
	 * 
	 * @param idPessoa Codigo identificador da pessoa
	 * @param nome Nome da Pessoa
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param tpPessoa
	 *            Tipo de Pessoa: <div style="margin-left: 60px">
	 *            <ul>
	 *            <li>1 - Cliente</li>
	 *            <li>2 - Funcionario</li>
	 *            <li>3 - Administrador</li>
	 *            </ul>
	 *            </div>
	 * @param contato {@link ContatoDTO}
	 */
	public PessoaDTO(Integer idPessoa, String nome, String dataNasc, String rg, String cpf, Integer tpPessoa, ContatoDTO contato) {
		setIdPessoa(idPessoa);
		setNome    (nome    );
		setDataNasc(dataNasc);
		setRG      (rg      );
		setCPF     (cpf     );
		setTpPessoa(tpPessoa);
		setContato (contato );
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Pessoa [idPessoa=" + idPessoa + ", nome="     + nome     +
			   ", dataNasc="       + dataNasc + ", rg="       + rg       + 
			   ", cpf="            + cpf      + ", tpPessoa=" + tpPessoa +
			   ", contato="        + contato  + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		boolean bEquals = false;
		Pessoa p;

		if (obj instanceof Pessoa) {
			p = (Pessoa) obj;

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

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
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
	 * 
	 * @return <b>1</b> caso o tipo de pessoa seja <i>Cliente</i>, <b>2</b> caso
	 *         seja <i>Funcionario</i> e <b>3</b> caso seja <i>Administrador</i>.
	 */
	public Integer getTpPessoa() {
		return tpPessoa;
	}

	/**
	 * Configura o tipo de pessoa.
	 * <ul>
	 * <li>1 - Cliente</li>
	 * <li>2 - Funcionario</li>
	 * <li>3 - Administrador</li>
	 * </ul>
	 * 
	 * @param tpPessoa tipo de pessoa
	 */
	public void setTpPessoa(Integer tpPessoa) {
		this.tpPessoa = tpPessoa;
	}

	public ContatoDTO getContato() {
		return contato;
	}

	public void setContato(ContatoDTO contato) {
		this.contato = contato;
	}

	/**
	 * Coleta a data e a hora da inclusao dos dados cadastrais da pessoa
	 * 
	 * @return data e a hora da inclusao dos dados cadastrais da pessoa
	 */
	public String getIncDH() {
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusao dos dados cadastrais da pessoa
	 * 
	 * @param incDH data e a hora da inclusao dos dados cadastrais da pessoa
	 */
	public void setIncDH(String incDH) {
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteracao dos dados cadastrais da pessoa
	 * 
	 * @return a data e a hora da alteracao dos dados cadastrais da pessoa
	 */
	public String getAltDH() {
		return altDH;
	}

	/**
	 * Configura data e hora da alteracao dos dados cadastrais da pessoa
	 * 
	 * @param altDH data e hora da alteracao dos dados cadastrais da pessoa
	 */
	public void setAltDH(String altDH) {
		this.altDH = altDH;
	}
	
	public Pessoa toEntity() {
	    Pessoa pessoa = new Pessoa();
	    
	    pessoa.setIdPessoa(this.getIdPessoa());
	    
	    pessoa.setNome(StringUtils.trimToNull(this.getNome()));
	    
	    if(StringUtils.trimToNull(this.getRG()) != null) {
	        pessoa.setRG(StringUtils.trimToEmpty(this.getRG()).replaceAll("[.]", "").replaceAll("[-]", ""));
	    }
	    
	    if(StringUtils.trimToNull(this.getCPF()) != null) {
	        pessoa.setCPF(StringUtils.trimToEmpty(this.getCPF()).replaceAll("[.]", "").replaceAll("[-]", ""));
	    }
	    
	    if(!StringUtils.isEmpty(this.getDataNasc())) {
	        pessoa.setDataNasc(Util.converteStringParaDate(this.getDataNasc()));
	    } else {
	        pessoa.setDataNasc(null);
	    }
	    
	    if(this.getContato() != null) {
	        pessoa.setContato(this.getContato().toEntity());
	        pessoa.getContato().setPessoa(pessoa);
	    }
	    
	    return pessoa;
	}
}