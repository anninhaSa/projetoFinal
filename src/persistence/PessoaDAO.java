package persistence;

import java.util.ArrayList;

import util.PessoaUtil;
import entity.Cliente;
import entity.Funcionario;
import entity.Pessoa;

public class PessoaDAO extends DAO
{
	/**
	 * Coleta a(s) {@link Pessoa}(s) a partir do nome.
	 * @param nome nome da pessoa
	 * @return {@link ArrayList} de {@link Pessoa}.
	 */
	public ArrayList<?> coletaPessoaByNome( String nome )
	{
		String strWhere = 
		    "  WHERE UPPER(p.nome) like '" + nome.toUpperCase( ) + "%' ";
		
		return coletaPessoa( strWhere );
	}
	
	/**
	 * Coleta a(s) {@link Pessoa}(s) a partir do celular.
	 * @param ddd ddd do celular
	 * @param celular número do celular
	 * @return {@link ArrayList} de {@link Pessoa}, {@link Cliente} ou {@link Funcionario}.
	 */
	public ArrayList<?> coletaPessoaByCelular( String ddd, String celular )
	{
		String strWhere = 
		    "  WHERE c.dddCelular = '" + ddd     + "' \n" +
			"    AND c.telCelular = '" + celular + "' ";
		
		return coletaPessoa( strWhere );
	}
	
	/**
	 * Coleta {@link Pessoa}(s) a partir do nome e do celular.
	 * @param nome nome da pessoa
	 * @param ddd ddd do celular
	 * @param celular número do celular
	 * @return {@link ArrayList} de {@link Pessoa}, {@link Cliente} ou {@link Funcionario}.
	 */
	public ArrayList<?> coletaPessoaByNomeAndCelular( String nome, String ddd, String celular )
	{
		String strWhere = 
		    "  WHERE UPPER(p.nome) like '" + nome.toUpperCase( ) + "%' \n" +
		    "    AND c.dddCelular  =    '" + ddd                 + "'  \n" +
		    "    AND c.telCelular  =    '" + celular             + "' ";
		
		return coletaPessoa( strWhere );
	}
	
	/**
	 * Coleta todas as {@link Pessoa}(s) cadastradas.
	 * @param strWhere cláusula where com o filtro da query
	 * @return {@link ArrayList} de {@link Pessoa}, {@link Cliente} ou {@link Funcionario}.
	 */
	public ArrayList<?> coletaTodasAsPessoas( )
	{
		return coletaPessoa( "" );
	}
	
