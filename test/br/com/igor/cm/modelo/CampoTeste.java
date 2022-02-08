package br.com.igor.cm.modelo;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.igor.cm.excecao.ExplosaoException;

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
	@Test
	void testeVizinho3() {
		Campo c2 = new Campo(3,3);
		boolean resultado = c1.adicionarvizinho(c2);
		assertTrue(resultado);
	}
	@Test
	void alternarMarcação() {
		c1.alternarmarcacao();
		boolean resultado = c1.isMarcado();
		assertTrue(resultado);
	}
	@Test
	void alternarMarcação2() {
		c1.alternarmarcacao();
		c1.alternarmarcacao();
		boolean resultado = c1.isMarcado();
		assertFalse(resultado);
	}
	@Test
	void abrirnormal() {
		c1.abrir();
		boolean resultado = c1.isAberto();
		assertTrue(resultado);
	}
	@Test
	void abrirvizinho() {
		Campo c2 = new Campo(3,3);
		Campo c3 = new Campo(4,4);
		c1.adicionarvizinho(c2);
		c2.adicionarvizinho(c3);
		c1.abrir();
		boolean resultado = c3.isAberto();
		assertTrue(resultado);
	}
	@Test
	void abrirmarcado() {
		c1.alternarmarcacao();
		c1.abrir();
		boolean resultado = c1.isAberto();
		assertFalse(resultado);
	}
	@Test
	void abriraberto() {
		c1.abrir();
		assertFalse(c1.abrir());
	}
	@Test
	void abrirMinado() {
		c1.minar();
		assertThrows(ExplosaoException.class,()->{
			c1.abrir();
		});
	}
	@Test
	void objetivo() {
		c1.abrir();
		assertTrue(c1.objetivoAlcancado());
	}
	@Test
	void objetivo2() {
		c1.minar();
		c1.alternarmarcacao();
		assertTrue(c1.objetivoAlcancado());
	}
	@Test
	void resetarAberto() {
		c1.abrir();
		c1.reiniciar();
		assertFalse(c1.isAberto());
	}
	@Test
	void toStringMarcado() {
		c1.alternarmarcacao();
		boolean resultado = c1.toString() == "X";
		assertTrue(resultado);
	}
	@Test
	void toStringAbertoMinado() {
		c1.minar();
		try {
			c1.abrir();
		} catch (Exception e) {
			boolean resultado = c1.toString() == "*";
			assertTrue(resultado);
		}		
	}
	@Test
	void toStringMinasNaVizinhaça() {
		Campo c2 = new Campo(3,3);
		Campo c3 = new Campo(4,4);
		c3.minar();
		c1.adicionarvizinho(c2);
		c2.adicionarvizinho(c3);
		c1.abrir();
		boolean resultado = c2.toString() == "1";
		assertTrue(resultado);
	}
	@Test
	void toStringAberto() {
		c1.abrir();
		boolean resultado = c1.toString() == " ";
		assertTrue(resultado);
	}
	@Test
	void toStringNormal() {
		boolean resultado = c1.toString() == "?";
		assertTrue(resultado);
	}
	
	
	
	
	
	
	
	
	
}





