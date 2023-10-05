package utils;

import java.util.ArrayList;

import objects.*;
import pt.iscte.guitoo.Point;

public class Sokoban {
	private ArrayList<Objeto> listaObj = new ArrayList<Objeto>();

	private int linhas;
	private int colunas;
	private int energia;

	private int alvosDoNivel = 0;
	private int verificarAlvosCompletos = 0;



	public Sokoban(int l, int c, int e, ArrayList<Objeto> lo, int alvos) {
		this.linhas = l;
		this.colunas = c;
		this.energia = e;
		this.listaObj = lo;
		this.alvosDoNivel = alvos;
	}


	public Empilhadora procuraEmp() {
		for (int i = 0; i < listaObj.size(); i++) {
			if (listaObj.get(i) instanceof Empilhadora) {
				return (Empilhadora) listaObj.get(i);
			}
		}
		return null;
	}


	public void clickPos(Integer r, Integer c) {
		Empilhadora emp = procuraEmp();

		Point posicaoClicada = new Point(r, c);
		Point empPos = emp.getPosicao();
		
//		Obter vetor direção entre a posição da empilhadora
//		e a coordenada do ponto clicado
		Point diff = posicaoClicada.difference(empPos);

		boolean eClicavel = posClicavel(diff);
		
		Objeto objPosClicada = retornaObjetoParaPos(r, c);

		Point posCaixaFinal = objPosClicada.getPosicao().sum(diff);
		Objeto objFrenteCaixa = retornaObjetoParaPos(posCaixaFinal.getX(), posCaixaFinal.getY());
		

//		Verificar se se pode mover a empilhadora
//		para a posição clicada (se clicar com uma distancia 
//		maior que 2, não será possível mover)
		if(eClicavel) {
			
//			se for possível, mover empilhadora e decrementar energia
			if (objPosClicada.isTransponivel()) {
				emp.setPosicao(posicaoClicada);
				energia--;
//				System.out.println(emp.getPosicao());
				System.out.println("Energia: " + energia); 
				
				if (objPosClicada instanceof Bateria) {
					energia += 5;
//					remover Bateria da lista de objetos
					removerObj(objPosClicada);
					
					System.out.println("Emp na pos da bateria");
				}if (objPosClicada instanceof Veneno) {
					energia -= 2;
					
				}if (objPosClicada instanceof Buraco) {
					
//					remover caixa da lista de objetos
				}
				
			}
			
//			Verificar se o obj que se encontra na posição para qual
//			a empilhadora se quer mover, é movivel
			if (objPosClicada.isMovivel()) {
				
//				Verificar se a posição para qual a caixa se vai mover,
//				tem um objeto que seja transponivel
				if (objFrenteCaixa.isTransponivel()) {
					objPosClicada.setPosicao(posCaixaFinal);
					
//				Caso seja um alvo, incrementar o contador de alvos
//				para ser possível determinar se o jogador finalizou o nivel
				}
				
				if (objFrenteCaixa instanceof Alvo) {
					verificarAlvosCompletos++;
					
				}if (objFrenteCaixa instanceof Buraco) {
					removerObj(objPosClicada);
//					falta ver o caso em que a emp vai para o buraco
//					não deixar ou remover emp?
				}
				
				if (terminouNivel()) {
					System.out.println("Parabéns!");
				}
			} 
		}
	}


	private void removerObj(Objeto objPosClicada) {
		for (int i = 0; i < listaObj.size(); i++) {
			if(listaObj.get(i).equals(objPosClicada)) {
				listaObj.remove(i);
			}
		}
	}


	public boolean posClicavel(Point diff) {
		if(diff.getX() == -1 && diff.getY() == 0) {
//			System.out.println("cima");	
			procuraEmp().setImageDir(Direction.UP);
		}else if(diff.getX() == 1 && diff.getY() == 0) {
//			System.out.println("baixo");	
			procuraEmp().setImageDir(Direction.DOWN);
		}else if(diff.getX() == 0 && diff.getY() == 1) {
//			System.out.println("dir");	
			procuraEmp().setImageDir(Direction.RIGHT);
		}else if(diff.getX() == 0 && diff.getY() == -1) {
//			System.out.println("esq");	
			procuraEmp().setImageDir(Direction.LEFT);
		}else {
			System.out.println("Posicao Invalida");
			return false;
		}
		return true;
	}


	public Objeto retornaObjetoParaPos(Integer r, Integer c) {
		for (int i = 0; i < listaObj.size(); i++) {
			Objeto aux = listaObj.get(i);
			if (r == aux.getPosicao().getX() && c == aux.getPosicao().getY()) {
				return aux;
			}
		}
		return null;
	}
	
	
	public boolean terminouNivel() {
		return alvosDoNivel == verificarAlvosCompletos;
	}





	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}

}


