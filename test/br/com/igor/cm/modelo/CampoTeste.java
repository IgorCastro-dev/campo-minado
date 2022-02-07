package br.com.igor.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

public class CampoTeste {
	Campo c1 = new Campo(2,2);
	
	
	@Test
	void testeVizinho() {
		Campo c2 = new Campo(3,2);
		boolean resultado = c1.adicionarvizinho(c2);
		assertTrue(resultado);
	}
	@Test
	void testeVizinho2() {
		Campo c2 = new Campo(5,5);
		boolean resultado = c1.adicionarvizinho(c2);
		assertFalse(resultado);
	}
}
