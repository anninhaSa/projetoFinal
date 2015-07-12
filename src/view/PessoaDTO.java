package view;

import entity.Contato;
import entity.Pessoa;

public class PessoaDTO {

	private Integer idPessoa;
	private String nome;
	private String dataNasc;
	private String rg;
	private String cpf;
	private Integer tpPessoa;
	private ContatoDTO contato;
	private String incDH;
	private String altDH;

	/**
	 * Construtor da classe {@link PessoaDTO} (inicializa todos os atributos).
	 */
	public PessoaDTO() {
		setIdPessoa(0);
		setNome("");
		setDataNasc("");
		setRG("");
		setCPF("");
		setTpPessoa(0);
		setContato(new ContatoDTO());
	}

	/**
	 * Construtor da classe {@link PessoaDTO} com os atributos DA CLASSE parametrizados.
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
	 */
	public PessoaDTO(Integer idPessoa, String nome, String dataNasc, String rg, String cpf, Integer tpPessoa) {
		setIdPessoa(idPessoa);
		setNome(nome);
		setDataNasc(dataNasc);
		setRG(rg);
		setCPF(cpf);
		setTpPessoa(tpPessoa);
		setContato(new ContatoDTO());
	}

	/**
	 * Construtor da classe {@link Pessoa} com TODOS os atributos parametrizados
	 * (os atributos da classe e os objetos de outras classes que estao
	 * relacionados com {@link Pessoa}).
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
	 * @param contato
	 *            {@link Contato}
	 */
	public PessoaDTO(Integer idPessoa, String nome, String dataNasc, String rg, String cpf, Integer tpPessoa, ContatoDTO contato) {
		setIdPessoa(idPessoa);
		setNome(nome);
		setDataNasc(dataNasc);
		setRG(rg);
		setCPF(cpf);
		setTpPessoa(tpPessoa);
		setContato(contato);
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

	/**
	 * Configura Id da pessoa.
	 * 
	 * @return Id da pessoa
	 */
	public Integer getIdPessoa() {
		return idPessoa;
	}

	/**
	 * Coleta Id da pessoa.
	 * 
	 * @param idPessoa
	 */
	public void setIdPessoa(Integer idPessoa) {
		this.idPessoa = idPessoa;
	}

	/**
	 * Coleta o nome da pessoa.
	 * 
	 * @return nome da pessoa.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Configura o nome da pessoa.
	 * 
	 * @param nome nome da pessoa
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Coleta a data de nascimento.
	 * 
	 * @return data de nascimento
	 */
	public String getDataNasc() {
		return dataNasc;
	}

	/**
	 * Configura a data de nascimento.
	 * 
	 * @param dataNasc data de nascimento
	 */
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	/**
	 * Coleta o RG.
	 * 
	 * @return RG
	 */
	public String getRG() {
		return rg;
	}

	/**
	 * Configura o RG.
	 * 
	 * @param rg RG
	 */
	public void setRG(String rg) {
		this.rg = rg;
	}

	/**
	 * Coleta o CPF.
	 * 
	 * @return CPF
	 */
	public String getCPF() {
		return cpf;
	}

	/**
	 * Configura o CPF.
	 * 
	 * @param cpf CPF
	 */
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

	/**
	 * Coleta contato.
	 * 
	 * @return {@link ContatoDTO}
	 */
	public ContatoDTO getContato() {
		return contato;
	}

	/**
	 * Configura contato.
	 * 
	 * @param contato {@link ContatoDTO}
	 */
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
}