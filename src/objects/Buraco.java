package objects;

import pt.iscte.guitoo.Point;

public class Buraco extends Objeto{
	public Buraco(Point p) {
		super(p);
        setImagem("images/Buraco.png");
        setTransponivel(true);
	}
}