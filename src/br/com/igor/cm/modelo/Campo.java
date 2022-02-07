package br.com.igor.cm.modelo;

import java.util.ArrayList;
import java.util.List;

public class Campo {
	private final int linha;
	private final int coluna;
	
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	
	private List<Campo> vizinhos = new ArrayList<>();	
	Campo(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public boolean adicionarvizinho(Campo vizinho) {
		boolean linhadiferente = linha != vizinho.linha;
		boolean colunadiferente = coluna != vizinho.coluna;
		boolean diagonal = (linhadiferente && colunadiferente);
		
		int deltalinha = Math.abs(linha - vizinho.linha);
		int deltacoluna = Math.abs(coluna - vizinho.coluna);
		int deltaGeral = deltalinha + deltacoluna;
		
		
		if(deltaGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(deltaGeral == 2 && diagonal){
			vizinhos.add(vizinho);
			return true;
		}else {
			return false;
		}
	}
	
}
