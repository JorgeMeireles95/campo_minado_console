package br.com.cod3r.com.modelo;

import static  org.junit.jupiter.api.Assertions.assertFalse;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CampoTeste {
	
	private Campo campo;
	
	
	
	@BeforeEach // É CHAMADO A CADA FUNÇÃO
	void inciarCampo() {
		 campo = new Campo(3,3);
	}
	
	
	
	
	
	@Test
	void testeVizinhoRealDistanciaEsquerda() {
		
		Campo vizinhoEsquerda = new Campo(3,2);//Esquerda
		boolean resultadoEsquerda = campo.adicionarVizinho(vizinhoEsquerda);
		assertTrue(resultadoEsquerda);
	}
	
	
	@Test	
	void testeVizinhoRealDistanciaDireita() {
		Campo vizinhoDireita = new Campo(3,4);//Direita
		boolean resultadoDireita = campo.adicionarVizinho(vizinhoDireita);
		assertTrue(resultadoDireita);
		
	}
		
		
	@Test	
	void testeVizinhoRealDistanciaEmCima() {
		Campo vizinhoEmCima = new Campo(2,3);//Em cima
		boolean resultadoEmCima = campo.adicionarVizinho(vizinhoEmCima);
		assertTrue(resultadoEmCima);
		
		
	}
		
	@Test	
	void testeVizinhoRealDistanciaEmbaixo() {
		Campo vizinhoEmbaixo = new Campo(4,3);//Embaixo
		boolean resultadoEmbaixo = campo.adicionarVizinho(vizinhoEmbaixo);
		assertTrue(resultadoEmbaixo);
	}
	
	
	
	@Test	
	void testeVizinhoRealDistanciaDiagonal(){
		Campo vizinhoDiagonal = new Campo(2,2);//Diagonal
		boolean resultadoDiagonal= campo.adicionarVizinho(vizinhoDiagonal);
		assertTrue(resultadoDiagonal);
	}
	
	
	@Test	
	void testeNaoVizinho(){
		Campo NaoVizinho = new Campo(1,1);//Diagonal
		boolean resultadoNaoVizinho= campo.adicionarVizinho(NaoVizinho);
		assertFalse(resultadoNaoVizinho);
	}
	
	

}
