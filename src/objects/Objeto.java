package objects;

import pt.iscte.guitoo.Point;

public class Objeto {
	
	private Point posicao;
	private String imagem;
	private boolean transponivel;
	private boolean movivel;
	private int camada;
	
	public Objeto(Point p) {
		this.posicao = p;
		movivel = false;
		camada = 1;
	}

	
	
	
	
	
	public Point getPosicao() {
		return posicao;
	}

	public void setPosicao(Point posicao) {
		this.posicao = posicao;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean isTransponivel() {
		return transponivel;
	}

	public void setTransponivel(boolean transponivel) {
		this.transponivel = transponivel;
	}




	

	public boolean isMovivel() {
		return movivel;
	}






	public void setMovivel(boolean movivel) {
		this.movivel = movivel;
	}






	public int getCamada() {
		return camada;
	}



	public void setCamada(int camada) {
		this.camada = camada;
	}

	




	
	

}
