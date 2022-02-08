package br.com.igor.cm.modelo;

import java.util.ArrayList;
import java.util.List;

import br.com.igor.cm.excecao.ExplosaoException;

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
	
	void alternarmarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	boolean abrir() {
	  if(!marcado && !aberto) {
		  aberto = true;
		  if(minado) {
			  throw new ExplosaoException();
		  }
		  if(vizinhacaSegura()) {
			  vizinhos.forEach(v -> v.abrir());
		  }
		  return true;
	  }else {
		  return false;
	  }
	}
	
	boolean vizinhacaSegura() {
		return vizinhos.stream().noneMatch(v -> v.minado);
	}
	
	public boolean isMarcado() {
		return marcado;
	}
	public boolean isAberto() {
		return aberto;
	}
	public void minar() {
		minado = true;
	}

	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}
	public boolean objetivoAlcancado() {
		boolean desvendado = aberto && !minado;
		boolean protegido = minado && marcado;
		return (desvendado||protegido);
	}
	long minasNaVizinhaca(){
		return vizinhos.stream().filter(v -> v.minado).count();
	}
	void reiniciar() {
		marcado = false;
		minado = false;
		aberto = false;
	}
	@Override
	public String toString() {
		if(marcado) {
			return "X";
		}else if(aberto && minado) {
			return "*";
		}else if(aberto && minasNaVizinhaca()>0) {
			return Long.toString(minasNaVizinhaca());
		}else if(aberto) {
			return " ";
		}else {
			return "?";
		}
	}
	
	
}
	
	
	
	
	
