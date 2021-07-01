package utils;

import java.io.File;
import objects.Objeto;
import pt.iscte.guitoo.board.Board;

public class SokobanGUI {
	final Board board;
	double probAlvo;
	
	Sokoban sokoban;
	int nivel;
	String [] niveis = {"L4.sokas", "L1.sok",  "L2.sok", "L3.sok"};


	SokobanGUI(String title, int nivel) {
		this.nivel = nivel;
//		probAlvo = 0.5;

		File f = new File(niveis[nivel]);

//		Escolher o Loader em conformidade com a extensão
		if (f.getName().endsWith("sokas")) {
			sokoban = new LoaderSokas().load(f);
		}else sokoban = new LoaderSok().load(f);


		int linhas = sokoban.getLinhas();
		int colunas = sokoban.getColunas();
		// 50 corresponde ah largura (pixels)das imagens fornecidas
		board  = new Board(title, linhas, colunas, 50);

		// dada a coordenada (linha, coluna) devolve nome de imagem a mostrar
		//		board.setIconProvider((r,c) -> random(r, c)); 
		board.setIconProvider((r,c) -> desenharObjeto(r,c)); 

		// quando a posicao (linha, coluna) eh primida, executa a acao
		//		board.addMouseListener((r,c) -> board.showMessage("clique: " + r + ", " + c));
		board.addMouseListener((r,c) -> readClick(r, c));

		// adiciona uma etiqueta contendo o texto fornecido (atualiazado sempre que ha uma accao/clique)
		board.addLabel(() -> " Energia: " + sokoban.getEnergia());

		board.addLabel(() -> " Clica num quadrado para andar ");


		// adiciona um botao, que executa a acao fornecida
		//		board.addAction("mudar probabilidade", () -> {
		//			String p = board.promptText("%?");
		//			probAlvo = Double.parseDouble(p) / 100;
		//		});
	}


	private String desenharObjeto(Integer r, Integer c) {
		Objeto aux = sokoban.retornaObjetoParaPos(r,c);
		
		if(aux == null) {
			System.out.println("Objeto nulo para a posição (" + r + " " + c + ")");
		}
		return aux.getImagem();
	}


	private void readClick(Integer r, Integer c) {
		if (sokoban.getEnergia() == 0) {
			board.showMessage("Ficaste sem energia!");
		}else 
			sokoban.clickPos(r, c);


		if(sokoban.terminouNivel()) {
			if(nivel == niveis.length-1) {
				board.showMessage("Parabéns");
			}else {
				nivel++;
				SokobanGUI gui = new SokobanGUI("Sokoban", nivel);
				gui.open(); 
			}
		}
	}



	// devolve alteatoriamente Alvo ou Parede, de acordo com a probabilidade dada por probAlvo
	String random(int r, int c) {
		if(Math.random() < probAlvo)
			return "images/Alvo.png";
		else
			return "images/Chao.png";
	}

	void open() {
		// abre a janela
		board.open();
	}


	public static void main(String[] args) {
		SokobanGUI gui = new SokobanGUI("Sokoban", 0);
		gui.open(); 
	}
}
