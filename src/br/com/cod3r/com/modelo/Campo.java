package br.com.cod3r.com.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.cod3r.com.excecao.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;

	private boolean aberto = false;

	private boolean minado = false;

	private boolean marcado = false;

	private List<Campo> vizinhos = new ArrayList<>();

	public Campo(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}

	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = linha != vizinho.linha;
		boolean colunaDiferente = coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;

		int deltaLinha = Math.abs(linha - vizinho.linha);
		int deltaColuna = Math.abs(linha - vizinho.coluna);
		int deltaGeral = deltaColuna + deltaLinha;

		if (deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;

		} else if (deltaGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		} else {
			return false;
		}
	}

	void alternarMarcacao() {
		if (!aberto) {
			marcado = !marcado;

		}
	}

	boolean abrir() {

		if (!aberto && !marcado) {
			aberto = true;

			if (minado) {
				throw new ExplosaoException();
			}

			if (vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());// Este m�todo faz que os vizinhos tamb�m chamem o m�todo abrir

			}
			return true;

		} else {
			return false;
		}

	}

	boolean vizinhancaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);

	}

	void minar() {
		minado = true;
	}

	public boolean isMarcado() {
		return marcado;
	}

	public boolean isAberto() {
		return aberto;
	}

	public boolean isFechado() {
		return !aberto;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}

	boolean objetivoAlcancado() {
		boolean desvendado = !minado && aberto;
		boolean protegido = minado && marcado;
		return desvendado || protegido;
	}

	long minasNaVizinhanca() {
		return vizinhos.stream().filter(v -> v.minado).count();

	}

	void reiniciar() {
		aberto = false;
		minado = false;
		marcado = false;
	}
	
	
	public String toString() {
		if(marcado) {
			return "X";
		}else if(aberto && minado ) {
			return "*";
		}else if(aberto && minasNaVizinhanca()>0) {
			return Long.toString(minasNaVizinhanca());
		}else if(aberto) {
			return " ";
		}else {
			return "?";
		}
	}

}
