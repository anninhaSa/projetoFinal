package persistence;

import static org.junit.Assert.*;

import org.junit.Test;

import persistence.impl.ClienteDAOImpl;
import persistence.impl.EnderecoDAOImpl;
import entity.Cliente;
import entity.Endereco;

public class EnderecoDAO_tst {

	@Test
	public void testInsereEndereco() {
		boolean     bOk = true;
		EnderecoDAOImpl ed  = new EnderecoDAOImpl();
		ClienteDAOImpl  cd  = new ClienteDAOImpl();
		
		Cliente cliente = cd.coletaClientePeloNome("Anna").get(0);
		
		cliente.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 3", "Baldeador", "Niteroi", "RJ", "24140050", cliente.getContato()));
		
		bOk = ed.insereEndereco(cliente.getContato().getEndereco());
		
		assertTrue(bOk);
		
		cliente = cd.coletaClientePeloNome("Leda").get(0);
		
		cliente.getContato().setEndereco(new Endereco(null, "Rua do Coelho", 773, "casa 1", "Baldeador", "Niteroi", "RJ", "24140050", cliente.getContato()));
		
		bOk = bOk && ed.insereEndereco(cliente.getContato().getEndereco());
		
		assertTrue(bOk);
		
		cliente = cd.coletaClientePeloNome("Deny").get(0);
		
		cliente.getContato().setEndereco(new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 1", "Caramujo", "Niteroi", "RJ", "24140050", cliente.getContato()));
		
		bOk = bOk && ed.insereEndereco(cliente.getContato().getEndereco());
		
		assertTrue(bOk);
		
		cliente = cd.coletaClientePeloNome("Denise").get(0);
		
		cliente.getContato().setEndereco(new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 1", "Caramujo", "Niteroi", "RJ", "24140050", cliente.getContato()));
		
		bOk = bOk && ed.insereEndereco(cliente.getContato().getEndereco());
		
		assertTrue(bOk);
		
		cliente = cd.coletaClientePeloNome("Vitor").get(0);
		
		cliente.getContato( ).setEndereco( new Endereco(null, "Rua Quintino Bocaiuva", 647, "casa 2", "Caramujo", "Niteroi", "RJ", "24140050", cliente.getContato()));
		
		bOk = bOk && ed.insereEndereco(cliente.getContato().getEndereco());
		
		assertTrue(bOk);
	}

	@Test
	public void testAtualizaEndereco() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluiEndereco() {
		fail("Not yet implemented");
	}

	@Test
	public void testColetaEnderecoByIdContato() {
		fail("Not yet implemented");
	}
}
