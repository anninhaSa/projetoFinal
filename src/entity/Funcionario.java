package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Classe com atributos do funcionário.
 */
@Entity
public class Funcionario extends Pessoa
{
	@OneToMany( mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Agendamento> listAgendamento;
	
	@OneToMany( mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Atendimento> listAtendimento;
	
	@OneToOne( mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private Autenticacao autenticacao;
	
	/**
	 * Construtor da classe {@link Funcionario}.
	 */
	public Funcionario( )
	{
		super( );
		setTpPessoa       ( s_nFuncionario                );
		setListAgendamento( new ArrayList<Agendamento>( ) );
		setListAtendimento( new ArrayList<Atendimento>( ) );
		setAutenticacao   ( new Autenticacao( )           );
	}
	
	/**
	 * Construtor da classe {@link Funcionario} com os atributos da classe básica ({@link Pessoa}) parametrizados.
	 * @param intIdPessoa Código identificador da pessoa
	 * @param strNome Nome da Pessoa 
	 * @param dtDataNasc Data de Nascimento
	 * @param strRG RG
	 * @param strCPF CPF
	 * @param contato {@link Contato}
	 */
	public Funcionario( Integer intIdPessoa, String strNome, Date    dtDataNasc,
						String  strRG,       String strCPF,  Contato contato )
	{
		setTpPessoa       ( s_nFuncionario                );
		setIdPessoa       ( intIdPessoa                   );
		setNome           ( strNome                       );
		setDataNasc       ( dtDataNasc                    );
		setRG             ( strRG                         );
		setCPF            ( strCPF                        );
		setContato        ( contato                       );
		setListAgendamento( new ArrayList<Agendamento>( ) );
		setListAtendimento( new ArrayList<Atendimento>( ) );
		setAutenticacao   ( new Autenticacao          ( ) );
	}

	/**
	 * Construtor da classe {@link Funcionario} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Funcionario}).
	 * @param intIdPessoa Código identificador da pessoa
	 * @param strNome Nome da Pessoa 
	 * @param dtDataNasc Data de Nascimento
	 * @param strRG RG
	 * @param strCPF CPF
	 * @param contato {@link Contato}
	 * @param listAgendamento lista com os {@link Agendamento}s do cliente
	 * @param listAtendimento lista com os {@link Atendimento}s do cliente
	 * @param autenticacao {@link Autenticacao}
	 */
	public Funcionario( Integer      intIdPessoa, String  strNome, Date              dtDataNasc,      String            strRG,
                        String       strCPF,      Contato contato, List<Agendamento> listAgendamento, List<Atendimento> listAtendimento,
                        Autenticacao autenticacao )
	{
		setTpPessoa       ( s_nFuncionario  );
		setIdPessoa       ( intIdPessoa     );
		setNome           ( strNome         );
		setDataNasc       ( dtDataNasc      );
		setRG             ( strRG           );
		setCPF            ( strCPF          );
		setContato        ( contato         );
		setListAgendamento( listAgendamento );
		setListAtendimento( listAtendimento );
		setAutenticacao   ( autenticacao    );
	}
	
	/**
	 * Construtor da classe {@link Funcionario} com os atributos cadastrais do funcionário.
	 * @param strNome Nome da Pessoa 
	 * @param dtDataNasc Data de Nascimento
	 * @param strRG RG
	 * @param strCPF CPF
	 */
	public Funcionario( String strNome, Date dtDataNasc, String strRG, String strCPF )
	{
		setTpPessoa( s_nFuncionario );
		setNome    ( strNome        );
		setDataNasc( dtDataNasc     );
		setRG      ( strRG          );
		setCPF     ( strCPF         );
	}
	
 	/**
	 * Coleta a lista de agendamento do funcionário.
	 * @return lista do tipo {@link Agendamento} 
	 */
	public List<Agendamento> getListAgendamento( )
	{
		return listAgendamento;
	}

	/**
	 * Configura a lista de agendamento do funcionário.
	 * @param listAgendamento lista do tipo {@link Agendamento}
	 */
	public void setListAgendamento( List<Agendamento> listAgendamento )
	{
		this.listAgendamento = listAgendamento;
	}

	/**
	 * Coleta a lista de atendimento do funcionário.
	 * @return
	 */
	public List<Atendimento> getListAtendimento( )
	{
		return listAtendimento;
	}

	/**
	 * Configura a lista de atendimento do funcionário.
	 * @param listAtendimento lista do tipo {@link Atendimento}
	 */
	public void setListAtendimento( List<Atendimento> listAtendimento )
	{
		this.listAtendimento = listAtendimento;
	}

	/**
	 * Coleta a autenticacao do usuário
	 * @return {@link Autenticacao}
	 */
	public Autenticacao getAutenticacao( )
	{
		return autenticacao;
	}

	/**
	 * Configura a autenticacao do funcionário.
	 * @param Autenticacao {@link Autenticacao}
	 */
	public void setAutenticacao( Autenticacao autenticacao )
	{
		this.autenticacao = autenticacao;
	}
}