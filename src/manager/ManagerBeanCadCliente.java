package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.lang.StringUtils;

import service.ClienteService;
import service.impl.ClienteServiceImpl;
import util.Formulario;
import util.StatusRetorno;
import validate.ValidadorPessoa;
import view.ClienteDTO;
import entity.Cliente;

/**
 * Classe responsavel por gerenciar a tela de <i>Cadastro de Cliente</i>.
 */
@ManagedBean(name = "mbCadCliente")
@SessionScoped
public class ManagerBeanCadCliente extends TrataLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<ClienteDTO> clientes;
	private String           nome;
	private String           telefone;
	private ClienteDTO       cliente;
	private ClienteDTO       clienteSelected;
	private ClienteService   clienteService;
	
	public ManagerBeanCadCliente() {
		setClientes       (new ArrayList<ClienteDTO>());
		setNome           (""                         );
		setTelefone       (""                         );
		setClienteSelected(new ClienteDTO()           );
		setCliente        (new ClienteDTO()           );
	}

	public String busca() {
		FacesContext  fc  = FacesContext.getCurrentInstance();
		String        msg = "";
		
		clienteService = new ClienteServiceImpl();
		
		setClientes(new ArrayList<ClienteDTO>());
		
		try {
			setNome    (StringUtils.trimToEmpty(getNome    ()));
			setTelefone(StringUtils.trimToEmpty(getTelefone()));
			
			if(!getNome().isEmpty()) {
			    setClientes(converteListaClienteEntityParaListaClienteDTO(clienteService.coletaClientePeloNome(getNome())));
			} else if(!getTelefone().isEmpty()) {
			    setClientes(converteListaClienteEntityParaListaClienteDTO(clienteService.coletaClientePeloTelefone(getTelefone())));
			} else {
			    setClientes(converteListaClienteEntityParaListaClienteDTO(clienteService.coletaListaClientes()));
			}
		}
		catch(Exception ex) {
			msg = "Erro: " + ex.getMessage();
			ex.printStackTrace();
		}
		
		fc.addMessage(Formulario.s_strFormBuscaCliente, new FacesMessage(msg));
		
		return null;
	}

	public String incluiCliente() {
	    clienteService = new ClienteServiceImpl();
	    
	    FacesContext  fc       = FacesContext.getCurrentInstance();
		StatusRetorno sRetorno = new StatusRetorno();
		
		try {
			sRetorno = clienteService.incluiCliente(getCliente().toEntity());
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			if(sRetorno.isOk()) {
				fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Inserido com sucesso", null));
				
				if(getCliente() != null && getClientes() != null) {
					Cliente clienteEncontrado = clienteService.coletaClientePeloId(cliente.getIdPessoa());
                    setCliente(clienteEncontrado.toView());
					getClientes().add(cliente);
				}
			} else {
				fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, sRetorno.getMsgErro().replace("/n", "<br>"), null));
			}

			setCliente(new ClienteDTO());
		}
		return null;
	}
	
	public String excluiCliente() {
	    clienteService = new ClienteServiceImpl();
		FacesContext fc = FacesContext.getCurrentInstance();
		
		if(getClienteSelected() != null && clienteService.excluiCliente(getClienteSelected().toEntity()).isOk()) {
			fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso", null));
			
			if(getClienteSelected() != null && getClientes() != null) {
				getClientes().remove(getClienteSelected());
			}
		} else {
			fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possível excluir o cliente!", null));
		}
		return null;
	}
	
	public String alteraCliente() {
	    clienteService = new ClienteServiceImpl();
	    
		FacesContext      fc     = FacesContext.getCurrentInstance();
		ValidadorPessoa valida = new ValidadorPessoa();
		String            msg    = "";
		
		if(getClienteSelected() != null) {
			StatusRetorno sRetorno = valida.aplica(getClienteSelected().toEntity());
			
			if(sRetorno.isOk() && clienteService.alteraCliente(getClienteSelected().toEntity()).isOk()) {
				msg = "Cliente alterado com sucesso!";
			} else {
				msg = sRetorno.getMsgErro().replaceAll("\n", "<br>");
			}
		} else {
			msg = "Não foi possível alterar o cliente!";
		}
		
		fc.addMessage("aviso", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, null));
		
		return null;
	}

    private List<ClienteDTO> converteListaClienteEntityParaListaClienteDTO(List<Cliente> clientesEntity) {
        List<ClienteDTO> listaClientesDTO = new ArrayList<ClienteDTO>();
        
        if(clientesEntity != null && clientesEntity.size() > 0) {
            for(Cliente cliente : clientesEntity) {
                listaClientesDTO.add(cliente.toView()) ;
            }
        }
        
        return listaClientesDTO;
    }
	
	/**
	 * Coleta os clientes
	 * @return {@link List} de {@link Cliente}.
	 */
	public List<ClienteDTO> getClientes() {
		return clientes;
	}

	/**
	 * Configura os clientes.
	 * @param clientes {@link List} de {@link ClienteDTO}
	 */
	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
	
	/**
	 * Coleta o nome do cliente informado na busca.
	 * @return nome do cliente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Configura o nome do cliente na busca.
	 * @param nome nome do cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Coleta o telefone do cliente na busca.
	 * @return telefone do cliente
	 */
	public String getTelefone() {
		return telefone;
	}

	/**
	 * Configura o telefone do cliente na busca.
	 * @param telefone telefone do cliente
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	/**
	 * Coleta o {@link ClienteDTO} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @return {@link ClienteDTO}
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * Configura o {@link ClienteDTO} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @param cliente {@link ClienteDTO}
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	/**
	 * Coleta o {@link ClienteDTO} novo da <code>dataTable</code> da tela de Cadastro de cliente.
	 * @return {@link ClienteDTO}
	 */
	public ClienteDTO getClienteSelected() {
		return clienteSelected;
	}

	/**
	 * Configura o {@link ClienteDTO} selecionado na <code>dataTable</code> da tela de Cadastro de cliente.
	 * @param clienteSelected {@link ClienteDTO}
	 */
	public void setClienteSelected(ClienteDTO clienteSelected) {
		this.clienteSelected = clienteSelected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}