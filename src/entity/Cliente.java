package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * Classe com os atributos do cliente.
 */
@Entity
public class Cliente extends Pessoa
{
	@Column( length = 250 )
	private String observacao;
	
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Agendamento> listAgendamento;
	
	@OneToMany( mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Atendimento> listAtendimento;
	
	/**
	 * Construtor da classe {@link Cliente}.
	 */
	public Cliente( )
	{
		super( );
		setTpPessoa       ( s_nCliente                    );
		setListAgendamento( new ArrayList<Agendamento>( ) );
		setListAtendimento( new ArrayList<Atendimento>( ) );
		setObservacao     ( new String( )                 );
	}
	
	/**
	 * Construtor da classe {@link Cliente} com os atributos da classe básica ({@link Pessoa}) parametrizados.
	 * @param idPessoa Código identificador da pessoa
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param contato {@link Contato}
	 * @param observacao observação
	 */
	public Cliente( Integer idPessoa, String  nome,    Date   dataNasc, String  rg,
					String  cpf,      Contato contato, String observacao )
	{
		setTpPessoa       ( s_nCliente                    );
		setIdPessoa       ( idPessoa                      );
		setNome           ( nome                          );
		setDataNasc       ( dataNasc                      );
		setRG             ( rg                            );
		setCPF            ( cpf                           );
		setContato        ( contato                       );
		setListAgendamento( new ArrayList<Agendamento>( ) );
		setListAtendimento( new ArrayList<Atendimento>( ) );
		setObservacao     ( observacao                    );
	}
	
	/**
	 * Construtor da classe {@link Cliente} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Cliente}).
	 * @param idPessoa Código identificador da pessoa
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 * @param contato {@link Contato}
	 * @param listAgendamento lista com os {@link Agendamento}s do cliente
	 * @param listAtendimento lista com os {@link Atendimento}s do cliente
	 * @param strObservacao observação
	 */
	public Cliente( Integer idPessoa, String  nome,    Date              dataNasc,        String            rg,
		            String  cpf,      Contato contato, List<Agendamento> listAgendamento, List<Atendimento> listAtendimento,
		            String  observacao )
	{
		setTpPessoa       ( s_nCliente      );
		setIdPessoa       ( idPessoa        );
		setNome           ( nome            );
		setDataNasc       ( dataNasc        );
		setRG             ( rg              );
		setCPF            ( cpf             );
		setContato        ( contato         );
		setListAgendamento( listAgendamento );
		setListAtendimento( listAtendimento );
		setObservacao     ( observacao      );
	}
	
	/**
	 * Construtor da classe {@link Cliente} com TODOS os atributos parametrizados 
	 * (os atributos da classe e os objetos de outras classes que estão relacionados com 
	 * {@link Cliente}).
	 * @param nome Nome da Pessoa 
	 * @param dataNasc Data de Nascimento
	 * @param rg RG
	 * @param cpf CPF
	 */
	public Cliente( String nome, Date dataNasc, String rg, String cpf )
	{
		setTpPessoa( s_nCliente );
		setNome    ( nome       );
		setDataNasc( dataNasc   );
		setRG      ( rg         );
		setCPF     ( cpf        );
	}
	
	/**
	 * Coleta as observações feitas a respeito do cliente.
	 * @return {@link String} com as observações do cliente.
	 */
	public String getObservacao( )
	{
		return observacao;
	}

	/**
	 * Configura a observação feita a respeito do cliente.
	 * @param observacao observação
	 */
	public void setObservacao( String observacao )
	{
		this.observacao = observacao;
	}

	/**
	 * Coleta a lista de agendamento do cliente.
	 * @return lista do tipo {@link Agendamento};
	 */
	public List<Agendamento> getListAgendamento( )
	{
		return listAgendamento;
	}
	
	/**
	 * Configura a lista de agendamento do cliente.
	 * @param listAgendamento lista do tipo {@link Agendamento}
	 */
	public void setListAgendamento( List<Agendamento> listAgendamento )
	{
		this.listAgendamento = listAgendamento;
	}
	
	/**
	 * Coleta a lista de atendimento do cliente
	 * @return lista do tipo {@link Atendimento}
	 */
	public List<Atendimento> getListAtendimento( )
	{
		return listAtendimento;
	}
	
	/**
	 * Configura a lista de atendimento do cliente.
	 * @param listAtendimento lista do tipo {@link Atendimento}
	 */
	public void setListAtendimento( List<Atendimento> listAtendimento )
	{
		this.listAtendimento = listAtendimento;
	}

	@Override
	public String toString() {
		return "Cliente [" + super.toString( ) + ", observacao=" + observacao + "]";
	}
	
	
}