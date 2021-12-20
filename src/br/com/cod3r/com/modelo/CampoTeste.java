package br.com.cod3r.com.modelo;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.cod3r.com.excecao.ExplosaoException;

public class CampoTeste {

	private Campo campo;

	@BeforeEach // É CHAMADO A CADA FUNÇÃO
	void inciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeVizinhoRealDistanciaEsquerda() {

		Campo vizinhoEsquerda = new Campo(3, 2);// Esquerda
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
	}

	@Test
	void testeVizinhoRealDistanciaDireita() {
		Campo vizinhoDireita = new Campo(3, 4);// Direita
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);

	}

	@Test
	void testeVizinhoRealDistanciaEmCima() {
		Campo vizinhoEmCima = new Campo(2, 3);// Em cima
		boolean resultadoEmCima = campo.adicionarVizinho(vizinhoEmCima);
		assertTrue(resultadoEmCima);

	}

	@Test
	void testeVizinhoRealDistanciaEmbaixo() {
		Campo vizinhoEmbaixo = new Campo(4, 3);// Embaixo
		boolean resultadoEmbaixo = campo.adicionarVizinho(vizinhoEmbaixo);
		assertTrue(resultadoEmbaixo);
	}

	@Test
	void testeVizinhoRealDistanciaDiagonal() {
		Campo vizinhoDiagonal = new Campo(2, 2);// Diagonal
		boolean resultadoDiagonal = campo.adicionarVizinho(vizinhoDiagonal);
		assertTrue(resultadoDiagonal);
	}

	@Test
	void testeNaoVizinho() {
		Campo NaoVizinho = new Campo(1, 1);// Diagonal
		boolean resultadoNaoVizinho = campo.adicionarVizinho(NaoVizinho);
		assertFalse(resultadoNaoVizinho);
	}

	@Test
	void testeAlternarMarcacao() {
		campo.alternarMarcacao();
		assertTrue(campo.isMarcado());
	}

	@Test
	void testeValorPadraoAtributosMarcado() {
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAlternarMarcacaoDuasChamadas() {
		campo.alternarMarcacao();
		campo.alternarMarcacao();
		assertFalse(campo.isMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcacao();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcacao();
		campo.minar();
		assertFalse(campo.abrir());

	}

	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();
		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}

	@Test
	void testeAbrirComVizinhos1() {

		Campo campo11 = new Campo(1, 1);

		Campo campo22 = new Campo(2, 2);

		campo22.adicionarVizinho(campo11);

		campo.adicionarVizinho(campo22);
		campo.abrir();

		assertTrue(campo22.isAberto() && campo11.isAberto());

	}
	
	
	@Test
	void testeAbrirComVizinhos2() {

		Campo campo11 = new Campo(1, 1);
		Campo campo12 = new Campo(1, 1);
		campo12.minar();
		
		
		Campo campo22 = new Campo(2, 2);
		campo22.adicionarVizinho(campo12);
		campo22.adicionarVizinho(campo11);

		campo.adicionarVizinho(campo22);
		campo.abrir();

		assertTrue(campo22.isAberto() && !campo11.isAberto());

	}

	
	
	
	
	
	
}
