package objects;

import pt.iscte.guitoo.Point;

public class Bateria extends Objeto{
	public Bateria(Point p) {
		super(p);
        setImagem("images/Bateria.png");
        setTransponivel(true);
	}
}
