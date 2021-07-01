package objects;

import pt.iscte.guitoo.Point;

public class Chao extends Objeto{
	public Chao(Point p) {
		super(p);
        setImagem("images/Chao.png");
        setTransponivel(true);
        setCamada(1);
	}
}