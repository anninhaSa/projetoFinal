package validate;

import junit.framework.TestCase;

import org.junit.Test;

import view.ClienteDTO;
import view.ContatoDTO;
import view.EnderecoDTO;

public class ValidaCliente_test extends TestCase {
	ValidadorPessoa valida = new ValidadorPessoa();
	
	@Test
	public void test_cliente_valido_totalmente_preenchido() {
		assertTrue(valida.aplica(coletaClienteValido().toEntity()).isOk());
	}
	
	//TODO S� os campos obrigat�rios preenchidos
	//TODO Um dos campos obrigat�rios n�o preenchido
	
	@Test
	public void test_cliente_nome_vazio() {
		ClienteDTO c = coletaClienteValido();
		
		c.setNome("");
		
		assertFalse(valida.aplica(c.toEntity()).isOk());
	}
	
	@Test
	public void test_cliente_nome_nulo() {
		ClienteDTO c = coletaClienteValido();
		
		c.setNome(null);
		
		assertFalse(valida.aplica(c.toEntity()).isOk());
	}
	
	@Test
	public void test_cliente_CPF_invalido() {
		ClienteDTO c = coletaClienteValido();
		
		c.setCPF("076.799.577-01");
		
		assertFalse(valida.aplica(c.toEntity()).isOk());
	}
	
	@Test
	public void test_cliente_CPF_vazio() {
		ClienteDTO c = coletaClienteValido();
		
		c.setCPF("");
		
		assertTrue(valida.aplica(c.toEntity()).isOk());
	}
	
	@Test
	public void test_cliente_CPF_nulo() {
		ClienteDTO c = coletaClienteValido();
		
		c.setCPF(null);
		
		assertTrue(valida.aplica(c.toEntity()).isOk());
	}
	
	public ClienteDTO coletaClienteValido() {
		ClienteDTO anna = new ClienteDTO(0, "Anna", "03/11/1986", "", "076.799.177-01", null, null, null, "");
		
		anna.setContato(new ContatoDTO(0, "annasa03@gmail.com.br", anna, null, "", "", "")); 
		anna.getContato().setPessoa(anna);
		anna.getContato().setEndereco(new EnderecoDTO(0, "Rua do Coelho", 773, "casa 3", "Baldeador", "Niteroi", "RJ", "24140050", anna.getContato()));
		anna.getContato().setTelResidencial("(21)2625-2115");
		anna.getContato().setTelComercial("(21)3233-5200");
		anna.getContato().setTelCelular("(21)9955-82559");
		
		return anna;
	}
}