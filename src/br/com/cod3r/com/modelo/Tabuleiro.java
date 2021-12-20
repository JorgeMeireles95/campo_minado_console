package br.com.cod3r.com.modelo;

import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

public class Tabuleiro {

	private int linhas;
	private int colunas;
	private int minas;
	private final List<Campo> campos = new ArrayList<>();

	public Tabuleiro(int linhas, int colunas, int minas) {
		super();
		this.linhas = linhas;
		this.colunas = colunas;
		this.minas = minas;

		gerarCampos();
		associarOsVizinhos();
		sortearMinas();

	}

	private void gerarCampos() {
		for (int i = 0; i < linhas; i++) {
			for (int j = 0; j < colunas; j++) {
				campos.add(new Campo(i, j));

			}

		}

	}

	private void associarOsVizinhos() {
		for (Campo c1 : campos) {
			for (Campo c2 : campos) {
				c1.adicionarVizinho(c2);
			}
		}

	}

	private void sortearMinas() {
		long minasArmadas = 0;
		Predicate<Campo> minado = c -> c.isMinado();
		do {
			minasArmadas = campos.stream().filter(minado).count();
			int aleatorio = (int) (Math.random() * campos.size());
			campos.get(aleatorio).minar();

		} while (minasArmadas < minas);
	}

	public boolean objetivoAlcancado() {

		return campos.stream().allMatch(c -> c.objetivoAlcancado());

	}
	
	
	
	
	public void reiniciar() {
		campos.stream().forEach(c -> c.reiniciar());
		sortearMinas();
	}

}
