package objects;

import pt.iscte.guitoo.Point;

public class Alvo extends Objeto{
	public Alvo(Point p) {
		super(p);
        setImagem("images/Alvo.png");
        setTransponivel(true);
        setCamada(1);
	}
}