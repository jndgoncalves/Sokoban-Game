package objects;

import pt.iscte.guitoo.Point;
import utils.Direction;

public class Empilhadora extends Objeto{
	public Empilhadora(Point p) {
		super(p);
        setImagem("images/Empilhadora_D.png");
        setTransponivel(false);
        setCamada(3);
	}

	public void setImageDir(Direction dir) {
		switch (dir) {
		case UP:
	        setImagem("images/Empilhadora_U.png");
			break;
			
		case DOWN:
	        setImagem("images/Empilhadora_D.png");
			break;
			
		case LEFT:
	        setImagem("images/Empilhadora_L.png");
			break;
			
		case RIGHT:
	        setImagem("images/Empilhadora_R.png");
			break;
			
		default:
			break;
		}
		
		
	}
}
