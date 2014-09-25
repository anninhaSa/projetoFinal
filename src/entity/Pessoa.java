package entity;

import java.util.Calendar;
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

/**
 * Classe com atributos da pessoa (cliente e funcionário).
 */
@Entity
@Inheritance      ( strategy = InheritanceType.JOINED                    )
@SequenceGenerator( name     = "seq_pessoa", sequenceName = "seq_pessoa" )
public class Pessoa
{
	public static final transient int s_nCliente       = 1;
	public static final transient int s_nFuncionario   = 2;
	public static final transient int s_nAdministrador = 3;
	
	@Id
	@GeneratedValue( generator = "seq_pessoa" )
	private Integer idPessoa;
	
	@Column( length = 90 )
	private String nome;
	
	@Temporal( value = TemporalType.DATE )
	private Date dataNasc;
	
	private String rg;
	
	@Column( length = 11 )
	private String cpf;
	
	private Integer tpPessoa;
	
	@OneToOne( mappedBy = "pessoa", fetch = FetchType.EAGER, cascade = CascadeType.ALL )
	private Contato contato;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar incDH;
	
	@Temporal( value = TemporalType.TIMESTAMP )
	private Calendar altDH;
	
	/**
	 * Construtor da classe {@link Pessoa} (inicializa todos os atributos).
	 */
	public Pessoa( )
	{
		setIdPessoa( 0              );
		setNome    ( ""             );
		setDataNasc( new Date( )    );
		setRG      ( ""             );
		setCPF     ( ""             );
		setTpPessoa( 0              );
		setContato ( new Contato( ) );
	}

	/**
	 * Construtor da classe {@link Pessoa} com os atributos DA CLASSE parametrizados.
	 * @param idPessoa Código identificador da pessoa
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param tpPessoa Tipo de Pessoa:
	 * <div style="margin-left: 60px">
	 *            <ul> 
	 *                <li>1 - Cliente</li> 
	 *                <li>2 - Funcionário</li>
	 *                <li>3 - Administrador</li>
	 *            </ul>
	 * </div>
	 */
	public Pessoa( Integer idPessoa, String nome, Date    dataNasc,
			       String  rg,       String cpf,  Integer tpPessoa )
	{
		setIdPessoa( idPessoa       );
		setNome    ( nome           );
		setDataNasc( dataNasc       );
		setRG      ( rg             );
		setCPF     ( cpf            );
		setTpPessoa( tpPessoa       );
		setContato ( new Contato( ) );
	}
	
	/**
	 * Construtor da classe {@link Pessoa} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Pessoa}).
	 * @param idPessoa Código identificador da pessoa
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param tpPessoa Tipo de Pessoa:
	 * <div style="margin-left: 60px">
	 *            <ul> 
	 *                <li>1 - Cliente</li> 
	 *                <li>2 - Funcionário</li>
	 *                <li>3 - Administrador</li>
	 *            </ul>
	 * </div>
	 * @param contato {@link Contato}
	 */
	public Pessoa( Integer idPessoa, String  nome,     Date    dataNasc, String rg,
			       String  cpf,      Integer tpPessoa, Contato contato )
	{
		setIdPessoa( idPessoa );
		setNome    ( nome     );
		setDataNasc( dataNasc );
		setRG      ( rg       );
		setCPF     ( cpf      );
		setTpPessoa( tpPessoa );
		setContato ( contato  );
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString( )
	{
		return "Pessoa [idPessoa=" + idPessoa + ", nome="     + nome     +
			   ", dataNasc="       + dataNasc + ", rg="       + rg       +
			   ", cpf="            + cpf      + ", tpPessoa=" + tpPessoa +
			   ", contato="        + contato  + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals( Object obj )
	{
		boolean bEquals = false;
		Pessoa  p;
		
		if( obj instanceof Pessoa )
		{
			p = (Pessoa)obj;
			
			bEquals = p.getNome( ).equals( this.getNome( ) );
		}
		
		return bEquals;
	}
	
	/**
	 * Configura Id da pessoa.
	 * @return Id da pessoa
	 */
	public Integer getIdPessoa( )
	{
		return idPessoa;
	}

	/**
	 * Coleta Id da pessoa.
	 * @param idPessoa
	 */
	public void setIdPessoa( Integer idPessoa )
	{
		this.idPessoa = idPessoa;
	}

	/**
	 * Coleta o nome da pessoa.
	 * @return
	 */
	public String getNome( )
	{
		return nome;
	}
	
	/**
	 * Configura o nome da pessoa.
	 * @param nome nome da pessoa
	 */
	public void setNome( String nome )
	{
		this.nome = nome;
	}
	
	/**
	 * Coleta a data de nascimento.
	 * @return data de nascimento
	 */
	public Date getDataNasc( )
	{
		return dataNasc;
	}

	/**
	 * Configura a data de nascimento.
	 * @param dataNasc data de nascimento
	 */
	public void setDataNasc( Date dataNasc )
	{
		this.dataNasc = dataNasc;
	}

	/**
	 * Coleta o RG.
	 * @return RG
	 */
	public String getRG( )
	{
		return rg;
	}

	/**
	 * Configura o RG.
	 * @param rg RG
	 */
	public void setRG( String rg )
	{
		this.rg = rg;
	}

	/**
	 * Coleta o CPF.
	 * @return CPF
	 */
	public String getCPF( )
	{
		return cpf;
	}

	/**
	 * Configura o CPF.
	 * @param cpf CPF
	 */
	public void setCPF( String cpf )
	{
		this.cpf = cpf;
	}

	/**
	 * Coleta tipo de pessoa.
	 * @return <b>1</b> caso o tipo de pessoa seja <i>Cliente</i>, <b>2</b> caso seja 
	 * <i>Funcionário</i> e <b>3</b> caso seja <i>Administrador</i>.
	 */
	public Integer getTpPessoa( )
	{
		return tpPessoa;
	}

	/**
	 * Configura tipo de pessoa.
	 * <ul> 
	 *     <li>1 - Cliente</li> 
	 *     <li>2 - Funcionário</li>
	 *     <li>3 - Administrador</li>
	 * </ul>
	 * @param tpPessoa tipo de pessoa
	 */
	public void setTpPessoa( Integer tpPessoa )
	{
		this.tpPessoa = tpPessoa;
	}

	/**
	 * Coleta contato.
	 * @return {@link Contato}
	 */
	public Contato getContato( )
	{
		return contato;
	}

	/**
	 * Configura contato.
	 * @param contato {@link Contato}
	 */
	public void setContato( Contato contato )
	{
		this.contato = contato;
	}
	
	/**
	 * Coleta a data e a hora da inclusão da pessoa
	 * @return {@link Calendar} com a data e a hora da inclusão da pessoa
	 */
	public Calendar getIncDH( )
	{
		return incDH;
	}

	/**
	 * Configura a data e a hora da inclusão da pessoa
	 * @param incDH {@link Calendar} com a data e a hora da inclusão da pessoa
	 */
	public void setIncDH( Calendar incDH )
	{
		this.incDH = incDH;
	}

	/**
	 * Coleta a data e a hora da alteração da pessoa
	 * @return {@link Calendar} com a data e a hora da alteração da pessoa
	 */
	public Calendar getAltDH( )
	{
		return altDH;
	}

	/**
	 * Configura data e hora da alteração da pessoa
	 * @param altDH {@link Calendar} com a data e hora da alteração da pessoa
	 */
	public void setAltDH( Calendar altDH )
	{
		this.altDH = altDH;
	}
}