package objects;

import pt.iscte.guitoo.Point;

public class Parede extends Objeto{
	public Parede(Point p) {
		super(p);
        setImagem("images/Parede.png");
        setTransponivel(false);
        setCamada(1);
	}
}
