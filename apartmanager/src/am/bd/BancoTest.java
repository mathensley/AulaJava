package am.bd;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class BancoTest {
	
	Banco c;
	
	@Test
	public void testConection(){
		assertNotNull(Banco.conectarBanco());
	}
	
	@Test
	public void testTable(){
		try {
			assertTrue(Banco.isTable(Banco.conectarBanco(), "cadastro"));
		} catch (SQLException e) {
			fail("Table não existe");
		}
	}
}