	/**
	 * Coleta {@link Pessoa}(s).
	 * @param strWhere cláusula where com o filtro da query
	 * @return {@link ArrayList} de {@link Pessoa}, {@link Cliente} ou {@link Funcionario}.
	 */
	private ArrayList<?> coletaPessoa( String strWhere )
	{
		ArrayList<Pessoa> listPessoa = new ArrayList<Pessoa>( );
		Pessoa            pessoa;
		Cliente           cliente;
		Funcionario       funcionario;
		boolean           bClienteDao = this instanceof ClienteDAO;
		
		String strClienteJoin     = bClienteDao                    ? "  INNER JOIN cliente     cli  ON p.idpessoa  = cli.idpessoa  \n" : "";
		String strFuncionarioJoin = this instanceof FuncionarioDAO ? "  INNER JOIN funcionario func ON p.idpessoa  = func.idpessoa \n" : "";
		String strClienteCampo    = bClienteDao                    ? "        , cli.observacao obs" : "";
		
		strWhere = strWhere != null ? strWhere : "";
		
		try
		{
			open( );
			
			ps = con.prepareStatement(
			    " SELECT p.idpessoa       idPessoa,       p.nome           nome,           p.dataNasc     dataNasc,     \n" +
			    "        p.cpf            cpf,            p.rg             rg,             p.tpPessoa     tpPessoa,     \n" +
			    "        c.idContato      idContato,      c.email          email,          c.dddCelular   dddCelular,   \n" +
			    "        c.telCelular     telCelular,     c.dddComercial   dddComercial,   c.telComercial telComercial, \n" +
			    "        c.dddResidencial dddResidencial, c.telResidencial telResidencial, e.idEndereco   idEndereco,   \n" +
			    "        e.logradouro     logradouro,     e.numero         numero,         e.complemento  complemento,  \n" +
			    "        e.bairro         bairro,         e.cidade         cidade,         e.uf           uf,           \n" +
			    "        e.cep            cep                                                                           \n" +
			    strClienteCampo                                                                                             +
			    "   FROM pessoa p                                                                                       \n" +
			    "   LEFT JOIN contato  c ON p.idpessoa  = c.id_pessoa                                                   \n" +
			    "   LEFT JOIN endereco e ON c.idcontato = e.id_contato                                                  \n" +
			    strClienteJoin                                                                                              +
			    strFuncionarioJoin                                                                                          +
			    strWhere );
			
			rs = ps.executeQuery( );
			
			while( rs.next( ) )
			{
				
				pessoa = new Pessoa( );
				
				//Pessoa
				pessoa.setIdPessoa( rs.getInt   ( "idPessoa" ) );
				pessoa.setNome    ( rs.getString( "nome"     ) );
				pessoa.setDataNasc( rs.getDate  ( "dataNasc" ) );
				pessoa.setCPF     ( rs.getString( "cpf"      ) );
				pessoa.setRG      ( rs.getString( "rg"       ) );
				pessoa.setTpPessoa( rs.getInt   ( "tpPessoa" ) );
				
				//Contato
				pessoa.getContato( ).setPessoa( pessoa );
				
				pessoa.getContato( ).setIdContato( rs.getInt    ( "idContato" ) );
				pessoa.getContato( ).setEmail    ( rs.getString ( "email"     ) );
				
				//Endereço
				pessoa.getContato( ).getEndereco( ).setContato( pessoa.getContato( ) );
				
				pessoa.getContato( ).getEndereco( ).setIdEndereco ( rs.getInt   ( "idEndereco"  ) );
				pessoa.getContato( ).getEndereco( ).setLogradouro ( rs.getString( "logradouro"  ) );
				pessoa.getContato( ).getEndereco( ).setNumero     ( rs.getInt   ( "numero"      ) );
				pessoa.getContato( ).getEndereco( ).setComplemento( rs.getString( "complemento" ) );
				pessoa.getContato( ).getEndereco( ).setBairro     ( rs.getString( "bairro"      ) );
				pessoa.getContato( ).getEndereco( ).setCidade     ( rs.getString( "cidade"      ) );
				pessoa.getContato( ).getEndereco( ).setUF         ( rs.getString( "uf"          ) );
				pessoa.getContato( ).getEndereco( ).setCep        ( rs.getString( "cep"         ) );
				
				//Telefone Residencial
				pessoa.getContato( ).setDddResidencial( rs.getString( "dddResidencial" ) );
				pessoa.getContato( ).setTelResidencial( rs.getString( "telResidencial" ) );
				
				//Telefone Comercial
				pessoa.getContato( ).setDddComercial( rs.getString( "dddComercial" ) );
				pessoa.getContato( ).setTelComercial( rs.getString( "telComercial" ) );
				
				//Celular
				pessoa.getContato( ).setDddCelular( rs.getString( "dddCelular" ) );
				pessoa.getContato( ).setTelCelular( rs.getString( "telCelular" ) );
				
				if( this instanceof ClienteDAO )
				{
					cliente = PessoaUtil.convertePessoa2Cliente( pessoa );
					
					cliente.setObservacao( rs.getString( "obs" ) );
					listPessoa.add( cliente );
				}
				else if( this instanceof FuncionarioDAO )
				{
					funcionario = PessoaUtil.convertePessoa2Funcionario( pessoa );
					
					listPessoa.add( funcionario );
				}
				else
					listPessoa.add( pessoa );
			}
			
			rs.close( );
			ps.close( );
			
			close( );
		}
		catch ( Exception e )
		{
			System.out.println( "coletaClienteByCelular: " + e );
		}
		
		return listPessoa.size( ) > 0 ? listPessoa : null;
    }
}